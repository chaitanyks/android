package com.google.firebase.database.core.utilities.encoding;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;
import com.google.firebase.database.ThrowOnExtraProperties;
import com.google.firebase.database.core.utilities.Utilities;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class CustomClassMapper {
    private static final String LOG_TAG = "ClassMapper";
    private static final ConcurrentMap<Class<?>, BeanMapper<?>> mappers = new ConcurrentHashMap();

    public static Object convertToPlainJavaTypes(Object object) {
        return serialize(object);
    }

    public static Map<String, Object> convertToPlainJavaTypes(Map<String, Object> update) {
        Object converted = serialize(update);
        Utilities.hardAssert(converted instanceof Map);
        return (Map) converted;
    }

    public static <T> T convertToCustomClass(Object object, Class<T> clazz) {
        return (T) deserializeToClass(object, clazz);
    }

    public static <T> T convertToCustomClass(Object object, GenericTypeIndicator<T> typeIndicator) {
        Type genericTypeIndicatorType = typeIndicator.getClass().getGenericSuperclass();
        if (genericTypeIndicatorType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericTypeIndicatorType;
            if (parameterizedType.getRawType().equals(GenericTypeIndicator.class)) {
                return (T) deserializeToType(object, parameterizedType.getActualTypeArguments()[0]);
            }
            throw new DatabaseException("Not a direct subclass of GenericTypeIndicator: " + genericTypeIndicatorType);
        }
        throw new DatabaseException("Not a direct subclass of GenericTypeIndicator: " + genericTypeIndicatorType);
    }

    /* access modifiers changed from: private */
    public static <T> Object serialize(T o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Number) {
            if ((o instanceof Float) || (o instanceof Double)) {
                double doubleValue = o.doubleValue();
                if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d || Math.floor(doubleValue) != doubleValue) {
                    return Double.valueOf(doubleValue);
                }
                return Long.valueOf(o.longValue());
            } else if ((o instanceof Long) || (o instanceof Integer)) {
                return o;
            } else {
                throw new DatabaseException(String.format("Numbers of type %s are not supported, please use an int, long, float or double", o.getClass().getSimpleName()));
            }
        } else if ((o instanceof String) || (o instanceof Boolean)) {
            return o;
        } else {
            if (o instanceof Character) {
                throw new DatabaseException("Characters are not supported, please use Strings");
            } else if (o instanceof Map) {
                Map<String, Object> result = new HashMap<>();
                for (Map.Entry<Object, Object> entry : o.entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        result.put((String) key, serialize(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return result;
            } else if (o instanceof Collection) {
                if (o instanceof List) {
                    T<Object> list = o;
                    List<Object> result2 = new ArrayList<>(list.size());
                    for (Object object : list) {
                        result2.add(serialize(object));
                    }
                    return result2;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            } else if (o.getClass().isArray()) {
                throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            } else if (o instanceof Enum) {
                return o.name();
            } else {
                return loadOrCreateBeanMapperForClass(o.getClass()).serialize(o);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <T> T deserializeToType(Object o, Type type) {
        if (o == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return (T) deserializeToParameterizedType(o, (ParameterizedType) type);
        }
        if (type instanceof Class) {
            return (T) deserializeToClass(o, (Class) type);
        }
        boolean z = true;
        if (type instanceof WildcardType) {
            if (((WildcardType) type).getLowerBounds().length <= 0) {
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                if (upperBounds.length <= 0) {
                    z = false;
                }
                Utilities.hardAssert(z, "Wildcard type " + type + " is not upper bounded.");
                return (T) deserializeToType(o, upperBounds[0]);
            }
            throw new DatabaseException("Generic lower-bounded wildcard types are not supported");
        } else if (type instanceof TypeVariable) {
            Type[] upperBounds2 = ((TypeVariable) type).getBounds();
            if (upperBounds2.length <= 0) {
                z = false;
            }
            Utilities.hardAssert(z, "Wildcard type " + type + " is not upper bounded.");
            return (T) deserializeToType(o, upperBounds2[0]);
        } else if (type instanceof GenericArrayType) {
            throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
        } else {
            throw new IllegalStateException("Unknown type encountered: " + type);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T deserializeToClass(Object o, Class<T> clazz) {
        if (o == 0) {
            return null;
        }
        if (clazz.isPrimitive() || Number.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz)) {
            return (T) deserializeToPrimitive(o, clazz);
        }
        if (String.class.isAssignableFrom(clazz)) {
            return (T) convertString(o);
        }
        if (clazz.isArray()) {
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        } else if (clazz.getTypeParameters().length > 0) {
            throw new DatabaseException("Class " + clazz.getName() + " has generic type parameters, please use GenericTypeIndicator instead");
        } else if (clazz.equals(Object.class)) {
            return o;
        } else {
            return clazz.isEnum() ? (T) deserializeToEnum(o, clazz) : (T) convertBean(o, clazz);
        }
    }

    private static <T> T deserializeToParameterizedType(Object o, ParameterizedType type) {
        Class<?> rawType = (Class) type.getRawType();
        if (List.class.isAssignableFrom(rawType)) {
            Type genericType = type.getActualTypeArguments()[0];
            if (o instanceof List) {
                List<Object> list = (List) o;
                T t = (T) new ArrayList(list.size());
                for (Object object : list) {
                    t.add(deserializeToType(object, genericType));
                }
                return t;
            }
            throw new DatabaseException("Expected a List while deserializing, but got a " + o.getClass());
        } else if (Map.class.isAssignableFrom(rawType)) {
            Type keyType = type.getActualTypeArguments()[0];
            Type valueType = type.getActualTypeArguments()[1];
            if (keyType.equals(String.class)) {
                Map<String, Object> map = expectMap(o);
                T t2 = (T) new HashMap();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    t2.put(entry.getKey(), deserializeToType(entry.getValue(), valueType));
                }
                return t2;
            }
            throw new DatabaseException("Only Maps with string keys are supported, but found Map with key type " + keyType);
        } else if (!Collection.class.isAssignableFrom(rawType)) {
            Map<String, Object> map2 = expectMap(o);
            BeanMapper<T> mapper = loadOrCreateBeanMapperForClass(rawType);
            HashMap<TypeVariable<Class<T>>, Type> typeMapping = new HashMap<>();
            TypeVariable<Class<T>>[] typeVariables = ((BeanMapper) mapper).clazz.getTypeParameters();
            Type[] types = type.getActualTypeArguments();
            if (types.length == typeVariables.length) {
                for (int i = 0; i < typeVariables.length; i++) {
                    typeMapping.put(typeVariables[i], types[i]);
                }
                return mapper.deserialize(map2, typeMapping);
            }
            throw new IllegalStateException("Mismatched lengths for type variables and actual types");
        } else {
            throw new DatabaseException("Collections are not supported, please use Lists instead");
        }
    }

    private static <T> T deserializeToPrimitive(Object o, Class<T> clazz) {
        if (Integer.class.isAssignableFrom(clazz) || Integer.TYPE.isAssignableFrom(clazz)) {
            return (T) convertInteger(o);
        }
        if (Boolean.class.isAssignableFrom(clazz) || Boolean.TYPE.isAssignableFrom(clazz)) {
            return (T) convertBoolean(o);
        }
        if (Double.class.isAssignableFrom(clazz) || Double.TYPE.isAssignableFrom(clazz)) {
            return (T) convertDouble(o);
        }
        if (Long.class.isAssignableFrom(clazz) || Long.TYPE.isAssignableFrom(clazz)) {
            return (T) convertLong(o);
        }
        if (Float.class.isAssignableFrom(clazz) || Float.TYPE.isAssignableFrom(clazz)) {
            return (T) Float.valueOf(convertDouble(o).floatValue());
        }
        throw new DatabaseException(String.format("Deserializing values to %s is not supported", clazz.getSimpleName()));
    }

    private static <T> T deserializeToEnum(Object object, Class<T> clazz) {
        if (object instanceof String) {
            String value = (String) object;
            try {
                return (T) Enum.valueOf(clazz, value);
            } catch (IllegalArgumentException e) {
                throw new DatabaseException("Could not find enum value of " + clazz.getName() + " for value \"" + value + "\"");
            }
        } else {
            throw new DatabaseException("Expected a String while deserializing to enum " + clazz + " but got a " + object.getClass());
        }
    }

    private static <T> BeanMapper<T> loadOrCreateBeanMapperForClass(Class<T> clazz) {
        BeanMapper<T> mapper = (BeanMapper<T>) mappers.get(clazz);
        if (mapper != null) {
            return mapper;
        }
        BeanMapper<T> mapper2 = new BeanMapper<>(clazz);
        mappers.put(clazz, mapper2);
        return mapper2;
    }

    private static Map<String, Object> expectMap(Object object) {
        if (object instanceof Map) {
            return (Map) object;
        }
        throw new DatabaseException("Expected a Map while deserializing, but got a " + object.getClass());
    }

    private static Integer convertInteger(Object o) {
        if (o instanceof Integer) {
            return (Integer) o;
        }
        if ((o instanceof Long) || (o instanceof Double)) {
            double value = ((Number) o).doubleValue();
            if (value >= -2.147483648E9d && value <= 2.147483647E9d) {
                return Integer.valueOf(((Number) o).intValue());
            }
            throw new DatabaseException("Numeric value out of 32-bit integer range: " + value + ". Did you mean to use a long or double instead of an int?");
        }
        throw new DatabaseException("Failed to convert a value of type " + o.getClass().getName() + " to int");
    }

    private static Long convertLong(Object o) {
        if (o instanceof Integer) {
            return Long.valueOf(((Integer) o).longValue());
        }
        if (o instanceof Long) {
            return (Long) o;
        }
        if (o instanceof Double) {
            Double value = (Double) o;
            if (value.doubleValue() >= -9.223372036854776E18d && value.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(value.longValue());
            }
            throw new DatabaseException("Numeric value out of 64-bit long range: " + value + ". Did you mean to use a double instead of a long?");
        }
        throw new DatabaseException("Failed to convert a value of type " + o.getClass().getName() + " to long");
    }

    private static Double convertDouble(Object o) {
        if (o instanceof Integer) {
            return Double.valueOf(((Integer) o).doubleValue());
        }
        if (o instanceof Long) {
            Double doubleValue = Double.valueOf(((Long) o).doubleValue());
            if (doubleValue.longValue() == ((Long) o).longValue()) {
                return doubleValue;
            }
            throw new DatabaseException("Loss of precision while converting number to double: " + o + ". Did you mean to use a 64-bit long instead?");
        } else if (o instanceof Double) {
            return (Double) o;
        } else {
            throw new DatabaseException("Failed to convert a value of type " + o.getClass().getName() + " to double");
        }
    }

    private static Boolean convertBoolean(Object o) {
        if (o instanceof Boolean) {
            return (Boolean) o;
        }
        throw new DatabaseException("Failed to convert value of type " + o.getClass().getName() + " to boolean");
    }

    private static String convertString(Object o) {
        if (o instanceof String) {
            return (String) o;
        }
        throw new DatabaseException("Failed to convert value of type " + o.getClass().getName() + " to String");
    }

    private static <T> T convertBean(Object o, Class<T> clazz) {
        BeanMapper<T> mapper = loadOrCreateBeanMapperForClass(clazz);
        if (o instanceof Map) {
            return mapper.deserialize(expectMap(o));
        }
        throw new DatabaseException("Can't convert object of type " + o.getClass().getName() + " to type " + clazz.getName());
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static class BeanMapper<T> {
        private final Class<T> clazz;
        private final Constructor<T> constructor;
        private final Map<String, Field> fields = new HashMap();
        private final Map<String, Method> getters = new HashMap();
        private final Map<String, String> properties = new HashMap();
        private final Map<String, Method> setters = new HashMap();
        private final boolean throwOnUnknownProperties;
        private final boolean warnOnUnknownProperties;

        public BeanMapper(Class<T> clazz2) {
            Constructor<T> constructor2;
            this.clazz = clazz2;
            this.throwOnUnknownProperties = clazz2.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.warnOnUnknownProperties = !clazz2.isAnnotationPresent(IgnoreExtraProperties.class);
            try {
                constructor2 = clazz2.getDeclaredConstructor(new Class[0]);
                constructor2.setAccessible(true);
            } catch (NoSuchMethodException e) {
                constructor2 = null;
            }
            this.constructor = constructor2;
            Method[] methods = clazz2.getMethods();
            for (Method method : methods) {
                if (shouldIncludeGetter(method)) {
                    String propertyName = propertyName(method);
                    addProperty(propertyName);
                    method.setAccessible(true);
                    if (!this.getters.containsKey(propertyName)) {
                        this.getters.put(propertyName, method);
                    } else {
                        throw new DatabaseException("Found conflicting getters for name: " + method.getName());
                    }
                }
            }
            Field[] fields2 = clazz2.getFields();
            for (Field field : fields2) {
                if (shouldIncludeField(field)) {
                    addProperty(propertyName(field));
                }
            }
            Class<? super T> currentClass = clazz2;
            do {
                Method[] declaredMethods = currentClass.getDeclaredMethods();
                for (Method method2 : declaredMethods) {
                    if (shouldIncludeSetter(method2)) {
                        String propertyName2 = propertyName(method2);
                        String existingPropertyName = this.properties.get(propertyName2.toLowerCase());
                        if (existingPropertyName == null) {
                            continue;
                        } else if (existingPropertyName.equals(propertyName2)) {
                            Method existingSetter = this.setters.get(propertyName2);
                            if (existingSetter == null) {
                                method2.setAccessible(true);
                                this.setters.put(propertyName2, method2);
                            } else if (!isSetterOverride(method2, existingSetter)) {
                                throw new DatabaseException("Found a conflicting setters with name: " + method2.getName() + " (conflicts with " + existingSetter.getName() + " defined on " + existingSetter.getDeclaringClass().getName() + ")");
                            }
                        } else {
                            throw new DatabaseException("Found setter with invalid case-sensitive name: " + method2.getName());
                        }
                    }
                }
                Field[] declaredFields = currentClass.getDeclaredFields();
                for (Field field2 : declaredFields) {
                    String propertyName3 = propertyName(field2);
                    if (this.properties.containsKey(propertyName3.toLowerCase()) && !this.fields.containsKey(propertyName3)) {
                        field2.setAccessible(true);
                        this.fields.put(propertyName3, field2);
                    }
                }
                currentClass = currentClass.getSuperclass();
                if (currentClass == null) {
                    break;
                }
            } while (!currentClass.equals(Object.class));
            if (this.properties.isEmpty()) {
                throw new DatabaseException("No properties to serialize found on class " + clazz2.getName());
            }
        }

        private void addProperty(String property) {
            String oldValue = this.properties.put(property.toLowerCase(), property);
            if (oldValue != null && !property.equals(oldValue)) {
                throw new DatabaseException("Found two getters or fields with conflicting case sensitivity for property: " + property.toLowerCase());
            }
        }

        public T deserialize(Map<String, Object> values) {
            return deserialize(values, Collections.emptyMap());
        }

        public T deserialize(Map<String, Object> values, Map<TypeVariable<Class<T>>, Type> types) {
            Constructor<T> constructor2 = this.constructor;
            if (constructor2 != null) {
                try {
                    T instance = constructor2.newInstance(new Object[0]);
                    for (Map.Entry<String, Object> entry : values.entrySet()) {
                        String propertyName = entry.getKey();
                        if (this.setters.containsKey(propertyName)) {
                            Method setter = this.setters.get(propertyName);
                            Type[] params = setter.getGenericParameterTypes();
                            if (params.length == 1) {
                                try {
                                    setter.invoke(instance, CustomClassMapper.deserializeToType(entry.getValue(), resolveType(params[0], types)));
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                } catch (InvocationTargetException e2) {
                                    throw new RuntimeException(e2);
                                }
                            } else {
                                throw new IllegalStateException("Setter does not have exactly one parameter");
                            }
                        } else if (this.fields.containsKey(propertyName)) {
                            Field field = this.fields.get(propertyName);
                            try {
                                field.set(instance, CustomClassMapper.deserializeToType(entry.getValue(), resolveType(field.getGenericType(), types)));
                            } catch (IllegalAccessException e3) {
                                throw new RuntimeException(e3);
                            }
                        } else {
                            String message = "No setter/field for " + propertyName + " found on class " + this.clazz.getName();
                            if (this.properties.containsKey(propertyName.toLowerCase())) {
                                message = message + " (fields/setters are case sensitive!)";
                            }
                            if (this.throwOnUnknownProperties) {
                                throw new DatabaseException(message);
                            } else if (this.warnOnUnknownProperties) {
                                Log.w(CustomClassMapper.LOG_TAG, message);
                            }
                        }
                    }
                    return instance;
                } catch (InstantiationException e4) {
                    throw new RuntimeException(e4);
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException(e6);
                }
            } else {
                throw new DatabaseException("Class " + this.clazz.getName() + " does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.");
            }
        }

        private Type resolveType(Type type, Map<TypeVariable<Class<T>>, Type> types) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            Type resolvedType = types.get(type);
            if (resolvedType != null) {
                return resolvedType;
            }
            throw new IllegalStateException("Could not resolve type " + type);
        }

        public Map<String, Object> serialize(T object) {
            Object propertyValue;
            if (this.clazz.isAssignableFrom(object.getClass())) {
                Map<String, Object> result = new HashMap<>();
                for (String property : this.properties.values()) {
                    if (this.getters.containsKey(property)) {
                        try {
                            propertyValue = this.getters.get(property).invoke(object, new Object[0]);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e2) {
                            throw new RuntimeException(e2);
                        }
                    } else {
                        Field field = this.fields.get(property);
                        if (field != null) {
                            try {
                                propertyValue = field.get(object);
                            } catch (IllegalAccessException e3) {
                                throw new RuntimeException(e3);
                            }
                        } else {
                            throw new IllegalStateException("Bean property without field or getter:" + property);
                        }
                    }
                    result.put(property, CustomClassMapper.serialize(propertyValue));
                }
                return result;
            }
            throw new IllegalArgumentException("Can't serialize object of class " + object.getClass() + " with BeanMapper for class " + this.clazz);
        }

        private static boolean shouldIncludeGetter(Method method) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getDeclaringClass().equals(Object.class) && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && !method.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean shouldIncludeSetter(Method method) {
            if (method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean shouldIncludeField(Field field) {
            if (!field.getDeclaringClass().equals(Object.class) && Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !field.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean isSetterOverride(Method base, Method override) {
            Utilities.hardAssert(base.getDeclaringClass().isAssignableFrom(override.getDeclaringClass()), "Expected override from a base class");
            Utilities.hardAssert(base.getReturnType().equals(Void.TYPE), "Expected void return type");
            Utilities.hardAssert(override.getReturnType().equals(Void.TYPE), "Expected void return type");
            Type[] baseParameterTypes = base.getParameterTypes();
            Type[] overrideParameterTypes = override.getParameterTypes();
            Utilities.hardAssert(baseParameterTypes.length == 1, "Expected exactly one parameter");
            Utilities.hardAssert(overrideParameterTypes.length == 1, "Expected exactly one parameter");
            if (!base.getName().equals(override.getName()) || !baseParameterTypes[0].equals(overrideParameterTypes[0])) {
                return false;
            }
            return true;
        }

        private static String propertyName(Field field) {
            String annotatedName = annotatedName(field);
            return annotatedName != null ? annotatedName : field.getName();
        }

        private static String propertyName(Method method) {
            String annotatedName = annotatedName(method);
            return annotatedName != null ? annotatedName : serializedName(method.getName());
        }

        private static String annotatedName(AccessibleObject obj) {
            if (obj.isAnnotationPresent(PropertyName.class)) {
                return ((PropertyName) obj.getAnnotation(PropertyName.class)).value();
            }
            return null;
        }

        private static String serializedName(String methodName) {
            String[] prefixes = {"get", "set", "is"};
            String methodPrefix = null;
            for (String prefix : prefixes) {
                if (methodName.startsWith(prefix)) {
                    methodPrefix = prefix;
                }
            }
            if (methodPrefix != null) {
                char[] chars = methodName.substring(methodPrefix.length()).toCharArray();
                int pos = 0;
                while (pos < chars.length && Character.isUpperCase(chars[pos])) {
                    chars[pos] = Character.toLowerCase(chars[pos]);
                    pos++;
                }
                return new String(chars);
            }
            throw new IllegalArgumentException("Unknown Bean prefix for method: " + methodName);
        }
    }
}
