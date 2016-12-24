/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package okhttp3.internal.framed;

public final class HeadersMode
extends Enum<HeadersMode> {
    private static final /* synthetic */ HeadersMode[] $VALUES;
    public static final /* enum */ HeadersMode HTTP_20_HEADERS;
    public static final /* enum */ HeadersMode SPDY_HEADERS;
    public static final /* enum */ HeadersMode SPDY_REPLY;
    public static final /* enum */ HeadersMode SPDY_SYN_STREAM;

    static {
        SPDY_SYN_STREAM = new HeadersMode();
        SPDY_REPLY = new HeadersMode();
        SPDY_HEADERS = new HeadersMode();
        HTTP_20_HEADERS = new HeadersMode();
        HeadersMode[] arrheadersMode = new HeadersMode[]{SPDY_SYN_STREAM, SPDY_REPLY, SPDY_HEADERS, HTTP_20_HEADERS};
        $VALUES = arrheadersMode;
    }

    private HeadersMode() {
        super(string2, n2);
    }

    public static HeadersMode valueOf(String string2) {
        return (HeadersMode)Enum.valueOf((Class)HeadersMode.class, (String)string2);
    }

    public static HeadersMode[] values() {
        return (HeadersMode[])$VALUES.clone();
    }

    public boolean failIfHeadersAbsent() {
        if (this == SPDY_HEADERS) {
            return true;
        }
        return false;
    }

    public boolean failIfHeadersPresent() {
        if (this == SPDY_REPLY) {
            return true;
        }
        return false;
    }

    public boolean failIfStreamAbsent() {
        if (this == SPDY_REPLY || this == SPDY_HEADERS) {
            return true;
        }
        return false;
    }

    public boolean failIfStreamPresent() {
        if (this == SPDY_SYN_STREAM) {
            return true;
        }
        return false;
    }
}

