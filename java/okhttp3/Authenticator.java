/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 */
package okhttp3;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public interface Authenticator {
    public static final Authenticator NONE = new Authenticator(){

        @Override
        public Request authenticate(Route route, Response response) {
            return null;
        }
    };

    public Request authenticate(Route var1, Response var2) throws IOException;

}

