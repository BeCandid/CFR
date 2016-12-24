/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Pair
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.UUID
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class wz {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Pair<String, String> a(String string2) {
        String string3;
        String string4;
        int n2 = string2.indexOf(58);
        if (n2 != -1 && string2.length() > n2 + 1) {
            string4 = string2.substring(0, n2);
            string3 = string2.substring(n2 + 1);
            do {
                return new Pair((Object)string4, (Object)string3);
                break;
            } while (true);
        }
        string3 = string2;
        string4 = null;
        return new Pair((Object)string4, (Object)string3);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static LikeView.ObjectType a(LikeView.ObjectType objectType, LikeView.ObjectType objectType2) {
        if (objectType == objectType2) {
            return objectType;
        }
        if (objectType == LikeView.ObjectType.a) {
            return objectType2;
        }
        if (objectType2 == LikeView.ObjectType.a) return objectType;
        return null;
    }

    public static String a(Bundle bundle) {
        if (bundle.containsKey("completionGesture")) {
            return bundle.getString("completionGesture");
        }
        return bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
    }

    public static String a(ShareVideoContent shareVideoContent, UUID uUID) {
        if (shareVideoContent == null || shareVideoContent.d() == null) {
            return null;
        }
        vy.a a2 = vy.a(uUID, shareVideoContent.d().c());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((Object)a2);
        vy.a(arrayList);
        return a2.a();
    }

    public static List<Bundle> a(ShareMediaContent shareMediaContent, final UUID uUID) {
        List<ShareMedia> list;
        if (shareMediaContent == null || (list = shareMediaContent.a()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List list2 = we.a(list, new we.d<ShareMedia, Bundle>((List)arrayList){
            final /* synthetic */ List b;

            @Override
            public Bundle a(ShareMedia shareMedia) {
                vy.a a2 = wz.b(uUID, shareMedia);
                this.b.add((Object)a2);
                Bundle bundle = new Bundle();
                bundle.putString("type", shareMedia.b().name());
                bundle.putString("uri", a2.a());
                return bundle;
            }
        });
        vy.a(arrayList);
        return list2;
    }

    public static List<String> a(SharePhotoContent sharePhotoContent, final UUID uUID) {
        List<SharePhoto> list;
        if (sharePhotoContent == null || (list = sharePhotoContent.a()) == null) {
            return null;
        }
        List list2 = we.a(list, new we.d<SharePhoto, vy.a>(){

            @Override
            public vy.a a(SharePhoto sharePhoto) {
                return wz.b(uUID, sharePhoto);
            }
        });
        List list3 = we.a(list2, new we.d<vy.a, String>(){

            @Override
            public String a(vy.a a2) {
                return a2.a();
            }
        });
        vy.a(list2);
        return list3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static JSONArray a(JSONArray jSONArray, boolean bl2) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        int n2 = 0;
        while (n2 < jSONArray.length()) {
            Object object = jSONArray.get(n2);
            if (object instanceof JSONArray) {
                object = wz.a((JSONArray)object, bl2);
            } else if (object instanceof JSONObject) {
                object = wz.a((JSONObject)object, bl2);
            }
            jSONArray2.put(object);
            ++n2;
        }
        return jSONArray2;
    }

    public static JSONObject a(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        return ww.a(shareOpenGraphContent.a(), new ww.a(){

            @Override
            public JSONObject a(SharePhoto sharePhoto) {
                Uri uri = sharePhoto.d();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", (Object)uri.toString());
                    return jSONObject;
                }
                catch (JSONException var4_4) {
                    throw new FacebookException("Unable to attach images", (Throwable)var4_4);
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public static JSONObject a(final UUID uUID, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        ShareOpenGraphAction shareOpenGraphAction = shareOpenGraphContent.a();
        final ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = ww.a(shareOpenGraphAction, new ww.a(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public JSONObject a(SharePhoto sharePhoto) {
                vy.a a2 = wz.b(uUID, sharePhoto);
                if (a2 == null) {
                    return null;
                }
                arrayList.add((Object)a2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", (Object)a2.a());
                    if (!sharePhoto.e()) return jSONObject;
                    jSONObject.put("user_generated", true);
                    return jSONObject;
                }
                catch (JSONException var5_4) {
                    throw new FacebookException("Unable to attach images", (Throwable)var5_4);
                }
            }
        });
        vy.a(arrayList);
        if (shareOpenGraphContent.j() != null && we.a(jSONObject.optString("place"))) {
            jSONObject.put("place", (Object)shareOpenGraphContent.j());
        }
        if (shareOpenGraphContent.i() != null) {
            JSONArray jSONArray = jSONObject.optJSONArray("tags");
            HashSet hashSet = jSONArray == null ? new HashSet() : we.b(jSONArray);
            Iterator iterator = shareOpenGraphContent.i().iterator();
            while (iterator.hasNext()) {
                hashSet.add((Object)((String)iterator.next()));
            }
            jSONObject.put("tags", (Object)new ArrayList((Collection)hashSet));
        }
        return jSONObject;
    }

    /*
     * Exception decompiling
     */
    public static JSONObject a(JSONObject var0_1, boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private static vf a(int n2, int n3, Intent intent) {
        UUID uUID = vz.b(intent);
        if (uUID == null) {
            return null;
        }
        return vf.a(uUID, n2);
    }

    public static wx a(final uk<wq.a> uk2) {
        return new wx(uk2){

            @Override
            public void a(vf vf2) {
                wz.b(uk2);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public void a(vf vf2, Bundle bundle) {
                if (bundle == null) return;
                String string2 = wz.a(bundle);
                if (string2 == null || "post".equalsIgnoreCase(string2)) {
                    String string3 = wz.b(bundle);
                    wz.a(uk2, string3);
                    return;
                }
                if ("cancel".equalsIgnoreCase(string2)) {
                    wz.b(uk2);
                    return;
                }
                wz.a(uk2, new FacebookException("UnknownError"));
            }

            @Override
            public void a(vf vf2, FacebookException facebookException) {
                wz.a(uk2, facebookException);
            }
        };
    }

    public static void a(final int n2) {
        CallbackManagerImpl.a(n2, new CallbackManagerImpl.a(){

            @Override
            public boolean a(int n22, Intent intent) {
                return wz.a(n2, n22, intent, wz.a(null));
            }
        });
    }

    public static void a(final int n2, uj uj2, final uk<wq.a> uk2) {
        if (!(uj2 instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl)uj2).b(n2, new CallbackManagerImpl.a(){

            @Override
            public boolean a(int n22, Intent intent) {
                return wz.a(n2, n22, intent, wz.a(uk2));
            }
        });
    }

    private static void a(String string2, String string3) {
        AppEventsLogger appEventsLogger = AppEventsLogger.a(ul.f());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_outcome", string2);
        if (string3 != null) {
            bundle.putString("error_message", string3);
        }
        appEventsLogger.a("fb_share_dialog_result", null, bundle);
    }

    static void a(uk<wq.a> uk2, FacebookException facebookException) {
        wz.a("error", facebookException.getMessage());
        if (uk2 != null) {
            uk2.onError(facebookException);
        }
    }

    static void a(uk<wq.a> uk2, String string2) {
        wz.a("succeeded", null);
        if (uk2 != null) {
            uk2.onSuccess(new wq.a(string2));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(int n2, int n3, Intent intent, wx wx2) {
        boolean bl2 = true;
        vf vf2 = wz.a(n2, n3, intent);
        if (vf2 == null) {
            return false;
        }
        vy.a(vf2.c());
        if (wx2 == null) return bl2;
        FacebookException facebookException = vz.a(vz.g(intent));
        if (facebookException != null) {
            if (facebookException instanceof FacebookOperationCanceledException) {
                wx2.a(vf2);
                return bl2;
            }
            wx2.a(vf2, facebookException);
            return bl2;
        }
        wx2.a(vf2, vz.e(intent));
        return bl2;
    }

    public static String b(Bundle bundle) {
        if (bundle.containsKey("postId")) {
            return bundle.getString("postId");
        }
        if (bundle.containsKey("com.facebook.platform.extra.POST_ID")) {
            return bundle.getString("com.facebook.platform.extra.POST_ID");
        }
        return bundle.getString("post_id");
    }

    /*
     * Enabled aggressive block sorting
     */
    private static vy.a b(UUID uUID, ShareMedia shareMedia) {
        Uri uri;
        Bitmap bitmap;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto)shareMedia;
            bitmap = sharePhoto.c();
            uri = sharePhoto.d();
        } else {
            boolean bl2 = shareMedia instanceof ShareVideo;
            bitmap = null;
            uri = null;
            if (bl2) {
                uri = ((ShareVideo)shareMedia).c();
                bitmap = null;
            }
        }
        if (bitmap != null) {
            return vy.a(uUID, bitmap);
        }
        vy.a a2 = null;
        if (uri == null) return a2;
        return vy.a(uUID, uri);
    }

    static void b(uk<wq.a> uk2) {
        wz.a("cancelled", null);
        if (uk2 != null) {
            uk2.onCancel();
        }
    }

}

