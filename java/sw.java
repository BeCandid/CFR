/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class sw {
    public static final sw a = new sw(new byte[0]);
    private final byte[] b;
    private volatile int c = 0;

    private sw(byte[] arrby) {
        this.b = arrby;
    }

    public static sw a(String string2) {
        try {
            sw sw2 = new sw(string2.getBytes("UTF-8"));
            return sw2;
        }
        catch (UnsupportedEncodingException var2_2) {
            throw new RuntimeException("UTF-8 not supported.", (Throwable)var2_2);
        }
    }

    public static sw a(byte[] arrby, int n2, int n3) {
        byte[] arrby2 = new byte[n3];
        System.arraycopy((Object)arrby, (int)n2, (Object)arrby2, (int)0, (int)n3);
        return new sw(arrby2);
    }

    public int a() {
        return this.b.length;
    }

    public void a(byte[] arrby, int n2, int n3, int n4) {
        System.arraycopy((Object)this.b, (int)n2, (Object)arrby, (int)n3, (int)n4);
    }

    public InputStream b() {
        return new ByteArrayInputStream(this.b);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof sw)) {
            return false;
        }
        sw sw2 = (sw)object;
        int n2 = this.b.length;
        if (n2 != sw2.b.length) {
            return false;
        }
        byte[] arrby = this.b;
        byte[] arrby2 = sw2.b;
        int n3 = 0;
        while (n3 < n2) {
            if (arrby[n3] != arrby2[n3]) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public int hashCode() {
        int n2 = this.c;
        if (n2 == 0) {
            int n3;
            byte[] arrby = this.b;
            n2 = n3 = this.b.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                n2 = n2 * 31 + arrby[i2];
            }
            if (n2 == 0) {
                n2 = 1;
            }
            this.c = n2;
        }
        return n2;
    }
}

