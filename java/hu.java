/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnItemTouchListener
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Toast
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.data.Notification;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import java.util.List;
import rx.schedulers.Schedulers;

public class hu
extends Fragment {
    private View a;
    private RecyclerView b;
    private hb c;
    private SwipeRefreshLayout d;
    private View e;
    private aps f;
    private long g;

    private aps b(boolean bl2) {
        this.g = System.currentTimeMillis();
        return ik.a().b(Boolean.toString((boolean)bl2), null).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(NetworkData networkData) {
                if (networkData.success) {
                    if (networkData.activity != null) {
                        hu.this.c.a(networkData.activity);
                    }
                    if (networkData.activity.size() < 10) {
                        hu.this.c.a((String)null);
                    } else {
                        hu.this.c.a(networkData.last_activity_id);
                    }
                    if (networkData.unread_count > 0) {
                        AppState.account.unread_activity_count = networkData.unread_count;
                        ix.a().a(new in.as(3, networkData.unread_count, true));
                    }
                    if (networkData.unread_groups_count > 0) {
                        AppState.account.unread_groups_count = networkData.unread_groups_count;
                        ix.a().a(new in.as(1, networkData.unread_groups_count, true));
                    }
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onCompleted() {
                hu.this.d.setRefreshing(false);
                View view = hu.this.e;
                int n2 = hu.this.c.getItemCount();
                int n3 = 0;
                if (n2 != 0) {
                    n3 = 8;
                }
                view.setVisibility(n3);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                hu.this.d.setRefreshing(false);
                View view = hu.this.e;
                int n2 = hu.this.c.getItemCount();
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

    public void a(boolean bl2) {
        this.b.scrollToPosition(0);
        this.f = super.b(bl2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968677, viewGroup, false);
        this.e = this.a.findViewById(2131624298);
        this.d = (SwipeRefreshLayout)this.a.findViewById(2131624296);
        this.d.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                if (hu.this.f != null) {
                    hu.this.f.unsubscribe();
                }
                hu.this.f = hu.this.b(true);
            }
        });
        this.b = (RecyclerView)this.a.findViewById(2131624297);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.b.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.c = new hb(this.getContext());
        this.b.setAdapter((RecyclerView.Adapter)this.c);
        this.b.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new iv(this.getContext()){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void onItemClick(View var1, int var2_2) {
                if (var2_2 < 0 || var2_2 >= hu.b(hu.this).e().size()) {
                    Toast.makeText((Context)hu.this.getContext(), (CharSequence)"Unable to find that notification", (int)0).show();
                    return;
                }
                var3_3 = (Notification)hu.b(hu.this).e().get(var2_2);
                var3_3.unread = 0;
                hu.b(hu.this).notifyItemChanged(var2_2);
                ik.a().a(var3_3.activity_id).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                var5_4 = var3_3.onclick.split(":");
                var6_5 = Integer.valueOf((String)var5_4[1]);
                var7_6 = var5_4[0];
                switch (var7_6.hashCode()) {
                    case -338943683: {
                        if (!var7_6.equals((Object)"showPost")) ** GOTO lbl24
                        var8_7 = 0;
                        ** GOTO lbl31
                    }
                    case -1572993592: {
                        if (!var7_6.equals((Object)"showPostBottom")) ** GOTO lbl24
                        var8_7 = 1;
                        ** GOTO lbl31
                    }
                    case -1925545598: {
                        if (!var7_6.equals((Object)"showGroup")) ** GOTO lbl24
                        var8_7 = 2;
                        ** GOTO lbl31
                    }
lbl24: // 4 sources:
                    default: {
                        ** GOTO lbl-1000
                    }
                    case 2067279704: 
                }
                if (var7_6.equals((Object)"showTab")) {
                    var8_7 = 3;
                } else lbl-1000: // 2 sources:
                {
                    var8_7 = -1;
                }
lbl31: // 5 sources:
                switch (var8_7) {
                    default: {
                        return;
                    }
                    case 0: {
                        var15_8 = new Intent(hu.this.getContext(), (Class)PostDetailsActivity.class);
                        var15_8.putExtra("post_id", var6_5);
                        if (var3_3.comment_id > 0) {
                            var15_8.putExtra("comment_id", var3_3.comment_id);
                            var15_8.putExtra("scrollToBottom", true);
                        }
                        hu.this.getContext().startActivity(var15_8);
                        return;
                    }
                    case 1: {
                        var11_9 = new Intent(hu.this.getContext(), (Class)PostDetailsActivity.class);
                        var11_9.putExtra("post_id", var6_5);
                        var11_9.putExtra("comment_id", var3_3.comment_id);
                        var11_9.putExtra("scrollToBottom", true);
                        hu.this.getContext().startActivity(var11_9);
                        return;
                    }
                    case 2: {
                        var9_10 = new Intent(hu.this.getContext(), (Class)GroupDetailsActivity.class);
                        var9_10.putExtra("group_id", var6_5);
                        hu.this.getContext().startActivity(var9_10);
                        return;
                    }
                    case 3: 
                }
                ix.a().a(new in.e(var6_5));
            }
        });
        this.b.addOnScrollListener((RecyclerView.OnScrollListener)new hn(linearLayoutManager, this.c){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ik.a().b(Boolean.toString((boolean)true), string2).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                        public void a(NetworkData networkData) {
                            if (networkData == null || networkData.activity == null || networkData.activity.isEmpty()) {
                                hu.this.c.a((String)null);
                                return;
                            }
                            hu.this.c.b(networkData.activity);
                            hu.this.c.a(String.valueOf((int)networkData.last_activity_id));
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable throwable) {
                        }

                        @Override
                        public /* synthetic */ void onNext(Object object) {
                            this.a((NetworkData)object);
                        }
                    });
                }
            }

        });
        return this.a;
    }

    public void onResume() {
        super.onResume();
        this.f = this.b(false);
        aou.a(this.getContext());
    }

}

