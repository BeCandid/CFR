/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.File
 *  java.lang.Object
 */
import android.net.Uri;
import java.io.File;

public class mh<T>
implements mr<File, T> {
    private final mr<Uri, T> a;

    public mh(mr<Uri, T> mr2) {
        this.a = mr2;
    }

    @Override
    public ku<T> a(File file, int n2, int n3) {
        return this.a.a(Uri.fromFile((File)file), n2, n3);
    }
}

