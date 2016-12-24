/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import java.io.File;

public class anh
implements ang {
    private final Context a;
    private final String b;
    private final String c;

    public anh(alc alc2) {
        if (alc2.E() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.a = alc2.E();
        this.b = alc2.G();
        this.c = "Android/" + this.a.getPackageName();
    }

    @Override
    public File a() {
        return this.a(this.a.getFilesDir());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    File a(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            akx.h().d("Fabric", "Couldn't create file");
            do {
                return null;
                break;
            } while (true);
        }
        akx.h().a("Fabric", "Null File");
        return null;
    }
}

