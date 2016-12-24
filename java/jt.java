/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.widget.ImageView
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class jt<ModelType>
extends jv<ModelType, mm, ow, oh> {
    jt(Context context, Class<ModelType> class_, qc<ModelType, mm, ow, oh> qc2, jx jx2, pt pt2, po po2) {
        super(context, class_, qc2, oh.class, jx2, pt2, po2);
        this.c();
    }

    public jt<ModelType> a() {
        kr[] arrkr = new kr[]{this.c.e()};
        return this.c(arrkr);
    }

    @Override
    public jt<ModelType> a(int n2) {
        super.b(n2);
        return this;
    }

    public jt<ModelType> a(int n2, int n3) {
        super.b(n2, n3);
        return this;
    }

    @Override
    public jt<ModelType> a(DiskCacheStrategy diskCacheStrategy) {
        super.b(diskCacheStrategy);
        return this;
    }

    @Override
    public jt<ModelType> a(ModelType ModelType) {
        super.b(ModelType);
        return this;
    }

    @Override
    public jt<ModelType> a(km<mm> km2) {
        super.b(km2);
        return this;
    }

    @Override
    public jt<ModelType> a(kn kn2) {
        super.b(kn2);
        return this;
    }

    @Override
    public jt<ModelType> a(kp<mm, ow> kp2) {
        super.b(kp2);
        return this;
    }

    @Override
    public jt<ModelType> a(qf<? super ModelType, oh> qf2) {
        super.b(qf2);
        return this;
    }

    @Override
    public jt<ModelType> a(boolean bl2) {
        super.b(bl2);
        return this;
    }

    @Override
    public /* varargs */ jt<ModelType> a(kr<Bitmap> ... arrkr) {
        pb[] arrpb = new pb[arrkr.length];
        for (int i2 = 0; i2 < arrkr.length; ++i2) {
            arrpb[i2] = new pb(this.c.a(), arrkr[i2]);
        }
        return this.c(arrpb);
    }

    @Override
    public /* varargs */ jt<ModelType> a(ns ... arrns) {
        return this.a((kr<Bitmap>[])arrns);
    }

    @Override
    public qy<oh> a(ImageView imageView) {
        return super.a(imageView);
    }

    public jt<ModelType> b() {
        kr[] arrkr = new kr[]{this.c.f()};
        return this.c(arrkr);
    }

    @Override
    public /* synthetic */ jv b(int n2) {
        return this.a((ModelType)n2);
    }

    @Override
    public /* synthetic */ jv b(int n2, int n3) {
        return this.a(n2, n3);
    }

    @Override
    public /* synthetic */ jv b(DiskCacheStrategy diskCacheStrategy) {
        return this.a((ModelType)diskCacheStrategy);
    }

    @Override
    public /* synthetic */ jv b(Object object) {
        return this.a(object);
    }

    @Override
    public /* synthetic */ jv b(km km2) {
        return this.a(km2);
    }

    @Override
    public /* synthetic */ jv b(kn kn2) {
        return this.a(kn2);
    }

    @Override
    public /* synthetic */ jv b(kp kp2) {
        return this.a(kp2);
    }

    @Override
    public /* synthetic */ jv b(qf qf2) {
        return this.a(qf2);
    }

    @Override
    public /* synthetic */ jv b(boolean bl2) {
        return this.a(bl2);
    }

    @Override
    public /* synthetic */ jv b(kr[] arrkr) {
        return this.c(arrkr);
    }

    public final jt<ModelType> c() {
        super.a(new qi());
        return this;
    }

    public /* varargs */ jt<ModelType> c(kr<ow> ... arrkr) {
        super.b((kr<ResourceType>[])arrkr);
        return this;
    }

    @Override
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.i();
    }

    public jt<ModelType> d() {
        super.h();
        return this;
    }

    @Override
    void e() {
        this.b();
    }

    @Override
    void f() {
        this.a();
    }

    @Override
    public /* synthetic */ jv g() {
        return this.i();
    }

    @Override
    public /* synthetic */ jv h() {
        return this.d();
    }

    public jt<ModelType> i() {
        return (jt)super.g();
    }
}

