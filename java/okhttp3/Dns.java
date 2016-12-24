/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetAddress
 *  java.net.UnknownHostException
 *  java.util.Arrays
 *  java.util.List
 */
package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface Dns {
    public static final Dns SYSTEM = new Dns(){

        @Override
        public List<InetAddress> lookup(String string2) throws UnknownHostException {
            if (string2 == null) {
                throw new UnknownHostException("hostname == null");
            }
            return Arrays.asList((Object[])InetAddress.getAllByName((String)string2));
        }
    };

    public List<InetAddress> lookup(String var1) throws UnknownHostException;

}

