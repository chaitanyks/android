package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzkw;
import com.google.android.gms.internal.measurement.zzln;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzac extends zzkk {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzad zzj = new zzad(this, zzn(), "google_app_measurement.db");
    private final zzkg zzk = new zzkg(zzm());

    zzac(zzkj zzkj) {
        super(zzkj);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final boolean zze() {
        return false;
    }

    public final void zzf() {
        zzak();
        c_().beginTransaction();
    }

    public final void b_() {
        zzak();
        c_().setTransactionSuccessful();
    }

    public final void zzh() {
        zzak();
        c_().endTransaction();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final SQLiteDatabase c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0184  */
    public final zzaj zza(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        Cursor cursor2;
        Boolean bool;
        long j;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        boolean zze2 = zzt().zze(str, zzap.zzbl);
        boolean z = false;
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"));
        if (zze2) {
            arrayList.add("current_session_count");
        }
        Cursor cursor3 = null;
        try {
            cursor = c_().query("events", (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                long j2 = cursor.getLong(0);
                long j3 = cursor.getLong(1);
                long j4 = cursor.getLong(2);
                long j5 = cursor.isNull(3) ? 0 : cursor.getLong(3);
                Long valueOf = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
                Long valueOf2 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
                Long valueOf3 = cursor.isNull(6) ? null : Long.valueOf(cursor.getLong(6));
                if (!cursor.isNull(7)) {
                    try {
                        if (cursor.getLong(7) == 1) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzr().zzf().zza("Error querying events. appId", zzfb.zza(str), zzo().zza(str2), e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor3 = cursor;
                            if (cursor3 != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    bool = null;
                }
                if (!zze2 || cursor.isNull(8)) {
                    j = 0;
                } else {
                    j = cursor.getLong(8);
                }
                cursor2 = cursor;
                try {
                    zzaj zzaj = new zzaj(str, str2, j2, j3, j, j4, j5, valueOf, valueOf2, valueOf3, bool);
                    if (cursor2.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for event aggregates, expected one. appId", zzfb.zza(str));
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return zzaj;
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor = cursor2;
                    zzr().zzf().zza("Error querying events. appId", zzfb.zza(str), zzo().zza(str2), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                zzr().zzf().zza("Error querying events. appId", zzfb.zza(str), zzo().zza(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                cursor2 = cursor;
                cursor3 = cursor2;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor = null;
            zzr().zzf().zza("Error querying events. appId", zzfb.zza(str), zzo().zza(str2), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
    }

    public final void zza(zzaj zzaj) {
        long j;
        Preconditions.checkNotNull(zzaj);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaj.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaj.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzaj.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzaj.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzaj.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzaj.zzg));
        contentValues.put("last_bundled_day", zzaj.zzh);
        contentValues.put("last_sampled_complex_event_id", zzaj.zzi);
        contentValues.put("last_sampling_rate", zzaj.zzj);
        if (zzt().zze(zzaj.zza, zzap.zzbl)) {
            contentValues.put("current_session_count", Long.valueOf(zzaj.zze));
        }
        if (zzaj.zzk == null || !zzaj.zzk.booleanValue()) {
            j = null;
        } else {
            j = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j);
        try {
            if (c_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzfb.zza(zzaj.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzfb.zza(zzaj.zza), e);
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            int delete = c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
            if (!zzkw.zzb() || !this.zza.zzb().zze(str, zzap.zzcx)) {
                zzr().zzx().zza("Deleted user attribute rows", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            if (!zzkw.zzb() || !this.zza.zzb().zze(str, zzap.zzcx)) {
                zzr().zzf().zza("Error deleting user attribute. appId", zzfb.zza(str), zzo().zzc(str2), e);
            } else {
                zzr().zzf().zza("Error deleting user property. appId", zzfb.zza(str), zzo().zzc(str2), e);
            }
        }
    }

    public final boolean zza(zzks zzks) {
        Preconditions.checkNotNull(zzks);
        zzd();
        zzak();
        if (zzc(zzks.zza, zzks.zzc) == null) {
            if (zzkv.zza(zzks.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzks.zza}) >= 25) {
                    return false;
                }
            } else if (!zzt().zze(zzks.zza, zzap.zzaz)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzks.zza, zzks.zzb}) >= 25) {
                    return false;
                }
            } else if (!"_npa".equals(zzks.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzks.zza, zzks.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzks.zza);
        contentValues.put("origin", zzks.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzks.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzks.zzd));
        zza(contentValues, "value", zzks.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzfb.zza(zzks.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzfb.zza(zzks.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1  */
    public final zzks zzc(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzks zzks = new zzks(str, cursor.getString(2), str2, cursor.getLong(0), zza(cursor, 1));
                    if (cursor.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for user property, expected one. appId", zzfb.zza(str));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzks;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzr().zzf().zza("Error querying user property. appId", zzfb.zza(str), zzo().zzc(str2), e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzr().zzf().zza("Error querying user property. appId", zzfb.zza(str), zzo().zzc(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error querying user property. appId", zzfb.zza(str), zzo().zzc(str2), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00be  */
    public final List<zzks> zza(String str) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        String str2;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        str2 = "";
                    } else {
                        str2 = string2;
                    }
                    long j = cursor.getLong(2);
                    try {
                        Object zza = zza(cursor, 3);
                        if (zza == null) {
                            zzr().zzf().zza("Read invalid user property value, ignoring it. appId", zzfb.zza(str));
                        } else {
                            arrayList.add(new zzks(str, str2, string, j, zza));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzr().zzf().zza("Error querying user properties. appId", zzfb.zza(str), e);
                            if (cursor != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            throw th;
                        }
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                e = e3;
                zzr().zzf().zza("Error querying user properties. appId", zzfb.zza(str), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error querying user properties. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0125, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0129, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x014c, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0125 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014c  */
    public final List<zzks> zza(String str, String str2, String str3) {
        Throwable th;
        Cursor cursor;
        String str4;
        SQLiteException e;
        String str5;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            int i = 3;
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                str4 = str2;
                arrayList2.add(str4);
                sb.append(" and origin=?");
            } else {
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                sb.append(" and name glob ?");
            }
            int i2 = 0;
            int i3 = 1;
            int i4 = 2;
            cursor = c_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        zzr().zzf().zza("Read more than the max allowed user properties, ignoring excess", 1000);
                        break;
                    }
                    String string = cursor.getString(i2);
                    long j = cursor.getLong(i3);
                    try {
                        Object zza = zza(cursor, i4);
                        String string2 = cursor.getString(i);
                        if (zza == null) {
                            try {
                                zzr().zzf().zza("(2)Read invalid user property value, ignoring it", zzfb.zza(str), string2, str3);
                                str5 = string2;
                            } catch (SQLiteException e2) {
                                e = e2;
                                str4 = string2;
                                try {
                                    zzr().zzf().zza("(2)Error querying user properties", zzfb.zza(str), str4, e);
                                    if (cursor != null) {
                                    }
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            try {
                                str5 = string2;
                            } catch (SQLiteException e3) {
                                e = e3;
                                str5 = string2;
                                str4 = str5;
                                zzr().zzf().zza("(2)Error querying user properties", zzfb.zza(str), str4, e);
                                if (cursor != null) {
                                }
                                return null;
                            }
                            try {
                                arrayList.add(new zzks(str, string2, string, j, zza));
                            } catch (SQLiteException e4) {
                                e = e4;
                                str4 = str5;
                                zzr().zzf().zza("(2)Error querying user properties", zzfb.zza(str), str4, e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return null;
                            }
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str4 = str5;
                        i = 3;
                        i3 = 1;
                        i4 = 2;
                        i2 = 0;
                    } catch (SQLiteException e5) {
                        e = e5;
                        zzr().zzf().zza("(2)Error querying user properties", zzfb.zza(str), str4, e);
                        if (cursor != null) {
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e6) {
                e = e6;
                zzr().zzf().zza("(2)Error querying user properties", zzfb.zza(str), str4, e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e7) {
            e = e7;
            str4 = str2;
            cursor = null;
            zzr().zzf().zza("(2)Error querying user properties", zzfb.zza(str), str4, e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th4) {
        }
    }

    public final boolean zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        zzd();
        zzak();
        if (zzc(zzv.zza, zzv.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzv.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzv.zza);
        contentValues.put("origin", zzv.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzv.zzc.zza);
        zza(contentValues, "value", zzv.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzv.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzv.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzv.zzh));
        zzp();
        contentValues.put("timed_out_event", zzkv.zza((Parcelable) zzv.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzv.zzd));
        zzp();
        contentValues.put("triggered_event", zzkv.zza((Parcelable) zzv.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzv.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzv.zzj));
        zzp();
        contentValues.put("expired_event", zzkv.zza((Parcelable) zzv.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzfb.zza(zzv.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzfb.zza(zzv.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x015b  */
    public final zzv zzd(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object zza = zza(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    zzv zzv = new zzv(str, string, new zzkq(str2, cursor.getLong(8), zza, string), cursor.getLong(6), z, cursor.getString(3), (zzan) zzg().zza(cursor.getBlob(5), zzan.CREATOR), cursor.getLong(4), (zzan) zzg().zza(cursor.getBlob(7), zzan.CREATOR), cursor.getLong(9), (zzan) zzg().zza(cursor.getBlob(10), zzan.CREATOR));
                    if (cursor.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for conditional property, expected one", zzfb.zza(str), zzo().zzc(str2));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzv;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzr().zzf().zza("Error querying conditional property", zzfb.zza(str), zzo().zzc(str2), e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzr().zzf().zza("Error querying conditional property", zzfb.zza(str), zzo().zzc(str2), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error querying conditional property", zzfb.zza(str), zzo().zzc(str2), e);
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzfb.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    public final List<zzv> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x017b  */
    public final List<zzv> zza(String str, String[] strArr) {
        Cursor cursor;
        Throwable th;
        SQLiteException e;
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        try {
            int i = 0;
            int i2 = 5;
            Cursor query = c_().query("conditional_properties", new String[]{"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                    String string = query.getString(i);
                    String string2 = query.getString(1);
                    String string3 = query.getString(2);
                    Object zza = zza(query, 3);
                    boolean z = query.getInt(4) != 0;
                    String string4 = query.getString(i2);
                    long j = query.getLong(6);
                    arrayList.add(new zzv(string, string2, new zzkq(string3, query.getLong(10), zza, string2), query.getLong(8), z, string4, (zzan) zzg().zza(query.getBlob(7), zzan.CREATOR), j, (zzan) zzg().zza(query.getBlob(9), zzan.CREATOR), query.getLong(11), (zzan) zzg().zza(query.getBlob(12), zzan.CREATOR)));
                    if (!query.moveToNext()) {
                        break;
                    }
                    i2 = 5;
                    i = 0;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzr().zzf().zza("Error querying conditional user property value", e);
                    List<zzv> emptyList = Collections.emptyList();
                    if (cursor != null) {
                    }
                    return emptyList;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Error querying conditional user property value", e);
            List<zzv> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0194 A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0198 A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01cc A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01cf A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01de A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x020e A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0211 A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0221 A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0257 A[Catch:{ SQLiteException -> 0x026f }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x029c  */
    public final zzg zzb(String str) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        boolean z;
        boolean z2;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            boolean z3 = false;
            cursor = c_().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    zzg zzg2 = new zzg(this.zza.zzs(), str);
                    zzg2.zza(cursor.getString(0));
                    zzg2.zzb(cursor.getString(1));
                    zzg2.zze(cursor.getString(2));
                    zzg2.zzg(cursor.getLong(3));
                    zzg2.zza(cursor.getLong(4));
                    zzg2.zzb(cursor.getLong(5));
                    zzg2.zzg(cursor.getString(6));
                    zzg2.zzh(cursor.getString(7));
                    zzg2.zzd(cursor.getLong(8));
                    zzg2.zze(cursor.getLong(9));
                    if (!cursor.isNull(10)) {
                        if (cursor.getInt(10) == 0) {
                            z = false;
                            zzg2.zza(z);
                            zzg2.zzj(cursor.getLong(11));
                            zzg2.zzk(cursor.getLong(12));
                            zzg2.zzl(cursor.getLong(13));
                            zzg2.zzm(cursor.getLong(14));
                            zzg2.zzh(cursor.getLong(15));
                            zzg2.zzi(cursor.getLong(16));
                            zzg2.zzc(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                            zzg2.zzf(cursor.getString(18));
                            zzg2.zzo(cursor.getLong(19));
                            zzg2.zzn(cursor.getLong(20));
                            zzg2.zzi(cursor.getString(21));
                            zzg2.zzp(!cursor.isNull(22) ? 0 : cursor.getLong(22));
                            if (!cursor.isNull(23)) {
                                if (cursor.getInt(23) == 0) {
                                    z2 = false;
                                    zzg2.zzb(z2);
                                    if (cursor.isNull(24) || cursor.getInt(24) != 0) {
                                        z3 = true;
                                    }
                                    zzg2.zzc(z3);
                                    zzg2.zzc(cursor.getString(25));
                                    zzg2.zzf(cursor.isNull(26) ? 0 : cursor.getLong(26));
                                    if (!cursor.isNull(27)) {
                                        zzg2.zza(Arrays.asList(cursor.getString(27).split(",", -1)));
                                    }
                                    if (zzln.zzb() && zzt().zze(str, zzap.zzcf)) {
                                        zzg2.zzd(cursor.getString(28));
                                    }
                                    zzg2.zzb();
                                    if (cursor.moveToNext()) {
                                        zzr().zzf().zza("Got multiple records for app, expected one. appId", zzfb.zza(str));
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return zzg2;
                                }
                            }
                            z2 = true;
                            zzg2.zzb(z2);
                            z3 = true;
                            zzg2.zzc(z3);
                            zzg2.zzc(cursor.getString(25));
                            zzg2.zzf(cursor.isNull(26) ? 0 : cursor.getLong(26));
                            if (!cursor.isNull(27)) {
                            }
                            zzg2.zzd(cursor.getString(28));
                            zzg2.zzb();
                            if (cursor.moveToNext()) {
                            }
                            if (cursor != null) {
                            }
                            return zzg2;
                        }
                    }
                    z = true;
                    zzg2.zza(z);
                    zzg2.zzj(cursor.getLong(11));
                    zzg2.zzk(cursor.getLong(12));
                    zzg2.zzl(cursor.getLong(13));
                    zzg2.zzm(cursor.getLong(14));
                    zzg2.zzh(cursor.getLong(15));
                    zzg2.zzi(cursor.getLong(16));
                    zzg2.zzc(!cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                    zzg2.zzf(cursor.getString(18));
                    zzg2.zzo(cursor.getLong(19));
                    zzg2.zzn(cursor.getLong(20));
                    zzg2.zzi(cursor.getString(21));
                    zzg2.zzp(!cursor.isNull(22) ? 0 : cursor.getLong(22));
                    if (!cursor.isNull(23)) {
                    }
                    z2 = true;
                    zzg2.zzb(z2);
                    z3 = true;
                    zzg2.zzc(z3);
                    zzg2.zzc(cursor.getString(25));
                    zzg2.zzf(cursor.isNull(26) ? 0 : cursor.getLong(26));
                    if (!cursor.isNull(27)) {
                    }
                    zzg2.zzd(cursor.getString(28));
                    zzg2.zzb();
                    if (cursor.moveToNext()) {
                    }
                    if (cursor != null) {
                    }
                    return zzg2;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        zzr().zzf().zza("Error querying app. appId", zzfb.zza(str), e);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                zzr().zzf().zza("Error querying app. appId", zzfb.zza(str), e);
                if (cursor != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error querying app. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void zza(zzg zzg2) {
        Preconditions.checkNotNull(zzg2);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzc());
        contentValues.put("app_instance_id", zzg2.zzd());
        contentValues.put("gmp_app_id", zzg2.zze());
        contentValues.put("resettable_device_id_hash", zzg2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzg2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg2.zzk()));
        contentValues.put("app_version", zzg2.zzl());
        contentValues.put("app_store", zzg2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzg2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg2.zzr()));
        contentValues.put("day", Long.valueOf(zzg2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzg2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzg2.zzm()));
        contentValues.put("firebase_instance_id", zzg2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg2.zzaa()));
        contentValues.put("health_monitor_sample", zzg2.zzac());
        contentValues.put("android_id", Long.valueOf(zzg2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzg2.zzag()));
        contentValues.put("admob_app_id", zzg2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzg2.zzq()));
        if (zzg2.zzai() != null) {
            if (zzg2.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzg2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzg2.zzai()));
            }
        }
        if (zzln.zzb() && zzt().zze(zzg2.zzc(), zzap.zzcf)) {
            contentValues.put("ga_app_id", zzg2.zzg());
        }
        try {
            SQLiteDatabase c_ = c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzg2.zzc()})) == 0 && c_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzfb.zza(zzg2.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzfb.zza(zzg2.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return (long) c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzap.zzo))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzfb.zza(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0127  */
    public final zzab zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Cursor cursor;
        Throwable th;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        String[] strArr = {str};
        zzab zzab = new zzab();
        try {
            SQLiteDatabase c_ = c_();
            cursor = c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    zzr().zzi().zza("Not updating daily counts, app is not known. appId", zzfb.zza(str));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzab;
                }
                if (cursor.getLong(0) == j) {
                    zzab.zzb = cursor.getLong(1);
                    zzab.zza = cursor.getLong(2);
                    zzab.zzc = cursor.getLong(3);
                    zzab.zzd = cursor.getLong(4);
                    zzab.zze = cursor.getLong(5);
                }
                if (z) {
                    zzab.zzb++;
                }
                if (z2) {
                    zzab.zza++;
                }
                if (z3) {
                    zzab.zzc++;
                }
                if (z4) {
                    zzab.zzd++;
                }
                if (z5) {
                    zzab.zze++;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzab.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzab.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzab.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzab.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzab.zze));
                c_.update("apps", contentValues, "app_id=?", strArr);
                if (cursor != null) {
                    cursor.close();
                }
                return zzab;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Error updating daily counts. appId", zzfb.zza(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzab;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Error updating daily counts. appId", zzfb.zza(str), e);
            if (cursor != null) {
            }
            return zzab;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    public final byte[] zzd(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                if (cursor.moveToNext()) {
                    zzr().zzf().zza("Got multiple records for app config, expected one. appId", zzfb.zza(str));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return blob;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Error querying remote config. appId", zzfb.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Error querying remote config. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final boolean zza(zzbs.zzg zzg2, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzv();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzx.zzj() || zzg2.zzl() > zzx.zzj() + currentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfb.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = zzg().zzc(zzg2.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (c_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzfb.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error storing bundle. appId", zzfb.zza(zzg2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzfb.zza(zzg2.zzx()), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    public final String d_() {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        try {
            cursor = c_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Database error getting next bundle app id", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final List<Pair<zzbs.zzg, Long>> zza(String str, int i, int i2) {
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            Cursor query = c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!query.moveToFirst()) {
                List<Pair<zzbs.zzg, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = query.getLong(0);
                try {
                    byte[] zzb2 = zzg().zzb(query.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i3 > i2) {
                        break;
                    }
                    try {
                        zzbs.zzg.zza zza = (zzbs.zzg.zza) zzkr.zza(zzbs.zzg.zzbf(), zzb2);
                        if (!query.isNull(2)) {
                            zza.zzi(query.getInt(2));
                        }
                        i3 += zzb2.length;
                        arrayList.add(Pair.create((zzbs.zzg) ((zzfe) zza.zzv()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge queued bundle. appId", zzfb.zza(str), e);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzr().zzf().zza("Failed to unzip queued bundle. appId", zzfb.zza(str), e2);
                }
            } while (i3 <= i2);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzr().zzf().zza("Error querying bundles. appId", zzfb.zza(str), e3);
            List<Pair<zzbs.zzg, Long>> emptyList2 = Collections.emptyList();
            if (0 != 0) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzv() {
        int delete;
        zzd();
        zzak();
        if (zzam()) {
            long zza = zzs().zzf.zza();
            long elapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzap.zzx.zza(null).longValue()) {
                zzs().zzf.zza(elapsedRealtime);
                zzd();
                zzak();
                if (zzam() && (delete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzx.zzj())})) > 0) {
                    zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, zzbk.zzb zzb2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzfd zzi2 = zzr().zzi();
            Object zza = zzfb.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzi2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zzb2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzc());
        if (zzt().zze(str, zzap.zzbk)) {
            contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        }
        contentValues.put("data", zzbi);
        try {
            if (c_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzfb.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzfb.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbk.zze zze2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzfd zzi2 = zzr().zzi();
            Object zza = zzfb.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzi2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zze2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        if (zzt().zze(str, zzap.zzbk)) {
            contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        }
        contentValues.put("data", zzbi);
        try {
            if (c_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzfb.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzfb.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0  */
    public final Map<Integer, List<zzbk.zzb>> zzf(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzbk.zzb>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzbk.zzb zzb2 = (zzbk.zzb) ((zzfe) ((zzbk.zzb.zza) zzkr.zza(zzbk.zzb.zzl(), cursor.getBlob(1))).zzv());
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge filter. appId", zzfb.zza(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final Map<Integer, List<zzbk.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            Cursor query = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
            if (!query.moveToFirst()) {
                Map<Integer, List<zzbk.zzb>> emptyMap = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzbk.zzb zzb2 = (zzbk.zzb) ((zzfe) ((zzbk.zzb.zza) zzkr.zza(zzbk.zzb.zzl(), query.getBlob(1))).zzv());
                    if (zzb2.zzf()) {
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzr().zzf().zza("Failed to merge filter. appId", zzfb.zza(str), e);
                }
            } while (query.moveToNext());
            if (query != null) {
                query.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e2);
            Map<Integer, List<zzbk.zzb>> emptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0  */
    public final Map<Integer, List<zzbk.zze>> zzg(String str, String str2) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<zzbk.zze>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzbk.zze zze2 = (zzbk.zze) ((zzfe) ((zzbk.zze.zza) zzkr.zza(zzbk.zze.zzi(), cursor.getBlob(1))).zzv());
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zze2);
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge filter", zzfb.zza(str), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf  */
    public final Map<Integer, List<Integer>> zza(String str, List<String> list) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        ArrayMap arrayMap = new ArrayMap();
        if (list.isEmpty()) {
            return arrayMap;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("app_id=? AND property_name in (");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("?");
        }
        sb.append(")");
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, str);
        Cursor cursor2 = null;
        try {
            cursor = c_().query("property_filters", new String[]{"audience_id", "filter_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayMap;
                }
                do {
                    int i2 = cursor.getInt(0);
                    List list2 = (List) arrayMap.get(Integer.valueOf(i2));
                    if (list2 == null) {
                        list2 = new ArrayList();
                        arrayMap.put(Integer.valueOf(i2), list2);
                    }
                    list2.add(Integer.valueOf(cursor.getInt(1)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    public final Map<Integer, List<Integer>> zzf(String str) {
        Throwable th;
        Cursor cursor;
        SQLiteException e;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyMap;
                }
                do {
                    int i = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(Integer.valueOf(cursor.getInt(1)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Database error querying scoped filters. appId", zzfb.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Database error querying scoped filters. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private final boolean zzc(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase c_ = c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzt().zzb(str, zzap.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzfb.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5  */
    public final Map<Integer, zzbs.zzi> zzg(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Cursor cursor2 = null;
        try {
            cursor = c_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursor.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzbs.zzi) ((zzfe) ((zzbs.zzi.zza) zzkr.zza(zzbs.zzi.zzi(), cursor.getBlob(1))).zzv()));
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge filter results. appId, audienceId, error", zzfb.zza(str), Integer.valueOf(i), e2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Database error querying filter results. appId", zzfb.zza(str), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Database error querying filter results. appId", zzfb.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zzh(String str, String str2) {
        Throwable th;
        SQLiteException e;
        long zza;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                zza = zza(sb.toString(), new String[]{str}, -1);
                if (zza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (c_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzr().zzf().zza("Failed to insert column (got -1). appId", zzfb.zza(str), str2);
                        c_.endTransaction();
                        return -1;
                    }
                    zza = 0;
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Error inserting column. appId", zzfb.zza(str), str2, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    c_.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzr().zzf().zza("Failed to update column (got 0). appId", zzfb.zza(str), str2);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return zza;
            } catch (SQLiteException e3) {
                e = e3;
                j = zza;
                zzr().zzf().zza("Error inserting column. appId", zzfb.zza(str), str2, e);
                c_.endTransaction();
                return j;
            }
        } catch (SQLiteException e4) {
            e = e4;
            zzr().zzf().zza("Error inserting column. appId", zzfb.zza(str), str2, e);
            c_.endTransaction();
            return j;
        } catch (Throwable th3) {
            th = th3;
            c_.endTransaction();
            throw th;
        }
    }

    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzbs.zzg zzg2) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbi = zzg2.zzbi();
        long zza = zzg().zza(zzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", zzbi);
        try {
            c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzfb.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
    public final String zza(long j) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (!cursor.moveToFirst()) {
                    zzr().zzx().zza("No expired configs for apps with pending events");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                if (cursor != null) {
                    cursor.close();
                }
                return string;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzr().zzf().zza("Error selecting expired configs", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzr().zzf().zza("Error selecting expired configs", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final long zzaa() {
        Cursor cursor = null;
        try {
            cursor = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096  */
    public final Pair<zzbs.zzc, Long> zza(String str, Long l) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            cursor = c_().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (!cursor.moveToFirst()) {
                    zzr().zzx().zza("Main event not found");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    Pair<zzbs.zzc, Long> create = Pair.create((zzbs.zzc) ((zzfe) ((zzbs.zzc.zza) zzkr.zza(zzbs.zzc.zzj(), cursor.getBlob(0))).zzv()), Long.valueOf(cursor.getLong(1)));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return create;
                } catch (IOException e2) {
                    zzr().zzf().zza("Failed to merge main event. appId, eventId", zzfb.zza(str), l, e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzr().zzf().zza("Error selecting main event", e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            zzr().zzf().zza("Error selecting main event", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final boolean zza(String str, Long l, long j, zzbs.zzc zzc2) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbi = zzc2.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbi);
        try {
            if (c_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzfb.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzfb.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzak zzak, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzak);
        Preconditions.checkNotEmpty(zzak.zza);
        zzbs.zzc.zza zzb2 = zzbs.zzc.zzj().zzb(zzak.zzd);
        Iterator<String> it = zzak.zze.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzbs.zze.zza zza = zzbs.zze.zzk().zza(next);
            zzg().zza(zza, zzak.zze.zza(next));
            zzb2.zza(zza);
        }
        byte[] zzbi = ((zzbs.zzc) ((zzfe) zzb2.zzv())).zzbi();
        if (!zzkw.zzb() || !zzt().zze(zzak.zza, zzap.zzcx)) {
            zzr().zzx().zza("Saving event, name, data size", zzo().zza(zzak.zzb), Integer.valueOf(zzbi.length));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzak.zzb);
        contentValues.put("timestamp", Long.valueOf(zzak.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzfb.zza(zzak.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzfb.zza(zzak.zza), e);
            return false;
        }
    }

    public final void zzb(String str, List<zzbk.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbk.zza.C0001zza zza = (zzbk.zza.C0001zza) list.get(i).zzbl();
            if (zza.zzb() != 0) {
                for (int i2 = 0; i2 < zza.zzb(); i2++) {
                    zzbk.zzb.zza zza2 = (zzbk.zzb.zza) zza.zzb(i2).zzbl();
                    zzbk.zzb.zza zza3 = (zzbk.zzb.zza) ((zzfe.zza) zza2.clone());
                    String zzb2 = zzhe.zzb(zza2.zza());
                    if (zzb2 != null) {
                        zza3.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza2.zzb(); i3++) {
                        zzbk.zzc zza4 = zza2.zza(i3);
                        String zza5 = zzhd.zza(zza4.zzh());
                        if (zza5 != null) {
                            zza3.zza(i3, (zzbk.zzc) ((zzfe) ((zzbk.zzc.zza) zza4.zzbl()).zza(zza5).zzv()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza = zza.zza(i2, zza3);
                        list.set(i, (zzbk.zza) ((zzfe) zza.zzv()));
                    }
                }
            }
            if (zza.zza() != 0) {
                for (int i4 = 0; i4 < zza.zza(); i4++) {
                    zzbk.zze zza6 = zza.zza(i4);
                    String zza7 = zzhg.zza(zza6.zzc());
                    if (zza7 != null) {
                        zza = zza.zza(i4, ((zzbk.zze.zza) zza6.zzbl()).zza(zza7));
                        list.set(i, (zzbk.zza) ((zzfe) zza.zzv()));
                    }
                }
            }
        }
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str});
            c_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbk.zza zza8 : list) {
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zza8);
                if (!zza8.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzfb.zza(str));
                } else {
                    int zzb3 = zza8.zzb();
                    Iterator<zzbk.zzb> it = zza8.zze().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator<zzbk.zze> it2 = zza8.zzc().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Iterator<zzbk.zzb> it3 = zza8.zze().iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            z = true;
                                            break;
                                        } else if (!zza(str, zzb3, it3.next())) {
                                            z = false;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbk.zze> it4 = zza8.zzc().iterator();
                                        while (true) {
                                            if (!it4.hasNext()) {
                                                break;
                                            } else if (!zza(str, zzb3, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                    }
                                } else if (!it2.next().zza()) {
                                    zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfb.zza(str), Integer.valueOf(zzb3));
                                    break;
                                }
                            }
                        } else if (!it.next().zza()) {
                            zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfb.zza(str), Integer.valueOf(zzb3));
                            break;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbk.zza zza9 : list) {
                arrayList.add(zza9.zza() ? Integer.valueOf(zza9.zzb()) : null);
            }
            zzc(str, arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }
}
