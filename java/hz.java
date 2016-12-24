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
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
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
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class hz
extends hy {
    private View f;
    private View g;
    private RecyclerView h;
    private hl i;
    private SwipeRefreshLayout j;

    public void b(final String string2) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"thread_page", (Object)string2);
        hashMap.put((Object)"include_messages", (Object)"1");
        ik.a().p((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(NetworkData networkData) {
                if (networkData.threads != null) {
                    ArrayList arrayList = new ArrayList();
                    for (MessageThread messageThread : networkData.threads) {
                        if (messageThread.online != 1) continue;
                        arrayList.add((Object)messageThread);
                    }
                    if (string2.equals((Object)"0")) {
                        hz.this.a((List<MessageThread>)arrayList);
                    } else {
                        hz.this.i.b(arrayList);
                    }
                    if (networkData.thread_next_page == 0) {
                        hz.this.i.a((String)null);
                        return;
                    }
                    hz.this.i.a(networkData.thread_next_page);
                }
            }

            @Override
            public void onCompleted() {
                hz.this.j.setRefreshing(false);
                hz.this.a();
            }

            @Override
            public void onError(Throwable throwable) {
                hz.this.j.setRefreshing(false);
                hz.this.a();
                rj.a(throwable);
                Log.d((String)"MessagesActive", (String)throwable.toString());
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = layoutInflater.inflate(2130968681, viewGroup, false);
        this.g = this.f.findViewById(2131624482);
        this.h = (RecyclerView)this.f.findViewById(2131624481);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        this.h.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        this.i = new hl((Context)this.getActivity());
        this.h.setAdapter((RecyclerView.Adapter)this.i);
        this.h.addOnScrollListener((RecyclerView.OnScrollListener)new hn(linearLayoutManager, this.i){

            @Override
            public void onLoadMore(String string2) {
                if (string2 != null && Integer.valueOf((String)string2) > 0) {
                    hz.this.b(string2);
                }
            }
        });
        RecyclerView.ItemAnimator itemAnimator = this.h.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator)itemAnimator).setSupportsChangeAnimations(false);
        }
        this.j = (SwipeRefreshLayout)this.f.findViewById(2131624480);
        this.j.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            public void onRefresh() {
                hz.this.b("0");
            }
        });
        this.j.post(new Runnable(){

            public void run() {
                hz.this.j.setRefreshing(true);
            }
        });
        return this.f;
    }

}

