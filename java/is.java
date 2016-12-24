/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class is {
    private static qf<String, oh> a(final View view, final View view2, final Context context, final int n2, final ImageView imageView) {
        return new qf<String, oh>(){

            public boolean a(Exception exception, String string2, qy<oh> qy2, boolean bl2) {
                jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl.a());
                new Handler(context.getMainLooper()).post(new Runnable(){

                    public void run() {
                        is.b(n2, view, view2);
                        view2.setVisibility(0);
                    }
                });
                return false;
            }

            public boolean a(oh oh2, String string2, qy<oh> qy2, boolean bl2, boolean bl3) {
                jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl.a());
                new Handler(context.getMainLooper()).post(new Runnable(){

                    public void run() {
                        is.b(n2, view, view2);
                        imageView.setBackground(null);
                    }
                });
                return false;
            }

            @Override
            public /* synthetic */ boolean onException(Exception exception, Object object, qy qy2, boolean bl2) {
                return this.a(exception, (String)object, qy2, bl2);
            }

            @Override
            public /* synthetic */ boolean onResourceReady(Object object, Object object2, qy qy2, boolean bl2, boolean bl3) {
                return this.a((oh)((Object)object), (String)object2, qy2, bl2, bl3);
            }

        };
    }

    public static void a(View view, View view2, Context context, int n2, int n3, String string2, ImageView imageView, View view3, int n4, boolean bl2) {
        if (bl2) {
            jt<String> jt2 = jx.b(GossipApplication.a().getApplicationContext()).a(new a()).a(string2).d();
            kr[] arrkr = new kr[]{new RoundedCornersTransformation(context, jb.a(10, context), 0)};
            jt2.a(arrkr).a(is.b(view, view2, context, n2, n3, string2, imageView, view3, n4, bl2)).a((String)DiskCacheStrategy.c).a(imageView);
            return;
        }
        jx.b(GossipApplication.a().getApplicationContext()).a(new a()).a(string2).d().a(is.b(view, view2, context, n2, n3, string2, imageView, view3, n4, bl2)).a((String)DiskCacheStrategy.c).a(imageView);
    }

    private static OkHttpClient b(final View view, final View view2, final Context context, final int n2, final int n3) {
        final ij.a a2 = new ij.a(){

            @Override
            public void a(final long l2, final long l3, boolean bl2) {
                Handler handler = new Handler(context.getMainLooper());
                if (!bl2) {
                    handler.post(new Runnable(){

                        public void run() {
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
                            layoutParams.width = n2;
                            layoutParams.height = (int)((long)jb.a(n3, context) * l2 / l3);
                            view.setVisibility(0);
                            view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                        }
                    });
                    return;
                }
                handler.post(new Runnable(){

                    public void run() {
                        is.b(n2, view, view2);
                    }
                });
            }

        };
        return new OkHttpClient.Builder().addInterceptor(new Interceptor(){

            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response.newBuilder().body(new ij(response.body(), a2)).build();
            }
        }).build();
    }

    private static qf<String, oh> b(final View view, final View view2, final Context context, final int n2, final int n3, final String string2, final ImageView imageView, final View view3, final int n4, final boolean bl2) {
        return new qf<String, oh>(){

            public boolean a(Exception exception, String string22, qy<oh> qy2, boolean bl22) {
                new Handler(context.getMainLooper()).post(new Runnable(){

                    public void run() {
                        if (view3 != null && n4 == 1 && AppState.config.getInt("android_ wait_for_play") == 1) {
                            view3.setVisibility(0);
                            view3.setOnClickListener(new View.OnClickListener(){

                                public void onClick(View view) {
                                    view3.setVisibility(8);
                                    view2.setVisibility(0);
                                    jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl.a(is.b(view, view2, context, n2, n3)));
                                    if (bl2) {
                                        is.d(string2, view, view2, context, n2, imageView);
                                        return;
                                    }
                                    is.c(string2, view, view2, context, n2, imageView);
                                }
                            });
                            return;
                        }
                        view2.setVisibility(0);
                        jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl.a(is.b(view, view2, context, n2, n3)));
                        if (bl2) {
                            is.d(string2, view, view2, context, n2, imageView);
                            return;
                        }
                        is.c(string2, view, view2, context, n2, imageView);
                    }

                });
                return false;
            }

            public boolean a(oh oh2, String string22, qy<oh> qy2, boolean bl22, boolean bl3) {
                jx.a(GossipApplication.a().getApplicationContext()).a(mj.class, InputStream.class, new kl.a());
                new Handler(context.getMainLooper()).post(new Runnable(){

                    public void run() {
                        view2.setVisibility(8);
                        if (view3 != null) {
                            view3.setVisibility(8);
                        }
                        imageView.setBackground(null);
                    }
                });
                return false;
            }

            @Override
            public /* synthetic */ boolean onException(Exception exception, Object object, qy qy2, boolean bl22) {
                return this.a(exception, (String)object, qy2, bl22);
            }

            @Override
            public /* synthetic */ boolean onResourceReady(Object object, Object object2, qy qy2, boolean bl22, boolean bl3) {
                return this.a((oh)((Object)object), (String)object2, qy2, bl22, bl3);
            }

        };
    }

    private static void b(int n2, View view, View view2) {
        view2.setVisibility(8);
        view.setVisibility(8);
    }

    private static void c(String string2, View view, View view2, Context context, int n2, ImageView imageView) {
        jx.b(GossipApplication.a().getApplicationContext()).a(string2).a(is.a(view, view2, context, n2, imageView)).a((String)DiskCacheStrategy.c).a(imageView);
    }

    private static void d(String string2, View view, View view2, Context context, int n2, ImageView imageView) {
        ju<String> ju2 = jx.b(GossipApplication.a().getApplicationContext()).a(string2);
        kr[] arrkr = new kr[]{new RoundedCornersTransformation(context, jb.a(10, context), 0)};
        ju2.a(arrkr).a(is.a(view, view2, context, n2, imageView)).a((String)DiskCacheStrategy.c).a(imageView);
    }

    static class a
    implements ng<String> {
        a() {
        }

        @Override
        public ku<InputStream> a(final String string2, int n2, int n3) {
            return new ku<InputStream>(){

                public InputStream a(Priority priority) throws Exception {
                    throw new IOException("Forced Glide network failure");
                }

                @Override
                public void a() {
                }

                @Override
                public /* synthetic */ Object b(Priority priority) throws Exception {
                    return this.a(priority);
                }

                @Override
                public String b() {
                    return string2;
                }

                @Override
                public void c() {
                }
            };
        }

    }

}

