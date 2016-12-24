/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class iq
extends Converter.Factory {
    private final aih a;

    private iq(aih aih2) {
        if (aih2 == null) {
            throw new NullPointerException("gson == null");
        }
        this.a = aih2;
    }

    public static iq a() {
        return iq.a(new aih());
    }

    public static iq a(aih aih2) {
        return new iq(aih2);
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, Retrofit retrofit) {
        air air2 = this.a.a(aju.get(type));
        return new iu(this.a, air2);
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] arrannotation, Retrofit retrofit) {
        air air2 = this.a.a(aju.get(type));
        return new ir(this.a, air2);
    }
}

