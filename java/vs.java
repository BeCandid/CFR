/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
import android.content.Context;
import android.net.Uri;
import java.util.Locale;

public class vs {
    private Context a;
    private Uri b;
    private b c;
    private boolean d;
    private Object e;

    /*
     * Enabled aggressive block sorting
     */
    private vs(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        Object object = a2.e == null ? new Object() : a2.e;
        this.e = object;
    }

    /* synthetic */ vs(a a2,  var2_2) {
        super(a2);
    }

    public static Uri a(String string2, int n2, int n3) {
        wf.a(string2, "userId");
        int n4 = Math.max((int)n2, (int)0);
        int n5 = Math.max((int)n3, (int)0);
        if (n4 == 0 && n5 == 0) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        Uri.Builder builder = new Uri.Builder().scheme("https").authority("graph.facebook.com").path(String.format((Locale)Locale.US, (String)"%s/picture", (Object[])new Object[]{string2}));
        if (n5 != 0) {
            builder.appendQueryParameter("height", String.valueOf((int)n5));
        }
        if (n4 != 0) {
            builder.appendQueryParameter("width", String.valueOf((int)n4));
        }
        builder.appendQueryParameter("migration_overrides", "{october_2012:true}");
        return builder.build();
    }

    public Context a() {
        return this.a;
    }

    public Uri b() {
        return this.b;
    }

    public b c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public Object e() {
        return this.e;
    }

    public static class a {
        private Context a;
        private Uri b;
        private b c;
        private boolean d;
        private Object e;

        public a(Context context, Uri uri) {
            wf.a((Object)uri, "imageUri");
            this.a = context;
            this.b = uri;
        }

        public a a(Object object) {
            this.e = object;
            return this;
        }

        public a a(b b2) {
            this.c = b2;
            return this;
        }

        public a a(boolean bl2) {
            this.d = bl2;
            return this;
        }

        public vs a() {
            return new vs(this, null);
        }
    }

    public static interface b {
        public void a(vt var1);
    }

}

