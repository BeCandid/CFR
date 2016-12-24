/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Throwable
 */
package okhttp3.internal.http;

import java.io.IOException;

public final class RequestException
extends Exception {
    public RequestException(IOException iOException) {
        super((Throwable)iOException);
    }

    public IOException getCause() {
        return (IOException)super.getCause();
    }
}

