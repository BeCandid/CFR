/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.internal.LikeDialogFeature;
import java.util.ArrayList;
import java.util.List;

public class wt
extends vl<LikeContent, b> {
    private static final int b = CallbackManagerImpl.RequestCodeOffset.d.a();

    public wt(Activity activity) {
        super(activity, b);
    }

    public wt(vq vq2) {
        super(vq2, b);
    }

    private static Bundle b(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.a());
        bundle.putString("object_type", likeContent.b());
        return bundle;
    }

    public static boolean e() {
        return vk.a(wt.h());
    }

    public static boolean f() {
        return vk.b(wt.h());
    }

    private static vj h() {
        return LikeDialogFeature.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void a(CallbackManagerImpl callbackManagerImpl, final uk<b> uk2) {
        final wx wx2 = uk2 == null ? null : new wx(uk2){

            @Override
            public void a(vf vf2, Bundle bundle) {
                uk2.onSuccess(new b(bundle));
            }
        };
        CallbackManagerImpl.a a2 = new CallbackManagerImpl.a(){

            @Override
            public boolean a(int n2, Intent intent) {
                return wz.a(wt.this.a(), n2, intent, wx2);
            }
        };
        callbackManagerImpl.b(this.a(), a2);
    }

    @Override
    protected List<vl<LikeContent, b>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)new a(this, null));
        arrayList.add((Object)new c(this, null));
        return arrayList;
    }

    @Override
    protected vf d() {
        return new vf(this.a());
    }

    class a
    extends vl<LikeContent, b> {
        final /* synthetic */ wt b;

        private a(wt wt2) {
            this.b = wt2;
            super((vl)wt2);
        }

        /* synthetic */ a(wt wt2, wt$1 var2_2) {
            super(wt2);
        }

        public vf a(final LikeContent likeContent) {
            vf vf2 = this.b.d();
            vk.a(vf2, new vk.a(){

                @Override
                public Bundle a() {
                    return wt.b(likeContent);
                }

                @Override
                public Bundle b() {
                    Log.e((String)"LikeDialog", (String)"Attempting to present the Like Dialog with an outdated Facebook app on the device");
                    return new Bundle();
                }
            }, wt.h());
            return vf2;
        }

        public boolean a(LikeContent likeContent, boolean bl2) {
            if (likeContent != null && wt.e()) {
                return true;
            }
            return false;
        }

    }

    public static final class b {
        private final Bundle a;

        public b(Bundle bundle) {
            this.a = bundle;
        }
    }

    class c
    extends vl<LikeContent, b> {
        final /* synthetic */ wt b;

        private c(wt wt2) {
            this.b = wt2;
            super((vl)wt2);
        }

        /* synthetic */ c(wt wt2,  var2_2) {
            super(wt2);
        }

        public vf a(LikeContent likeContent) {
            vf vf2 = this.b.d();
            vk.a(vf2, wt.b(likeContent), wt.h());
            return vf2;
        }

        public boolean a(LikeContent likeContent, boolean bl2) {
            if (likeContent != null && wt.f()) {
                return true;
            }
            return false;
        }
    }

}

