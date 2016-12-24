/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.resource.bitmap.ImageHeaderParser
 *  com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$ImageType
 *  com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class oy
implements kp<mm, ow> {
    private static final b a = new b();
    private static final a b = new a();
    private final kp<mm, Bitmap> c;
    private final kp<InputStream, on> d;
    private final ln e;
    private final b f;
    private final a g;
    private String h;

    public oy(kp<mm, Bitmap> kp2, kp<InputStream, on> kp3, ln ln2) {
        super(kp2, kp3, ln2, a, b);
    }

    oy(kp<mm, Bitmap> kp2, kp<InputStream, on> kp3, ln ln2, b b2, a a2) {
        this.c = kp2;
        this.d = kp3;
        this.e = ln2;
        this.f = b2;
        this.g = a2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private ow a(InputStream inputStream, int n2, int n3) throws IOException {
        lj<on> lj2 = this.d.a(inputStream, n2, n3);
        ow ow2 = null;
        if (lj2 == null) return ow2;
        on on2 = lj2.b();
        if (on2.e() <= 1) return new ow(new nr(on2.b(), this.e), null);
        return new ow(null, lj2);
    }

    private ow a(mm mm2, int n2, int n3, byte[] arrby) throws IOException {
        if (mm2.a() != null) {
            return super.b(mm2, n2, n3, arrby);
        }
        return super.b(mm2, n2, n3);
    }

    private ow b(mm mm2, int n2, int n3) throws IOException {
        lj<Bitmap> lj2 = this.c.a(mm2, n2, n3);
        ow ow2 = null;
        if (lj2 != null) {
            ow2 = new ow(lj2, null);
        }
        return ow2;
    }

    private ow b(mm mm2, int n2, int n3, byte[] arrby) throws IOException {
        InputStream inputStream = this.g.a(mm2.a(), arrby);
        inputStream.mark(2048);
        ImageHeaderParser.ImageType imageType = this.f.a(inputStream);
        inputStream.reset();
        ImageHeaderParser.ImageType imageType2 = ImageHeaderParser.ImageType.a;
        ow ow2 = null;
        if (imageType == imageType2) {
            ow2 = super.a(inputStream, n2, n3);
        }
        if (ow2 == null) {
            ow2 = super.b(new mm(inputStream, mm2.b()), n2, n3);
        }
        return ow2;
    }

    @Override
    public String a() {
        if (this.h == null) {
            this.h = this.d.a() + this.c.a();
        }
        return this.h;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public lj<ow> a(mm mm2, int n2, int n3) throws IOException {
        rb rb2 = rb.a();
        byte[] arrby = rb2.b();
        ow ow2 = super.a(mm2, n2, n3, arrby);
        if (ow2 == null) return null;
        return new ox(ow2);
        finally {
            rb2.a(arrby);
        }
    }

    static class a {
        a() {
        }

        public InputStream a(InputStream inputStream, byte[] arrby) {
            return new RecyclableBufferedInputStream(inputStream, arrby);
        }
    }

    static class b {
        b() {
        }

        public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).b();
        }
    }

}

