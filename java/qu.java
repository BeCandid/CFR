/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class qu {
    public <Z> qy<Z> a(ImageView imageView, Class<Z> class_) {
        if (oh.class.isAssignableFrom(class_)) {
            return new qs(imageView);
        }
        if (Bitmap.class.equals(class_)) {
            return new qq(imageView);
        }
        if (Drawable.class.isAssignableFrom(class_)) {
            return new qr(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + class_ + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}

