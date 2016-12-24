/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile
implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator(){

        public Profile a(Parcel parcel) {
            return new Profile(parcel, null);
        }

        public Profile[] a(int n2) {
            return new Profile[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final Uri f;

    /*
     * Enabled aggressive block sorting
     */
    private Profile(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        String string2 = parcel.readString();
        Uri uri = string2 == null ? null : Uri.parse((String)string2);
        this.f = uri;
    }

    /* synthetic */ Profile(Parcel parcel,  var2_2) {
        super(parcel);
    }

    public Profile(String string2, String string3, String string4, String string5, String string6, Uri uri) {
        wf.a(string2, "id");
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = string6;
        this.f = uri;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Profile(JSONObject jSONObject) {
        this.a = jSONObject.optString("id", null);
        this.b = jSONObject.optString("first_name", null);
        this.c = jSONObject.optString("middle_name", null);
        this.d = jSONObject.optString("last_name", null);
        this.e = jSONObject.optString("name", null);
        String string2 = jSONObject.optString("link_uri", null);
        Uri uri = null;
        if (string2 != null) {
            uri = Uri.parse((String)string2);
        }
        this.f = uri;
    }

    public static Profile a() {
        return ur.a().b();
    }

    public static void a(Profile profile) {
        ur.a().a(profile);
    }

    public static void b() {
        AccessToken accessToken = AccessToken.a();
        if (accessToken == null) {
            Profile.a(null);
            return;
        }
        we.a(accessToken.b(), new we.c(){

            @Override
            public void a(FacebookException facebookException) {
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(JSONObject jSONObject) {
                String string2 = jSONObject.optString("id");
                if (string2 == null) {
                    return;
                }
                String string3 = jSONObject.optString("link");
                String string4 = jSONObject.optString("first_name");
                String string5 = jSONObject.optString("middle_name");
                String string6 = jSONObject.optString("last_name");
                String string7 = jSONObject.optString("name");
                Uri uri = string3 != null ? Uri.parse((String)string3) : null;
                Profile.a(new Profile(string2, string4, string5, string6, string7, uri));
            }
        });
    }

    public String c() {
        return this.e;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", (Object)this.a);
            jSONObject.put("first_name", (Object)this.b);
            jSONObject.put("middle_name", (Object)this.c);
            jSONObject.put("last_name", (Object)this.d);
            jSONObject.put("name", (Object)this.e);
            if (this.f != null) {
                jSONObject.put("link_uri", (Object)this.f.toString());
            }
            return jSONObject;
        }
        catch (JSONException var2_2) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile)object;
        if (this.a.equals((Object)profile.a) && this.b == null) {
            if (profile.b == null) return true;
            return false;
        }
        if (this.b.equals((Object)profile.b) && this.c == null) {
            if (profile.c == null) return true;
            return false;
        }
        if (this.c.equals((Object)profile.c) && this.d == null) {
            if (profile.d == null) return true;
            return false;
        }
        if (this.d.equals((Object)profile.d) && this.e == null) {
            if (profile.e == null) return true;
            return false;
        }
        if (!this.e.equals((Object)profile.e) || this.f != null) return this.f.equals((Object)profile.f);
        {
            if (profile.f != null) return false;
        }
        return true;
    }

    public int hashCode() {
        int n2 = 527 + this.a.hashCode();
        if (this.b != null) {
            n2 = n2 * 31 + this.b.hashCode();
        }
        if (this.c != null) {
            n2 = n2 * 31 + this.c.hashCode();
        }
        if (this.d != null) {
            n2 = n2 * 31 + this.d.hashCode();
        }
        if (this.e != null) {
            n2 = n2 * 31 + this.e.hashCode();
        }
        if (this.f != null) {
            n2 = n2 * 31 + this.f.hashCode();
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        String string2 = this.f == null ? null : this.f.toString();
        parcel.writeString(string2);
    }

}

