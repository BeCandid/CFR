/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  com.crashlytics.android.answers.SessionEvent
 *  com.crashlytics.android.answers.SessionEvent$Type
 */
import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.answers.SessionEvent;

class rq
extends akv.b {
    private final sf a;
    private final rt b;

    public rq(sf sf2, rt rt2) {
        this.a = sf2;
        this.b = rt2;
    }

    @Override
    public void a(Activity activity) {
        this.a.a(activity, SessionEvent.Type.a);
    }

    @Override
    public void a(Activity activity, Bundle bundle) {
    }

    @Override
    public void b(Activity activity) {
        this.a.a(activity, SessionEvent.Type.b);
        this.b.a();
    }

    @Override
    public void b(Activity activity, Bundle bundle) {
    }

    @Override
    public void c(Activity activity) {
        this.a.a(activity, SessionEvent.Type.c);
        this.b.b();
    }

    @Override
    public void d(Activity activity) {
        this.a.a(activity, SessionEvent.Type.d);
    }

    @Override
    public void e(Activity activity) {
    }
}

