package com.google.firebase.database.android;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.core.Platform;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.persistence.DefaultPersistenceManager;
import com.google.firebase.database.core.persistence.LRUCachePolicy;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.AndroidLogger;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class AndroidPlatform implements Platform {
    private static final String APP_IN_BACKGROUND_INTERRUPT_REASON = "app_in_background";
    private final Context applicationContext;
    private final Set<String> createdPersistenceCaches = new HashSet();
    private final FirebaseApp firebaseApp;

    public AndroidPlatform(FirebaseApp app) {
        this.firebaseApp = app;
        if (app != null) {
            this.applicationContext = app.getApplicationContext();
            return;
        }
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
    }

    @Override // com.google.firebase.database.core.Platform
    public EventTarget newEventTarget(com.google.firebase.database.core.Context context) {
        return new AndroidEventTarget();
    }

    @Override // com.google.firebase.database.core.Platform
    public RunLoop newRunLoop(com.google.firebase.database.core.Context ctx) {
        final LogWrapper logger = ctx.getLogger("RunLoop");
        return new DefaultRunLoop() {
            /* class com.google.firebase.database.android.AndroidPlatform.AnonymousClass1 */

            @Override // com.google.firebase.database.core.utilities.DefaultRunLoop
            public void handleException(final Throwable e) {
                final String message = DefaultRunLoop.messageForException(e);
                logger.error(message, e);
                new Handler(AndroidPlatform.this.applicationContext.getMainLooper()).post(new Runnable() {
                    /* class com.google.firebase.database.android.AndroidPlatform.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        throw new RuntimeException(message, e);
                    }
                });
                getExecutorService().shutdownNow();
            }
        };
    }

    @Override // com.google.firebase.database.core.Platform
    public PersistentConnection newPersistentConnection(com.google.firebase.database.core.Context context, ConnectionContext connectionContext, HostInfo info, PersistentConnection.Delegate delegate) {
        final PersistentConnection connection = new PersistentConnectionImpl(connectionContext, info, delegate);
        this.firebaseApp.addBackgroundStateChangeListener(new FirebaseApp.BackgroundStateChangeListener() {
            /* class com.google.firebase.database.android.AndroidPlatform.AnonymousClass2 */

            @Override // com.google.firebase.FirebaseApp.BackgroundStateChangeListener
            public void onBackgroundStateChanged(boolean background) {
                if (background) {
                    connection.interrupt(AndroidPlatform.APP_IN_BACKGROUND_INTERRUPT_REASON);
                } else {
                    connection.resume(AndroidPlatform.APP_IN_BACKGROUND_INTERRUPT_REASON);
                }
            }
        });
        return connection;
    }

    @Override // com.google.firebase.database.core.Platform
    public Logger newLogger(com.google.firebase.database.core.Context context, Logger.Level component, List<String> enabledComponents) {
        return new AndroidLogger(component, enabledComponents);
    }

    @Override // com.google.firebase.database.core.Platform
    public String getUserAgent(com.google.firebase.database.core.Context context) {
        return Build.VERSION.SDK_INT + "/Android";
    }

    @Override // com.google.firebase.database.core.Platform
    public String getPlatformVersion() {
        return "android-" + FirebaseDatabase.getSdkVersion();
    }

    @Override // com.google.firebase.database.core.Platform
    public PersistenceManager createPersistenceManager(com.google.firebase.database.core.Context firebaseContext, String firebaseId) {
        String sessionId = firebaseContext.getSessionPersistenceKey();
        String cacheId = firebaseId + "_" + sessionId;
        if (!this.createdPersistenceCaches.contains(cacheId)) {
            this.createdPersistenceCaches.add(cacheId);
            return new DefaultPersistenceManager(firebaseContext, new SqlPersistenceStorageEngine(this.applicationContext, firebaseContext, cacheId), new LRUCachePolicy(firebaseContext.getPersistenceCacheSizeBytes()));
        }
        throw new DatabaseException("SessionPersistenceKey '" + sessionId + "' has already been used.");
    }

    @Override // com.google.firebase.database.core.Platform
    public File getSSLCacheDirectory() {
        return this.applicationContext.getApplicationContext().getDir("sslcache", 0);
    }
}
