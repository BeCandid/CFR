/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

class li
implements kn {
    private final String a;
    private final kn b;

    public li(String string2, kn kn2) {
        this.a = string2;
        this.b = kn2;
    }

    @Override
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.a.getBytes("UTF-8"));
        this.b.a(messageDigest);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        li li2 = (li)object;
        if (!this.a.equals((Object)li2.a)) {
            return false;
        }
        if (this.b.equals((Object)li2.b)) return true;
        return false;
    }

    public int hashCode() {
        return 31 * this.a.hashCode() + this.b.hashCode();
    }
}

