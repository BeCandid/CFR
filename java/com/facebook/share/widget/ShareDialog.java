/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.UUID
 */
package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ShareDialog
extends vl<ShareContent, wq.a>
implements wq {
    private static final int b = CallbackManagerImpl.RequestCodeOffset.b.a();
    private boolean c;
    private boolean d;

    public ShareDialog(Activity activity) {
        super(activity, b);
        this.c = false;
        this.d = true;
        wz.a(b);
    }

    ShareDialog(Activity activity, int n2) {
        super(activity, n2);
        this.c = false;
        this.d = true;
        wz.a(n2);
    }

    ShareDialog(Fragment fragment, int n2) {
        super(new vq(fragment), n2);
    }

    ShareDialog(android.support.v4.app.Fragment fragment, int n2) {
        super(new vq(fragment), n2);
    }

    private ShareDialog(vq vq2, int n2) {
        super(vq2, n2);
        this.c = false;
        this.d = true;
        wz.a(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Context context, ShareContent shareContent, Mode mode) {
        String string2;
        vj vj2;
        if (this.d) {
            mode = Mode.a;
        }
        switch (.a[mode.ordinal()]) {
            default: {
                string2 = "unknown";
                break;
            }
            case 1: {
                string2 = "automatic";
                break;
            }
            case 2: {
                string2 = "web";
                break;
            }
            case 3: {
                string2 = "native";
            }
        }
        String string3 = (vj2 = ShareDialog.g(shareContent.getClass())) == ShareDialogFeature.a ? "status" : (vj2 == ShareDialogFeature.b ? "photo" : (vj2 == ShareDialogFeature.c ? "video" : (vj2 == OpenGraphActionDialogFeature.a ? "open_graph" : "unknown")));
        AppEventsLogger appEventsLogger = AppEventsLogger.a(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", string2);
        bundle.putString("fb_share_dialog_content_type", string3);
        appEventsLogger.a("fb_share_dialog_show", null, bundle);
    }

    public static boolean a(Class<? extends ShareContent> class_) {
        if (ShareDialog.f(class_) || ShareDialog.e(class_)) {
            return true;
        }
        return false;
    }

    private static boolean e(Class<? extends ShareContent> class_) {
        vj vj2 = ShareDialog.g(class_);
        if (vj2 != null && vk.a(vj2)) {
            return true;
        }
        return false;
    }

    private static boolean f(Class<? extends ShareContent> class_) {
        if (ShareLinkContent.class.isAssignableFrom(class_) || ShareOpenGraphContent.class.isAssignableFrom(class_)) {
            return true;
        }
        return false;
    }

    private static vj g(Class<? extends ShareContent> class_) {
        if (ShareLinkContent.class.isAssignableFrom(class_)) {
            return ShareDialogFeature.a;
        }
        if (SharePhotoContent.class.isAssignableFrom(class_)) {
            return ShareDialogFeature.b;
        }
        if (ShareVideoContent.class.isAssignableFrom(class_)) {
            return ShareDialogFeature.c;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(class_)) {
            return OpenGraphActionDialogFeature.a;
        }
        if (ShareMediaContent.class.isAssignableFrom(class_)) {
            return ShareDialogFeature.d;
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
        arrayList.add((Object)new b(this, null));
        arrayList.add((Object)new a(this, null));
        arrayList.add((Object)new c(this, null));
        return arrayList;
    }

    @Override
    protected vf d() {
        return new vf(this.a());
    }

    public boolean e() {
        return this.c;
    }

    public static final class Mode
    extends Enum<Mode> {
        public static final /* enum */ Mode a = new Mode();
        public static final /* enum */ Mode b = new Mode();
        public static final /* enum */ Mode c = new Mode();
        public static final /* enum */ Mode d = new Mode();
        private static final /* synthetic */ Mode[] e;

        static {
            Mode[] arrmode = new Mode[]{a, b, c, d};
            e = arrmode;
        }

        private Mode() {
            super(string2, n2);
        }

        public static Mode valueOf(String string2) {
            return (Mode)Enum.valueOf((Class)Mode.class, (String)string2);
        }

        public static Mode[] values() {
            return (Mode[])e.clone();
        }
    }

    class a
    extends vl<ShareContent, wq.a> {
        final /* synthetic */ ShareDialog b;

        private a(ShareDialog shareDialog) {
            this.b = shareDialog;
            super((vl)shareDialog);
        }

        /* synthetic */ a(ShareDialog shareDialog,  var2_2) {
            super(shareDialog);
        }

        public Object a() {
            return Mode.d;
        }

        /*
         * Enabled aggressive block sorting
         */
        public vf a(ShareContent shareContent) {
            Bundle bundle;
            this.b.a((Context)this.b.b(), shareContent, Mode.d);
            vf vf2 = this.b.d();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent)shareContent;
                wy.c(shareLinkContent);
                bundle = xa.b(shareLinkContent);
            } else {
                bundle = xa.a((ShareFeedContent)shareContent);
            }
            vk.a(vf2, "feed", bundle);
            return vf2;
        }

        public boolean a(ShareContent shareContent, boolean bl2) {
            if (shareContent instanceof ShareLinkContent || shareContent instanceof ShareFeedContent) {
                return true;
            }
            return false;
        }
    }

    class b
    extends vl<ShareContent, wq.a> {
        final /* synthetic */ ShareDialog b;

        private b(ShareDialog shareDialog) {
            this.b = shareDialog;
            super((vl)shareDialog);
        }

        /* synthetic */ b(ShareDialog shareDialog, com.facebook.share.widget.ShareDialog$1 var2_2) {
            super(shareDialog);
        }

        public Object a() {
            return Mode.b;
        }

        public vf a(final ShareContent shareContent) {
            this.b.a((Context)this.b.b(), shareContent, Mode.b);
            wy.b(shareContent);
            final vf vf2 = this.b.d();
            vk.a(vf2, new vk.a(this.b.e()){
                final /* synthetic */ boolean c;

                @Override
                public Bundle a() {
                    return wv.a(vf2.c(), shareContent, this.c);
                }

                @Override
                public Bundle b() {
                    return wr.a(vf2.c(), shareContent, this.c);
                }
            }, ShareDialog.g(shareContent.getClass()));
            return vf2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean a(ShareContent shareContent, boolean bl2) {
            if (shareContent == null) {
                return false;
            }
            boolean bl3 = true;
            if (!bl2) {
                if (shareContent.l() != null) {
                    bl3 = vk.a(ShareDialogFeature.e);
                }
                if (shareContent instanceof ShareLinkContent && !we.a(((ShareLinkContent)shareContent).d())) {
                    bl3 &= vk.a(ShareDialogFeature.f);
                }
                if (!bl3) return false;
            }
            if (!ShareDialog.e(shareContent.getClass())) return false;
            return true;
        }

    }

    class c
    extends vl<ShareContent, wq.a> {
        final /* synthetic */ ShareDialog b;

        private c(ShareDialog shareDialog) {
            this.b = shareDialog;
            super((vl)shareDialog);
        }

        /* synthetic */ c(ShareDialog shareDialog,  var2_2) {
            super(shareDialog);
        }

        private String b(ShareContent shareContent) {
            if (shareContent instanceof ShareLinkContent) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }

        public Object a() {
            return Mode.c;
        }

        /*
         * Enabled aggressive block sorting
         */
        public vf a(ShareContent shareContent) {
            this.b.a((Context)this.b.b(), shareContent, Mode.c);
            vf vf2 = this.b.d();
            wy.c(shareContent);
            Bundle bundle = shareContent instanceof ShareLinkContent ? xa.a((ShareLinkContent)shareContent) : xa.a((ShareOpenGraphContent)shareContent);
            vk.a(vf2, super.b(shareContent), bundle);
            return vf2;
        }

        public boolean a(ShareContent shareContent, boolean bl2) {
            if (shareContent != null && ShareDialog.f(shareContent.getClass())) {
                return true;
            }
            return false;
        }
    }

}

