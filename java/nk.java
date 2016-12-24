/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.net.URL
 */
import android.content.Context;
import java.io.InputStream;
import java.net.URL;

public class nk
extends mx<InputStream> {
    public nk(mr<mj, InputStream> mr2) {
        super(mr2);
    }

    public static class a
    implements ms<URL, InputStream> {
        @Override
        public mr<URL, InputStream> a(Context context, mi mi2) {
            return new nk(mi2.a(mj.class, InputStream.class));
        }

        @Override
        public void a() {
        }
    }

}

