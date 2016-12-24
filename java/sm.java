/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 */
import android.annotation.TargetApi;
import android.app.Activity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@TargetApi(value=14)
class sm
extends sl {
    private final akv.b a;
    private final ExecutorService b;

    public sm(akv akv2, ExecutorService executorService) {
        this.a = new akv.b(){

            @Override
            public void a(Activity activity) {
                if (sm.this.a()) {
                    sm.this.b.submit(new Runnable(){

                        public void run() {
                            sm.this.c();
                        }
                    });
                }
            }

        };
        this.b = executorService;
        akv2.a(this.a);
    }

}

