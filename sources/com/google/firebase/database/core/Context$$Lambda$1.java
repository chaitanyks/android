package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import java.util.concurrent.ScheduledExecutorService;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public final /* synthetic */ class Context$$Lambda$1 implements ConnectionAuthTokenProvider {
    private final AuthTokenProvider arg$1;
    private final ScheduledExecutorService arg$2;

    private Context$$Lambda$1(AuthTokenProvider authTokenProvider, ScheduledExecutorService scheduledExecutorService) {
        this.arg$1 = authTokenProvider;
        this.arg$2 = scheduledExecutorService;
    }

    public static ConnectionAuthTokenProvider lambdaFactory$(AuthTokenProvider authTokenProvider, ScheduledExecutorService scheduledExecutorService) {
        return new Context$$Lambda$1(authTokenProvider, scheduledExecutorService);
    }

    @Override // com.google.firebase.database.connection.ConnectionAuthTokenProvider
    public void getToken(boolean z, ConnectionAuthTokenProvider.GetTokenCallback getTokenCallback) {
        this.arg$1.getToken(z, new AuthTokenProvider.GetTokenCompletionListener(this.arg$2, getTokenCallback) {
            /* class com.google.firebase.database.core.Context.AnonymousClass1 */

            @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
            public void onSuccess(String token) {
                executorService.execute(Context$1$$Lambda$1.lambdaFactory$(callback, token));
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider.GetTokenCompletionListener
            public void onError(String error) {
                executorService.execute(Context$1$$Lambda$4.lambdaFactory$(callback, error));
            }
        });
    }
}
