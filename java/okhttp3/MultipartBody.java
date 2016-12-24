/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.UUID
 */
package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody
extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final ByteString boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    static {
        MIXED = MediaType.parse("multipart/mixed");
        ALTERNATIVE = MediaType.parse("multipart/alternative");
        DIGEST = MediaType.parse("multipart/digest");
        PARALLEL = MediaType.parse("multipart/parallel");
        FORM = MediaType.parse("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.boundary = byteString;
        this.originalType = mediaType;
        this.contentType = MediaType.parse(mediaType + "; boundary=" + byteString.utf8());
        this.parts = Util.immutableList(list);
    }

    /*
     * Enabled aggressive block sorting
     */
    static StringBuilder appendQuotedString(StringBuilder stringBuilder, String string2) {
        stringBuilder.append('\"');
        int n2 = 0;
        int n3 = string2.length();
        do {
            if (n2 >= n3) {
                stringBuilder.append('\"');
                return stringBuilder;
            }
            char c2 = string2.charAt(n2);
            switch (c2) {
                default: {
                    stringBuilder.append(c2);
                    break;
                }
                case '\n': {
                    stringBuilder.append("%0A");
                    break;
                }
                case '\r': {
                    stringBuilder.append("%0D");
                    break;
                }
                case '\"': {
                    stringBuilder.append("%22");
                }
            }
            ++n2;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private long writeOrCountBytes(BufferedSink bufferedSink, boolean bl2) throws IOException {
        long l2 = 0;
        Buffer buffer = null;
        if (bl2) {
            bufferedSink = buffer = new Buffer();
        }
        int n2 = this.parts.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            MediaType mediaType;
            long l3;
            Part part = (Part)this.parts.get(i2);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            byte[] arrby = DASHDASH;
            bufferedSink.write(arrby);
            ByteString byteString = this.boundary;
            bufferedSink.write(byteString);
            byte[] arrby2 = CRLF;
            bufferedSink.write(arrby2);
            if (headers != null) {
                int n3 = headers.size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    String string2 = headers.name(i3);
                    bufferedSink.writeUtf8(string2).write(COLONSPACE).writeUtf8(headers.value(i3)).write(CRLF);
                }
            }
            if ((mediaType = requestBody.contentType()) != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(mediaType.toString()).write(CRLF);
            }
            if ((l3 = requestBody.contentLength()) != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l3).write(CRLF);
            } else if (bl2) {
                buffer.clear();
                return -1;
            }
            byte[] arrby3 = CRLF;
            bufferedSink.write(arrby3);
            if (bl2) {
                l2 += l3;
            } else {
                requestBody.writeTo(bufferedSink);
            }
            byte[] arrby4 = CRLF;
            bufferedSink.write(arrby4);
        }
        byte[] arrby = DASHDASH;
        bufferedSink.write(arrby);
        ByteString byteString = this.boundary;
        bufferedSink.write(byteString);
        byte[] arrby5 = DASHDASH;
        bufferedSink.write(arrby5);
        byte[] arrby6 = CRLF;
        bufferedSink.write(arrby6);
        if (bl2) {
            l2 += buffer.size();
            buffer.clear();
        }
        return l2;
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    @Override
    public long contentLength() throws IOException {
        long l2;
        long l3 = this.contentLength;
        if (l3 != -1) {
            return l3;
        }
        this.contentLength = l2 = this.writeOrCountBytes(null, true);
        return l2;
    }

    @Override
    public MediaType contentType() {
        return this.contentType;
    }

    public Part part(int n2) {
        return (Part)this.parts.get(n2);
    }

    public List<Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public MediaType type() {
        return this.originalType;
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        super.writeOrCountBytes(bufferedSink, false);
    }

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts = new ArrayList();
        private MediaType type = MultipartBody.MIXED;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String string2) {
            this.boundary = ByteString.encodeUtf8(string2);
        }

        public Builder addFormDataPart(String string2, String string3) {
            return this.addPart(Part.createFormData(string2, string3));
        }

        public Builder addFormDataPart(String string2, String string3, RequestBody requestBody) {
            return this.addPart(Part.createFormData(string2, string3, requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return this.addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            if (part == null) {
                throw new NullPointerException("part == null");
            }
            this.parts.add((Object)part);
            return this;
        }

        public Builder addPart(RequestBody requestBody) {
            return this.addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, this.parts);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            if (!mediaType.type().equals((Object)"multipart")) {
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
            this.type = mediaType;
            return this;
        }
    }

    public static final class Part {
        private final RequestBody body;
        private final Headers headers;

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            }
            if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers != null && headers.get("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new Part(headers, requestBody);
        }

        public static Part create(RequestBody requestBody) {
            return Part.create(null, requestBody);
        }

        public static Part createFormData(String string2, String string3) {
            return Part.createFormData(string2, null, RequestBody.create(null, string3));
        }

        public static Part createFormData(String string2, String string3, RequestBody requestBody) {
            if (string2 == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder stringBuilder = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(stringBuilder, string2);
            if (string3 != null) {
                stringBuilder.append("; filename=");
                MultipartBody.appendQuotedString(stringBuilder, string3);
            }
            String[] arrstring = new String[]{"Content-Disposition", stringBuilder.toString()};
            return Part.create(Headers.of(arrstring), requestBody);
        }
    }

}

