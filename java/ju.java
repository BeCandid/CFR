/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.ParcelFileDescriptor
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 */
import android.content.Context;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class ju<ModelType>
extends jt<ModelType> {
    private final mr<ModelType, InputStream> g;
    private final mr<ModelType, ParcelFileDescriptor> h;
    private final jz.d i;

    ju(Class<ModelType> class_, mr<ModelType, InputStream> mr2, mr<ModelType, ParcelFileDescriptor> mr3, Context context, jx jx2, pt pt2, po po2, jz.d d2) {
        super(context, class_, ju.a(jx2, mr2, mr3, ow.class, oh.class, null), jx2, pt2, po2);
        this.g = mr2;
        this.h = mr3;
        this.i = d2;
    }

    private static <A, Z, R> qb<A, mm, Z, R> a(jx jx2, mr<A, InputStream> mr2, mr<A, ParcelFileDescriptor> mr3, Class<Z> class_, Class<R> class_2, pf<Z, R> pf2) {
        if (mr2 == null && mr3 == null) {
            return null;
        }
        if (pf2 == null) {
            pf2 = jx2.a(class_, class_2);
        }
        py py2 = jx2.b(mm.class, class_);
        return new qb(new ml<A>(mr2, mr3), pf2, py2);
    }

    public js<ModelType> j() {
        return this.i.a(new js<ModelType>(this, this.g, this.h, this.i));
    }
}

