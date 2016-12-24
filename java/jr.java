/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  android.widget.ImageView
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.InputStream;

public class jr<ModelType, TranscodeType>
extends jv<ModelType, mm, Bitmap, TranscodeType> {
    private final ln g;
    private nu h = nu.a;
    private DecodeFormat i;
    private kp<InputStream, Bitmap> j;
    private kp<ParcelFileDescriptor, Bitmap> k;

    jr(qc<ModelType, mm, Bitmap, TranscodeType> qc2, Class<TranscodeType> class_, jv<ModelType, ?, ?, ?> jv2) {
        super(qc2, class_, jv2);
        this.g = jv2.c.a();
        this.i = jv2.c.g();
        this.j = new od(this.g, this.i);
        this.k = new nw(this.g, this.i);
    }

    public jr<ModelType, TranscodeType> a() {
        ns[] arrns = new ns[]{this.c.c()};
        return this.a(arrns);
    }

    @Override
    public jr<ModelType, TranscodeType> a(int n2) {
        super.b(n2);
        return this;
    }

    public jr<ModelType, TranscodeType> a(int n2, int n3) {
        super.b(n2, n3);
        return this;
    }

    @Override
    public jr<ModelType, TranscodeType> a(DiskCacheStrategy diskCacheStrategy) {
        super.b(diskCacheStrategy);
        return this;
    }

    @Override
    public jr<ModelType, TranscodeType> a(ModelType ModelType) {
        super.b(ModelType);
        return this;
    }

    @Override
    public jr<ModelType, TranscodeType> a(km<mm> km2) {
        super.b(km2);
        return this;
    }

    @Override
    public jr<ModelType, TranscodeType> a(kn kn2) {
        super.b(kn2);
        return this;
    }

    @Override
    public jr<ModelType, TranscodeType> a(kp<mm, Bitmap> kp2) {
        super.b(kp2);
        return this;
    }

    @Override
    public jr<ModelType, TranscodeType> a(qf<? super ModelType, TranscodeType> qf2) {
        super.b(qf2);
        return this;
    }

    @Override
    public jr<ModelType, TranscodeType> a(boolean bl2) {
        super.b(bl2);
        return this;
    }

    @Override
    public /* varargs */ jr<ModelType, TranscodeType> a(kr<Bitmap> ... arrkr) {
        super.b((kr<ResourceType>[])arrkr);
        return this;
    }

    @Override
    public /* varargs */ jr<ModelType, TranscodeType> a(ns ... arrns) {
        super.b(arrns);
        return this;
    }

    @Override
    public qy<TranscodeType> a(ImageView imageView) {
        return super.a(imageView);
    }

    public jr<ModelType, TranscodeType> b() {
        ns[] arrns = new ns[]{this.c.d()};
        return this.a(arrns);
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
        return this.a(arrkr);
    }

    public jr<ModelType, TranscodeType> c() {
        super.h();
        return this;
    }

    @Override
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.d();
    }

    public jr<ModelType, TranscodeType> d() {
        return (jr)super.g();
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
        return this.d();
    }

    @Override
    public /* synthetic */ jv h() {
        return this.c();
    }
}

