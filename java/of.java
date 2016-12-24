/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.MediaMetadataRetriever
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.DecodeFormat
 *  java.io.FileDescriptor
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.FileDescriptor;
import java.io.IOException;

public class of
implements np<ParcelFileDescriptor> {
    private static final a a = new a();
    private a b;
    private int c;

    public of() {
        this(a, -1);
    }

    of(a a2, int n2) {
        this.b = a2;
        this.c = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, ln ln2, int n2, int n3, DecodeFormat decodeFormat) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = this.b.a();
        mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        Bitmap bitmap = this.c >= 0 ? mediaMetadataRetriever.getFrameAtTime((long)this.c) : mediaMetadataRetriever.getFrameAtTime();
        mediaMetadataRetriever.release();
        parcelFileDescriptor.close();
        return bitmap;
    }

    @Override
    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

}

