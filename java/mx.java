/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.net.URL
 */
import java.net.URL;

public class mx<T>
implements mr<URL, T> {
    private final mr<mj, T> a;

    public mx(mr<mj, T> mr2) {
        this.a = mr2;
    }

    @Override
    public ku<T> a(URL uRL, int n2, int n3) {
        return this.a.a(new mj(uRL), n2, n3);
    }
}

