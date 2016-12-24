/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 */
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class la
extends ky<InputStream> {
    public la(Context context, Uri uri) {
        super(context, uri);
    }

    protected InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }

    @Override
    protected void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override
    protected /* synthetic */ Object b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return this.a(uri, contentResolver);
    }
}

