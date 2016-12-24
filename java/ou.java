/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.util.Log
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Queue
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ou
implements kp<InputStream, on> {
    private static final b a = new b();
    private static final a b = new a();
    private final Context c;
    private final b d;
    private final ln e;
    private final a f;
    private final om g;

    public ou(Context context, ln ln2) {
        super(context, ln2, a, b);
    }

    ou(Context context, ln ln2, b b2, a a2) {
        this.c = context;
        this.e = ln2;
        this.f = a2;
        this.g = new om(ln2);
        this.d = b2;
    }

    private Bitmap a(kd kd2, kf kf2, byte[] arrby) {
        kd2.a(kf2, arrby);
        kd2.a();
        return kd2.f();
    }

    /*
     * Enabled aggressive block sorting
     */
    private op a(byte[] arrby, int n2, int n3, kg kg2, kd kd2) {
        Bitmap bitmap;
        kf kf2 = kg2.b();
        if (kf2.a() <= 0 || kf2.b() != 0 || (bitmap = this.a(kd2, kf2, arrby)) == null) {
            return null;
        }
        no<Bitmap> no2 = no.b();
        return new op(new on(this.c, this.g, this.e, no2, n2, n3, kf2, arrby, bitmap));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            int n2;
            byte[] arrby = new byte[16384];
            while ((n2 = inputStream.read(arrby)) != -1) {
                byteArrayOutputStream.write(arrby, 0, n2);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException var2_4) {
            Log.w((String)"GifResourceDecoder", (String)"Error reading data from stream", (Throwable)var2_4);
            return byteArrayOutputStream.toByteArray();
        }
    }

    @Override
    public String a() {
        return "";
    }

    public op a(InputStream inputStream, int n2, int n3) {
        byte[] arrby = ou.a(inputStream);
        kg kg2 = this.d.a(arrby);
        kd kd2 = this.f.a(this.g);
        try {
            op op2 = super.a(arrby, n2, n3, kg2, kd2);
            return op2;
        }
        finally {
            this.d.a(kg2);
            this.f.a(kd2);
        }
    }

    static class a {
        private final Queue<kd> a = ri.a(0);

        a() {
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public kd a(kd.a a2) {
            void var4_2 = this;
            synchronized (var4_2) {
                kd kd2 = (kd)this.a.poll();
                if (kd2 != null) return kd2;
                return new kd(a2);
            }
        }

        public void a(kd kd2) {
            void var4_2 = this;
            synchronized (var4_2) {
                kd2.g();
                this.a.offer((Object)kd2);
                return;
            }
        }
    }

    static class b {
        private final Queue<kg> a = ri.a(0);

        b() {
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public kg a(byte[] arrby) {
            void var5_2 = this;
            synchronized (var5_2) {
                kg kg2 = (kg)this.a.poll();
                if (kg2 != null) return kg2.a(arrby);
                kg2 = new kg();
                return kg2.a(arrby);
            }
        }

        public void a(kg kg2) {
            void var4_2 = this;
            synchronized (var4_2) {
                kg2.a();
                this.a.offer((Object)kg2);
                return;
            }
        }
    }

}

