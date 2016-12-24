/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.net.Socket
 */
package okhttp3;

import java.net.Socket;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Route;

public interface Connection {
    public Handshake handshake();

    public Protocol protocol();

    public Route route();

    public Socket socket();
}

