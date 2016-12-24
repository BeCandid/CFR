/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.UUID
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.OpenGraphMessageDialogFeature;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class xb
extends vl<ShareContent, wq.a>
implements wq {
    private static final int b = CallbackManagerImpl.RequestCodeOffset.c.a();
    private boolean c;

    public xb(Activity activity, int n2) {
        super(activity, n2);
        this.c = false;
        wz.a(n2);
    }

    public xb(android.app.Fragment fragment, int n2) {
        super(new vq(fragment), n2);
    }

    public xb(Fragment fragment, int n2) {
        super(new vq(fragment), n2);
    }

    private xb(vq vq2, int n2) {
        super(vq2, n2);
        this.c = false;
        wz.a(n2);
    }

    public static boolean a(Class<? extends ShareContent> class_) {
        vj vj2 = xb.c(class_);
        if (vj2 != null && vk.a(vj2)) {
            return true;
        }
        return false;
    }

    private static vj c(Class<? extends ShareContent> class_) {
        if (ShareLinkContent.class.isAssignableFrom(class_)) {
            return MessageDialogFeature.a;
        }
        if (SharePhotoContent.class.isAssignableFrom(class_)) {
            return MessageDialogFeature.b;
        }
        if (ShareVideoContent.class.isAssignableFrom(class_)) {
            return MessageDialogFeature.c;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(class_)) {
            return OpenGraphMessageDialogFeature.a;
        }
        return null;
    }

    @Override
    protected void a(CallbackManagerImpl callbackManagerImpl, uk<wq.a> uk2) {
        wz.a(this.a(), callbackManagerImpl, uk2);
    }

    @Override
    protected List<vl<ShareContent, wq.a>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new a(this, null));
        return arrayList;
    }

    @Override
    protected vf d() {
        return new vf(this.a());
    }

    public boolean e() {
        return this.c;
    }

    class a
    extends vl<ShareContent, wq.a> {
        final /* synthetic */ xb b;

        private a(xb xb2) {
            this.b = xb2;
            super((vl)xb2);
        }

        /* synthetic */ a(xb xb2, xb$1 var2_2) {
            super(xb2);
        }

        public vf a(final ShareContent shareContent) {
            wy.a(shareContent);
            final vf vf2 = this.b.d();
            final boolean bl2 = this.b.e();
            this.b.b();
            vk.a(vf2, new vk.a(){

                @Override
                public Bundle a() {
                    return wv.a(vf2.c(), shareContent, bl2);
                }

                @Override
                public Bundle b() {
                    return wr.a(vf2.c(), shareContent, bl2);
                }
            }, xb.c(shareContent.getClass()));
            return vf2;
        }

        public boolean a(ShareContent shareContent, boolean bl2) {
            if (shareContent != null && xb.a(shareContent.getClass())) {
                return true;
            }
            return false;
        }

    }

}

