/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class qr
extends qt<Drawable> {
    public qr(ImageView imageView) {
        super(imageView);
    }

    protected void a(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    @Override
    protected /* synthetic */ void setResource(Object object) {
        this.a((Drawable)object);
    }
}

