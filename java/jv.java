/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.request.GenericRequest
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.GenericRequest;

public class jv<ModelType, DataType, ResourceType, TranscodeType>
implements Cloneable {
    private boolean A;
    private Drawable B;
    private int C;
    protected final Class<ModelType> a;
    protected final Context b;
    protected final jx c;
    protected final Class<TranscodeType> d;
    protected final pt e;
    protected final po f;
    private px<ModelType, DataType, ResourceType, TranscodeType> g;
    private ModelType h;
    private kn i;
    private boolean j;
    private int k;
    private int l;
    private qf<? super ModelType, TranscodeType> m;
    private Float n;
    private jv<?, ?, ?, TranscodeType> o;
    private Float p;
    private Drawable q;
    private Drawable r;
    private Priority s;
    private boolean t;
    private ql<TranscodeType> u;
    private int v;
    private int w;
    private DiskCacheStrategy x;
    private kr<ResourceType> y;
    private boolean z;

    jv(Context context, Class<ModelType> class_, qc<ModelType, DataType, ResourceType, TranscodeType> qc2, Class<TranscodeType> class_2, jx jx2, pt pt2, po po2) {
        this.i = ra.a();
        this.p = Float.valueOf((float)1.0f);
        this.s = null;
        this.t = true;
        this.u = qm.a();
        this.v = -1;
        this.w = -1;
        this.x = DiskCacheStrategy.d;
        this.y = no.b();
        this.b = context;
        this.a = class_;
        this.d = class_2;
        this.c = jx2;
        this.e = pt2;
        this.f = po2;
        px<ModelType, DataType, ResourceType, TranscodeType> px2 = null;
        if (qc2 != null) {
            px2 = new px<ModelType, DataType, ResourceType, TranscodeType>(qc2);
        }
        this.g = px2;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (class_ != null && qc2 == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    jv(qc<ModelType, DataType, ResourceType, TranscodeType> qc2, Class<TranscodeType> class_, jv<ModelType, ?, ?, ?> jv2) {
        super(jv2.b, jv2.a, qc2, class_, jv2.c, jv2.e, jv2.f);
        this.h = jv2.h;
        this.j = jv2.j;
        this.i = jv2.i;
        this.x = jv2.x;
        this.t = jv2.t;
    }

    private Priority a() {
        if (this.s == Priority.d) {
            return Priority.c;
        }
        if (this.s == Priority.c) {
            return Priority.b;
        }
        return Priority.a;
    }

    private qd a(qy<TranscodeType> qy2, float f2, Priority priority, qe qe2) {
        return GenericRequest.a(this.g, this.h, (kn)this.i, (Context)this.b, (Priority)priority, qy2, (float)f2, (Drawable)this.q, (int)this.k, (Drawable)this.r, (int)this.l, (Drawable)this.B, (int)this.C, this.m, (qe)qe2, (lc)this.c.b(), this.y, this.d, (boolean)this.t, this.u, (int)this.w, (int)this.v, (DiskCacheStrategy)this.x);
    }

    private qd a(qy<TranscodeType> qy2, qh qh2) {
        if (this.o != null) {
            if (this.A) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.o.u.equals(qm.a())) {
                this.o.u = this.u;
            }
            if (this.o.s == null) {
                this.o.s = super.a();
            }
            if (ri.a(this.w, this.v) && !ri.a(this.o.w, this.o.v)) {
                this.o.b(this.w, this.v);
            }
            qh qh3 = new qh(qh2);
            qd qd2 = super.a(qy2, this.p.floatValue(), this.s, qh3);
            this.A = true;
            qd qd3 = super.a(qy2, qh3);
            this.A = false;
            qh3.a(qd2, qd3);
            return qh3;
        }
        if (this.n != null) {
            qh qh4 = new qh(qh2);
            qh4.a(super.a(qy2, this.p.floatValue(), this.s, qh4), super.a(qy2, this.n.floatValue(), super.a(), qh4));
            return qh4;
        }
        return super.a(qy2, this.p.floatValue(), this.s, qh2);
    }

    private qd b(qy<TranscodeType> qy2) {
        if (this.s == null) {
            this.s = Priority.c;
        }
        return super.a(qy2, null);
    }

    jv<ModelType, DataType, ResourceType, TranscodeType> a(ql<TranscodeType> ql2) {
        if (ql2 == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.u = ql2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public qy<TranscodeType> a(ImageView imageView) {
        ri.a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (this.z) return this.a(this.c.a(imageView, this.d));
        if (imageView.getScaleType() == null) return this.a(this.c.a(imageView, this.d));
        switch (.a[imageView.getScaleType().ordinal()]) {
            case 1: {
                this.f();
            }
            default: {
                return this.a(this.c.a(imageView, this.d));
            }
            case 2: 
            case 3: 
            case 4: 
        }
        this.e();
        return this.a(this.c.a(imageView, this.d));
    }

    public <Y extends qy<TranscodeType>> Y a(Y y2) {
        ri.a();
        if (y2 == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.j) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        qd qd2 = y2.getRequest();
        if (qd2 != null) {
            qd2.d();
            this.e.b(qd2);
            qd2.a();
        }
        qd qd3 = super.b((qy<TranscodeType>)y2);
        y2.setRequest(qd3);
        this.f.a((pp)y2);
        this.e.a(qd3);
        return y2;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(int n2) {
        this.k = n2;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(int n2, int n3) {
        if (!ri.a(n2, n3)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.w = n2;
        this.v = n3;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(DiskCacheStrategy diskCacheStrategy) {
        this.x = diskCacheStrategy;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(ModelType ModelType) {
        this.h = ModelType;
        this.j = true;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(km<DataType> km2) {
        if (this.g != null) {
            this.g.a(km2);
        }
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(kn kn2) {
        if (kn2 == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.i = kn2;
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(kp<DataType, ResourceType> kp2) {
        if (this.g != null) {
            this.g.a(kp2);
        }
        return this;
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> b(qf<? super ModelType, TranscodeType> qf2) {
        this.m = qf2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public jv<ModelType, DataType, ResourceType, TranscodeType> b(boolean bl2) {
        boolean bl3 = !bl2;
        this.t = bl3;
        return this;
    }

    public /* varargs */ jv<ModelType, DataType, ResourceType, TranscodeType> b(kr<ResourceType> ... arrkr) {
        this.z = true;
        if (arrkr.length == 1) {
            this.y = arrkr[0];
            return this;
        }
        this.y = new ko<ResourceType>(arrkr);
        return this;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.g();
    }

    void e() {
    }

    void f() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public jv<ModelType, DataType, ResourceType, TranscodeType> g() {
        try {
            jv jv2 = (jv)super.clone();
            px<ModelType, DataType, ResourceType, TranscodeType> px2 = this.g != null ? this.g.g() : null;
            jv2.g = px2;
            return jv2;
        }
        catch (CloneNotSupportedException var1_3) {
            throw new RuntimeException((Throwable)var1_3);
        }
    }

    public jv<ModelType, DataType, ResourceType, TranscodeType> h() {
        return this.a((Y)qm.a());
    }

}

