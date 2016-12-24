/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  android.util.Pair
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.UUID
 */
package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider
extends ContentProvider {
    private static final String a = FacebookContentProvider.class.getName();

    public static String a(String string2, UUID uUID, String string3) {
        Object[] arrobject = new Object[]{"content://com.facebook.app.FacebookContentProvider", string2, uUID.toString(), string3};
        return String.format((String)"%s%s/%s/%s", (Object[])arrobject);
    }

    Pair<UUID, String> a(Uri uri) {
        try {
            String[] arrstring = uri.getPath().substring(1).split("/");
            String string2 = arrstring[0];
            String string3 = arrstring[1];
            Pair pair = new Pair((Object)UUID.fromString((String)string2), (Object)string3);
            return pair;
        }
        catch (Exception var2_6) {
            return null;
        }
    }

    public int delete(Uri uri, String string2, String[] arrstring) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String string2) throws FileNotFoundException {
        Pair<UUID, String> pair = this.a(uri);
        if (pair == null) {
            throw new FileNotFoundException();
        }
        try {
            ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open((File)vy.a((UUID)pair.first, (String)pair.second), (int)268435456);
            return parcelFileDescriptor;
        }
        catch (FileNotFoundException var4_5) {
            Log.e((String)a, (String)("Got unexpected exception:" + (Object)var4_5));
            throw var4_5;
        }
    }

    public Cursor query(Uri uri, String[] arrstring, String string2, String[] arrstring2, String string3) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string2, String[] arrstring) {
        return 0;
    }
}

