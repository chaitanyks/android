package com.google.firebase.database.android;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public abstract class AndroidAuthTokenProvider implements AuthTokenProvider {
    public static AuthTokenProvider forAuthenticatedAccess(final InternalAuthProvider authProvider) {
        return new AuthTokenProvider() {
            /* class com.google.firebase.database.android.AndroidAuthTokenProvider.AnonymousClass1 */

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void getToken(boolean forceRefresh, AuthTokenProvider.GetTokenCompletionListener listener) {
                InternalAuthProvider.this.getAccessToken(forceRefresh).addOnSuccessListener(AndroidAuthTokenProvider$1$$Lambda$1.lambdaFactory$(listener)).addOnFailureListener(AndroidAuthTokenProvider$1$$Lambda$2.lambdaFactory$(listener));
            }

            static /* synthetic */ void lambda$getToken$1(AuthTokenProvider.GetTokenCompletionListener listener, Exception e) {
                if (AndroidAuthTokenProvider.isUnauthenticatedUsage(e)) {
                    listener.onSuccess(null);
                } else {
                    listener.onError(e.getMessage());
                }
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void addTokenChangeListener(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenListener) {
                InternalAuthProvider.this.addIdTokenListener(AndroidAuthTokenProvider$1$$Lambda$3.lambdaFactory$(executorService, tokenListener));
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void removeTokenChangeListener(AuthTokenProvider.TokenChangeListener tokenListener) {
            }
        };
    }

    public static AuthTokenProvider forUnauthenticatedAccess() {
        return new AuthTokenProvider() {
            /* class com.google.firebase.database.android.AndroidAuthTokenProvider.AnonymousClass2 */

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void getToken(boolean forceRefresh, AuthTokenProvider.GetTokenCompletionListener listener) {
                listener.onSuccess(null);
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void addTokenChangeListener(ExecutorService executorService, AuthTokenProvider.TokenChangeListener listener) {
                executorService.execute(AndroidAuthTokenProvider$2$$Lambda$1.lambdaFactory$(listener));
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider
            public void removeTokenChangeListener(AuthTokenProvider.TokenChangeListener listener) {
            }
        };
    }

    /* access modifiers changed from: private */
    public static boolean isUnauthenticatedUsage(Exception e) {
        if ((e instanceof FirebaseApiNotAvailableException) || (e instanceof FirebaseNoSignedInUserException)) {
            return true;
        }
        return false;
    }
}
