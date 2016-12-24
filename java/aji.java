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
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.util.Date
 *  java.util.Locale
 */
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class aji
extends air<Date> {
    public static final ais a = new ais(){

        @Override
        public <T> air<T> a(aih aih2, aju<T> aju2) {
            if (aju2.getRawType() == Date.class) {
                return new aji();
            }
            return null;
        }
    };
    private final DateFormat b = DateFormat.getDateTimeInstance((int)2, (int)2, (Locale)Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance((int)2, (int)2);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Date a(String string2) {
        void var10_2 = this;
        synchronized (var10_2) {
            try {
                Date date = this.c.parse(string2);
                return date;
            }
            catch (ParseException var3_5) {
                try {
                    Date date = this.b.parse(string2);
                    return date;
                }
                catch (ParseException var4_7) {
                    try {
                        Date date = ajt.a(string2, new ParsePosition(0));
                        return date;
                    }
                    catch (ParseException var5_9) {
                        throw new JsonSyntaxException(string2, (Throwable)var5_9);
                    }
                }
            }
        }
    }

    public Date a(ajv ajv2) throws IOException {
        if (ajv2.f() == JsonToken.i) {
            ajv2.j();
            return null;
        }
        return super.a(ajv2.h());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(ajw ajw2, Date date) throws IOException {
        void var6_3 = this;
        synchronized (var6_3) {
            if (date == null) {
                ajw2.f();
            } else {
                ajw2.b(this.b.format(date));
            }
            return;
        }
    }

    @Override
    public /* synthetic */ Object b(ajv ajv2) throws IOException {
        return this.a(ajv2);
    }

}

