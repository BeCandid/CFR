/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.sql.Date
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Date
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class ajp
extends air<Date> {
    public static final ais a = new ais(){

        @Override
        public <T> air<T> a(aih aih2, aju<T> aju2) {
            if (aju2.getRawType() == Date.class) {
                return new ajp();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Date a(ajv ajv2) throws IOException {
        void var5_2 = this;
        synchronized (var5_2) {
            if (ajv2.f() == JsonToken.i) {
                ajv2.j();
                return null;
            }
            try {
                return new Date(this.b.parse(ajv2.h()).getTime());
            }
            catch (ParseException var4_4) {
                throw new JsonSyntaxException((Throwable)var4_4);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(ajw ajw2, Date date) throws IOException {
        void var7_3 = this;
        synchronized (var7_3) {
            String string2;
            String string3 = date == null ? null : (string2 = this.b.format((java.util.Date)date));
            ajw2.b(string3);
            return;
        }
    }

    @Override
    public /* synthetic */ Object b(ajv ajv2) throws IOException {
        return this.a(ajv2);
    }

}

