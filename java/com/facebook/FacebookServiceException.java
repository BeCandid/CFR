/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.facebook;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;

public class FacebookServiceException
extends FacebookException {
    private final FacebookRequestError a;

    public FacebookServiceException(FacebookRequestError facebookRequestError, String string2) {
        super(string2);
        this.a = facebookRequestError;
    }

    public final FacebookRequestError a() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "{FacebookServiceException: " + "httpResponseCode: " + this.a.a() + ", facebookErrorCode: " + this.a.b() + ", facebookErrorType: " + this.a.d() + ", message: " + this.a.e() + "}";
    }
}

