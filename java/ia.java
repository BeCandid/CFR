/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v4.widget.SwipeRefreshLayout$OnRefreshListener
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ItemAnimator
 *  android.support.v7.widget.RecyclerView$LayoutManager
 *  android.support.v7.widget.RecyclerView$OnScrollListener
 *  android.support.v7.widget.SimpleItemAnimator
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.NetworkData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class ia
extends hy {
    public void b(final String string2) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"request_page", (Object)string2);
        hashMap.put((Object)"include_messages", (Object)"1");
        ik.a().p((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(NetworkData networkData) {
                if (networkData.requests != null) {
                    if (string2.equals((Object)"0")) {
                        ia.this.a(networkData.requests);
                    } else {
                        ia.this.d.b(networkData.requests);
                    }
                    if (networkData.request_next_page == 0) {
                        ia.this.d.a((String)null);
                        return;
                    }
                    ia.this.d.a(networkData.request_next_page);
                }
            }

            @Override
            public void onCompleted() {
                ia.this.e.setRefreshing(false);
                ia.this.a();
            }

            @Override
            public void onError(Throwable throwable) {
                ia.this.e.setRefreshing(false);
                ia.this.a();
                rj.a(throwable);
                Log.d((String)"MessagesRequests", (String)throwable.toString());
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2130968682, viewGroup, false);
        this.b = this.a.findViewById(2131624486);
        this.c = (RecyclerView)this.a.findViewById(2131624485);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.c.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.d = new hl((Context)((BaseActivity)this.getActivity()));
        this.c.setAdapter((RecyclerView.Adapter)this.d);
        this.c.addOnScrollListener((RecyclerView.OnScrollListener)new hn(linearLayoutManager, this.d){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null) {
                    ia.this.b(string2);
                }
            }
        });
        RecyclerView.ItemAnimator itemAnimator = this.c.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.e = (SwipeRefreshLayout)this.a.findViewById(2131624484);
        this.e.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                ia.this.b("0");
            }
        });
        this.e.post(new Runnable(){

            public void run() {
                ia.this.e.setRefreshing(true);
            }
        });
        return this.a;
    }

}

