/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {
    private static final Pattern PARAMETER;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE;
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    static {
        TYPE_SUBTYPE = Pattern.compile((String)"([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile((String)";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private MediaType(String string2, String string3, String string4, String string5) {
        this.mediaType = string2;
        this.type = string3;
        this.subtype = string4;
        this.charset = string5;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static MediaType parse(String string2) {
        Matcher matcher = TYPE_SUBTYPE.matcher((CharSequence)string2);
        if (matcher.lookingAt()) {
            String string3 = matcher.group(1).toLowerCase(Locale.US);
            String string4 = matcher.group(2).toLowerCase(Locale.US);
            String string5 = null;
            Matcher matcher2 = PARAMETER.matcher((CharSequence)string2);
            int n2 = matcher.end();
            do {
                if (n2 >= string2.length()) {
                    return new MediaType(string2, string3, string4, string5);
                }
                matcher2.region(n2, string2.length());
                if (!matcher2.lookingAt()) break;
                String string6 = matcher2.group(1);
                if (string6 != null && string6.equalsIgnoreCase("charset")) {
                    String string7 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                    if (string5 != null && !string7.equalsIgnoreCase(string5)) {
                        throw new IllegalArgumentException("Multiple different charsets: " + string2);
                    }
                    string5 = string7;
                }
                n2 = matcher2.end();
            } while (true);
        }
        return null;
    }

    public Charset charset() {
        if (this.charset != null) {
            return Charset.forName((String)this.charset);
        }
        return null;
    }

    public Charset charset(Charset charset) {
        if (this.charset != null) {
            charset = Charset.forName((String)this.charset);
        }
        return charset;
    }

    public boolean equals(Object object) {
        if (object instanceof MediaType && ((MediaType)object).mediaType.equals((Object)this.mediaType)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public String type() {
        return this.type;
    }
}

