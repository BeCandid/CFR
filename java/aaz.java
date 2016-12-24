/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.util.SparseArray
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 */
import android.os.DeadObjectException;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;

public abstract class aaz {
    public final int a;
    public final int b;

    public void a(SparseArray<abq> sparseArray) {
    }

    public abstract void a(Status var1);

    public abstract void a(xf.c var1) throws DeadObjectException;

    public boolean a() {
        return true;
    }

    public static final class a
    extends aaz {
        public final abc.a<? extends xk, xf.c> c;

        @Override
        public void a(SparseArray<abq> sparseArray) {
            abq abq2 = (abq)sparseArray.get(this.a);
            if (abq2 != null) {
                abq2.a(this.c);
            }
        }

        @Override
        public void a(Status status) {
            this.c.a(status);
        }

        @Override
        public void a(xf.c c2) throws DeadObjectException {
            this.c.a((xk)((Object)c2));
        }

        @Override
        public boolean a() {
            return this.c.g();
        }
    }

}

