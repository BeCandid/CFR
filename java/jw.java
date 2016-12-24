/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Object
 */
import android.content.Context;

public class jw<ModelType, DataType, ResourceType>
extends jv<ModelType, DataType, ResourceType, ResourceType> {
    private final mr<ModelType, DataType> g;
    private final Class<DataType> h;
    private final Class<ResourceType> i;
    private final jz.d j;

    jw(Context context, jx jx2, Class<ModelType> class_, mr<ModelType, DataType> mr2, Class<DataType> class_2, Class<ResourceType> class_3, pt pt2, po po2, jz.d d2) {
        super(context, class_, jw.a(jx2, mr2, class_2, class_3, ph.b()), class_3, jx2, pt2, po2);
        this.g = mr2;
        this.h = class_2;
        this.i = class_3;
        this.j = d2;
    }

    private static <A, T, Z, R> qc<A, T, Z, R> a(jx jx2, mr<A, T> mr2, Class<T> class_, Class<Z> class_2, pf<Z, R> pf2) {
        return new qb<A, T, Z, R>(mr2, pf2, jx2.b(class_, class_2));
    }
}

