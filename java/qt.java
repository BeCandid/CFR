/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 *  java.lang.Exception
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public abstract class qt<Z>
extends qz<ImageView, Z>
implements qk.a {
    public qt(ImageView imageView) {
        super(imageView);
    }

    @Override
    public Drawable getCurrentDrawable() {
        return ((ImageView)this.view).getDrawable();
    }

    @Override
    public void onLoadCleared(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    @Override
    public void onLoadFailed(Exception exception, Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    @Override
    public void onLoadStarted(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    @Override
    public void onResourceReady(Z z2, qk<? super Z> qk2) {
        if (qk2 == null || !qk2.a(z2, (qk.a)this)) {
            this.setResource(z2);
        }
    }

    @Override
    public void setDrawable(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    protected abstract void setResource(Z var1);
}

