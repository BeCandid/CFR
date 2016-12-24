/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.util.Log
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URLEncoder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.UUID
 */
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class vy {
    private static final String a = vy.class.getName();
    private static File b;

    private vy() {
    }

    static File a() {
        reference var2 = vy.class;
        synchronized (vy.class) {
            if (b == null) {
                b = new File(ul.f().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            File file = b;
            // ** MonitorExit[var2] (shouldn't be in output)
            return file;
        }
    }

    public static File a(UUID uUID, String string2) throws FileNotFoundException {
        if (we.a(string2) || uUID == null) {
            throw new FileNotFoundException();
        }
        try {
            File file = vy.a(uUID, string2, false);
            return file;
        }
        catch (IOException var2_3) {
            throw new FileNotFoundException();
        }
    }

    static File a(UUID uUID, String string2, boolean bl2) throws IOException {
        File file = vy.a(uUID, bl2);
        if (file == null) {
            return null;
        }
        try {
            File file2 = new File(file, URLEncoder.encode((String)string2, (String)"UTF-8"));
            return file2;
        }
        catch (UnsupportedEncodingException var5_5) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static File a(UUID uUID, boolean bl2) {
        if (b == null) {
            return null;
        }
        File file = new File(b, uUID.toString());
        if (!bl2) return file;
        if (file.exists()) return file;
        file.mkdirs();
        return file;
    }

    public static a a(UUID uUID, Bitmap bitmap) {
        wf.a((Object)uUID, "callId");
        wf.a((Object)bitmap, "attachmentBitmap");
        return new a(uUID, bitmap, null, null);
    }

    public static a a(UUID uUID, Uri uri) {
        wf.a((Object)uUID, "callId");
        wf.a((Object)uri, "attachmentUri");
        return new a(uUID, null, uri, null);
    }

    private static void a(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)fileOutputStream);
            return;
        }
        finally {
            we.a((Closeable)fileOutputStream);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void a(Uri var0_1, boolean var1, File var2_2) throws IOException {
        var3_3 = new FileOutputStream(var2_2);
        if (var1) ** GOTO lbl6
        try {
            var6_4 = new FileInputStream(var0_1.getPath());
            ** GOTO lbl7
lbl6: // 1 sources:
            var6_4 = var5_5 = ul.f().getContentResolver().openInputStream(var0_1);
lbl7: // 2 sources:
            we.a((InputStream)var6_4, (OutputStream)var3_3);
            return;
        }
        finally {
            we.a((Closeable)var3_3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Collection<a> collection) {
        if (collection == null || collection.size() == 0) return;
        if (b == null) {
            vy.c();
        }
        vy.b();
        ArrayList arrayList = new ArrayList();
        try {
            for (a a2 : collection) {
                if (!a2.g) continue;
                File file = vy.a(a2.a, a2.c, true);
                arrayList.add((Object)file);
                if (a2.d != null) {
                    vy.a(a2.d, file);
                    continue;
                }
                if (a2.e == null) continue;
                vy.a(a2.e, a2.f, file);
            }
            return;
        }
        catch (IOException var3_5) {
            Log.e((String)a, (String)("Got unexpected exception:" + (Object)var3_5));
            for (File file : arrayList) {
                try {
                    file.delete();
                }
                catch (Exception var7_7) {}
            }
        }
        throw new FacebookException((Throwable)var3_5);
    }

    public static void a(UUID uUID) {
        File file = vy.a(uUID, false);
        if (file != null) {
            we.a(file);
        }
    }

    static File b() {
        File file = vy.a();
        file.mkdirs();
        return file;
    }

    public static void c() {
        we.a(vy.a());
    }

    public static final class a {
        private final UUID a;
        private final String b;
        private final String c;
        private Bitmap d;
        private Uri e;
        private boolean f;
        private boolean g;

        /*
         * Enabled aggressive block sorting
         */
        private a(UUID uUID, Bitmap bitmap, Uri uri) {
            boolean bl2 = true;
            this.a = uUID;
            this.d = bitmap;
            this.e = uri;
            if (uri != null) {
                String string2 = uri.getScheme();
                if ("content".equalsIgnoreCase(string2)) {
                    this.f = bl2;
                    if (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) {
                        bl2 = false;
                    }
                    this.g = bl2;
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    this.g = bl2;
                } else if (!we.b(uri)) {
                    throw new FacebookException("Unsupported scheme for media Uri : " + string2);
                }
            } else {
                if (bitmap == null) {
                    throw new FacebookException("Cannot share media without a bitmap or Uri set");
                }
                this.g = bl2;
            }
            String string3 = !this.g ? null : UUID.randomUUID().toString();
            this.c = string3;
            String string4 = !this.g ? this.e.toString() : FacebookContentProvider.a(ul.i(), uUID, this.c);
            this.b = string4;
        }

        /* synthetic */ a(UUID uUID, Bitmap bitmap, Uri uri,  var4) {
            super(uUID, bitmap, uri);
        }

        public String a() {
            return this.b;
        }
    }

}

