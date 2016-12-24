/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  java.lang.Object
 */
import android.annotation.SuppressLint;

public class ma
extends rf<kn, lj<?>>
implements mb {
    private mb.a a;

    public ma(int n2) {
        super(n2);
    }

    @Override
    protected int a(lj<?> lj2) {
        return lj2.c();
    }

    public /* synthetic */ lj a(kn kn2) {
        return (lj)super.c(kn2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @SuppressLint(value={"InlinedApi"})
    @Override
    public void a(int n2) {
        if (n2 >= 60) {
            this.a();
            return;
        } else {
            if (n2 < 40) return;
            {
                this.b(this.b() / 2);
                return;
            }
        }
    }

    @Override
    protected void a(kn kn2, lj<?> lj2) {
        if (this.a != null) {
            this.a.b(lj2);
        }
    }

    @Override
    public void a(mb.a a2) {
        this.a = a2;
    }
}

