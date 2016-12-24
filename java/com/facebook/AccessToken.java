/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken
implements Parcelable {
    public static final Parcelable.Creator<AccessToken> CREATOR;
    private static final Date a;
    private static final Date b;
    private static final Date c;
    private static final AccessTokenSource d;
    private final Date e;
    private final Set<String> f;
    private final Set<String> g;
    private final String h;
    private final AccessTokenSource i;
    private final Date j;
    private final String k;
    private final String l;

    static {
        b = AccessToken.a = new Date(Long.MAX_VALUE);
        c = new Date();
        d = AccessTokenSource.b;
        CREATOR = new Parcelable.Creator(){

            public AccessToken a(Parcel parcel) {
                return new AccessToken(parcel);
            }

            public AccessToken[] a(int n2) {
                return new AccessToken[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
    }

    AccessToken(Parcel parcel) {
        this.e = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList((List)arrayList);
        this.f = Collections.unmodifiableSet((Set)new HashSet((Collection)arrayList));
        arrayList.clear();
        parcel.readStringList((List)arrayList);
        this.g = Collections.unmodifiableSet((Set)new HashSet((Collection)arrayList));
        this.h = parcel.readString();
        this.i = AccessTokenSource.valueOf(parcel.readString());
        this.j = new Date(parcel.readLong());
        this.k = parcel.readString();
        this.l = parcel.readString();
    }

    /*
     * Enabled aggressive block sorting
     */
    public AccessToken(String string2, String string3, String string4, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2) {
        wf.a(string2, "accessToken");
        wf.a(string3, "applicationId");
        wf.a(string4, "userId");
        if (date == null) {
            date = b;
        }
        this.e = date;
        HashSet hashSet = collection != null ? new HashSet(collection) : new HashSet();
        this.f = Collections.unmodifiableSet((Set)hashSet);
        HashSet hashSet2 = collection2 != null ? new HashSet(collection2) : new HashSet();
        this.g = Collections.unmodifiableSet((Set)hashSet2);
        this.h = string2;
        if (accessTokenSource == null) {
            accessTokenSource = d;
        }
        this.i = accessTokenSource;
        if (date2 == null) {
            date2 = c;
        }
        this.j = date2;
        this.k = string3;
        this.l = string4;
    }

    public static AccessToken a() {
        return uh.a().b();
    }

    public static AccessToken a(Bundle bundle) {
        String string2;
        List<String> list = AccessToken.a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        List<String> list2 = AccessToken.a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        String string3 = up.d(bundle);
        if (we.a(string3)) {
            string3 = ul.i();
        }
        String string4 = up.b(bundle);
        JSONObject jSONObject = we.e(string4);
        try {
            string2 = jSONObject.getString("id");
        }
        catch (JSONException var6_7) {
            return null;
        }
        return new AccessToken(string4, string3, string2, (Collection<String>)list, (Collection<String>)list2, up.c(bundle), up.a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), up.a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
    }

    public static AccessToken a(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt("version") > 1) {
            throw new FacebookException("Unknown AccessToken serialization format.");
        }
        String string2 = jSONObject.getString("token");
        Date date = new Date(jSONObject.getLong("expires_at"));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
        Date date2 = new Date(jSONObject.getLong("last_refresh"));
        AccessTokenSource accessTokenSource = AccessTokenSource.valueOf(jSONObject.getString("source"));
        return new AccessToken(string2, jSONObject.getString("application_id"), jSONObject.getString("user_id"), (Collection<String>)we.a(jSONArray), (Collection<String>)we.a(jSONArray2), accessTokenSource, date, date2);
    }

    static List<String> a(Bundle bundle, String string2) {
        ArrayList arrayList = bundle.getStringArrayList(string2);
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList((List)new ArrayList((Collection)arrayList));
    }

    public static void a(AccessToken accessToken) {
        uh.a().a(accessToken);
    }

    private void a(StringBuilder stringBuilder) {
        stringBuilder.append(" permissions:");
        if (this.f == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append("[");
        stringBuilder.append(TextUtils.join((CharSequence)", ", this.f));
        stringBuilder.append("]");
    }

    private String k() {
        if (this.h == null) {
            return "null";
        }
        if (ul.a(LoggingBehavior.b)) {
            return this.h;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    public String b() {
        return this.h;
    }

    public Date c() {
        return this.e;
    }

    public Set<String> d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public Set<String> e() {
        return this.g;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken)object;
        if (!this.e.equals((Object)accessToken.e)) return false;
        if (!this.f.equals(accessToken.f)) return false;
        if (!this.g.equals(accessToken.g)) return false;
        if (!this.h.equals((Object)accessToken.h)) return false;
        if (this.i != accessToken.i) return false;
        if (!this.j.equals((Object)accessToken.j)) return false;
        if (this.k == null) {
            if (accessToken.k != null) return false;
        } else if (!this.k.equals((Object)accessToken.k)) return false;
        if (this.l.equals((Object)accessToken.l)) return true;
        return false;
    }

    public AccessTokenSource f() {
        return this.i;
    }

    public Date g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        int n2;
        int n3 = 31 * (31 * (31 * (31 * (31 * (31 * (527 + this.e.hashCode()) + this.f.hashCode()) + this.g.hashCode()) + this.h.hashCode()) + this.i.hashCode()) + this.j.hashCode());
        if (this.k == null) {
            n2 = 0;
            do {
                return 31 * (n3 + n2) + this.l.hashCode();
                break;
            } while (true);
        }
        n2 = this.k.hashCode();
        return 31 * (n3 + n2) + this.l.hashCode();
    }

    public String i() {
        return this.l;
    }

    public JSONObject j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", (Object)this.h);
        jSONObject.put("expires_at", this.e.getTime());
        jSONObject.put("permissions", (Object)new JSONArray(this.f));
        jSONObject.put("declined_permissions", (Object)new JSONArray(this.g));
        jSONObject.put("last_refresh", this.j.getTime());
        jSONObject.put("source", (Object)this.i.name());
        jSONObject.put("application_id", (Object)this.k);
        jSONObject.put("user_id", (Object)this.l);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{AccessToken");
        stringBuilder.append(" token:").append(this.k());
        this.a(stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeLong(this.e.getTime());
        parcel.writeStringList((List)new ArrayList(this.f));
        parcel.writeStringList((List)new ArrayList(this.g));
        parcel.writeString(this.h);
        parcel.writeString(this.i.name());
        parcel.writeLong(this.j.getTime());
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }

    public static interface a {
        public void a(AccessToken var1);

        public void a(FacebookException var1);
    }

}

