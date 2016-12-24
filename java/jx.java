/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.support.v4.app.FragmentActivity
 *  android.util.Log
 *  android.widget.ImageView
 *  com.bumptech.glide.load.DecodeFormat
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 *  java.util.Iterator
 *  java.util.List
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class jx {
    private static volatile jx a;
    private final mi b;
    private final lc c;
    private final ln d;
    private final mb e;
    private final DecodeFormat f;
    private final qu g = new qu();
    private final pg h = new pg();
    private final pz i;
    private final nt j;
    private final pb k;
    private final nx l;
    private final pb m;
    private final Handler n;
    private final mf o;

    jx(lc lc2, mb mb2, ln ln2, Context context, DecodeFormat decodeFormat) {
        this.c = lc2;
        this.d = ln2;
        this.e = mb2;
        this.f = decodeFormat;
        this.b = new mi(context);
        this.n = new Handler(Looper.getMainLooper());
        this.o = new mf(mb2, ln2, decodeFormat);
        this.i = new pz();
        oc oc2 = new oc(ln2, decodeFormat);
        this.i.a(InputStream.class, Bitmap.class, oc2);
        nv nv2 = new nv(ln2, decodeFormat);
        this.i.a(ParcelFileDescriptor.class, Bitmap.class, nv2);
        ob ob2 = new ob(oc2, nv2);
        this.i.a(mm.class, Bitmap.class, ob2);
        oo oo2 = new oo(context, ln2);
        this.i.a(InputStream.class, on.class, oo2);
        this.i.a(mm.class, ow.class, new pc(ob2, oo2, ln2));
        this.i.a(InputStream.class, File.class, new ol());
        this.a(File.class, ParcelFileDescriptor.class, new my.a());
        this.a(File.class, InputStream.class, new nf.a());
        this.a(Integer.TYPE, ParcelFileDescriptor.class, new na.a());
        this.a(Integer.TYPE, InputStream.class, new nh.a());
        this.a(Integer.class, ParcelFileDescriptor.class, new na.a());
        this.a(Integer.class, InputStream.class, new nh.a());
        this.a(String.class, ParcelFileDescriptor.class, new nb.a());
        this.a(String.class, InputStream.class, new ni.a());
        this.a(Uri.class, ParcelFileDescriptor.class, new nc.a());
        this.a(Uri.class, InputStream.class, new nj.a());
        this.a(URL.class, InputStream.class, new nk.a());
        this.a(mj.class, InputStream.class, new nd.a());
        this.a(byte[].class, InputStream.class, new ne.a());
        this.h.a(Bitmap.class, ny.class, new pe(context.getResources(), ln2));
        this.h.a(ow.class, oh.class, new pd(new pe(context.getResources(), ln2)));
        this.j = new nt(ln2);
        this.k = new pb(ln2, this.j);
        this.l = new nx(ln2);
        this.m = new pb(ln2, this.l);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static jx a(Context context) {
        if (a != null) return a;
        reference var7_1 = jx.class;
        // MONITORENTER : jx.class
        if (a == null) {
            Context context2 = context.getApplicationContext();
            List<pv> list = new pw(context2).a();
            jy jy2 = new jy(context2);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((pv)iterator.next()).a(context2, jy2);
            }
            a = jy2.a();
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                ((pv)iterator2.next()).a(context2, a);
            }
        }
        // MONITOREXIT : var7_1
        return a;
    }

    public static jz a(FragmentActivity fragmentActivity) {
        return pr.a().a(fragmentActivity);
    }

    public static <T> mr<T, InputStream> a(Class<T> class_, Context context) {
        return jx.a(class_, InputStream.class, context);
    }

    public static <T, Y> mr<T, Y> a(Class<T> class_, Class<Y> class_2, Context context) {
        if (class_ == null) {
            if (Log.isLoggable((String)"Glide", (int)3)) {
                Log.d((String)"Glide", (String)"Unable to load null model, setting placeholder only");
            }
            return null;
        }
        return jx.a(context).i().a(class_, class_2);
    }

    public static void a(qy<?> qy2) {
        ri.a();
        qd qd2 = qy2.getRequest();
        if (qd2 != null) {
            qd2.d();
            qy2.setRequest(null);
        }
    }

    public static jz b(Context context) {
        return pr.a().a(context);
    }

    public static <T> mr<T, ParcelFileDescriptor> b(Class<T> class_, Context context) {
        return jx.a(class_, ParcelFileDescriptor.class, context);
    }

    private mi i() {
        return this.b;
    }

    public ln a() {
        return this.d;
    }

    <Z, R> pf<Z, R> a(Class<Z> class_, Class<R> class_2) {
        return this.h.a(class_, class_2);
    }

    <R> qy<R> a(ImageView imageView, Class<R> class_) {
        return this.g.a(imageView, class_);
    }

    public void a(int n2) {
        ri.a();
        this.e.a(n2);
        this.d.a(n2);
    }

    public <T, Y> void a(Class<T> class_, Class<Y> class_2, ms<T, Y> ms2) {
        ms<T, Y> ms3 = this.b.a(class_, class_2, ms2);
        if (ms3 != null) {
            ms3.a();
        }
    }

    lc b() {
        return this.c;
    }

    <T, Z> py<T, Z> b(Class<T> class_, Class<Z> class_2) {
        return this.i.a(class_, class_2);
    }

    nt c() {
        return this.j;
    }

    nx d() {
        return this.l;
    }

    pb e() {
        return this.k;
    }

    pb f() {
        return this.m;
    }

    DecodeFormat g() {
        return this.f;
    }

    public void h() {
        ri.a();
        this.e.a();
        this.d.a();
    }
}

