/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException
extends Exception {
    private static final Method addSuppressedExceptionMethod;
    private IOException lastException;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Method method;
        try {
            Method method2;
            method = method2 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        }
        catch (Exception var0_2) {
            method = null;
        }
        addSuppressedExceptionMethod = method;
    }

    public RouteException(IOException iOException) {
        super((Throwable)iOException);
        this.lastException = iOException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void addSuppressedIfPossible(IOException iOException, IOException iOException2) {
        if (addSuppressedExceptionMethod == null) return;
        try {
            addSuppressedExceptionMethod.invoke((Object)iOException, new Object[]{iOException2});
            return;
        }
        catch (IllegalAccessException var4_3) {
            return;
        }
        catch (InvocationTargetException var3_4) {
            return;
        }
    }

    public void addConnectException(IOException iOException) {
        super.addSuppressedIfPossible(iOException, this.lastException);
        this.lastException = iOException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }
}

