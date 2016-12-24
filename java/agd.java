/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.String
 */
public abstract class agd
extends ahm {
    private boolean a;

    public agd(ahk ahk2) {
        super(ahk2);
        this.n.a((agd)this);
    }

    boolean a() {
        if (this.a) {
            return true;
        }
        return false;
    }

    boolean b() {
        return false;
    }

    public void c() {
        if (!this.a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void d() {
        if (this.a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        this.e();
        this.n.I();
        this.a = true;
    }

    public abstract void e();
}

