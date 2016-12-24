/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 *  java.lang.Math
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class qs
extends qt<oh> {
    private int a;
    private oh b;

    public qs(ImageView imageView) {
        super(imageView, -1);
    }

    public qs(ImageView imageView, int n2) {
        super(imageView);
        this.a = n2;
    }

    protected void a(oh oh2) {
        ((ImageView)this.view).setImageDrawable((Drawable)oh2);
    }

    public void a(oh oh2, qk<? super oh> qk2) {
        if (!oh2.a()) {
            float f2 = (float)((ImageView)this.view).getWidth() / (float)((ImageView)this.view).getHeight();
            float f3 = (float)oh2.getIntrinsicWidth() / (float)oh2.getIntrinsicHeight();
            if (Math.abs((float)(f2 - 1.0f)) <= 0.05f && Math.abs((float)(f3 - 1.0f)) <= 0.05f) {
                oh2 = new qx(oh2, ((ImageView)this.view).getWidth());
            }
        }
        super.onResourceReady(oh2, qk2);
        this.b = oh2;
        oh2.a(this.a);
        oh2.start();
    }

    @Override
    public /* synthetic */ void onResourceReady(Object object, qk qk2) {
        this.a((oh)((Object)object), qk2);
    }

    @Override
    public void onStart() {
        if (this.b != null) {
            this.b.start();
        }
    }

    @Override
    public void onStop() {
        if (this.b != null) {
            this.b.stop();
        }
    }

    @Override
    protected /* synthetic */ void setResource(Object object) {
        this.a((oh)((Object)object));
    }
}

