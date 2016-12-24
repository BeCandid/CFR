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

public class nd
implements mr<mj, InputStream> {
    private final mq<mj, mj> a;

    public nd() {
        this(null);
    }

    public nd(mq<mj, mj> mq2) {
        this.a = mq2;
    }

    @Override
    public ku<InputStream> a(mj mj2, int n2, int n3) {
        mj mj3 = mj2;
        if (this.a != null && (mj3 = this.a.a(mj2, 0, 0)) == null) {
            this.a.a(mj2, 0, 0, mj2);
            mj3 = mj2;
        }
        return new kx(mj3);
    }

    public static class a
    implements ms<mj, InputStream> {
        private final mq<mj, mj> a = new mq(500);

        @Override
        public mr<mj, InputStream> a(Context context, mi mi2) {
            return new nd(this.a);
        }

        @Override
        public void a() {
        }
    }

}

