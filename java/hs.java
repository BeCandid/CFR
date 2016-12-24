/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ItemAnimator
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.SimpleItemAnimator
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import java.util.HashSet;
import java.util.List;
import rx.schedulers.Schedulers;

public class hs
extends Fragment
implements hf.a {
    private View a;
    private hf b;
    private String c;
    private aps d;
    private RecyclerView e;
    private SwipeRefreshLayout f;
    private View g;
    private Handler h;
    private final int i = 60000;
    private long j;
    private Runnable k;

    public hs() {
        this.k = new Runnable(){

            public void run() {
                ik.a().a(hs.this.c, null, hs.this.b.b(hs.this.c), 0).b(Schedulers.io()).a(apv.a()).b(new apr<List<Post>>(){

                    public void a(List<Post> list) {
                        for (Post post : list) {
                            List<Integer> list2 = hs.this.b.a(post);
                            if (list2.isEmpty() || AppState.expandedPostIds.contains((Object)post.post_id)) continue;
                            for (Integer n2 : list2) {
                                hs.this.b.a((int)n2, post);
                            }
                        }
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        rj.a(throwable);
                    }

                    @Override
                    public /* synthetic */ void onNext(Object object) {
                        this.a((List)object);
                    }
                });
                hs.this.h.postDelayed(hs.this.k, 60000);
            }

        };
    }

    private aps a(String string2, int n2) {
        if (this.b == null) {
            rj.a((Throwable)new Exception("Feed Adapter is NULL"));
            return null;
        }
        return ik.a().a(string2, null, this.b.b(string2), n2).b(Schedulers.io()).a(apv.a()).b(super.b());
    }

    private void a(in.k k2) {
        try {
            Post post = k2.a;
            this.b.b(post);
            this.e.smoothScrollToPosition(0);
            return;
        }
        catch (Exception var2_3) {
            rj.a((Throwable)var2_3);
            return;
        }
    }

    private apr b() {
        return new apr<List<Post>>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(List<Post> list) {
                if (list == null || list.isEmpty() || list.size() == 1 && !(list.get(0) instanceof Post)) {
                    return;
                }
                Post post = null;
                for (Post post2 : list) {
                    if (post2.related_to_post > 0) {
                        if (post == null) {
                            post2.first_related_post = 1;
                        }
                        post = post2;
                        continue;
                    }
                    if (post == null) continue;
                    post.last_related_post = 1;
                    break;
                }
                hs.this.b.a(list);
                hs.this.b.a(Integer.toString((int)((Post)list.get((int)(-1 + list.size()))).post_id));
            }

            @Override
            public void onCompleted() {
                hs.this.e.scrollToPosition(0);
                hs.this.e.setVisibility(0);
                hs.this.g.setVisibility(8);
                hs.this.f.setRefreshing(false);
            }

            @Override
            public void onError(Throwable throwable) {
                hs.this.g.setVisibility(8);
                hs.this.f.setRefreshing(false);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((List)object);
            }
        };
    }

    public void a() {
        this.h.postDelayed(this.k, 60000);
        if (AppState.account != null && AppState.account.unread_feed_count > 0) {
            this.d = this.a(this.c, 0);
        }
    }

    public void a(int n2) {
        AppState.expandedPostIds.clear();
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(0);
        }
        if (this.d != null) {
            this.d.unsubscribe();
        }
        this.d = super.a(this.c, n2);
    }

    public void b(int n2) {
        this.b.b(n2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getArguments();
        if (bundle2.containsKey("feed_type")) {
            this.c = bundle2.getString("feed_type");
        }
        this.h = new Handler(Looper.getMainLooper());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968669, viewGroup, false);
        this.g = this.a.findViewById(2131624191);
        this.e = (RecyclerView)this.a.findViewById(2131624425);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.e.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.b = new hf((BaseActivity)this.getContext(), this.c);
        this.b.a((hf.a)this);
        this.e.setAdapter((RecyclerView.Adapter)this.b);
        RecyclerView.ItemAnimator itemAnimator = this.e.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.f = (SwipeRefreshLayout)this.a.findViewById(2131624169);
        this.f.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                hs.this.a(0);
            }
        });
        this.d = super.a(this.c, 0);
        ((BaseActivity)this.getActivity()).addToSubscriptionList(this.d);
        aps aps2 = ix.a().a(in.k.class, new apr<in.k>(){

            public void a(in.k k2) {
                if (hs.this.c.equals((Object)"home")) {
                    hs.this.a(k2);
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.k)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(aps2);
        aps aps3 = ix.a().a(in.p.class, new apr<in.p>(){

            public void a(in.p p2) {
                int n2 = hs.this.b.d(p2.b);
                if (n2 == -1) {
                    return;
                }
                int n3 = hs.this.b.getItemCount();
                for (int i2 = n2; i2 < n3; ++i2) {
                    if (hs.b((hs)hs.this).f((int)i2).group_id != p2.a) continue;
                    hs.this.b.b(hs.this.b.e(i2));
                    --i2;
                    --n3;
                }
                hs.this.b.notifyDataSetChanged();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.p)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(aps3);
        aps aps4 = ix.a().a(in.n.class, new apr<in.n>(){

            public void a(in.n n2) {
                hs.this.b.notifyDataSetChanged();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.n)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(aps4);
        aps aps5 = ix.a().a(in.o.class, new apr<in.o>(){

            public void a(in.o o2) {
                hs.this.a(0);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.o)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(aps5);
        aps aps6 = ix.a().a(in.ah.class, new apr<in.ah>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(in.ah ah2) {
                if (hs.this.b == null || hs.this.e == null || hs.this.c == null) return;
                {
                    if (!ah2.b && hs.this.c.equals((Object)"home")) {
                        hs.this.a(ah2.a);
                        return;
                    } else {
                        int n2;
                        if (ah2.c == null || !hs.this.c.equals((Object)ah2.c) || AppState.relatedPosts == null || AppState.relatedPosts.isEmpty() || (n2 = hs.this.b.d(ah2.a)) < 0) return;
                        {
                            ((Post)AppState.relatedPosts.get((int)0)).first_related_post = 1;
                            hs.this.b.a(n2 + 1, AppState.relatedPosts);
                            return;
                        }
                    }
                }
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.ah)object);
            }
        });
        ((BaseActivity)this.getActivity()).addToSubscriptionList(aps6);
        return this.a;
    }

    @Override
    public void onErrorRetry(String string2) {
        this.onLoadMore(string2);
    }

    @Override
    public void onLoadMore(String string2) {
        if (string2 != null) {
            ik.a().a(this.c, string2, this.b.b(this.c), 0).b(Schedulers.io()).a(apv.a()).b(new apr<List<Post>>(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void a(List<Post> list) {
                    if (list == null || list.isEmpty()) {
                        hs.this.b.a((String)null);
                        return;
                    } else {
                        if (list.size() == 1 && !(list.get(0) instanceof Post)) return;
                        {
                            hs.this.b.b(list);
                            hs.this.b.a(Integer.toString((int)((Post)list.get((int)(-1 + list.size()))).post_id));
                            return;
                        }
                    }
                }

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    rj.a(throwable);
                    jb.a(hs.this.e, hs.this.b);
                }

                @Override
                public /* synthetic */ void onNext(Object object) {
                    this.a((List)object);
                }
            });
        }
    }

    public void onPause() {
        super.onPause();
        this.h.removeCallbacks(this.k);
        this.j = System.currentTimeMillis();
    }

    public void onResume() {
        super.onResume();
        if (this.j != 0 && (System.currentTimeMillis() - this.j) / 60000 > (long)AppState.config.getInt("refresh_timeout", 5)) {
            this.a(0);
            return;
        }
        this.a();
    }

}

