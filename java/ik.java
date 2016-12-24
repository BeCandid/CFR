/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.AssetManager
 *  android.location.Location
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.io.BufferedInputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.CookieHandler
 *  java.net.CookieManager
 *  java.net.CookiePolicy
 *  java.net.CookieStore
 *  java.security.KeyStore
 *  java.security.Principal
 *  java.security.SecureRandom
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateFactory
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  retrofit2.CallAdapter
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 *  retrofit2.Retrofit$Builder
 *  retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
 *  retrofit2.converter.scalars.ScalarsConverterFactory
 *  retrofit2.http.Field
 *  retrofit2.http.FieldMap
 *  retrofit2.http.FormUrlEncoded
 *  retrofit2.http.Multipart
 *  retrofit2.http.POST
 *  retrofit2.http.Part
 *  retrofit2.http.PartMap
 *  rx.exceptions.CompositeException
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.JavaNetCookieJar;
import com.becandid.candid.data.PersistentCookieStore;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.GroupNameCheck;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.models.PostInfoResponse;
import com.facebook.AccessToken;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.security.KeyStore;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSink;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.exceptions.CompositeException;
import rx.schedulers.Schedulers;

public class ik {
    public static CookieStore a;
    private static volatile ik b;
    private Retrofit c;
    private Retrofit d;
    private a e;

    public ik() {
        if (this.c == null) {
            this.m(GossipApplication.d);
        }
        this.e = (a)this.c.create((Class)a.class);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static ik a() {
        if (b != null) return b;
        reference var1 = ik.class;
        // MONITORENTER : ik.class
        if (b == null) {
            b = new ik();
        }
        // MONITOREXIT : var1
        return b;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private SSLSocketFactory i() {
        CertificateFactory certificateFactory;
        BufferedInputStream bufferedInputStream;
        try {
            certificateFactory = CertificateFactory.getInstance((String)"X.509");
            bufferedInputStream = new BufferedInputStream(GossipApplication.a().getAssets().open("AddTrustExternalCARoot.crt"));
        }
        catch (Exception exception) {
            rj.a((Throwable)exception);
            Log.d((String)"SSLSocketFactory", (String)exception.toString());
            return null;
        }
        Certificate certificate = certificateFactory.generateCertificate((InputStream)bufferedInputStream);
        Log.d((String)"CA", (String)((X509Certificate)certificate).getSubjectDN().toString());
        {
            catch (Throwable throwable) {
                bufferedInputStream.close();
                throw throwable;
            }
        }
        bufferedInputStream.close();
        KeyStore keyStore = KeyStore.getInstance((String)KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", certificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sSLContext.getSocketFactory();
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.becandid.candid/1.6.9 ");
        stringBuilder.append("androidver/" + Build.VERSION.RELEASE + " ");
        stringBuilder.append("model/" + Build.MODEL + " ");
        stringBuilder.append("ver_code/184 ");
        stringBuilder.append("make/" + Build.MANUFACTURER);
        return stringBuilder.toString();
    }

    private int k() {
        int n2 = 20;
        if (AppState.config != null) {
            n2 = AppState.config.getInt("android_num_posts_per_feed");
        }
        return n2;
    }

    private void m(String string2) {
        SSLSocketFactory sSLSocketFactory;
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        String string3 = super.j();
        a = PersistentCookieStore.getCookieStore(GossipApplication.a().getApplicationContext());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if ((AppState.config == null || AppState.config.getBoolean("use_limited_ca", true)) && (sSLSocketFactory = super.i()) != null) {
            builder.sslSocketFactory(sSLSocketFactory);
        }
        builder.cookieJar(new JavaNetCookieJar((CookieHandler)new CookieManager(a, CookiePolicy.ACCEPT_ALL)));
        builder.addInterceptor((ik)this.new c(string3));
        builder.addInterceptor((ik)this.new d());
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);
        this.c = new Retrofit.Builder().baseUrl(string2).addCallAdapterFactory((CallAdapter.Factory)RxJavaCallAdapterFactory.create()).addConverterFactory((Converter.Factory)iq.a()).client(builder.build()).build();
    }

    public apl<EmptyClass> a(int n2) {
        return this.e.b(n2);
    }

    public apl<EmptyClass> a(int n2, int n3) {
        return this.e.a(n2, n3).a(new ii("unable to like comment"));
    }

    public apl<NetworkData> a(int n2, String string2) {
        return this.e.d(Integer.toString((int)n2), string2, Integer.toString((int)super.k())).a(new ii("fetch group feed failed"));
    }

    public apl<Group> a(int n2, String string2, String string3, String string4, String string5) {
        return this.e.a(n2, string2, string3, string4, string5).b(new aqc<NetworkData, apl<Group>>(){

            public apl<Group> a(NetworkData networkData) {
                if (networkData != null) {
                    return apl.a(networkData.group);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("update group failed"));
    }

    public apl<NetworkData> a(FacebookInfo facebookInfo) {
        if (facebookInfo.fbToken == null || facebookInfo.fbToken.b() == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"fb_token", (Object)facebookInfo.fbToken.b());
        if (facebookInfo.schoolIds != null && facebookInfo.schoolIds.size() > 0) {
            hashMap.put((Object)"fb_school_ids", (Object)DataUtil.join(facebookInfo.schoolIds));
        }
        if (facebookInfo.jobIds != null && facebookInfo.jobIds.size() > 0) {
            hashMap.put((Object)"fb_job_ids", (Object)DataUtil.join(facebookInfo.jobIds));
        }
        if (facebookInfo.age != null) {
            hashMap.put((Object)"age", (Object)facebookInfo.age);
        }
        return this.e.f((Map<String, String>)hashMap).a(new ii("auto join facebook failed"));
    }

    /*
     * Enabled aggressive block sorting
     */
    public apl<NetworkData> a(FacebookInfo facebookInfo, boolean bl2) {
        HashMap hashMap = new HashMap();
        if (bl2) {
            hashMap.put((Object)"for_you", (Object)"1");
        }
        if (facebookInfo != null && facebookInfo.fbToken != null) {
            hashMap.put((Object)"fb_token", (Object)facebookInfo.fbToken.b());
            if (facebookInfo.jobIds != null && !facebookInfo.jobIds.isEmpty()) {
                hashMap.put((Object)"fb_job_ids", (Object)DataUtil.join(facebookInfo.jobIds));
            }
            if (facebookInfo.schoolIds != null && !facebookInfo.schoolIds.isEmpty()) {
                hashMap.put((Object)"fb_school_ids", (Object)DataUtil.join(facebookInfo.schoolIds));
            }
        }
        if (AppState.location != null) {
            StringBuilder stringBuilder = new StringBuilder().append(AppState.location.getLatitude()).append(",").append(AppState.location.getLongitude()).append("@");
            String string2 = AppState.location.hasAccuracy() ? Float.valueOf((float)AppState.location.getAccuracy()) : "50";
            hashMap.put((Object)"location", (Object)stringBuilder.append((Object)string2).toString());
        }
        return this.e.e((Map<String, String>)hashMap).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to get suggested groups"));
    }

    public apl<EmptyClass> a(Group group) {
        return this.e.d(group.group_id).b(new aqc<NetworkData, apl<EmptyClass>>(){

            public apl<EmptyClass> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(new EmptyClass());
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("skip group failed"));
    }

    public apl<EmptyClass> a(Post post, String string2) {
        if (string2 == null) {
            string2 = "owner";
        }
        return this.e.c(Integer.toString((int)post.post_id), string2).a(new ii("delete post failed"));
    }

    public apl<NetworkData> a(String string2, String string3) {
        return this.e.d(string2, string3).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to verify phone number"));
    }

    public apl<EmptyClass> a(String string2, String string3, String string4) {
        String string5 = "-7";
        if (string3 == null || !string3.equals((Object)"0")) {
            string5 = string3;
        }
        if (string2 == null) {
            return null;
        }
        return this.e.c(string2, string5, string4).a(new ii("invite contacts failed"));
    }

    public apl<List<Post>> a(String string2, String string3, String string4, int n2) {
        String string5 = string2;
        if (string2 == null) {
            string5 = "home";
        }
        HashMap hashMap = new HashMap();
        if ("friends".equals((Object)string2)) {
            hashMap.put((Object)"include_fb", (Object)"1");
            hashMap.put((Object)"include_phone", (Object)"1");
        }
        if (string4 != null && !string4.isEmpty()) {
            hashMap.put((Object)"seen_posts", (Object)string4);
        }
        if (n2 > 0) {
            hashMap.put((Object)"related_posts_post_id", (Object)Integer.toString((int)n2));
        }
        hashMap.put((Object)"include_comments", (Object)"1");
        hashMap.put((Object)"num", (Object)Integer.toString((int)super.k()));
        return this.e.a(string5, string3, (Map<String, String>)hashMap).b(new aqc<NetworkData, apl<List<Post>>>(){

            public apl<List<Post>> a(NetworkData networkData) {
                if (networkData != null) {
                    return apl.a(networkData.posts);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("fetch feed failed"));
    }

    public apl<Group> a(String string2, String string3, String string4, String string5) {
        return this.e.a(string2, string3, string4, string5).b(new aqc<NetworkData, apl<Group>>(){

            public apl<Group> a(NetworkData networkData) {
                if (networkData != null) {
                    return apl.a(networkData.group);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("create group failed"));
    }

    public apl<String> a(String string2, Map<String, String> map, RequestBody requestBody) {
        return this.b(string2).a(map, requestBody).b(new aqc<String, apl<String>>(){

            public apl<String> a(String string2) {
                if (string2 != null) {
                    return apl.a(string2);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((String)object);
            }
        }).a(new ii("error uploading image to s3"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public apl<GroupNameCheck> a(String string2, boolean bl2) {
        int n2;
        a a2 = this.e;
        if (bl2) {
            n2 = 1;
            do {
                return a2.a(string2, n2).a(new ii("check group name failed"));
                break;
            } while (true);
        }
        n2 = 0;
        return a2.a(string2, n2).a(new ii("check group name failed"));
    }

    public apl<EmptyClass> a(Map<String, String> map) {
        return this.e.p(map).a(new ii("update user info failed"));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public apl<NetworkData> a(boolean bl2) {
        int n2;
        a a2 = this.e;
        if (bl2) {
            n2 = 1;
            do {
                return a2.a(n2).a(new ii("Unable to logout"));
                break;
            } while (true);
        }
        n2 = 0;
        return a2.a(n2).a(new ii("Unable to logout"));
    }

    public void a(String string2) {
        super.m(string2);
        this.e = (a)this.c.create((Class)a.class);
    }

    public apl<NetworkData> b() {
        return this.e.a().b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    AppState.config.setExperimentConfig(networkData.config);
                    AppState.account = networkData.my_info;
                    AppState.tabsOrder = networkData.feed_tab_order;
                    if (AppState.account.unread_activity_count >= 0) {
                        ix.a().a(new in.as(3, AppState.account.unread_activity_count));
                    }
                    if (AppState.account.unread_feed_count >= 0) {
                        ix.a().a(new in.as(0, AppState.account.unread_feed_count));
                    }
                    if (AppState.account.unread_groups_count >= 0) {
                        ix.a().a(new in.as(1, AppState.account.unread_groups_count));
                    }
                    if (networkData.groups != null) {
                        AppState.groups = new ArrayList(networkData.groups);
                    }
                    if (networkData.activity_settings != null) {
                        AppState.notificationSettings = new ArrayList(networkData.activity_settings);
                    }
                    if (networkData.feed_colors != null) {
                        AppState.feedColors = networkData.feed_colors;
                    }
                    if (networkData.group_tags != null) {
                        AppState.groupTags = networkData.group_tags;
                    }
                    AppState.needAge = networkData.my_info.need_age;
                    AppState.needOnboarding = networkData.my_info.need_onboarding;
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to get your info"));
    }

    public apl<NetworkData> b(int n2) {
        return this.e.c(n2).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    if (AppState.groups == null) {
                        AppState.groups = new ArrayList();
                    }
                    AppState.groups.add((Object)networkData.group);
                    ix.a().a(new in.m(networkData.group));
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("join group failed"));
    }

    public apl<NetworkData> b(int n2, String string2) {
        return this.e.a(n2, string2).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to report comment"));
    }

    public apl<EmptyClass> b(Post post, String string2) {
        return this.e.a(Integer.toString((int)post.post_id), string2).a(new ii("report post failed"));
    }

    public apl<NetworkData> b(String string2, String string3) {
        return this.e.b(string2, string3).a(new ii("Get activity failed"));
    }

    public apl<Post> b(String string2, String string3, String string4) {
        return this.e.b(string2, string3, string4).b(new aqc<NetworkData, apl<Post>>(){

            public apl<Post> a(NetworkData networkData) {
                if (networkData != null) {
                    return apl.a(networkData.post);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("like post failed"));
    }

    public apl<ain> b(Map<String, String> map) {
        return this.e.c(map).a(new ii("new user hash failed"));
    }

    public b b(String string2) {
        if (this.d == null || !this.d.baseUrl().host().equals((Object)"s3.amazonaws.com")) {
            this.d = new Retrofit.Builder().baseUrl("https://" + "s3.amazonaws.com" + "/").addConverterFactory((Converter.Factory)ScalarsConverterFactory.create()).addCallAdapterFactory((CallAdapter.Factory)RxJavaCallAdapterFactory.create()).build();
        }
        return (b)this.d.create((Class)b.class);
    }

    public apl<ain> c() {
        return this.e.b().a(new ii("unable to get splash page"));
    }

    public apl<NetworkData> c(int n2) {
        return this.e.e(n2).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("leave group failed"));
    }

    public apl<EmptyClass> c(String string2) {
        return this.e.a(string2, "android", "production").a(new ii("send GCM Token failed"));
    }

    public apl<NetworkData.UploadResponse> c(String string2, String string3) {
        final File file = new File(string3);
        return this.e.e("image/jpg", "edit_account").b(new aqc<NetworkData.UploadResponse, apl<NetworkData.UploadResponse>>(){

            public apl<NetworkData.UploadResponse> a(final NetworkData.UploadResponse uploadResponse) {
                if (uploadResponse != null && uploadResponse.success) {
                    RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
                    ik.this.a((String)uploadResponse.s3_data.get((Object)"bucket"), uploadResponse.s3_data, requestBody).b(Schedulers.io()).a(apv.a()).b(new apr<String>(){

                        public void a(String string2) {
                            ix.a().a(new in.ak(uploadResponse, true, null));
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            rj.a(throwable);
                            if (throwable instanceof CompositeException) {
                                Iterator iterator = ((CompositeException)throwable).a().iterator();
                                while (iterator.hasNext()) {
                                    Log.d((String)"ERRS", (String)((Throwable)iterator.next()).toString());
                                }
                            }
                            ix.a().a(new in.ak(uploadResponse, false, null));
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((String)object);
                        }
                    });
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData.UploadResponse)object);
            }

        });
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public apl<NetworkData> c(String string2, String string3, String string4) {
        int n2;
        if (string2 != null) {
            n2 = 0;
            do {
                return this.e.b(string2, string3, string4, Integer.toString((int)n2)).a(new ii("unable to add nickname to a thread"));
                break;
            } while (true);
        }
        n2 = 1;
        return this.e.b(string2, string3, string4, Integer.toString((int)n2)).a(new ii("unable to add nickname to a thread"));
    }

    public apl<ain> c(Map<String, String> map) {
        return this.e.d(map).a(new ii("sync friends failed"));
    }

    public apl<NetworkData> createPost(Post post, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"group_id", (Object)String.valueOf((int)post.group_id));
        if (post.caption != null) {
            hashMap.put((Object)"caption", (Object)post.caption);
        }
        if (post.mentioned_groups_info != null) {
            hashMap.put((Object)"mentioned_group_ids", (Object)post.mentioned_groups_info);
        }
        if (post.source_url != null) {
            hashMap.put((Object)"source_url", (Object)post.source_url);
            hashMap.put((Object)"width", (Object)String.valueOf((int)post.width));
            hashMap.put((Object)"height", (Object)String.valueOf((int)post.height));
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        if (hashMap.containsKey((Object)"source_url") && hashMap.get((Object)"source_url") == null) {
            hashMap.put((Object)"source_url", (Object)"");
        }
        if (post.friends_disabled == 1) {
            hashMap.put((Object)"friends_disabled", (Object)"1");
        }
        return this.e.a((Map<String, String>)hashMap).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null) {
                    if (networkData.group != null) {
                        AppState.groups.add((Object)networkData.group);
                        ix.a().a(new in.m(networkData.group));
                    }
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("create post failed"));
    }

    public apl<NetworkData> d() {
        HashMap hashMap = new HashMap();
        if (AppState.fbInfo != null && AppState.fbInfo.fbToken != null) {
            hashMap.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
            hashMap.put((Object)"fb_token", (Object)AppState.fbInfo.fbToken.b());
        }
        return this.e.v((Map<String, String>)hashMap).a(new ii("unable to check for an existing facebook account"));
    }

    public apl<NetworkData> d(int n2) {
        return this.e.f(n2).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    if (networkData.debug) {
                        AppState.internal = networkData.debug;
                    }
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to get user profile"));
    }

    public apl<Map<String, String>> d(String string2) {
        return this.e.a(string2).b(new aqc<PostInfoResponse, apl<Map<String, String>>>(){

            public apl<Map<String, String>> a(PostInfoResponse postInfoResponse) {
                if (postInfoResponse != null) {
                    return apl.a(postInfoResponse.data);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((PostInfoResponse)object);
            }
        }).a(new ii("Unable to get post info"));
    }

    public apl<NetworkData> d(String string2, String string3) {
        return this.e.f(string2, string3).a(new ii("unable to mark nickname alert shown"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public apl<Post> d(Map<String, String> map) {
        Context context = GossipApplication.a().getApplicationContext();
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo((String)context.getPackageName(), (int)0).versionCode <= 68) return this.e.b(map).b(new aqc<NetworkData, apl<Post>>(){

                public apl<Post> a(NetworkData networkData) {
                    if (networkData != null) {
                        return apl.a(networkData.post);
                    }
                    return null;
                }

                @Override
                public /* synthetic */ Object call(Object object) {
                    return this.a((NetworkData)object);
                }
            }).a(new ii("Get post comments failed"));
            map.put((Object)"threaded", (Object)Integer.toString((int)1));
        }
        catch (PackageManager.NameNotFoundException var4_4) {
            rj.a((Throwable)var4_4);
            return this.e.b(map).b(new ).a(new ii("Get post comments failed"));
        }
        return this.e.b(map).b(new ).a(new ii("Get post comments failed"));
    }

    public apl<NetworkData> e() {
        HashMap hashMap = new HashMap();
        if (AppState.fbInfo != null && AppState.fbInfo.fbToken != null) {
            hashMap.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
            hashMap.put((Object)"fb_token", (Object)AppState.fbInfo.fbToken.b());
        }
        if (AppState.contactsInfo != null && AppState.contactsInfo.phone_number != null) {
            hashMap.put((Object)"phone_number", (Object)AppState.contactsInfo.phone_number);
            hashMap.put((Object)"otp_code", (Object)AppState.contactsInfo.otpCode);
            if (AppState.contactsInfo.contacts != null && !AppState.contactsInfo.contacts.isEmpty()) {
                hashMap.put((Object)"phone_contacts", (Object)DataUtil.join(AppState.contactsInfo.contacts));
            }
        }
        if (AppState.referralId != null) {
            hashMap.put((Object)"referral_id", (Object)AppState.referralId);
        }
        return this.e.w((Map<String, String>)hashMap).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    if (networkData.my_info != null) {
                        AppState.account = networkData.my_info;
                        AppState.needAge = networkData.my_info.need_age;
                        AppState.age = networkData.my_info.age;
                    }
                    if (networkData.group_tags != null) {
                        AppState.groupTags = networkData.group_tags;
                    }
                    if (networkData.activity_settings != null) {
                        AppState.notificationSettings = new ArrayList(networkData.activity_settings);
                    }
                    if (networkData.config != null) {
                        AppState.setConfig(networkData.config);
                    }
                    if (networkData.referral_post_id != 0) {
                        AppState.referralPostId = networkData.referral_post_id;
                    }
                }
                return apl.a(networkData);
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to get or create a user"));
    }

    public apl<EmptyClass> e(int n2) {
        return this.e.g(n2).a(new ii("unable to invite friends to group"));
    }

    public apl<EmptyClass> e(String string2) {
        return this.e.b(string2);
    }

    public apl<EmptyClass> e(Map<String, String> map) {
        return this.e.g(map).b(new aqc<NetworkData, apl<EmptyClass>>(){

            public apl<EmptyClass> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(new EmptyClass());
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("update activity settings failed"));
    }

    /*
     * Enabled aggressive block sorting
     */
    public apl<NetworkData> f() {
        HashMap hashMap = new HashMap();
        if (AppState.location != null) {
            StringBuilder stringBuilder = new StringBuilder().append(AppState.location.getLatitude()).append(",").append(AppState.location.getLongitude()).append("@");
            String string2 = AppState.location.hasAccuracy() ? Float.valueOf((float)AppState.location.getAccuracy()) : "50";
            hashMap.put((Object)"location", (Object)stringBuilder.append((Object)string2).toString());
        }
        if (AppState.fbInfo != null && AppState.fbInfo.age != null) {
            hashMap.put((Object)"age", (Object)AppState.fbInfo.age);
        } else if (AppState.age != null) {
            hashMap.put((Object)"age", (Object)AppState.age);
        }
        if (AppState.activeTags != null && !AppState.activeTags.isEmpty()) {
            hashMap.put((Object)"tags", (Object)DataUtil.join(AppState.activeTags));
        }
        if (AppState.fbInfo != null) {
            if (AppState.fbInfo.jobIds != null && !AppState.fbInfo.jobIds.isEmpty()) {
                hashMap.put((Object)"fb_job_ids", (Object)DataUtil.join(AppState.fbInfo.jobIds));
            }
            if (AppState.fbInfo.schoolIds != null && !AppState.fbInfo.schoolIds.isEmpty()) {
                hashMap.put((Object)"fb_school_ids", (Object)DataUtil.join(AppState.fbInfo.schoolIds));
            }
            if (AppState.fbInfo.friendIds != null && !AppState.fbInfo.friendIds.isEmpty()) {
                hashMap.put((Object)"fb_friends", (Object)DataUtil.join(AppState.fbInfo.friendIds));
            }
        }
        return this.e.x((Map<String, String>)hashMap).a(new ii("unable to get groups for user signup"));
    }

    public apl<NetworkData> f(int n2) {
        return this.e.h(n2).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to delete group"));
    }

    public apl<EmptyClass> f(String string2) {
        return this.e.c(string2);
    }

    public apl<NetworkData> f(Map<String, String> map) {
        return this.e.h(map).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to delete comment"));
    }

    public apl<NetworkData> g() {
        return this.e.d().a(new ii("unable to mark messages visit"));
    }

    public apl<NetworkData> g(int n2) {
        return this.e.b(n2, Integer.toString((int)super.k())).a(new ii("unable to get history page"));
    }

    public apl<EmptyClass> g(String string2) {
        return this.e.d(string2).a(new ii("unable to skip upsell"));
    }

    public apl<NetworkData> g(Map<String, String> map) {
        return this.e.i(map).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to report comment"));
    }

    public apl<NetworkData> h() {
        return this.e.c().a(new ii("unable to get unread message count"));
    }

    public apl<NetworkData> h(int n2) {
        return this.e.c(n2, Integer.toString((int)super.k())).a(new ii("unable to get posts page"));
    }

    public apl<NetworkData> h(String string2) {
        return this.e.e(string2).a(new ii("unable to generate otp code"));
    }

    public apl<NetworkData> h(Map<String, String> map) {
        return this.e.j(map).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii("unable to add comment"));
    }

    public apl<NetworkData> i(int n2) {
        return this.e.i(n2).a(new ii("unable to get groups page"));
    }

    public apl<ain> i(String string2) {
        return this.e.f(string2).a(new ii("unable to search for images"));
    }

    public apl<NetworkData> i(Map<String, String> map) {
        return this.e.k(map).b(new aqc<NetworkData, apl<NetworkData>>(){

            public apl<NetworkData> a(NetworkData networkData) {
                if (networkData != null && networkData.success) {
                    return apl.a(networkData);
                }
                return null;
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((NetworkData)object);
            }
        }).a(new ii(""));
    }

    public apl<EmptyClass> j(String string2) {
        return this.e.g(string2).a(new ii("unable to mark notification as clicked"));
    }

    public apl<ain> j(Map<String, String> map) {
        return this.e.l(map).a(new ii("unable to get search results"));
    }

    public apl<EmptyClass> k(String string2) {
        return this.e.h(string2).a(new ii("unable to set server message_sent seen"));
    }

    public apl<ain> k(Map<String, String> map) {
        return this.e.m(map).a(new ii("unable to get search results"));
    }

    public apl<NetworkData> l(String string2) {
        return this.e.i(string2).a(new ii("unable to search user threads"));
    }

    public apl<NetworkData> l(Map<String, String> map) {
        return this.e.n(map).a(new ii("unable to edit post"));
    }

    public apl<NetworkData> m(Map<String, String> map) {
        return this.e.o(map).a(new ii("unable to edit comment"));
    }

    public apl<NetworkData> n(Map<String, String> map) {
        return this.e.t(map).a(new ii("unable to read message_sent thread"));
    }

    public apl<NetworkData> o(Map<String, String> map) {
        return this.e.r(map).a(new ii("unable to add message_sent"));
    }

    public apl<NetworkData> p(Map<String, String> map) {
        return this.e.s(map).a(new ii("unable to get threads and requests"));
    }

    public apl<NetworkData> q(Map<String, String> map) {
        return this.e.y(map).a(new ii("unable to report message"));
    }

    public apl<NetworkData> r(Map<String, String> map) {
        return this.e.z(map).a(new ii("unable to set message settings"));
    }

    public apl<NetworkData> s(Map<String, String> map) {
        return this.e.A(map).a(new ii("unable to block user"));
    }

    public apl<NetworkData> t(Map<String, String> map) {
        return this.e.B(map).a(new ii("unable to unblock user"));
    }

    public apl<NetworkData> u(Map<String, String> map) {
        return this.e.C(map).a(new ii("unable to delete thread"));
    }

    public apl<NetworkData> v(Map<String, String> map) {
        return this.e.q(map).a(new ii("unable to handle message request"));
    }

    public apl<NetworkData> w(Map<String, String> map) {
        return this.e.u(map).a(new ii("unable to mark thread read"));
    }

    static interface a {
        @FormUrlEncoded
        @POST(value="api/block_thread")
        public apl<NetworkData> A(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/unblock_thread")
        public apl<NetworkData> B(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/delete_thread")
        public apl<NetworkData> C(@FieldMap Map<String, String> var1);

        @POST(value="api/get_my_info")
        public apl<NetworkData> a();

        @FormUrlEncoded
        @POST(value="api/logout")
        public apl<NetworkData> a(@Field(value="forever") int var1);

        @FormUrlEncoded
        @POST(value="api/like_comment")
        public apl<EmptyClass> a(@Field(value="comment_id") int var1, @Field(value="value") int var2);

        @FormUrlEncoded
        @POST(value="api/report_group")
        public apl<NetworkData> a(@Field(value="group_id") int var1, @Field(value="reason") String var2);

        @FormUrlEncoded
        @POST(value="api/update_group")
        public apl<NetworkData> a(@Field(value="group_id") int var1, @Field(value="group_name") String var2, @Field(value="about") String var3, @Field(value="tags") String var4, @Field(value="source_url") String var5);

        @FormUrlEncoded
        @POST(value="api/get_post_info")
        public apl<PostInfoResponse> a(@Field(value="url") String var1);

        @FormUrlEncoded
        @POST(value="api/check_group_name")
        public apl<GroupNameCheck> a(@Field(value="group_name") String var1, @Field(value="will_use_duplicate") int var2);

        @FormUrlEncoded
        @POST(value="api/report_post")
        public apl<EmptyClass> a(@Field(value="post_id") String var1, @Field(value="reason") String var2);

        @FormUrlEncoded
        @POST(value="api/update_device_token")
        public apl<EmptyClass> a(@Field(value="device_token") String var1, @Field(value="platform_type") String var2, @Field(value="version_type") String var3);

        @FormUrlEncoded
        @POST(value="api/create_group")
        public apl<NetworkData> a(@Field(value="group_name") String var1, @Field(value="about") String var2, @Field(value="tags") String var3, @Field(value="source_url") String var4);

        @FormUrlEncoded
        @POST(value="api/feed")
        public apl<NetworkData> a(@Field(value="feed_type") String var1, @Field(value="min_post_id") String var2, @FieldMap Map<String, String> var3);

        @FormUrlEncoded
        @POST(value="api/add_post")
        public apl<NetworkData> a(@FieldMap Map<String, String> var1);

        @POST(value="api/splash_page")
        public apl<ain> b();

        @FormUrlEncoded
        @POST(value="api/mark_read_activity")
        public apl<EmptyClass> b(@Field(value="activity_id") int var1);

        @FormUrlEncoded
        @POST(value="api/all_interacted_posts")
        public apl<NetworkData> b(@Field(value="page") int var1, @Field(value="num") String var2);

        @FormUrlEncoded
        @POST(value="api/mute_post")
        public apl<EmptyClass> b(@Field(value="post_id") String var1);

        @FormUrlEncoded
        @POST(value="api/get_activity")
        public apl<NetworkData> b(@Field(value="mark_read") String var1, @Field(value="last_activity_id") String var2);

        @FormUrlEncoded
        @POST(value="api/like_post")
        public apl<NetworkData> b(@Field(value="post_id") String var1, @Field(value="value") String var2, @Field(value="is_rumor") String var3);

        @FormUrlEncoded
        @POST(value="api/add_nickname")
        public apl<NetworkData> b(@Field(value="nickname") String var1, @Field(value="post_id") String var2, @Field(value="target_post_name") String var3, @Field(value="ignore") String var4);

        @FormUrlEncoded
        @POST(value="api/post_comments")
        public apl<NetworkData> b(@FieldMap Map<String, String> var1);

        @POST(value="api/get_threads_requests_count")
        public apl<NetworkData> c();

        @FormUrlEncoded
        @POST(value="api/join_group")
        public apl<NetworkData> c(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/my_posts_on_scroll")
        public apl<NetworkData> c(@Field(value="page") int var1, @Field(value="num") String var2);

        @FormUrlEncoded
        @POST(value="api/unmute_post")
        public apl<EmptyClass> c(@Field(value="post_id") String var1);

        @FormUrlEncoded
        @POST(value="api/delete_post")
        public apl<EmptyClass> c(@Field(value="post_id") String var1, @Field(value="reason") String var2);

        @FormUrlEncoded
        @POST(value="api/invite_contacts")
        public apl<EmptyClass> c(@Field(value="contacts_json") String var1, @Field(value="upsell_id") String var2, @Field(value="name") String var3);

        @FormUrlEncoded
        @POST(value="api/new_user_hash")
        public apl<ain> c(@FieldMap Map<String, String> var1);

        @POST(value="api/mark_messages_visit")
        public apl<NetworkData> d();

        @FormUrlEncoded
        @POST(value="api/skip_group")
        public apl<NetworkData> d(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/skip_upsell")
        public apl<EmptyClass> d(@Field(value="upsell_id") String var1);

        @FormUrlEncoded
        @POST(value="api/verify_phone_number")
        public apl<NetworkData> d(@Field(value="otp_code") String var1, @Field(value="phone_number") String var2);

        @FormUrlEncoded
        @POST(value="api/group_feed")
        public apl<NetworkData> d(@Field(value="group_id") String var1, @Field(value="min_post_id") String var2, @Field(value="num") String var3);

        @FormUrlEncoded
        @POST(value="api/sync_friends")
        public apl<ain> d(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/leave_group")
        public apl<NetworkData> e(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/generate_otp")
        public apl<NetworkData> e(@Field(value="phone_number") String var1);

        @FormUrlEncoded
        @POST(value="api/start_upload")
        public apl<NetworkData.UploadResponse> e(@Field(value="content_type") String var1, @Field(value="form_id") String var2);

        @FormUrlEncoded
        @POST(value="api/suggested_groups")
        public apl<NetworkData> e(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/profile")
        public apl<NetworkData> f(@Field(value="user_id") int var1);

        @FormUrlEncoded
        @POST(value="api/search_images")
        public apl<ain> f(@Field(value="query") String var1);

        @FormUrlEncoded
        @POST(value="api/mark_nickname_alert_shown")
        public apl<NetworkData> f(@Field(value="post_id") String var1, @Field(value="target_post_name") String var2);

        @FormUrlEncoded
        @POST(value="api/auto_join_fb_groups")
        public apl<NetworkData> f(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/invite_group_friends")
        public apl<EmptyClass> g(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/click_notification")
        public apl<EmptyClass> g(@Field(value="notification_id") String var1);

        @FormUrlEncoded
        @POST(value="api/update_activity_settings")
        public apl<NetworkData> g(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/delete_group")
        public apl<NetworkData> h(@Field(value="group_id") int var1);

        @FormUrlEncoded
        @POST(value="api/server_message_seen")
        public apl<EmptyClass> h(@Field(value="message_type") String var1);

        @FormUrlEncoded
        @POST(value="api/delete_comment")
        public apl<NetworkData> h(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/my_groups_on_scroll")
        public apl<NetworkData> i(@Field(value="page") int var1);

        @FormUrlEncoded
        @POST(value="api/search_user_threads")
        public apl<NetworkData> i(@Field(value="search_string") String var1);

        @FormUrlEncoded
        @POST(value="api/report_comment")
        public apl<NetworkData> i(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/add_comment")
        public apl<NetworkData> j(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/update_user_tags")
        public apl<NetworkData> k(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/search_groups")
        public apl<ain> l(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/search_links")
        public apl<ain> m(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/edit_post")
        public apl<NetworkData> n(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/edit_comment")
        public apl<NetworkData> o(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/update_user_info")
        public apl<EmptyClass> p(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/handle_message_request")
        public apl<NetworkData> q(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/add_message")
        public apl<NetworkData> r(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/get_threads_and_requests")
        public apl<NetworkData> s(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/get_thread")
        public apl<NetworkData> t(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/read_thread")
        public apl<NetworkData> u(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/login_fb_user")
        public apl<NetworkData> v(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/signupprocess")
        public apl<NetworkData> w(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/get_location_tags_groups")
        public apl<NetworkData> x(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/report_message")
        public apl<NetworkData> y(@FieldMap Map<String, String> var1);

        @FormUrlEncoded
        @POST(value="api/set_message_settings")
        public apl<NetworkData> z(@FieldMap Map<String, String> var1);
    }

    static interface b {
        @Multipart
        @POST(value="/likes.images")
        public apl<String> a(@PartMap Map<String, String> var1, @Part(value="File") RequestBody var2);
    }

    class c
    implements Interceptor {
        private final String b;

        public c(String string2) {
            this.b = string2;
        }

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("User-Agent", this.b).build());
        }
    }

    class d
    implements Interceptor {
        private ja b;

        public d() {
            this.b = new ja();
        }

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            Buffer buffer = new Buffer();
            request.body().writeTo(buffer);
            byte[] arrby = this.b.a(buffer.buffer().readUtf8());
            buffer.close();
            RequestBody requestBody = RequestBody.create(request.body().contentType(), arrby);
            Response response = chain.proceed(request.newBuilder().header("Candid-Encoded", "1").method(request.method(), requestBody).build());
            byte[] arrby2 = this.b.b(response.body().string());
            ResponseBody responseBody = ResponseBody.create(response.body().contentType(), arrby2);
            return response.newBuilder().body(responseBody).build();
        }
    }

}

