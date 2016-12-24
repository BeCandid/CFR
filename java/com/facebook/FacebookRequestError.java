/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.FacebookException;
import com.facebook.FacebookServiceException;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError
implements Parcelable {
    public static final Parcelable.Creator<FacebookRequestError> CREATOR;
    static final a a;
    private final Category b;
    private final int c;
    private final int d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final JSONObject k;
    private final JSONObject l;
    private final Object m;
    private final HttpURLConnection n;
    private final FacebookException o;

    static {
        a = new a(200, 299, null);
        CREATOR = new Parcelable.Creator<FacebookRequestError>(){

            public FacebookRequestError a(Parcel parcel) {
                return new FacebookRequestError(parcel, null);
            }

            public FacebookRequestError[] a(int n2) {
                return new FacebookRequestError[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    private FacebookRequestError(int n2, int n3, int n4, String string2, String string3, String string4, String string5, boolean bl2, JSONObject jSONObject, JSONObject jSONObject2, Object object, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean bl3;
        this.c = n2;
        this.d = n3;
        this.e = n4;
        this.f = string2;
        this.g = string3;
        this.l = jSONObject;
        this.k = jSONObject2;
        this.m = object;
        this.n = httpURLConnection;
        this.h = string4;
        this.i = string5;
        if (facebookException != null) {
            this.o = facebookException;
            bl3 = true;
        } else {
            this.o = new FacebookServiceException((FacebookRequestError)this, string3);
            bl3 = false;
        }
        vn vn2 = FacebookRequestError.h();
        Category category = bl3 ? Category.b : vn2.a(n3, n4, bl2);
        this.b = category;
        this.j = vn2.a(this.b);
    }

    public FacebookRequestError(int n2, String string2, String string3) {
        super(-1, n2, -1, string2, string3, null, null, false, null, null, null, null, null);
    }

    private FacebookRequestError(Parcel parcel) {
        super(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }

    /* synthetic */ FacebookRequestError(Parcel parcel,  var2_2) {
        super(parcel);
    }

    /*
     * Enabled aggressive block sorting
     */
    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        FacebookException facebookException = exception instanceof FacebookException ? (FacebookException)exception : new FacebookException((Throwable)exception);
        super(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, facebookException);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static FacebookRequestError a(JSONObject var0_1, Object var1, HttpURLConnection var2_2) {
        try {
            if (var0_1.has("code") == false) return null;
            var4_3 = var0_1.getInt("code");
            var5_4 = we.a(var0_1, "body", "FACEBOOK_NON_JSON_RESULT");
            if (var5_4 == null || !(var5_4 instanceof JSONObject)) ** GOTO lbl38
            var8_5 = (JSONObject)var5_4;
            var9_6 = -1;
            var10_7 = -1;
            if (var8_5.has("error")) {
                var18_8 = (JSONObject)we.a(var8_5, "error", null);
                var11_9 = var18_8.optString("type", null);
                var12_10 = var18_8.optString("message", null);
                var9_6 = var18_8.optInt("code", -1);
                var10_7 = var18_8.optInt("error_subcode", -1);
                var15_11 = var18_8.optString("error_user_msg", null);
                var14_12 = var18_8.optString("error_user_title", null);
                var16_13 = var18_8.optBoolean("is_transient", false);
                return new FacebookRequestError(var4_3, var9_6, var10_7, var11_9, var12_10, var14_12, var15_11, var16_13, var8_5, var0_1, var1, var2_2, null);
            }
            if (var8_5.has("error_code") || var8_5.has("error_msg")) ** GOTO lbl-1000
            var17_15 = var8_5.has("error_reason");
            var11_9 = null;
            var12_10 = null;
            var14_12 = null;
            var15_11 = null;
            var16_13 = false;
            var13_14 = false;
            if (var17_15) lbl-1000: // 2 sources:
            {
                var11_9 = var8_5.optString("error_reason", null);
                var12_10 = var8_5.optString("error_msg", null);
                var9_6 = var8_5.optInt("error_code", -1);
                var10_7 = var8_5.optInt("error_subcode", -1);
                var13_14 = true;
                var14_12 = null;
                var15_11 = null;
                var16_13 = false;
                if (var13_14) {
                    return new FacebookRequestError(var4_3, var9_6, var10_7, var11_9, var12_10, var14_12, var15_11, var16_13, var8_5, var0_1, var1, var2_2, null);
                }
            }
lbl38: // 5 sources:
            if (FacebookRequestError.a.a(var4_3) != false) return null;
            var6_16 = var0_1.has("body") != false ? (JSONObject)we.a(var0_1, "body", "FACEBOOK_NON_JSON_RESULT") : null;
            return new FacebookRequestError(var4_3, -1, -1, null, null, null, null, false, var6_16, var0_1, var1, var2_2, null);
        }
        catch (JSONException var3_18) {
            // empty catch block
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static vn h() {
        reference var5 = FacebookRequestError.class;
        synchronized (FacebookRequestError.class) {
            we.b b2 = we.d(ul.i());
            vn vn2 = b2.f();
            if (b2 != null) return vn2;
            vn vn3 = vn.a();
            return vn3;
        }
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        if (this.g != null) {
            return this.g;
        }
        return this.o.getLocalizedMessage();
    }

    public JSONObject f() {
        return this.k;
    }

    public FacebookException g() {
        return this.o;
    }

    public String toString() {
        return "{HttpStatus: " + this.c + ", errorCode: " + this.d + ", errorType: " + this.f + ", errorMessage: " + this.e() + "}";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
    }

    public static final class Category
    extends Enum<Category> {
        public static final /* enum */ Category a = new Category();
        public static final /* enum */ Category b = new Category();
        public static final /* enum */ Category c = new Category();
        private static final /* synthetic */ Category[] d;

        static {
            Category[] arrcategory = new Category[]{a, b, c};
            d = arrcategory;
        }

        private Category() {
            super(string2, n2);
        }

        public static Category valueOf(String string2) {
            return (Category)Enum.valueOf((Class)Category.class, (String)string2);
        }

        public static Category[] values() {
            return (Category[])d.clone();
        }
    }

    static class a {
        private final int a;
        private final int b;

        private a(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        /* synthetic */ a(int n2, int n3,  var3_2) {
            super(n2, n3);
        }

        boolean a(int n2) {
            if (this.a <= n2 && n2 <= this.b) {
                return true;
            }
            return false;
        }
    }

}

