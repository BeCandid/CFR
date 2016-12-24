/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class qh
implements qd,
qe {
    private qd a;
    private qd b;
    private qe c;

    public qh() {
        this(null);
    }

    public qh(qe qe2) {
        this.c = qe2;
    }

    private boolean j() {
        if (this.c == null || this.c.a(this)) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (this.c == null || this.c.b(this)) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (this.c != null && this.c.c()) {
            return true;
        }
        return false;
    }

    @Override
    public void a() {
        this.a.a();
        this.b.a();
    }

    public void a(qd qd2, qd qd3) {
        this.a = qd2;
        this.b = qd3;
    }

    @Override
    public boolean a(qd qd2) {
        if (super.j() && (qd2.equals((Object)this.a) || !this.a.h())) {
            return true;
        }
        return false;
    }

    @Override
    public void b() {
        if (!this.b.f()) {
            this.b.b();
        }
        if (!this.a.f()) {
            this.a.b();
        }
    }

    @Override
    public boolean b(qd qd2) {
        if (super.k() && qd2.equals((Object)this.a) && !this.c()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void c(qd qd2) {
        if (qd2.equals((Object)this.b)) {
            return;
        }
        if (this.c != null) {
            this.c.c((qd)this);
        }
        if (this.b.g()) return;
        this.b.d();
    }

    @Override
    public boolean c() {
        if (this.l() || this.h()) {
            return true;
        }
        return false;
    }

    @Override
    public void d() {
        this.b.d();
        this.a.d();
    }

    @Override
    public void e() {
        this.a.e();
        this.b.e();
    }

    @Override
    public boolean f() {
        return this.a.f();
    }

    @Override
    public boolean g() {
        if (this.a.g() || this.b.g()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean h() {
        if (this.a.h() || this.b.h()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean i() {
        return this.a.i();
    }
}

