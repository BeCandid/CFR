/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.zzamc
 *  java.io.IOException
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.String
 */
import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public abstract class aau {
    protected volatile int a = -1;

    public int a() {
        if (this.a < 0) {
            this.b();
        }
        return this.a;
    }

    public abstract aau a(aas var1) throws IOException;

    public void a(zzamc zzamc2) throws IOException {
    }

    public int b() {
        int n2;
        this.a = n2 = this.c();
        return n2;
    }

    protected int c() {
        return 0;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.d();
    }

    public aau d() throws CloneNotSupportedException {
        return (aau)super.clone();
    }

    public String toString() {
        return aav.a(this);
    }
}

