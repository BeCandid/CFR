/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class mm {
    private final InputStream a;
    private final ParcelFileDescriptor b;

    public mm(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.a = inputStream;
        this.b = parcelFileDescriptor;
    }

    public InputStream a() {
        return this.a;
    }

    public ParcelFileDescriptor b() {
        return this.b;
    }
}

