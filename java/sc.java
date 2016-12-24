/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.crashlytics.android.answers.SamplingEventFilter
 *  com.crashlytics.android.answers.SamplingEventFilter$1
 *  com.crashlytics.android.answers.SessionEvent
 *  com.crashlytics.android.answers.SessionEvent$Type
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 *  rx
 */
import com.crashlytics.android.answers.SamplingEventFilter;
import com.crashlytics.android.answers.SessionEvent;
import java.util.Set;

public class sc
implements rx {
    static final Set<SessionEvent.Type> b = new SamplingEventFilter.1();
    final int a;

    public sc(int n2) {
        this.a = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(SessionEvent sessionEvent) {
        boolean bl2 = b.contains((Object)sessionEvent.c) && sessionEvent.a.g == null;
        if (Math.abs((int)(sessionEvent.a.c.hashCode() % this.a)) == 0) return false;
        boolean bl3 = true;
        if (!bl2) return false;
        if (bl3) {
            return true;
        }
        return false;
    }
}

