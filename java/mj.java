/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.Map
 */
import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class mj {
    private final URL a;
    private final mk b;
    private final String c;
    private String d;
    private URL e;

    public mj(String string2) {
        super(string2, mk.b);
    }

    public mj(String string2, mk mk2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + string2);
        }
        if (mk2 == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.c = string2;
        this.a = null;
        this.b = mk2;
    }

    public mj(URL uRL) {
        super(uRL, mk.b);
    }

    public mj(URL uRL, mk mk2) {
        if (uRL == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (mk2 == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.a = uRL;
        this.c = null;
        this.b = mk2;
    }

    private URL e() throws MalformedURLException {
        if (this.e == null) {
            this.e = new URL(this.f());
        }
        return this.e;
    }

    private String f() {
        if (TextUtils.isEmpty((CharSequence)this.d)) {
            String string2 = this.c;
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = this.a.toString();
            }
            this.d = Uri.encode((String)string2, (String)"@#&=*+-_.,:!?()/~'%");
        }
        return this.d;
    }

    public URL a() throws MalformedURLException {
        return this.e();
    }

    public String b() {
        return this.f();
    }

    public Map<String, String> c() {
        return this.b.a();
    }

    public String d() {
        if (this.c != null) {
            return this.c;
        }
        return this.a.toString();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof mj;
        boolean bl3 = false;
        if (bl2) {
            mj mj2 = (mj)object;
            boolean bl4 = this.d().equals((Object)mj2.d());
            bl3 = false;
            if (bl4) {
                boolean bl5 = this.b.equals((Object)mj2.b);
                bl3 = false;
                if (bl5) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    public int hashCode() {
        return 31 * this.d().hashCode() + this.b.hashCode();
    }

    public String toString() {
        return this.d() + '\n' + this.b.toString();
    }
}

