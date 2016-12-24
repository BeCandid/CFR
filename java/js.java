/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class js<ModelType>
extends jr<ModelType, Bitmap> {
    private final mr<ModelType, InputStream> g;
    private final mr<ModelType, ParcelFileDescriptor> h;
    private final jx i;
    private final jz.d j;

    js(jv<ModelType, ?, ?, ?> jv2, mr<ModelType, InputStream> mr2, mr<ModelType, ParcelFileDescriptor> mr3, jz.d d2) {
        super(js.a(jv2.c, mr2, mr3, Bitmap.class, null), Bitmap.class, jv2);
        this.g = mr2;
        this.h = mr3;
        this.i = jv2.c;
        this.j = d2;
    }

    private static <A, R> qb<A, mm, Bitmap, R> a(jx jx2, mr<A, InputStream> mr2, mr<A, ParcelFileDescriptor> mr3, Class<R> class_, pf<Bitmap, R> pf2) {
        if (mr2 == null && mr3 == null) {
            return null;
        }
        if (pf2 == null) {
            pf2 = jx2.a(Bitmap.class, class_);
        }
        py py2 = jx2.b(mm.class, Bitmap.class);
        return new qb(new ml<A>(mr2, mr3), pf2, py2);
    }
}

