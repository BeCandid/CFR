/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.AssetManager
 *  android.os.ParcelFileDescriptor
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class kv
extends ks<ParcelFileDescriptor> {
    public kv(AssetManager assetManager, String string2) {
        super(assetManager, string2);
    }

    @Override
    protected /* synthetic */ Object a(AssetManager assetManager, String string2) throws IOException {
        return this.b(assetManager, string2);
    }

    @Override
    protected void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    protected ParcelFileDescriptor b(AssetManager assetManager, String string2) throws IOException {
        return assetManager.openFd(string2).getParcelFileDescriptor();
    }
}

