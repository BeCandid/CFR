/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Set
 */
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class wy {
    private static a a;
    private static a b;

    private static a a() {
        if (b == null) {
            b = new a(null);
        }
        return b;
    }

    public static void a(ShareContent shareContent) {
        wy.a(shareContent, wy.a());
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(ShareContent shareContent, a a2) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if (shareContent instanceof ShareLinkContent) {
            a2.a((ShareLinkContent)shareContent);
            return;
        } else {
            if (shareContent instanceof SharePhotoContent) {
                a2.a((SharePhotoContent)shareContent);
                return;
            }
            if (shareContent instanceof ShareVideoContent) {
                a2.a((ShareVideoContent)shareContent);
                return;
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                a2.a((ShareOpenGraphContent)shareContent);
                return;
            }
            if (!(shareContent instanceof ShareMediaContent)) return;
            {
                a2.a((ShareMediaContent)shareContent);
                return;
            }
        }
    }

    public static void a(ShareMedia shareMedia, a a2) {
        if (shareMedia instanceof SharePhoto) {
            a2.a((SharePhoto)shareMedia);
            return;
        }
        if (shareMedia instanceof ShareVideo) {
            a2.a((ShareVideo)shareMedia);
            return;
        }
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{shareMedia.getClass().getSimpleName()};
        throw new FacebookException(String.format((Locale)locale, (String)"Invalid media type: %s", (Object[])arrobject));
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(Object object, a a2) {
        if (object instanceof ShareOpenGraphObject) {
            a2.a((ShareOpenGraphObject)object);
            return;
        } else {
            if (!(object instanceof SharePhoto)) return;
            {
                a2.a((SharePhoto)object);
                return;
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(String string2, boolean bl2) {
        if (!bl2) {
            return;
        }
        String[] arrstring = string2.split(":");
        if (arrstring.length < 2) {
            throw new FacebookException("Open Graph keys must be namespaced: %s", string2);
        }
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            if (arrstring[n3].isEmpty()) {
                throw new FacebookException("Invalid key found in Open Graph dictionary: %s", string2);
            }
            ++n3;
        }
    }

    private static a b() {
        if (a == null) {
            a = new b(null);
        }
        return a;
    }

    public static void b(ShareContent shareContent) {
        wy.a(shareContent, wy.a());
    }

    private static void b(ShareLinkContent shareLinkContent, a a2) {
        Uri uri = shareLinkContent.c();
        if (uri != null && !we.b(uri)) {
            throw new FacebookException("Image Url must be an http:// or https:// url");
        }
    }

    private static void b(ShareMediaContent shareMediaContent, a a2) {
        List<ShareMedia> list = shareMediaContent.a();
        if (list == null || list.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        }
        if (list.size() > 6) {
            Locale locale = Locale.ROOT;
            Object[] arrobject = new Object[]{6};
            throw new FacebookException(String.format((Locale)locale, (String)"Cannot add more than %d media.", (Object[])arrobject));
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            a2.a((ShareMedia)iterator.next());
        }
    }

    private static void b(ShareOpenGraphAction shareOpenGraphAction, a a2) {
        if (shareOpenGraphAction == null) {
            throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
        }
        if (we.a(shareOpenGraphAction.a())) {
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        }
        a2.a(shareOpenGraphAction, false);
    }

    private static void b(ShareOpenGraphContent shareOpenGraphContent, a a2) {
        a2.a(shareOpenGraphContent.a());
        String string2 = shareOpenGraphContent.b();
        if (we.a(string2)) {
            throw new FacebookException("Must specify a previewPropertyName.");
        }
        if (shareOpenGraphContent.a().a(string2) == null) {
            throw new FacebookException("Property \"" + string2 + "\" was not found on the action. " + "The name of the preview property must match the name of an " + "action property.");
        }
    }

    private static void b(ShareOpenGraphObject shareOpenGraphObject, a a2) {
        if (shareOpenGraphObject == null) {
            throw new FacebookException("Cannot share a null ShareOpenGraphObject");
        }
        a2.a(shareOpenGraphObject, true);
    }

    private static void b(ShareOpenGraphValueContainer shareOpenGraphValueContainer, a a2, boolean bl2) {
        for (String string2 : shareOpenGraphValueContainer.c()) {
            wy.a(string2, bl2);
            Object object = shareOpenGraphValueContainer.a(string2);
            if (object instanceof List) {
                for (Object object2 : (List)object) {
                    if (object2 == null) {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                    wy.a(object2, a2);
                }
                continue;
            }
            wy.a(object, a2);
        }
    }

    private static void b(SharePhotoContent sharePhotoContent, a a2) {
        List<SharePhoto> list = sharePhotoContent.a();
        if (list == null || list.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        }
        if (list.size() > 6) {
            Locale locale = Locale.ROOT;
            Object[] arrobject = new Object[]{6};
            throw new FacebookException(String.format((Locale)locale, (String)"Cannot add more than %d photos.", (Object[])arrobject));
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            a2.a((SharePhoto)iterator.next());
        }
    }

    private static void b(ShareVideo shareVideo, a a2) {
        if (shareVideo == null) {
            throw new FacebookException("Cannot share a null ShareVideo");
        }
        Uri uri = shareVideo.c();
        if (uri == null) {
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        if (!we.c(uri) && !we.d(uri)) {
            throw new FacebookException("ShareVideo must reference a video that is on the device");
        }
    }

    private static void b(ShareVideoContent shareVideoContent, a a2) {
        a2.a(shareVideoContent.d());
        SharePhoto sharePhoto = shareVideoContent.c();
        if (sharePhoto != null) {
            a2.a(sharePhoto);
        }
    }

    public static void c(ShareContent shareContent) {
        wy.a(shareContent, wy.b());
    }

    private static void c(SharePhoto sharePhoto, a a2) {
        if (sharePhoto == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Bitmap bitmap = sharePhoto.c();
        Uri uri = sharePhoto.d();
        if (bitmap == null) {
            if (uri == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            if (we.b(uri) && !a2.a()) {
                throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            }
        }
    }

    private static void d(SharePhoto sharePhoto, a a2) {
        wy.c(sharePhoto, a2);
        if (sharePhoto.c() != null || !we.b(sharePhoto.d())) {
            wf.d(ul.f());
        }
    }

    private static void e(SharePhoto sharePhoto, a a2) {
        if (sharePhoto == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Uri uri = sharePhoto.d();
        if (uri == null || !we.b(uri)) {
            throw new FacebookException("SharePhoto must have a non-null imageUrl set to the Uri of an image on the web");
        }
    }

    static class a {
        private boolean a;

        private a() {
            this.a = false;
        }

        /* synthetic */ a( var1) {
        }

        public void a(ShareLinkContent shareLinkContent) {
            wy.b(shareLinkContent, (a)this);
        }

        public void a(ShareMedia shareMedia) {
            wy.a(shareMedia, (a)this);
        }

        public void a(ShareMediaContent shareMediaContent) {
            wy.b(shareMediaContent, (a)this);
        }

        public void a(ShareOpenGraphAction shareOpenGraphAction) {
            wy.b(shareOpenGraphAction, (a)this);
        }

        public void a(ShareOpenGraphContent shareOpenGraphContent) {
            this.a = true;
            wy.b(shareOpenGraphContent, (a)this);
        }

        public void a(ShareOpenGraphObject shareOpenGraphObject) {
            wy.b(shareOpenGraphObject, (a)this);
        }

        public void a(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean bl2) {
            wy.b(shareOpenGraphValueContainer, (a)this, bl2);
        }

        public void a(SharePhoto sharePhoto) {
            wy.d(sharePhoto, (a)this);
        }

        public void a(SharePhotoContent sharePhotoContent) {
            wy.b(sharePhotoContent, (a)this);
        }

        public void a(ShareVideo shareVideo) {
            wy.b(shareVideo, (a)this);
        }

        public void a(ShareVideoContent shareVideoContent) {
            wy.b(shareVideoContent, (a)this);
        }

        public boolean a() {
            return this.a;
        }
    }

    static class b
    extends a {
        private b() {
            super(null);
        }

        /* synthetic */ b( var1) {
        }

        @Override
        public void a(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override
        public void a(SharePhoto sharePhoto) {
            wy.e(sharePhoto, (a)this);
        }

        @Override
        public void a(SharePhotoContent sharePhotoContent) {
            throw new FacebookException("Cannot share SharePhotoContent via web sharing dialogs");
        }

        @Override
        public void a(ShareVideoContent shareVideoContent) {
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }
    }

}

