/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

public class oa
implements kp<mm, Bitmap> {
    private final kp<InputStream, Bitmap> a;
    private final kp<ParcelFileDescriptor, Bitmap> b;

    public oa(kp<InputStream, Bitmap> kp2, kp<ParcelFileDescriptor, Bitmap> kp3) {
        this.a = kp2;
        this.b = kp3;
    }

    @Override
    public String a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public lj<Bitmap> a(mm var1, int var2_3, int var3_2) throws IOException {
        var4_4 = var1.a();
        var5_5 = null;
        if (var4_4 != null) {
            var5_5 = var10_6 = this.a.a(var4_4, var2_3, var3_2);
        }
lbl6: // 5 sources:
        do {
            if (var5_5 == null && (var6_7 = var1.b()) != null) {
                var5_5 = this.b.a(var6_7, var2_3, var3_2);
            }
            return var5_5;
            break;
        } while (true);
        catch (IOException var7_8) {
            var8_9 = Log.isLoggable((String)"ImageVideoDecoder", (int)2);
            var5_5 = null;
            if (!var8_9) ** GOTO lbl6
            Log.v((String)"ImageVideoDecoder", (String)"Failed to load image from stream, trying FileDescriptor", (Throwable)var7_8);
            var5_5 = null;
            ** continue;
        }
    }
}

