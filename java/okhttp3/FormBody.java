/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody
extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    private FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    /* synthetic */ FormBody(List list, List list2,  var3_2) {
        super(list, list2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private long writeOrCountBytes(BufferedSink bufferedSink, boolean bl2) {
        long l2 = 0;
        Buffer buffer = bl2 ? new Buffer() : bufferedSink.buffer();
        int n2 = this.encodedNames.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8((String)this.encodedNames.get(i2));
            buffer.writeByte(61);
            buffer.writeUtf8((String)this.encodedValues.get(i2));
        }
        if (bl2) {
            l2 = buffer.size();
            buffer.clear();
        }
        return l2;
    }

    @Override
    public long contentLength() {
        return this.writeOrCountBytes(null, true);
    }

    @Override
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int n2) {
        return (String)this.encodedNames.get(n2);
    }

    public String encodedValue(int n2) {
        return (String)this.encodedValues.get(n2);
    }

    public String name(int n2) {
        return HttpUrl.percentDecode(this.encodedName(n2), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int n2) {
        return HttpUrl.percentDecode(this.encodedValue(n2), true);
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        super.writeOrCountBytes(bufferedSink, false);
    }

    public static final class Builder {
        private final List<String> names = new ArrayList();
        private final List<String> values = new ArrayList();

        public Builder add(String string2, String string3) {
            this.names.add((Object)HttpUrl.canonicalize(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.values.add((Object)HttpUrl.canonicalize(string3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public Builder addEncoded(String string2, String string3) {
            this.names.add((Object)HttpUrl.canonicalize(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.values.add((Object)HttpUrl.canonicalize(string3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values, null);
        }
    }

}

