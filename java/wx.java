/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 */
import android.os.Bundle;
import com.facebook.FacebookException;

public abstract class wx {
    private uk a;

    public wx(uk uk2) {
        this.a = uk2;
    }

    public void a(vf vf2) {
        if (this.a != null) {
            this.a.onCancel();
        }
    }

    public abstract void a(vf var1, Bundle var2);

    public void a(vf vf2, FacebookException facebookException) {
        if (this.a != null) {
            this.a.onError(facebookException);
        }
    }
}

