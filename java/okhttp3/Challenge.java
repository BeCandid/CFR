/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3;

import okhttp3.internal.Util;

public final class Challenge {
    private final String realm;
    private final String scheme;

    public Challenge(String string2, String string3) {
        this.scheme = string2;
        this.realm = string3;
    }

    public boolean equals(Object object) {
        if (object instanceof Challenge && Util.equal(this.scheme, ((Challenge)object).scheme) && Util.equal(this.realm, ((Challenge)object).realm)) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = this.realm != null ? this.realm.hashCode() : 0;
        int n3 = 31 * (n2 + 899);
        String string2 = this.scheme;
        int n4 = 0;
        if (string2 != null) {
            n4 = this.scheme.hashCode();
        }
        return n3 + n4;
    }

    public String realm() {
        return this.realm;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " realm=\"" + this.realm + "\"";
    }
}

