/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 */
import java.io.File;

public class lx
implements lu.a {
    private final int a;
    private final a b;

    public lx(a a2, int n2) {
        this.a = n2;
        this.b = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public lu a() {
        File file = this.b.a();
        if (!(file != null && (file.mkdirs() || file.exists() && file.isDirectory()))) {
            return null;
        }
        return ly.a(file, this.a);
    }

    public static interface a {
        public File a();
    }

}

