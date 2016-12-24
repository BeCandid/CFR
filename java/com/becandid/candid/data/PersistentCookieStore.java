/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.CookieStore
 *  java.net.HttpCookie
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.becandid.candid.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersistentCookieStore
implements CookieStore {
    private static PersistentCookieStore cookieStore;
    private static final aih sGson;
    private Map<URI, Set<HttpCookie>> allCookies;
    private SharedPreferences gsonSharedPreferences;

    static {
        sGson = new aih();
    }

    private PersistentCookieStore(Context context) {
        super.loadAllFromPersistence(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static URI cookieUri(URI uRI, HttpCookie httpCookie) {
        if (httpCookie.getDomain() == null) return uRI;
        try {
            String string2;
            String string3;
            String string4 = uRI.getScheme() == null ? "http" : uRI.getScheme();
            String string5 = httpCookie.getDomain();
            if (httpCookie.getPath() == null) {
                string2 = "/";
                return new URI(string4, string5, string2, null);
            }
            string2 = string3 = httpCookie.getPath();
            return new URI(string4, string5, string2, null);
        }
        catch (URISyntaxException var2_6) {
            Log.w((String)"PersistentCookieStore", (Throwable)var2_6);
        }
        return uRI;
    }

    private String getCookieKey(URI uRI, HttpCookie httpCookie) {
        return uRI.toString() + '|' + httpCookie.getName();
    }

    public static PersistentCookieStore getCookieStore(Context context) {
        if (cookieStore == null) {
            cookieStore = new PersistentCookieStore(context.getApplicationContext());
        }
        return cookieStore;
    }

    private String getGsonSerializedCookie(HttpCookie httpCookie) {
        return sGson.a((Object)httpCookie);
    }

    private List<HttpCookie> getValidCookies(URI uRI) {
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : this.allCookies.entrySet()) {
            String string2;
            URI uRI2 = (URI)entry.getKey();
            if (TextUtils.isEmpty((CharSequence)uRI2.getHost())) continue;
            String string3 = string2 = uRI2.getHost();
            if (!string2.startsWith(".")) {
                string3 = "." + string2;
            }
            if (!uRI.getHost().equals((Object)string2) && !uRI.getHost().endsWith(string3) && (!uRI.getHost().contains((CharSequence)".dev.") || !uRI.getHost().endsWith(string2)) || uRI2.getPath() != null && !"/".equals((Object)uRI2.getPath()) && !uRI2.getPath().equals((Object)uRI.getPath())) continue;
            hashSet.addAll((Collection)entry.getValue());
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            HttpCookie httpCookie = (HttpCookie)iterator.next();
            if (!httpCookie.hasExpired() || "u".equals((Object)httpCookie.getName())) continue;
            arrayList.add((Object)httpCookie);
            iterator.remove();
        }
        if (!arrayList.isEmpty()) {
            super.removeFromPersistence(uRI, (List<HttpCookie>)arrayList);
        }
        return new ArrayList((Collection)hashSet);
    }

    private void loadAllFromPersistence(Context context) {
        this.allCookies = new dh<URI, Set<HttpCookie>>();
        super.loadCookies(context, "com.becandid.likes.cookieStore");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void loadCookies(Context context, String string2) {
        SharedPreferences sharedPreferences;
        this.gsonSharedPreferences = sharedPreferences = context.getSharedPreferences(string2, 0);
        Iterator iterator = sharedPreferences.getAll().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String[] arrstring = ((String)entry.getKey()).split("\\|", 2);
            try {
                URI uRI = new URI(arrstring[0]);
                String string3 = (String)entry.getValue();
                HttpCookie httpCookie = (HttpCookie)sGson.a(string3, HttpCookie.class);
                if (httpCookie == null) continue;
                Set set = (Set)this.allCookies.get((Object)uRI);
                if (set == null) {
                    set = new HashSet();
                    this.allCookies.put((Object)uRI, (Object)set);
                }
                set.remove((Object)httpCookie);
                set.add((Object)httpCookie);
            }
            catch (URISyntaxException var8_5) {
                Log.w((String)"PersistentCookieStore", (Throwable)var8_5);
                continue;
            }
            break;
        }
        return;
    }

    private void removeAllFromPersistence() {
        this.gsonSharedPreferences.edit().clear().apply();
    }

    private void removeFromPersistence(URI uRI, HttpCookie httpCookie) {
        SharedPreferences.Editor editor = this.gsonSharedPreferences.edit();
        editor.remove(super.getCookieKey(uRI, httpCookie));
        editor.apply();
    }

    private void removeFromPersistence(URI uRI, List<HttpCookie> list) {
        SharedPreferences.Editor editor = this.gsonSharedPreferences.edit();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            editor.remove(super.getCookieKey(uRI, (HttpCookie)iterator.next()));
        }
        editor.apply();
    }

    private void saveToPersistence(URI uRI, HttpCookie httpCookie) {
        SharedPreferences.Editor editor = this.gsonSharedPreferences.edit();
        editor.putString(super.getCookieKey(uRI, httpCookie), super.getGsonSerializedCookie(httpCookie));
        editor.apply();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(URI uRI, HttpCookie httpCookie) {
        void var10_3 = this;
        synchronized (var10_3) {
            Log.d((String)"PersistentCookieStore", (String)("add: " + uRI.toString()));
            URI uRI2 = PersistentCookieStore.cookieUri(uRI, httpCookie);
            Set set = (Set)this.allCookies.get((Object)uRI2);
            if (set == null) {
                set = new HashSet();
                this.allCookies.put((Object)uRI2, (Object)set);
            }
            set.remove((Object)httpCookie);
            set.add((Object)httpCookie);
            super.saveToPersistence(uRI2, httpCookie);
            return;
        }
    }

    public List<HttpCookie> get(URI uRI) {
        void var4_2 = this;
        synchronized (var4_2) {
            List<HttpCookie> list = super.getValidCookies(uRI);
            return list;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public List<HttpCookie> getCookies() {
        PersistentCookieStore persistentCookieStore = this;
        synchronized (persistentCookieStore) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.allCookies.keySet().iterator();
            while (iterator.hasNext()) {
                arrayList.addAll(this.getValidCookies((URI)iterator.next()));
            }
            return arrayList;
        }
    }

    public List<URI> getURIs() {
        PersistentCookieStore persistentCookieStore = this;
        synchronized (persistentCookieStore) {
            ArrayList arrayList = new ArrayList((Collection)this.allCookies.keySet());
            return arrayList;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean remove(URI uRI, HttpCookie httpCookie) {
        void var6_3 = this;
        synchronized (var6_3) {
            Set set = (Set)this.allCookies.get((Object)uRI);
            if (set == null) return false;
            if (!set.remove((Object)httpCookie)) return false;
            boolean bl2 = true;
            if (!bl2) return bl2;
            super.removeFromPersistence(uRI, httpCookie);
            return bl2;
        }
    }

    public boolean removeAll() {
        PersistentCookieStore persistentCookieStore = this;
        synchronized (persistentCookieStore) {
            this.allCookies.clear();
            this.removeAllFromPersistence();
            return true;
        }
    }
}

