/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import org.json.JSONException;
import org.json.JSONObject;

public class xa {
    public static Bundle a(ShareFeedContent shareFeedContent) {
        Bundle bundle = new Bundle();
        we.a(bundle, "to", shareFeedContent.a());
        we.a(bundle, "link", shareFeedContent.b());
        we.a(bundle, "picture", shareFeedContent.f());
        we.a(bundle, "source", shareFeedContent.g());
        we.a(bundle, "name", shareFeedContent.c());
        we.a(bundle, "caption", shareFeedContent.d());
        we.a(bundle, "description", shareFeedContent.e());
        return bundle;
    }

    public static Bundle a(ShareContent shareContent) {
        Bundle bundle = new Bundle();
        ShareHashtag shareHashtag = shareContent.l();
        if (shareHashtag != null) {
            we.a(bundle, "hashtag", shareHashtag.a());
        }
        return bundle;
    }

    public static Bundle a(ShareLinkContent shareLinkContent) {
        Bundle bundle = xa.a((ShareContent)shareLinkContent);
        we.a(bundle, "href", shareLinkContent.h());
        we.a(bundle, "quote", shareLinkContent.d());
        return bundle;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bundle a(ShareOpenGraphContent shareOpenGraphContent) {
        JSONObject jSONObject;
        Bundle bundle = xa.a((ShareContent)shareOpenGraphContent);
        we.a(bundle, "action_type", shareOpenGraphContent.a().a());
        try {
            jSONObject = wz.a(wz.a(shareOpenGraphContent), false);
            if (jSONObject == null) return bundle;
        }
        catch (JSONException var2_3) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", (Throwable)var2_3);
        }
        we.a(bundle, "action_properties", jSONObject.toString());
        return bundle;
    }

    public static Bundle b(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        we.a(bundle, "name", shareLinkContent.b());
        we.a(bundle, "description", shareLinkContent.a());
        we.a(bundle, "link", we.a(shareLinkContent.h()));
        we.a(bundle, "picture", we.a(shareLinkContent.c()));
        we.a(bundle, "quote", shareLinkContent.d());
        if (shareLinkContent.l() != null) {
            we.a(bundle, "hashtag", shareLinkContent.l().a());
        }
        return bundle;
    }
}

