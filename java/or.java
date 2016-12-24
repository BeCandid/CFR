/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.io.UnsupportedEncodingException
 *  java.lang.Class
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.security.MessageDigest
 *  java.util.UUID
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

class or {
    private final b a;
    private final kd b;
    private final Handler c;
    private boolean d = false;
    private boolean e = false;
    private jv<kd, kd, Bitmap, Bitmap> f;
    private a g;
    private boolean h;

    public or(Context context, b b2, kd kd2, int n2, int n3) {
        this(b2, kd2, null, or.a(context, kd2, n2, n3, jx.a(context).a()));
    }

    or(b b2, kd kd2, Handler handler, jv<kd, kd, Bitmap, Bitmap> jv2) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), (Handler.Callback)new c((or)this, null));
        }
        this.a = b2;
        this.b = kd2;
        this.c = handler;
        this.f = jv2;
    }

    private static jv<kd, kd, Bitmap, Bitmap> a(Context context, kd kd2, int n2, int n3, ln ln2) {
        ot ot2 = new ot(ln2);
        os os2 = new os();
        km km2 = nl.b();
        return jx.b(context).a(os2, kd.class).a((Object)kd2).a(Bitmap.class).b(km2).b(ot2).b(true).b(DiskCacheStrategy.b).b(n2, n3);
    }

    private void e() {
        if (!this.d || this.e) {
            return;
        }
        this.e = true;
        this.b.a();
        long l2 = SystemClock.uptimeMillis() + (long)this.b.b();
        a a2 = new a(this.c, this.b.d(), l2);
        this.f.b(new d()).a((a)a2);
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.h = false;
        this.e();
    }

    public void a(kr<Bitmap> kr2) {
        if (kr2 == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f = this.f.b(kr2);
    }

    void a(a a2) {
        if (this.h) {
            this.c.obtainMessage(2, (Object)a2).sendToTarget();
            return;
        }
        a a3 = this.g;
        this.g = a2;
        this.a.b(a2.b);
        if (a3 != null) {
            this.c.obtainMessage(2, (Object)a3).sendToTarget();
        }
        this.e = false;
        super.e();
    }

    public void b() {
        this.d = false;
    }

    public void c() {
        this.b();
        if (this.g != null) {
            jx.a(this.g);
            this.g = null;
        }
        this.h = true;
    }

    public Bitmap d() {
        if (this.g != null) {
            return this.g.a();
        }
        return null;
    }

    static class a
    extends qv<Bitmap> {
        private final Handler a;
        private final int b;
        private final long c;
        private Bitmap d;

        public a(Handler handler, int n2, long l2) {
            this.a = handler;
            this.b = n2;
            this.c = l2;
        }

        public Bitmap a() {
            return this.d;
        }

        public void a(Bitmap bitmap, qk<? super Bitmap> qk2) {
            this.d = bitmap;
            Message message = this.a.obtainMessage(1, (Object)this);
            this.a.sendMessageAtTime(message, this.c);
        }

        @Override
        public /* synthetic */ void onResourceReady(Object object, qk qk2) {
            this.a((Bitmap)object, qk2);
        }
    }

    public static interface b {
        public void b(int var1);
    }

    class c
    implements Handler.Callback {
        final /* synthetic */ or a;

        private c(or or2) {
            this.a = or2;
        }

        /* synthetic */ c(or or2,  var2_2) {
            super(or2);
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                a a2 = (a)message.obj;
                this.a.a(a2);
                return true;
            }
            if (message.what == 2) {
                jx.a((a)message.obj);
            }
            return false;
        }
    }

    static class d
    implements kn {
        private final UUID a;

        public d() {
            this(UUID.randomUUID());
        }

        d(UUID uUID) {
            this.a = uUID;
        }

        @Override
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        public boolean equals(Object object) {
            if (object instanceof d) {
                return ((d)object).a.equals((Object)this.a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

}

