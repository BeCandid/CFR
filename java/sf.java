/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Looper
 *  com.crashlytics.android.answers.SessionEvent
 *  com.crashlytics.android.answers.SessionEvent$Type
 *  com.crashlytics.android.answers.SessionEvent$a
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.ScheduledExecutorService
 */
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.concurrent.ScheduledExecutorService;

class sf
implements rt.a {
    final ro a;
    final akv b;
    final rt c;
    final rr d;
    private final long e;

    sf(ro ro2, akv akv2, rt rt2, rr rr2, long l2) {
        this.a = ro2;
        this.b = akv2;
        this.c = rt2;
        this.d = rr2;
        this.e = l2;
    }

    public static sf a(alc alc2, Context context, IdManager idManager, String string2, String string3, long l2) {
        sj sj2 = new sj(context, idManager, string2, string3);
        rp rp2 = new rp(context, new anh(alc2));
        ana ana2 = new ana(akx.h());
        akv akv2 = new akv(context);
        ScheduledExecutorService scheduledExecutorService = alw.b("Answers Events Handler");
        rt rt2 = new rt(scheduledExecutorService);
        return new sf(new ro(alc2, context, rp2, sj2, ana2, scheduledExecutorService), akv2, rt2, rr.a(context), l2);
    }

    @Override
    public void a() {
        akx.h().a("Answers", "Flush events when app is backgrounded");
        this.a.c();
    }

    public void a(Activity activity, SessionEvent.Type type) {
        akx.h().a("Answers", "Logged lifecycle event: " + type.name());
        this.a.a(SessionEvent.a((SessionEvent.Type)type, (Activity)activity));
    }

    public void a(anl anl2, String string2) {
        this.c.a(anl2.h);
        this.a.a(anl2, string2);
    }

    public void a(String string2) {
    }

    public void a(String string2, String string3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        akx.h().a("Answers", "Logged crash");
        this.a.c(SessionEvent.a((String)string2, (String)string3));
    }

    public void a(ru ru2) {
        akx.h().a("Answers", "Logged custom event: " + ru2);
        this.a.a(SessionEvent.a((ru)ru2));
    }

    public void a(rz rz2) {
        akx.h().a("Answers", "Logged predefined event: " + rz2);
        this.a.a(SessionEvent.a((rz)rz2));
    }

    boolean a(long l2) {
        if (!this.d.b() && this.b(l2)) {
            return true;
        }
        return false;
    }

    public void b() {
        this.a.b();
        this.b.a(new rq(this, this.c));
        this.c.a(this);
        if (this.a(this.e)) {
            this.d();
            this.d.a();
        }
    }

    boolean b(long l2) {
        if (System.currentTimeMillis() - l2 < 3600000) {
            return true;
        }
        return false;
    }

    public void c() {
        this.b.a();
        this.a.a();
    }

    public void d() {
        akx.h().a("Answers", "Logged install");
        this.a.b(SessionEvent.a());
    }
}

