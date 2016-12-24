/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.FilenameFilter
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class sy
extends FileOutputStream {
    public static final FilenameFilter a = new FilenameFilter(){

        public boolean accept(File file, String string2) {
            return string2.endsWith(".cls_temp");
        }
    };
    private final String b;
    private File c;
    private File d;
    private boolean e = false;

    public sy(File file, String string2) throws FileNotFoundException {
        super(new File(file, string2 + ".cls_temp"));
        this.b = (Object)file + File.separator + string2;
        this.c = new File(this.b + ".cls_temp");
    }

    public void a() throws IOException {
        if (this.e) {
            return;
        }
        this.e = true;
        super.flush();
        super.close();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        sy sy2 = this;
        // MONITORENTER : sy2
        boolean bl2 = this.e;
        if (bl2) {
            // MONITOREXIT : sy2
            return;
        }
        this.e = true;
        super.flush();
        super.close();
        File file = new File(this.b + ".cls");
        if (this.c.renameTo(file)) {
            this.c = null;
            this.d = file;
            return;
        }
        String string2 = "";
        if (file.exists()) {
            string2 = " (target already exists)";
            throw new IOException("Could not rename temp file: " + (Object)this.c + " -> " + (Object)file + string2);
        }
        if (this.c.exists()) throw new IOException("Could not rename temp file: " + (Object)this.c + " -> " + (Object)file + string2);
        string2 = " (source does not exist)";
        throw new IOException("Could not rename temp file: " + (Object)this.c + " -> " + (Object)file + string2);
    }

}

