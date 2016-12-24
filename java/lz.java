/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import java.io.File;

public final class lz
extends lx {
    public lz(Context context) {
        super(context, "image_manager_disk_cache", 262144000);
    }

    public lz(Context context, final String string2, int n2) {
        super(new lx.a(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public File a() {
                File file = Context.this.getCacheDir();
                if (file == null) {
                    return null;
                }
                if (string2 == null) return file;
                return new File(file, string2);
            }
        }, n2);
    }

}

