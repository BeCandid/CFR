/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.Object
 *  java.lang.String
 *  retrofit2.Converter
 */
import com.becandid.candid.data.DataUtil;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class ir<T>
implements Converter<ResponseBody, T> {
    private final aih a;
    private final air<T> b;

    ir(aih aih2, air<T> air2) {
        this.a = aih2;
        this.b = air2;
    }

    public T a(ResponseBody responseBody) throws IOException {
        String string2 = DataUtil.decodeIds(responseBody.string());
        ajv ajv2 = this.a.a((Reader)new StringReader(string2));
        try {
            T t2 = this.b.b(ajv2);
            return t2;
        }
        finally {
            responseBody.close();
        }
    }

    public /* synthetic */ Object convert(Object object) throws IOException {
        return this.a((ResponseBody)object);
    }
}

