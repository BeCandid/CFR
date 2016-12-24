/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.UUID
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class wr {
    private static Bundle a(ShareContent shareContent, boolean bl2) {
        Bundle bundle = new Bundle();
        we.a(bundle, "com.facebook.platform.extra.LINK", shareContent.h());
        we.a(bundle, "com.facebook.platform.extra.PLACE", shareContent.j());
        we.a(bundle, "com.facebook.platform.extra.REF", shareContent.k());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", bl2);
        List<String> list = shareContent.i();
        if (!we.a(list)) {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(list));
        }
        return bundle;
    }

    private static Bundle a(ShareLinkContent shareLinkContent, boolean bl2) {
        Bundle bundle = wr.a((ShareContent)shareLinkContent, bl2);
        we.a(bundle, "com.facebook.platform.extra.TITLE", shareLinkContent.b());
        we.a(bundle, "com.facebook.platform.extra.DESCRIPTION", shareLinkContent.a());
        we.a(bundle, "com.facebook.platform.extra.IMAGE", shareLinkContent.c());
        return bundle;
    }

    private static Bundle a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean bl2) {
        Bundle bundle = wr.a(shareOpenGraphContent, bl2);
        we.a(bundle, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareOpenGraphContent.b());
        we.a(bundle, "com.facebook.platform.extra.ACTION_TYPE", shareOpenGraphContent.a().a());
        we.a(bundle, "com.facebook.platform.extra.ACTION", jSONObject.toString());
        return bundle;
    }

    private static Bundle a(SharePhotoContent sharePhotoContent, List<String> list, boolean bl2) {
        Bundle bundle = wr.a(sharePhotoContent, bl2);
        bundle.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(list));
        return bundle;
    }

    private static Bundle a(ShareVideoContent shareVideoContent, boolean bl2) {
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bundle a(UUID uUID, ShareContent shareContent, boolean bl2) {
        wf.a(shareContent, "shareContent");
        wf.a((Object)uUID, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return wr.a((ShareLinkContent)shareContent, bl2);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent)shareContent;
            return wr.a(sharePhotoContent, wz.a(sharePhotoContent, uUID), bl2);
        }
        if (shareContent instanceof ShareVideoContent) {
            return wr.a((ShareVideoContent)shareContent, bl2);
        }
        boolean bl3 = shareContent instanceof ShareOpenGraphContent;
        Bundle bundle = null;
        if (!bl3) return bundle;
        ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent)shareContent;
        try {
            return wr.a(shareOpenGraphContent, wz.a(uUID, shareOpenGraphContent), bl2);
        }
        catch (JSONException var6_8) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + var6_8.getMessage());
        }
    }
}

