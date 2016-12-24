/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.ImageView
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Object
 */
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ata
implements GestureDetector.OnDoubleTapListener {
    private atc a;

    public ata(atc atc2) {
        this.a(atc2);
    }

    public void a(atc atc2) {
        this.a = atc2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        try {
            float f2 = this.a.g();
            float f3 = motionEvent.getX();
            float f4 = motionEvent.getY();
            if (f2 < this.a.e()) {
                this.a.a(this.a.e(), f3, f4, true);
                return true;
            }
            if (f2 >= this.a.e() && f2 < this.a.f()) {
                this.a.a(this.a.f(), f3, f4, true);
                return true;
            }
            this.a.a(this.a.d(), f3, f4, true);
            return true;
        }
        catch (ArrayIndexOutOfBoundsException var2_5) {
            return true;
        }
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF rectF;
        if (this.a == null) {
            return false;
        }
        ImageView imageView = this.a.c();
        if (this.a.i() != null && (rectF = this.a.b()) != null) {
            float f2;
            float f3 = motionEvent.getX();
            if (rectF.contains(f3, f2 = motionEvent.getY())) {
                float f4 = (f3 - rectF.left) / rectF.width();
                float f5 = (f2 - rectF.top) / rectF.height();
                this.a.i().onPhotoTap((View)imageView, f4, f5);
                return true;
            }
            this.a.i().onOutsidePhotoTap();
        }
        if (this.a.j() == null) return false;
        this.a.j().a((View)imageView, motionEvent.getX(), motionEvent.getY());
        return false;
    }
}

