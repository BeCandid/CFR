/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.CookieHandler
 *  java.net.HttpCookie
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package com.becandid.candid.data;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;

public final class JavaNetCookieJar
implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
    }

    /*
     * Enabled aggressive block sorting
     */
    private List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String string2) {
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        int n3 = string2.length();
        while (n2 < n3) {
            int n4 = Util.delimiterOffset(string2, n2, n3, ";,");
            int n5 = Util.delimiterOffset(string2, n2, n4, '=');
            String string3 = Util.trimSubstring(string2, n2, n5);
            if (!string3.startsWith("$")) {
                String string4 = n5 < n4 ? Util.trimSubstring(string2, n5 + 1, n4) : "";
                if (string4.startsWith("\"") && string4.endsWith("\"")) {
                    string4 = string4.substring(1, -1 + string4.length());
                }
                arrayList.add((Object)new Cookie.Builder().name(string3).value(string4).domain(httpUrl.host()).build());
            }
            n2 = n4 + 1;
        }
        return arrayList;
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        Map map;
        ArrayList arrayList;
        Map map2 = Collections.emptyMap();
        try {
            map = this.cookieHandler.get(httpUrl.uri(), map2);
            arrayList = null;
        }
        catch (IOException var3_10) {
            Internal.logger.log(Level.WARNING, "Loading cookies failed for " + httpUrl.resolve("/..."), (Throwable)var3_10);
            return Collections.emptyList();
        }
        for (Map.Entry entry : map.entrySet()) {
            String string2 = (String)entry.getKey();
            if (!"Cookie".equalsIgnoreCase(string2) && !"Cookie2".equalsIgnoreCase(string2) || ((List)entry.getValue()).isEmpty()) continue;
            for (String string3 : (List)entry.getValue()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(super.decodeHeaderAsJavaNetCookies(httpUrl, string3));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList((List)arrayList);
        }
        return Collections.emptyList();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (this.cookieHandler == null) return;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((Cookie)iterator.next()).toString());
        }
        Map map = Collections.singletonMap((Object)"Set-Cookie", (Object)arrayList);
        for (Map.Entry entry : map.entrySet()) {
            ArrayList arrayList2 = new ArrayList();
            for (String string2 : (List)entry.getValue()) {
                try {
                    Iterator iterator2 = HttpCookie.parse((String)string2).iterator();
                    while (iterator2.hasNext()) {
                        arrayList2.add((Object)((HttpCookie)iterator2.next()));
                    }
                    continue;
                }
                catch (IllegalArgumentException var12_11) {
                    continue;
                }
            }
        }
        try {
            this.cookieHandler.put(httpUrl.uri(), map);
            return;
        }
        catch (IOException var7_13) {
            Internal.logger.log(Level.WARNING, "Saving cookies failed for " + httpUrl.resolve("/..."), (Throwable)var7_13);
            return;
        }
    }
}

