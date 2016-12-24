/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 */
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class ajr<T>
extends air<T> {
    private final aih a;
    private final air<T> b;
    private final Type c;

    ajr(aih aih2, air<T> air2, Type type) {
        this.a = aih2;
        this.b = air2;
        this.c = type;
    }

    private Type a(Type type, Object object) {
        if (object != null && (type == Object.class || type instanceof TypeVariable || type instanceof Class)) {
            type = object.getClass();
        }
        return type;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(ajw ajw2, T t2) throws IOException {
        void var3_5;
        air<T> air2 = this.b;
        Type type = super.a(this.c, t2);
        if (type != this.c) {
            air air3 = this.a.a(aju.get(type));
            if (!(air3 instanceof ajo.a)) {
                air air4 = air3;
            } else if (!(this.b instanceof ajo.a)) {
                air<T> air5 = this.b;
            } else {
                air air6 = air3;
            }
        }
        var3_5.a(ajw2, t2);
    }

    @Override
    public T b(ajv ajv2) throws IOException {
        return this.b.b(ajv2);
    }
}

