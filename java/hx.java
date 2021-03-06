/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
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
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.os.Bundle;
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
import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;
import java.util.List;
import rx.schedulers.Schedulers;

public class hx
extends Fragment
implements hf.a {
    private View a;
    private RecyclerView b;
    private hf c;
    private View d;
    private SwipeRefreshLayout e;
    private aps f;

    public aps a() {
        this.c.c();
        return ik.a().h(0).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void a(NetworkData networkData) {
                if (!networkData.success) return;
                if (networkData.posts != null) {
                    hx.this.c.a(networkData.posts);
                }
                if (networkData.next_page != 0) {
                    hx.this.c.a(String.valueOf((int)networkData.next_page));
                    return;
                }
                hx.this.c.a((String)null);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onCompleted() {
                hx.this.e.setRefreshing(false);
                View view = hx.this.d;
                int n2 = hx.this.c.getItemCount() == 0 ? 0 : 8;
                view.setVisibility(n2);
                hx.this.b.scrollToPosition(0);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                hx.this.e.setRefreshing(false);
                View view = hx.this.d;
                int n2 = hx.this.c.getItemCount();
                int n3 = 0;
                if (n2 != 0) {
                    n3 = 8;
                }
                view.setVisibility(n3);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a(int n2) {
        if (this.c == null) {
            return;
        }
        this.c.b(n2);
        if (this.c.getItemCount() > 0) return;
        this.d.setVisibility(0);
    }

    public void a(Post post) {
        if (this.c == null) {
            return;
        }
        this.c.b(post);
        this.d.setVisibility(8);
    }

    public void b() {
        this.f = this.a();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968680, viewGroup, false);
        this.d = this.a.findViewById(2131624185);
        this.b = (RecyclerView)this.a.findViewById(2131624478);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.b.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.c = new hf((BaseActivity)this.getActivity(), null);
        this.c.a((hf.a)this);
        this.b.setAdapter((RecyclerView.Adapter)this.c);
        RecyclerView.ItemAnimator itemAnimator = this.b.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout)this.a.findViewById(2131624169);
        this.e.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                hx.this.f = hx.this.a();
            }
        });
        this.f = this.a();
        return this.a;
    }

    @Override
    public void onErrorRetry(String string2) {
        this.onLoadMore(string2);
    }

    @Override
    public void onLoadMore(String string2) {
        if (string2 != null) {
            ik.a().h(Integer.parseInt((String)string2)).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                public void a(NetworkData networkData) {
                    if (networkData == null || networkData.posts == null || networkData.posts.isEmpty()) {
                        hx.this.c.a((String)null);
                        return;
                    }
                    hx.this.c.b(networkData.posts);
                    if (networkData.next_page != 0) {
                        hx.this.c.a(String.valueOf((int)networkData.next_page));
                        return;
                    }
                    hx.this.c.a((String)null);
                }

                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable throwable) {
                    rj.a(throwable);
                    jb.a(hx.this.b, hx.this.c);
                }

                @Override
                public /* synthetic */ void onNext(Object object) {
                    this.a((NetworkData)object);
                }
            });
        }
    }

}

