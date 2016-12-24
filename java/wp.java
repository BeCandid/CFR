/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.app.Fragment
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

public class wp
extends vl<ShareContent, a> {
    private static final int b = CallbackManagerImpl.RequestCodeOffset.i.a();

    public wp(Activity activity) {
        super(activity, b);
    }

    public wp(android.app.Fragment fragment) {
        super(new vq(fragment), b);
    }

    public wp(Fragment fragment) {
        super(new vq(fragment), b);
    }

    @Override
    protected void a(CallbackManagerImpl callbackManagerImpl, final uk<a> uk2) {
        callbackManagerImpl.b(this.a(), new CallbackManagerImpl.a(){

            @Override
            public boolean a(int n2, Intent intent) {
                intent.getExtras();
                if (intent.hasExtra("error")) {
                    FacebookRequestError facebookRequestError = (FacebookRequestError)intent.getParcelableExtra("error");
                    uk2.onError(facebookRequestError.g());
                    return true;
                }
                uk2.onSuccess(new a());
                return true;
            }
        });
    }

    @Override
    protected boolean a(ShareContent shareContent, Object object) {
        if (shareContent instanceof ShareLinkContent || shareContent instanceof ShareOpenGraphContent) {
            return true;
        }
        return false;
    }

    @Override
    protected void b(ShareContent shareContent, Object object) {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if (!(shareContent instanceof ShareLinkContent) && !(shareContent instanceof ShareOpenGraphContent)) {
            throw new FacebookException(this.getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
        }
        Intent intent = new Intent();
        intent.setClass(ul.f(), (Class)FacebookActivity.class);
        intent.setAction("DeviceShareDialogFragment");
        intent.putExtra("content", (Parcelable)shareContent);
        this.a(intent, this.a());
    }

    @Override
    protected List<vl<ShareContent, a>> c() {
        return null;
    }

    @Override
    protected vf d() {
        return null;
    }

    public static class a {
    }

}

