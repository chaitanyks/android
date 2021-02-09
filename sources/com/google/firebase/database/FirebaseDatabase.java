package com.google.firebase.database;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class FirebaseDatabase {
    private static final String SDK_VERSION = "19.2.1";
    private final FirebaseApp app;
    private final DatabaseConfig config;
    private Repo repo;
    private final RepoInfo repoInfo;

    public static FirebaseDatabase getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, instance.getOptions().getDatabaseUrl());
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static FirebaseDatabase getInstance(String url) {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, url);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static FirebaseDatabase getInstance(FirebaseApp app2) {
        return getInstance(app2, app2.getOptions().getDatabaseUrl());
    }

    public static synchronized FirebaseDatabase getInstance(FirebaseApp app2, String url) {
        FirebaseDatabase firebaseDatabase;
        synchronized (FirebaseDatabase.class) {
            if (!TextUtils.isEmpty(url)) {
                ParsedUrl parsedUrl = Utilities.parseUrl(url);
                if (parsedUrl.path.isEmpty()) {
                    Preconditions.checkNotNull(app2, "Provided FirebaseApp must not be null.");
                    FirebaseDatabaseComponent component = (FirebaseDatabaseComponent) app2.get(FirebaseDatabaseComponent.class);
                    Preconditions.checkNotNull(component, "Firebase Database component is not present.");
                    firebaseDatabase = component.get(parsedUrl.repoInfo);
                } else {
                    throw new DatabaseException("Specified Database URL '" + url + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + parsedUrl.path.toString());
                }
            } else {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
        }
        return firebaseDatabase;
    }

    static FirebaseDatabase createForTests(FirebaseApp app2, RepoInfo repoInfo2, DatabaseConfig config2) {
        FirebaseDatabase db = new FirebaseDatabase(app2, repoInfo2, config2);
        db.ensureRepo();
        return db;
    }

    FirebaseDatabase(FirebaseApp app2, RepoInfo repoInfo2, DatabaseConfig config2) {
        this.app = app2;
        this.repoInfo = repoInfo2;
        this.config = config2;
    }

    public FirebaseApp getApp() {
        return this.app;
    }

    public DatabaseReference getReference() {
        ensureRepo();
        return new DatabaseReference(this.repo, Path.getEmptyPath());
    }

    public DatabaseReference getReference(String path) {
        ensureRepo();
        if (path != null) {
            Validation.validateRootPathString(path);
            return new DatabaseReference(this.repo, new Path(path));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
    }

    public DatabaseReference getReferenceFromUrl(String url) {
        ensureRepo();
        if (url != null) {
            ParsedUrl parsedUrl = Utilities.parseUrl(url);
            if (parsedUrl.repoInfo.host.equals(this.repo.getRepoInfo().host)) {
                return new DatabaseReference(this.repo, parsedUrl.path);
            }
            throw new DatabaseException("Invalid URL (" + url + ") passed to getReference().  URL was expected to match configured Database URL: " + getReference().toString());
        }
        throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
    }

    public void purgeOutstandingWrites() {
        ensureRepo();
        this.repo.scheduleNow(new Runnable() {
            /* class com.google.firebase.database.FirebaseDatabase.AnonymousClass1 */

            public void run() {
                FirebaseDatabase.this.repo.purgeOutstandingWrites();
            }
        });
    }

    public void goOnline() {
        ensureRepo();
        RepoManager.resume(this.repo);
    }

    public void goOffline() {
        ensureRepo();
        RepoManager.interrupt(this.repo);
    }

    public synchronized void setLogLevel(Logger.Level logLevel) {
        assertUnfrozen("setLogLevel");
        this.config.setLogLevel(logLevel);
    }

    public synchronized void setPersistenceEnabled(boolean isEnabled) {
        assertUnfrozen("setPersistenceEnabled");
        this.config.setPersistenceEnabled(isEnabled);
    }

    public synchronized void setPersistenceCacheSizeBytes(long cacheSizeInBytes) {
        assertUnfrozen("setPersistenceCacheSizeBytes");
        this.config.setPersistenceCacheSizeBytes(cacheSizeInBytes);
    }

    public static String getSdkVersion() {
        return "19.2.1";
    }

    private void assertUnfrozen(String methodCalled) {
        if (this.repo != null) {
            throw new DatabaseException("Calls to " + methodCalled + "() must be made before any other usage of FirebaseDatabase instance.");
        }
    }

    private synchronized void ensureRepo() {
        if (this.repo == null) {
            this.repo = RepoManager.createRepo(this.config, this.repoInfo, this);
        }
    }

    /* access modifiers changed from: package-private */
    public DatabaseConfig getConfig() {
        return this.config;
    }
}
