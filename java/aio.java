/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonIOException
 *  com.google.gson.JsonParseException
 *  com.google.gson.JsonSyntaxException
 *  com.google.gson.stream.JsonToken
 *  com.google.gson.stream.MalformedJsonException
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.StackOverflowError
 *  java.lang.String
 *  java.lang.Throwable
 */
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class aio {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ail a(ajv ajv2) throws JsonIOException, JsonSyntaxException {
        boolean bl2 = ajv2.p();
        ajv2.a(true);
        try {
            ail ail2 = aje.a(ajv2);
            return ail2;
        }
        catch (StackOverflowError var5_4) {
            throw new JsonParseException("Failed parsing JSON source: " + ajv2 + " to Json", (Throwable)var5_4);
        }
        catch (OutOfMemoryError var3_6) {
            throw new JsonParseException("Failed parsing JSON source: " + ajv2 + " to Json", (Throwable)var3_6);
        }
        finally {
            ajv2.a(bl2);
        }
    }

    public ail a(Reader reader) throws JsonIOException, JsonSyntaxException {
        ail ail2;
        try {
            ajv ajv2 = new ajv(reader);
            ail2 = this.a(ajv2);
            if (!ail2.l() && ajv2.f() != JsonToken.j) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
        }
        catch (MalformedJsonException var5_4) {
            throw new JsonSyntaxException((Throwable)var5_4);
        }
        catch (IOException var4_5) {
            throw new JsonIOException((Throwable)var4_5);
        }
        catch (NumberFormatException var3_6) {
            throw new JsonSyntaxException((Throwable)var3_6);
        }
        return ail2;
    }

    public ail a(String string2) throws JsonSyntaxException {
        return this.a((Reader)new StringReader(string2));
    }
}

