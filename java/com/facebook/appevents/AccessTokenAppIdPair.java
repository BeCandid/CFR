/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.facebook.appevents;

import com.facebook.AccessToken;
import java.io.Serializable;

public class AccessTokenAppIdPair
implements Serializable {
    private final String a;
    private final String b;

    public AccessTokenAppIdPair(AccessToken accessToken) {
        super(accessToken.b(), ul.i());
    }

    public AccessTokenAppIdPair(String string2, String string3) {
        if (we.a(string2)) {
            string2 = null;
        }
        this.a = string2;
        this.b = string3;
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.a, this.b, null);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof AccessTokenAppIdPair)) {
            return false;
        }
        AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair)object;
        if (!we.a(accessTokenAppIdPair.a, this.a)) return false;
        if (!we.a(accessTokenAppIdPair.b, this.b)) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = this.a == null ? 0 : this.a.hashCode();
        String string2 = this.b;
        int n3 = 0;
        if (string2 == null) {
            return n2 ^ n3;
        }
        n3 = this.b.hashCode();
        return n2 ^ n3;
    }

    public static class SerializationProxyV1
    implements Serializable {
        private final String a;
        private final String b;

        private SerializationProxyV1(String string2, String string3) {
            this.a = string2;
            this.b = string3;
        }

        /* synthetic */ SerializationProxyV1(String string2, String string3,  var3_2) {
            super(string2, string3);
        }

        private Object readResolve() {
            return new AccessTokenAppIdPair(this.a, this.b);
        }
    }

}

