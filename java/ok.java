/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ok<T>
implements kp<File, T> {
    private static final a a = new a();
    private kp<InputStream, T> b;
    private final a c;

    public ok(kp<InputStream, T> kp2) {
        super(kp2, a);
    }

    ok(kp<InputStream, T> kp2, a a2) {
        this.b = kp2;
        this.c = a2;
    }

    @Override
    public String a() {
        return "";
    }

    @Override
    public lj<T> a(File file, int n2, int n3) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.c.a(file);
            lj<T> lj2 = this.b.a(inputStream, n2, n3);
            return lj2;
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    static class a {
        a() {
        }

        public InputStream a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

}

