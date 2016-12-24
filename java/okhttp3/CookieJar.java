/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package okhttp3;

import java.util.Collections;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar(){

        @Override
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }

        @Override
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }
    };

    public List<Cookie> loadForRequest(HttpUrl var1);

    public void saveFromResponse(HttpUrl var1, List<Cookie> var2);

}

