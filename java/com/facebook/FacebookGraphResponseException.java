/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.facebook;

import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;

public class FacebookGraphResponseException
extends FacebookException {
    private final uo a;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final String toString() {
        FacebookRequestError facebookRequestError = this.a != null ? this.a.a() : null;
        StringBuilder stringBuilder = new StringBuilder().append("{FacebookGraphResponseException: ");
        String string2 = this.getMessage();
        if (string2 != null) {
            stringBuilder.append(string2);
            stringBuilder.append(" ");
        }
        if (facebookRequestError != null) {
            stringBuilder.append("httpResponseCode: ").append(facebookRequestError.a()).append(", facebookErrorCode: ").append(facebookRequestError.b()).append(", facebookErrorType: ").append(facebookRequestError.d()).append(", message: ").append(facebookRequestError.e()).append("}");
        }
        return stringBuilder.toString();
    }
}

