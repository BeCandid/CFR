/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.DecodeFormat
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

public class nw
implements kp<ParcelFileDescriptor, Bitmap> {
    private final of a;
    private final ln b;
    private DecodeFormat c;

    public nw(ln ln2, DecodeFormat decodeFormat) {
        super(new of(), ln2, decodeFormat);
    }

    public nw(of of2, ln ln2, DecodeFormat decodeFormat) {
        this.a = of2;
        this.b = ln2;
        this.c = decodeFormat;
    }

    @Override
    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }

    @Override
    public lj<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int n2, int n3) throws IOException {
        return nr.a(this.a.a(parcelFileDescriptor, this.b, n2, n3, this.c), this.b);
    }
}

