/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.crashlytics.android.answers.SessionEvent
 *  com.crashlytics.android.answers.SessionEvent$a
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledExecutorService
 */
import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

class ro
implements amt {
    final ScheduledExecutorService a;
    sg b = new rv();
    private final alc c;
    private final Context d;
    private final rp e;
    private final sj f;
    private final anb g;

    public ro(alc alc2, Context context, rp rp2, sj sj2, anb anb2, ScheduledExecutorService scheduledExecutorService) {
        this.c = alc2;
        this.d = context;
        this.e = rp2;
        this.f = sj2;
        this.g = anb2;
        this.a = scheduledExecutorService;
    }

    private void a(Runnable runnable) {
        try {
            this.a.submit(runnable).get();
            return;
        }
        catch (Exception var2_2) {
            akx.h().e("Answers", "Failed to run events task", (Throwable)var2_2);
            return;
        }
    }

    private void b(Runnable runnable) {
        try {
            this.a.submit(runnable);
            return;
        }
        catch (Exception var2_2) {
            akx.h().e("Answers", "Failed to submit events task", (Throwable)var2_2);
            return;
        }
    }

    public void a() {
        this.b(new Runnable(){

            public void run() {
                try {
                    sg sg2 = ro.this.b;
                    ro.this.b = new rv();
                    sg2.b();
                    return;
                }
                catch (Exception var1_2) {
                    akx.h().e("Answers", "Failed to disable events", (Throwable)var1_2);
                    return;
                }
            }
        });
    }

    public void a(final anl anl2, final String string2) {
        super.b(new Runnable(){

            public void run() {
                try {
                    ro.this.b.a(anl2, string2);
                    return;
                }
                catch (Exception var1_1) {
                    akx.h().e("Answers", "Failed to set analytics settings data", (Throwable)var1_1);
                    return;
                }
            }
        });
    }

    public void a(SessionEvent.a a2) {
        this.a(a2, false, false);
    }

    void a(final SessionEvent.a a2, boolean bl2, final boolean bl3) {
        Runnable runnable = new Runnable(){

            public void run() {
                try {
                    ro.this.b.a(a2);
                    if (bl3) {
                        ro.this.b.c();
                    }
                    return;
                }
                catch (Exception var1_1) {
                    akx.h().e("Answers", "Failed to process event", (Throwable)var1_1);
                    return;
                }
            }
        };
        if (bl2) {
            super.a(runnable);
            return;
        }
        super.b(runnable);
    }

    @Override
    public void a(String string2) {
        super.b(new Runnable(){

            public void run() {
                try {
                    ro.this.b.a();
                    return;
                }
                catch (Exception var1_1) {
                    akx.h().e("Answers", "Failed to send events files", (Throwable)var1_1);
                    return;
                }
            }
        });
    }

    public void b() {
        this.b(new Runnable(){

            public void run() {
                try {
                    sh sh2 = ro.this.f.a();
                    sd sd2 = ro.this.e.a();
                    sd2.a(ro.this);
                    ro.this.b = new rw(ro.this.c, ro.this.d, ro.this.a, sd2, ro.this.g, sh2);
                    return;
                }
                catch (Exception var1_3) {
                    akx.h().e("Answers", "Failed to enable events", (Throwable)var1_3);
                    return;
                }
            }
        });
    }

    public void b(SessionEvent.a a2) {
        this.a(a2, false, true);
    }

    public void c() {
        this.b(new Runnable(){

            public void run() {
                try {
                    ro.this.b.c();
                    return;
                }
                catch (Exception var1_1) {
                    akx.h().e("Answers", "Failed to flush events", (Throwable)var1_1);
                    return;
                }
            }
        });
    }

    public void c(SessionEvent.a a2) {
        this.a(a2, true, false);
    }

}

