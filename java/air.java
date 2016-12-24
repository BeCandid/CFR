/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Throwable
 */
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

public abstract class air<T> {
    public final ail a(T t2) {
        try {
            ajl ajl2 = new ajl();
            this.a(ajl2, t2);
            ail ail2 = ajl2.a();
            return ail2;
        }
        catch (IOException var3_4) {
            throw new JsonIOException((Throwable)var3_4);
        }
    }

    public final air<T> a() {
        return new air<T>(){

            @Override
            public void a(ajw ajw2, T t2) throws IOException {
                if (t2 == null) {
                    ajw2.f();
                    return;
                }
                air.this.a(ajw2, t2);
            }

            @Override
            public T b(ajv ajv2) throws IOException {
                if (ajv2.f() == JsonToken.i) {
                    ajv2.j();
                    return null;
                }
                return air.this.b(ajv2);
            }
        };
    }

    public abstract void a(ajw var1, T var2) throws IOException;

    public abstract T b(ajv var1) throws IOException;

}

