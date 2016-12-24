/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import java.io.InputStream;

public class ne
implements ng<byte[]> {
    private final String a;

    public ne() {
        this("");
    }

    @Deprecated
    public ne(String string2) {
        this.a = string2;
    }

    @Override
    public ku<InputStream> a(byte[] arrby, int n2, int n3) {
        return new kt(arrby, this.a);
    }

    public static class a
    implements ms<byte[], InputStream> {
        @Override
        public mr<byte[], InputStream> a(Context context, mi mi2) {
            return new ne();
        }

        @Override
        public void a() {
        }
    }

}

