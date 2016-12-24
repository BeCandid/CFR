/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.
 *  com.google.gson.internal.$Gson
 *  com.google.gson.internal.$Gson$Types
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 */
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class ajg<E>
extends air<Object> {
    public static final ais a = new ais(){

        @Override
        public <T> air<T> a(aih aih2, aju<T> aju2) {
            Type type = aju2.getType();
            if (!(type instanceof GenericArrayType || type instanceof Class && ((Class)type).isArray())) {
                return null;
            }
            Type type2 = .Gson.Types.g((Type)type);
            return new ajg(aih2, aih2.a(aju.get(type2)), .Gson.Types.e((Type)type2));
        }
    };
    private final Class<E> b;
    private final air<E> c;

    public ajg(aih aih2, air<E> air2, Class<E> class_) {
        this.c = new ajr<E>(aih2, air2, (Type)class_);
        this.b = class_;
    }

    @Override
    public void a(ajw ajw2, Object object) throws IOException {
        if (object == null) {
            ajw2.f();
            return;
        }
        ajw2.b();
        int n2 = Array.getLength((Object)object);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = Array.get((Object)object, (int)i2);
            this.c.a(ajw2, (Object)object2);
        }
        ajw2.c();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Object b(ajv ajv2) throws IOException {
        if (ajv2.f() == JsonToken.i) {
            ajv2.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ajv2.a();
        while (ajv2.e()) {
            arrayList.add(this.c.b(ajv2));
        }
        ajv2.b();
        Object object = Array.newInstance(this.b, (int)arrayList.size());
        int n2 = 0;
        while (n2 < arrayList.size()) {
            Array.set((Object)object, (int)n2, (Object)arrayList.get(n2));
            ++n2;
        }
        return object;
    }

}

