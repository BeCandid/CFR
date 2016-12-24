/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package okhttp3.internal;

public abstract class NamedRunnable
implements Runnable {
    protected final String name;

    public /* varargs */ NamedRunnable(String string2, Object ... arrobject) {
        this.name = String.format((String)string2, (Object[])arrobject);
    }

    public abstract void execute();

    public final void run() {
        String string2 = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            this.execute();
            return;
        }
        finally {
            Thread.currentThread().setName(string2);
        }
    }
}

