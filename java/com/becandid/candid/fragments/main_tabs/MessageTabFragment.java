/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.support.design.widget.TabLayout
 *  android.support.design.widget.TabLayout$a
 *  android.support.design.widget.TabLayout$d
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.view.ViewPager
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.fragments.main_tabs;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.MessageSearchActivity;
import com.becandid.candid.activities.MessageSettingsActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.TabViewPager;
import com.becandid.thirdparty.BlurTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MessageTabFragment
extends ht {
    private Context d;
    private BaseActivity e;
    private hq f;
    private hz g;
    private ib h;
    private ia i;
    private aps j;
    @BindView(value=2131624557)
    View messagesContainer;
    @BindView(value=2131624558)
    TextView messagesSearch;
    @BindView(value=2131624559)
    ImageView messagesSettings;
    @BindView(value=2131624563)
    FrameLayout messagesSpinny;
    @BindView(value=2131624562)
    TextView messagingDisabled;
    @BindView(value=2131624560)
    TabLayout tabBar;
    @BindView(value=2131624561)
    TabViewPager viewPager;

    @Override
    public void a() {
        super.a();
        ((MainTabsActivity)this.d).setShowMessagingPopup(false);
        this.j = this.e();
    }

    public void a(int n2) {
        if (n2 == 1) {
            this.viewPager.setVisibility(8);
            this.messagingDisabled.setVisibility(0);
            this.messagesSearch.setEnabled(false);
            this.tabBar.setEnabled(false);
            return;
        }
        this.viewPager.setVisibility(0);
        this.messagingDisabled.setVisibility(8);
        this.messagesSearch.setEnabled(true);
        this.tabBar.setEnabled(true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2, int n3, int n4) {
        if (this.tabBar != null) {
            int n5 = this.viewPager.getCurrentItem();
            int n6 = n2 > 0 && n5 != 0 && n5 != 1 ? 2130838257 : 0;
            ((TextView)this.tabBar.a(0).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, n6, 0);
            int n7 = n3 > 0 && n5 != 0 && n5 != 1 ? 2130838257 : 0;
            ((TextView)this.tabBar.a(1).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, n7, 0);
            int n8 = n4 > 0 && n5 != 2 ? 2130838257 : 0;
            ((TextView)this.tabBar.a(2).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, n8, 0);
        }
    }

    @Override
    public void b() {
        if (this.messagesContainer != null) {
            this.messagesContainer.setVisibility(0);
        }
    }

    @Override
    public void c() {
        this.messagesContainer.setVisibility(8);
    }

    public void d() {
        final View view = ((Activity)this.d).findViewById(16908290);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){

            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                if (!AppState.hasMessagingShown) {
                    new BlurTask((Activity)MessageTabFragment.this.d, ((Activity)MessageTabFragment.this.d).findViewById(16908290), BlurTask.BadgeType.f).execute((Object[])new Void[0]);
                    AppState.hasMessagingShown = true;
                    AppState.saveState((ContextWrapper)GossipApplication.a());
                    return;
                }
                ((MainTabsActivity)MessageTabFragment.this.d).setShowMessagingPopup(false);
            }
        });
    }

    public aps e() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"include_messages", (Object)"1");
        return ik.a().p((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            public void a(NetworkData networkData) {
                if (networkData.threads != null) {
                    MessageTabFragment.this.h.a(networkData.threads);
                    ArrayList arrayList = new ArrayList();
                    for (MessageThread messageThread : networkData.threads) {
                        if (messageThread.online != 1) continue;
                        arrayList.add((Object)messageThread);
                    }
                    MessageTabFragment.this.g.a((List<MessageThread>)arrayList);
                    if (networkData.thread_next_page > 0) {
                        MessageTabFragment.this.h.a(Integer.toString((int)networkData.thread_next_page));
                        MessageTabFragment.this.g.a(Integer.toString((int)networkData.thread_next_page));
                    }
                }
                if (networkData.requests != null) {
                    MessageTabFragment.this.i.a(networkData.requests);
                    if (networkData.request_next_page > 0) {
                        MessageTabFragment.this.i.a(Integer.toString((int)networkData.request_next_page));
                    }
                }
                MessageTabFragment.this.a(0, networkData.new_threads, networkData.new_requests);
                int n2 = networkData.new_threads + networkData.new_requests;
                ix.a().a(new in.as(2, n2, true));
                MessageTabFragment.this.f();
            }

            @Override
            public void onCompleted() {
                MessageTabFragment.this.c = false;
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
                MessageTabFragment.this.c = false;
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    public void f() {
        this.g.a();
        this.h.a();
        this.i.a();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968702, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        this.e = (BaseActivity)this.getActivity();
        this.d = (BaseActivity)this.getActivity();
        this.a = this.getContext();
        this.messagesSearch.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(MessageTabFragment.this.d, (Class)MessageSearchActivity.class);
                MessageTabFragment.this.d.startActivity(intent);
            }
        });
        this.messagesSettings.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(MessageTabFragment.this.d, (Class)MessageSettingsActivity.class);
                MessageTabFragment.this.d.startActivity(intent);
            }
        });
        this.f = new hq(this.e.getSupportFragmentManager());
        this.g = new hz();
        this.h = new ib();
        this.i = new ia();
        this.f.a(this.g, "ACTIVE");
        this.f.a(this.h, "THREADS");
        this.f.a(this.i, "REQUESTS");
        this.viewPager.setAdapter((ev)((Object)this.f));
        this.viewPager.setOffscreenPageLimit(2);
        this.viewPager.setCurrTab("messages");
        this.tabBar.setupWithViewPager((ViewPager)this.viewPager);
        for (int i2 = 0; i2 < this.tabBar.getTabCount(); ++i2) {
            TextView textView = (TextView)LayoutInflater.from((Context)this.d).inflate(2130968649, null);
            textView.setText(this.tabBar.a(i2).d());
            textView.setCompoundDrawablePadding(0);
            this.tabBar.a(i2).a((View)textView);
        }
        this.tabBar.setSelectedTabIndicatorColor(this.getResources().getColor(2131558476));
        this.tabBar.setTabTextColors(Color.parseColor((String)"#888888"), this.getResources().getColor(2131558476));
        this.tabBar.setOnTabSelectedListener(new TabLayout.a(){

            public void onTabReselected(TabLayout.d d2) {
                TextView textView = (TextView)d2.a();
                textView.setTextColor(MessageTabFragment.this.getResources().getColor(2131558476));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                MessageTabFragment.this.e();
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onTabSelected(TabLayout.d d2) {
                TextView textView = (TextView)d2.a();
                textView.setTextColor(MessageTabFragment.this.getResources().getColor(2131558476));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                MessageTabFragment.this.viewPager.setCurrentItem(d2.c(), true);
                if (d2.c() == 0) {
                    TextView textView2 = (TextView)MessageTabFragment.this.tabBar.a(1).a();
                    textView2.setTextColor(Color.parseColor((String)"#888888"));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    return;
                } else {
                    if (d2.c() != 1) return;
                    {
                        TextView textView3 = (TextView)MessageTabFragment.this.tabBar.a(0).a();
                        textView3.setTextColor(Color.parseColor((String)"#888888"));
                        textView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        return;
                    }
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onTabUnselected(TabLayout.d d2) {
                TextView textView = (TextView)d2.a();
                textView.setTextColor(Color.parseColor((String)"#888888"));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                if (d2.c() == 0) {
                    TextView textView2 = (TextView)MessageTabFragment.this.tabBar.a(1).a();
                    textView2.setTextColor(Color.parseColor((String)"#888888"));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    return;
                } else {
                    if (d2.c() != 1) return;
                    {
                        TextView textView3 = (TextView)MessageTabFragment.this.tabBar.a(0).a();
                        textView3.setTextColor(Color.parseColor((String)"#888888"));
                        textView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        return;
                    }
                }
            }
        });
        this.j = this.e();
        if (AppState.account != null) {
            this.a(AppState.account.messaging_disabled);
        }
        aps aps2 = ix.a().a(in.aa.class, new apr<in.aa>(){

            public void a(in.aa aa2) {
                MessageTabFragment.this.a(aa2.a);
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
                this.a((in.aa)object);
            }
        });
        ((BaseActivity)this.d).addToSubscriptionList(aps2);
        aps aps3 = ix.a().a(in.x.class, new apr<in.x>(){

            public void a(in.x x2) {
                MessageTabFragment.this.j = MessageTabFragment.this.e();
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
                this.a((in.x)object);
            }
        });
        ((BaseActivity)this.d).addToSubscriptionList(aps3);
        aps aps4 = ix.a().a(in.ae.class, new apr<in.ae>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(final in.ae ae2) {
                int n2 = 1;
                boolean bl2 = MessageTabFragment.this.g.a(ae2);
                boolean bl3 = MessageTabFragment.this.h.a(ae2);
                boolean bl4 = MessageTabFragment.this.i.a(ae2);
                if (!(bl4 | (bl2 | bl3))) {
                    HashMap hashMap = new HashMap();
                    hashMap.put((Object)"post_id", (Object)Integer.toString((int)ae2.b));
                    hashMap.put((Object)"post_name", (Object)ae2.d);
                    ik.a().n((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                        public void a(NetworkData networkData) {
                            if (!networkData.success) {
                                Toast.makeText((Context)MessageTabFragment.this.d, (CharSequence)networkData.error, (int)0).show();
                                return;
                            }
                            MessageThread messageThread = networkData.thread;
                            messageThread.unread_messages = 1;
                            ((Message)messageThread.messages.get((int)0)).subject = ae2.c;
                            if (messageThread.is_request == 1) {
                                MessageTabFragment.this.i.a(messageThread);
                                MessageTabFragment.this.a(0, 0, 1);
                                return;
                            }
                            MessageTabFragment.this.h.a(messageThread);
                            if (messageThread.online == 1) {
                                MessageTabFragment.this.g.a(messageThread);
                                MessageTabFragment.this.a(1, 1, 0);
                                return;
                            }
                            MessageTabFragment.this.a(0, 1, 0);
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
                    return;
                }
                int n3 = bl2 ? n2 : 0;
                int n4 = bl3 ? n2 : 0;
                if (!bl4) {
                    n2 = 0;
                }
                MessageTabFragment.this.a(n3, n4, n2);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.ae)object);
            }

        });
        ((BaseActivity)this.d).addToSubscriptionList(aps4);
        aps aps5 = ix.a().a(in.u.class, new apr<in.u>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(in.u u2) {
                MessageTabFragment.this.g.b();
                MessageThread messageThread = MessageTabFragment.this.i.b();
                MessageThread messageThread2 = MessageTabFragment.this.h.b();
                if (messageThread == null && messageThread2 == null) {
                    MessageTabFragment.this.viewPager.setCurrentItem(1, true);
                    return;
                }
                if (messageThread != null && messageThread2 == null) {
                    MessageTabFragment.this.viewPager.setCurrentItem(2, true);
                    return;
                }
                if (messageThread == null && messageThread2 != null) {
                    MessageTabFragment.this.viewPager.setCurrentItem(1, true);
                    return;
                }
                if (messageThread == null || messageThread2 == null) return;
                {
                    if (messageThread.unread_messages > 0 && messageThread2.unread_messages == 0) {
                        MessageTabFragment.this.viewPager.setCurrentItem(2, true);
                        return;
                    }
                }
                if (messageThread.unread_messages == 0 && messageThread2.unread_messages > 0) {
                    MessageTabFragment.this.viewPager.setCurrentItem(1, true);
                    return;
                }
                if (messageThread.unread_messages > 0 && messageThread2.unread_messages > 0) {
                    if (((Message)messageThread.messages.get((int)0)).sent_time > ((Message)messageThread2.messages.get((int)0)).sent_time) {
                        MessageTabFragment.this.viewPager.setCurrentItem(2, true);
                        return;
                    }
                    MessageTabFragment.this.viewPager.setCurrentItem(1, true);
                    return;
                }
                MessageTabFragment.this.viewPager.setCurrentItem(1, true);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.u)object);
            }
        });
        ((BaseActivity)this.d).addToSubscriptionList(aps5);
        aps aps6 = ix.a().a(in.j.class, new apr<in.j>(){

            public void a(in.j j2) {
                if (j2 != null) {
                    MessageTabFragment.this.g.a(j2.a, j2.b);
                    MessageTabFragment.this.h.a(j2.a, j2.b);
                    MessageTabFragment.this.i.a(j2.a, j2.b);
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
                this.a((in.j)object);
            }
        });
        ((BaseActivity)this.d).addToSubscriptionList(aps6);
        return view;
    }

    public void onResume() {
        super.onResume();
        aou.a(this.d);
        ik.a().g().b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
        ix.a().a(new in.as(2, 0, true));
        this.j = this.e();
    }

}

