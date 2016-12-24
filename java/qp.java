/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Exception
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;

public abstract class qp<Z>
implements qy<Z> {
    private qd a;

    @Override
    public qd getRequest() {
        return this.a;
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onLoadCleared(Drawable drawable) {
    }

    @Override
    public void onLoadFailed(Exception exception, Drawable drawable) {
    }

    @Override
    public void onLoadStarted(Drawable drawable) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setRequest(qd qd2) {
        this.a = qd2;
    }
}

