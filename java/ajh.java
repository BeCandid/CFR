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
 *  java.lang.reflect.Type
 *  java.util.Collection
 */
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class ajh
implements ais {
    private final aiz a;

    public ajh(aiz aiz2) {
        this.a = aiz2;
    }

    @Override
    public <T> air<T> a(aih aih2, aju<T> aju2) {
        Type type = aju2.getType();
        Class<T> class_ = aju2.getRawType();
        if (!Collection.class.isAssignableFrom(class_)) {
            return null;
        }
        Type type2 = .Gson.Types.a((Type)type, class_);
        return new a(aih2, type2, aih2.a(aju.get(type2)), this.a.a(aju2));
    }

    static final class a<E>
    extends air<Collection<E>> {
        private final air<E> a;
        private final ajc<? extends Collection<E>> b;

        public a(aih aih2, Type type, air<E> air2, ajc<? extends Collection<E>> ajc2) {
            this.a = new ajr<E>(aih2, air2, type);
            this.b = ajc2;
        }

        public Collection<E> a(ajv ajv2) throws IOException {
            if (ajv2.f() == JsonToken.i) {
                ajv2.j();
                return null;
            }
            Collection<E> collection = this.b.a();
            ajv2.a();
            while (ajv2.e()) {
                collection.add(this.a.b(ajv2));
            }
            ajv2.b();
            return collection;
        }

        @Override
        public void a(ajw ajw2, Collection<E> collection) throws IOException {
            if (collection == null) {
                ajw2.f();
                return;
            }
            ajw2.b();
            for (Object object : collection) {
                this.a.a(ajw2, (Object)object);
            }
            ajw2.c();
        }

        @Override
        public /* synthetic */ Object b(ajv ajv2) throws IOException {
            return this.a(ajv2);
        }
    }

}

