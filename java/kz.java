/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class kz
extends ks<InputStream> {
    public kz(AssetManager assetManager, String string2) {
        super(assetManager, string2);
    }

    @Override
    protected /* synthetic */ Object a(AssetManager assetManager, String string2) throws IOException {
        return this.b(assetManager, string2);
    }

    @Override
    protected void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    protected InputStream b(AssetManager assetManager, String string2) throws IOException {
        return assetManager.open(string2);
    }
}

