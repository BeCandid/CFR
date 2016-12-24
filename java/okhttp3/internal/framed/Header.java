/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3.internal.framed;

import okio.ByteString;

public final class Header {
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(":status");
    public static final ByteString TARGET_AUTHORITY;
    public static final ByteString TARGET_HOST;
    public static final ByteString TARGET_METHOD;
    public static final ByteString TARGET_PATH;
    public static final ByteString TARGET_SCHEME;
    public static final ByteString VERSION;
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    static {
        TARGET_METHOD = ByteString.encodeUtf8(":method");
        TARGET_PATH = ByteString.encodeUtf8(":path");
        TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
        TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
        TARGET_HOST = ByteString.encodeUtf8(":host");
        VERSION = ByteString.encodeUtf8(":version");
    }

    public Header(String string2, String string3) {
        super(ByteString.encodeUtf8(string2), ByteString.encodeUtf8(string3));
    }

    public Header(ByteString byteString, String string2) {
        super(byteString, ByteString.encodeUtf8(string2));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = 32 + byteString.size() + byteString2.size();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Header;
        boolean bl3 = false;
        if (bl2) {
            Header header = (Header)object;
            boolean bl4 = this.name.equals(header.name);
            bl3 = false;
            if (bl4) {
                boolean bl5 = this.value.equals(header.value);
                bl3 = false;
                if (bl5) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    public int hashCode() {
        return 31 * (527 + this.name.hashCode()) + this.value.hashCode();
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.name.utf8(), this.value.utf8()};
        return String.format((String)"%s: %s", (Object[])arrobject);
    }
}

