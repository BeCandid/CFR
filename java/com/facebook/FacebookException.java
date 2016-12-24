/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.facebook;

public class FacebookException
extends RuntimeException {
    public FacebookException() {
    }

    public FacebookException(String string2) {
        super(string2);
    }

    public FacebookException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public /* varargs */ FacebookException(String string2, Object ... arrobject) {
        super(String.format((String)string2, (Object[])arrobject));
    }

    public FacebookException(Throwable throwable) {
        super(throwable);
    }

    public String toString() {
        return this.getMessage();
    }
}

