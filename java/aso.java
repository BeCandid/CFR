/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.concurrent.ThreadFactory
 *  rx.internal.util.RxThreadFactory
 */
import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;

public final class aso
extends apo {
    private static final RxThreadFactory b = new RxThreadFactory("RxNewThreadScheduler-");
    private static final aso c = new aso();

    private aso() {
    }

    public static aso a() {
        return c;
    }

    @Override
    public apo.a createWorker() {
        return new aqt((ThreadFactory)b);
    }
}

