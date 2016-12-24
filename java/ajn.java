/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedTreeMap
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

public final class ajn
extends air<Object> {
    public static final ais a = new ais(){

        @Override
        public <T> air<T> a(aih aih2, aju<T> aju2) {
            if (aju2.getRawType() == Object.class) {
                return new ajn(aih2);
            }
            return null;
        }
    };
    private final aih b;

    ajn(aih aih2) {
        this.b = aih2;
    }

    @Override
    public void a(ajw ajw2, Object object) throws IOException {
        if (object == null) {
            ajw2.f();
            return;
        }
        air<Object> air2 = this.b.a(object.getClass());
        if (air2 instanceof ajn) {
            ajw2.d();
            ajw2.e();
            return;
        }
        air2.a(ajw2, object);
    }

    @Override
    public Object b(ajv ajv2) throws IOException {
        JsonToken jsonToken = ajv2.f();
        switch (.a[jsonToken.ordinal()]) {
            default: {
                throw new IllegalStateException();
            }
            case 1: {
                ArrayList arrayList = new ArrayList();
                ajv2.a();
                while (ajv2.e()) {
                    arrayList.add(this.b(ajv2));
                }
                ajv2.b();
                return arrayList;
            }
            case 2: {
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                ajv2.c();
                while (ajv2.e()) {
                    linkedTreeMap.put((Object)ajv2.g(), this.b(ajv2));
                }
                ajv2.d();
                return linkedTreeMap;
            }
            case 3: {
                return ajv2.h();
            }
            case 4: {
                return ajv2.k();
            }
            case 5: {
                return ajv2.i();
            }
            case 6: 
        }
        ajv2.j();
        return null;
    }

}

