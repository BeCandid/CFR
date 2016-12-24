/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class vc {
    private static final String a = vc.class.getCanonicalName();
    private static final ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();
    private static AtomicInteger c = new AtomicInteger(0);
    private static volatile ve d;
    private static AtomicBoolean e;

    static {
        e = new AtomicBoolean(false);
    }

    public static UUID a() {
        if (d != null) {
            return d.a();
        }
        return null;
    }
}

