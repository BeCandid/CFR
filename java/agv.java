/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.measurement.internal.EventParams
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Set
 */
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParams;
import java.util.Iterator;
import java.util.Set;

public class agv {
    final String a;
    final String b;
    final String c;
    final long d;
    final long e;
    final EventParams f;

    agv(ahk ahk2, String string2, String string3, String string4, long l2, long l3, Bundle bundle) {
        xz.a(string3);
        xz.a(string4);
        this.a = string3;
        this.b = string4;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = null;
        }
        this.c = string2;
        this.d = l2;
        this.e = l3;
        if (this.e != 0 && this.e > this.d) {
            ahk2.f().z().a("Event created with reverse previous/current timestamps");
        }
        this.f = this.a(ahk2, bundle);
    }

    private agv(ahk ahk2, String string2, String string3, String string4, long l2, long l3, EventParams eventParams) {
        xz.a(string3);
        xz.a(string4);
        xz.a(eventParams);
        this.a = string3;
        this.b = string4;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = null;
        }
        this.c = string2;
        this.d = l2;
        this.e = l3;
        if (this.e != 0 && this.e > this.d) {
            ahk2.f().z().a("Event created with reverse previous/current timestamps");
        }
        this.f = eventParams;
    }

    agv a(ahk ahk2, long l2) {
        return new agv(ahk2, this.c, this.a, this.b, this.d, l2, this.f);
    }

    EventParams a(ahk ahk2, Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator iterator = bundle2.keySet().iterator();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                if (string2 == null) {
                    ahk2.f().f().a("Param name can't be null");
                    iterator.remove();
                    continue;
                }
                Object object = ahk2.n().b(string2, bundle2.get(string2));
                if (object == null) {
                    ahk2.f().z().a("Param value can't be null", string2);
                    iterator.remove();
                    continue;
                }
                ahk2.n().a(bundle2, string2, object);
            }
            return new EventParams(bundle2);
        }
        return new EventParams(new Bundle());
    }

    public String toString() {
        String string2 = this.a;
        String string3 = this.b;
        String string4 = String.valueOf((Object)this.f);
        return new StringBuilder(33 + String.valueOf((Object)string2).length() + String.valueOf((Object)string3).length() + String.valueOf((Object)string4).length()).append("Event{appId='").append(string2).append("'").append(", name='").append(string3).append("'").append(", params=").append(string4).append("}").toString();
    }
}

