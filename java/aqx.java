/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
import java.io.PrintStream;

public final class aqx {
    public static void a(Throwable throwable) {
        try {
            ask.a().b().a(throwable);
            return;
        }
        catch (Throwable var1_1) {
            aqx.b(var1_1);
            return;
        }
    }

    private static void b(Throwable throwable) {
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + throwable.getMessage());
        throwable.printStackTrace();
    }
}

