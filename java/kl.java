/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.content.Context;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class kl
implements mr<mj, InputStream> {
    private final Call.Factory a;

    public kl(Call.Factory factory) {
        this.a = factory;
    }

    @Override
    public ku<InputStream> a(mj mj2, int n2, int n3) {
        return new kk(this.a, mj2);
    }

    public static class a
    implements ms<mj, InputStream> {
        private static volatile Call.Factory a;
        private Call.Factory b;

        public a() {
            this(a.b());
        }

        public a(Call.Factory factory) {
            this.b = factory;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        private static Call.Factory b() {
            if (a != null) return a;
            reference var1 = a.class;
            // MONITORENTER : kl$a.class
            if (a == null) {
                a = new OkHttpClient();
            }
            // MONITOREXIT : var1
            return a;
        }

        @Override
        public mr<mj, InputStream> a(Context context, mi mi2) {
            return new kl(this.b);
        }

        @Override
        public void a() {
        }
    }

}

