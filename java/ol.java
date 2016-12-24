/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Error
 *  java.lang.Object
 *  java.lang.String
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ol
implements py<InputStream, File> {
    private static final a a = new a(null);
    private final kp<File, File> b = new oi();
    private final km<InputStream> c = new mu();

    @Override
    public kp<File, File> a() {
        return this.b;
    }

    @Override
    public kp<InputStream, File> b() {
        return a;
    }

    @Override
    public km<InputStream> c() {
        return this.c;
    }

    @Override
    public kq<File> d() {
        return nm.b();
    }

    static class a
    implements kp<InputStream, File> {
        private a() {
        }

        /* synthetic */ a( var1) {
        }

        @Override
        public String a() {
            return "";
        }

        @Override
        public lj<File> a(InputStream inputStream, int n2, int n3) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }
    }

}

