/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.util.Collection
 *  java.util.concurrent.ExecutorService
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class alc<Result>
implements Comparable<alc> {
    akx e;
    alb<Result> f;
    Context g;
    ala<Result> h;
    IdManager i;
    final amd j;

    public alc() {
        this.f = new alb(this);
        this.j = (amd)this.getClass().getAnnotation((Class)amd.class);
    }

    final void C() {
        alb<Result> alb2 = this.f;
        ExecutorService executorService = this.e.f();
        Void[] arrvoid = new Void[]{null};
        alb2.a(executorService, (Params[])arrvoid);
    }

    protected IdManager D() {
        return this.i;
    }

    public Context E() {
        return this.g;
    }

    public akx F() {
        return this.e;
    }

    public String G() {
        return ".Fabric" + File.separator + this.b();
    }

    boolean H() {
        if (this.j != null) {
            return true;
        }
        return false;
    }

    protected Collection<amk> I() {
        return this.f.c();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int a(alc alc2) {
        if (this.b(alc2)) {
            return 1;
        }
        if (alc2.b((alc)this)) {
            return -1;
        }
        if (this.H()) {
            if (!alc2.H()) return 1;
        }
        if (this.H()) return 0;
        if (!alc2.H()) return 0;
        return -1;
    }

    public abstract String a();

    void a(Context context, akx akx2, ala<Result> ala2, IdManager idManager) {
        this.e = akx2;
        this.g = new aky(context, this.b(), this.G());
        this.h = ala2;
        this.i = idManager;
    }

    protected void a(Result Result2) {
    }

    protected boolean a_() {
        return true;
    }

    public abstract String b();

    protected void b(Result Result2) {
    }

    boolean b(alc alc2) {
        if (this.H()) {
            Class<?>[] arrclass = this.j.a();
            int n2 = arrclass.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!arrclass[i2].isAssignableFrom(alc2.getClass())) continue;
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((alc)object);
    }

    protected abstract Result f();
}

