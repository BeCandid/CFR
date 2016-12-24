/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Pair
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
import android.util.Pair;
import com.facebook.FacebookException;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
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

public class wv {
    private static Bundle a(ShareContent shareContent, boolean bl2) {
        ShareHashtag shareHashtag;
        Bundle bundle = new Bundle();
        we.a(bundle, "LINK", shareContent.h());
        we.a(bundle, "PLACE", shareContent.j());
        we.a(bundle, "REF", shareContent.k());
        bundle.putBoolean("DATA_FAILURES_FATAL", bl2);
        List<String> list = shareContent.i();
        if (!we.a(list)) {
            bundle.putStringArrayList("FRIENDS", new ArrayList(list));
        }
        if ((shareHashtag = shareContent.l()) != null) {
            we.a(bundle, "HASHTAG", shareHashtag.a());
        }
        return bundle;
    }

    private static Bundle a(ShareLinkContent shareLinkContent, boolean bl2) {
        Bundle bundle = wv.a((ShareContent)shareLinkContent, bl2);
        we.a(bundle, "TITLE", shareLinkContent.b());
        we.a(bundle, "DESCRIPTION", shareLinkContent.a());
        we.a(bundle, "IMAGE", shareLinkContent.c());
        we.a(bundle, "QUOTE", shareLinkContent.d());
        return bundle;
    }

    private static Bundle a(ShareMediaContent shareMediaContent, List<Bundle> list, boolean bl2) {
        Bundle bundle = wv.a(shareMediaContent, bl2);
        bundle.putParcelableArrayList("MEDIA", new ArrayList(list));
        return bundle;
    }

    private static Bundle a(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean bl2) {
        Bundle bundle = wv.a(shareOpenGraphContent, bl2);
        we.a(bundle, "PREVIEW_PROPERTY_NAME", (String)wz.a((String)shareOpenGraphContent.b()).second);
        we.a(bundle, "ACTION_TYPE", shareOpenGraphContent.a().a());
        we.a(bundle, "ACTION", jSONObject.toString());
        return bundle;
    }

    private static Bundle a(SharePhotoContent sharePhotoContent, List<String> list, boolean bl2) {
        Bundle bundle = wv.a(sharePhotoContent, bl2);
        bundle.putStringArrayList("PHOTOS", new ArrayList(list));
        return bundle;
    }

    private static Bundle a(ShareVideoContent shareVideoContent, String string2, boolean bl2) {
        Bundle bundle = wv.a(shareVideoContent, bl2);
        we.a(bundle, "TITLE", shareVideoContent.b());
        we.a(bundle, "DESCRIPTION", shareVideoContent.a());
        we.a(bundle, "VIDEO", string2);
        return bundle;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bundle a(UUID uUID, ShareContent shareContent, boolean bl2) {
        wf.a(shareContent, "shareContent");
        wf.a((Object)uUID, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return wv.a((ShareLinkContent)shareContent, bl2);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent)shareContent;
            return wv.a(sharePhotoContent, wz.a(sharePhotoContent, uUID), bl2);
        }
        if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent)shareContent;
            return wv.a(shareVideoContent, wz.a(shareVideoContent, uUID), bl2);
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent)shareContent;
            try {
                return wv.a(shareOpenGraphContent, wz.a(wz.a(uUID, shareOpenGraphContent), false), bl2);
            }
            catch (JSONException var7_8) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + var7_8.getMessage());
            }
        }
        boolean bl3 = shareContent instanceof ShareMediaContent;
        Bundle bundle = null;
        if (!bl3) return bundle;
        ShareMediaContent shareMediaContent = (ShareMediaContent)shareContent;
        return wv.a(shareMediaContent, wz.a(shareMediaContent, uUID), bl2);
    }
}

