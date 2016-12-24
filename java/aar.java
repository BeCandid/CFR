/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicReference
 */
import android.content.Context;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class aar {
    private static final AtomicReference<aar> a = new AtomicReference();

    aar(Context context) {
    }

    public static aar a() {
        return (aar)a.get();
    }

    public static aar a(Context context) {
        a.compareAndSet((Object)null, (Object)new aar(context));
        return (aar)a.get();
    }

    public void a(ahv ahv2) {
    }

    public Set<String> b() {
        return Collections.emptySet();
    }
}

