/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  javax.security.auth.x500.X500Principal
 */
package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        this.dn = x500Principal.getName("RFC2253");
        this.length = this.dn.length();
    }

    private String escapedAV() {
        this.beg = this.pos;
        this.end = this.pos;
        block5 : do {
            if (this.pos >= this.length) {
                return new String(this.chars, this.beg, this.end - this.beg);
            }
            switch (this.chars[this.pos]) {
                default: {
                    char[] arrc = this.chars;
                    int n2 = this.end;
                    this.end = n2 + 1;
                    arrc[n2] = this.chars[this.pos];
                    this.pos = 1 + this.pos;
                    continue block5;
                }
                case '+': 
                case ',': 
                case ';': {
                    return new String(this.chars, this.beg, this.end - this.beg);
                }
                case '\\': {
                    char[] arrc = this.chars;
                    int n3 = this.end;
                    this.end = n3 + 1;
                    arrc[n3] = this.getEscaped();
                    this.pos = 1 + this.pos;
                    continue block5;
                }
                case ' ': 
            }
            this.cur = this.end;
            this.pos = 1 + this.pos;
            char[] arrc = this.chars;
            int n4 = this.end;
            this.end = n4 + 1;
            arrc[n4] = 32;
            while (this.pos < this.length && this.chars[this.pos] == ' ') {
                char[] arrc2 = this.chars;
                int n5 = this.end;
                this.end = n5 + 1;
                arrc2[n5] = 32;
                this.pos = 1 + this.pos;
            }
            if (this.pos == this.length || this.chars[this.pos] == ',' || this.chars[this.pos] == '+' || this.chars[this.pos] == ';') break;
        } while (true);
        return new String(this.chars, this.beg, this.cur - this.beg);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int getByte(int n2) {
        int n3;
        int n4;
        char c2;
        if (n2 + 1 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char c3 = this.chars[n2];
        if (c3 >= '0' && c3 <= '9') {
            n3 = c3 - 48;
        } else if (c3 >= 'a' && c3 <= 'f') {
            n3 = c3 - 87;
        } else {
            if (c3 < 'A') throw new IllegalStateException("Malformed DN: " + this.dn);
            if (c3 > 'F') throw new IllegalStateException("Malformed DN: " + this.dn);
            n3 = c3 - 55;
        }
        if ((c2 = this.chars[n2 + 1]) >= '0' && c2 <= '9') {
            n4 = c2 - 48;
            return n4 + (n3 << 4);
        }
        if (c2 >= 'a' && c2 <= 'f') {
            n4 = c2 - 87;
            return n4 + (n3 << 4);
        }
        if (c2 < 'A') throw new IllegalStateException("Malformed DN: " + this.dn);
        if (c2 > 'F') throw new IllegalStateException("Malformed DN: " + this.dn);
        n4 = c2 - 55;
        return n4 + (n3 << 4);
    }

    private char getEscaped() {
        this.pos = 1 + this.pos;
        if (this.pos == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        switch (this.chars[this.pos]) {
            default: {
                return this.getUTF8();
            }
            case ' ': 
            case '\"': 
            case '#': 
            case '%': 
            case '*': 
            case '+': 
            case ',': 
            case ';': 
            case '<': 
            case '=': 
            case '>': 
            case '\\': 
            case '_': 
        }
        return this.chars[this.pos];
    }

    /*
     * Enabled aggressive block sorting
     */
    private char getUTF8() {
        int n2;
        int n3;
        char c2 = '?';
        int n4 = this.getByte(this.pos);
        this.pos = 1 + this.pos;
        if (n4 < 128) {
            return (char)n4;
        }
        if (n4 < 192) return c2;
        if (n4 > 247) return c2;
        if (n4 <= 223) {
            n3 = 1;
            n2 = n4 & 31;
        } else if (n4 <= 239) {
            n3 = 2;
            n2 = n4 & 15;
        } else {
            n3 = 3;
            n2 = n4 & 7;
        }
        int n5 = 0;
        while (n5 < n3) {
            this.pos = 1 + this.pos;
            if (this.pos == this.length) return c2;
            if (this.chars[this.pos] != '\\') return c2;
            this.pos = 1 + this.pos;
            int n6 = this.getByte(this.pos);
            this.pos = 1 + this.pos;
            if ((n6 & 192) != 128) return c2;
            n2 = (n2 << 6) + (n6 & 63);
            ++n5;
        }
        return (char)n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private String hexAV() {
        if (4 + this.pos >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.beg = this.pos;
        this.pos = 1 + this.pos;
        do {
            if (this.pos != this.length && this.chars[this.pos] != '+' && this.chars[this.pos] != ',' && this.chars[this.pos] != ';') ** GOTO lbl9
            this.end = this.pos;
            ** GOTO lbl16
lbl9: // 1 sources:
            if (this.chars[this.pos] == ' ') {
                this.end = this.pos;
                this.pos = 1 + this.pos;
                while (this.pos < this.length && this.chars[this.pos] == ' ') {
                    this.pos = 1 + this.pos;
                }
            }
            ** GOTO lbl19
lbl16: // 2 sources:
            if ((var1_3 = this.end - this.beg) < 5) throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            if ((var1_3 & 1) != 0) break;
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
lbl19: // 1 sources:
            if (this.chars[this.pos] >= 'A' && this.chars[this.pos] <= 'F') {
                var5_2 = this.chars;
                var6_1 = this.pos;
                var5_2[var6_1] = (char)(32 + var5_2[var6_1]);
            }
            this.pos = 1 + this.pos;
        } while (true);
        var2_4 = new byte[var1_3 / 2];
        var3_5 = 0;
        var4_6 = 1 + this.beg;
        while (var3_5 < var2_4.length) {
            var2_4[var3_5] = (byte)this.getByte(var4_6);
            var4_6 += 2;
            ++var3_5;
        }
        return new String(this.chars, this.beg, var1_3);
    }

    private String nextAT() {
        while (this.pos < this.length && this.chars[this.pos] == ' ') {
            this.pos = 1 + this.pos;
        }
        if (this.pos == this.length) {
            return null;
        }
        this.beg = this.pos;
        this.pos = 1 + this.pos;
        while (this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] != ' ') {
            this.pos = 1 + this.pos;
        }
        if (this.pos >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = this.pos;
        if (this.chars[this.pos] == ' ') {
            while (this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] == ' ') {
                this.pos = 1 + this.pos;
            }
            if (this.chars[this.pos] != '=' || this.pos == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        this.pos = 1 + this.pos;
        while (this.pos < this.length && this.chars[this.pos] == ' ') {
            this.pos = 1 + this.pos;
        }
        if (!(this.end - this.beg <= 4 || this.chars[3 + this.beg] != '.' || this.chars[this.beg] != 'O' && this.chars[this.beg] != 'o' || this.chars[1 + this.beg] != 'I' && this.chars[1 + this.beg] != 'i' || this.chars[2 + this.beg] != 'D' && this.chars[2 + this.beg] != 'd')) {
            this.beg = 4 + this.beg;
        }
        return new String(this.chars, this.beg, this.end - this.beg);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String quotedAV() {
        this.end = this.beg = (this.pos = 1 + this.pos);
        do {
            if (this.pos == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            if (this.chars[this.pos] == '\"') {
                this.pos = 1 + this.pos;
                while (this.pos < this.length && this.chars[this.pos] == ' ') {
                    this.pos = 1 + this.pos;
                }
                return new String(this.chars, this.beg, this.end - this.beg);
            }
            this.chars[this.end] = this.chars[this.pos] == '\\' ? this.getEscaped() : this.chars[this.pos];
            this.pos = 1 + this.pos;
            this.end = 1 + this.end;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String findMostSpecific(String string2) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String string3 = super.nextAT();
        if (string3 == null) {
            return null;
        }
        do {
            String string4 = "";
            if (this.pos == this.length) {
                return null;
            }
            switch (this.chars[this.pos]) {
                default: {
                    string4 = super.escapedAV();
                    break;
                }
                case '\"': {
                    string4 = super.quotedAV();
                    break;
                }
                case '#': {
                    string4 = super.hexAV();
                }
                case '+': 
                case ',': 
                case ';': 
            }
            if (string2.equalsIgnoreCase(string3)) return string4;
            if (this.pos >= this.length) {
                return null;
            }
            if (this.chars[this.pos] != ',' && this.chars[this.pos] != ';' && this.chars[this.pos] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos = 1 + this.pos;
        } while ((string3 = super.nextAT()) != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}

