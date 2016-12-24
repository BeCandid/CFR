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
 *  android.support.design.widget.AppBarLayout
 *  android.support.design.widget.TabLayout
 *  android.support.design.widget.TabLayout$a
 *  android.support.design.widget.TabLayout$d
 *  android.support.v4.app.ActivityCompat
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentActivity
 *  android.support.v4.app.FragmentManager
 *  android.support.v4.view.ViewPager
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  butterknife.OnClick
 *  butterknife.Unbinder
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.text.DecimalFormat
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
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
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MeSettingsActivity;
import com.becandid.candid.activities.OnboardingActivity;
import com.becandid.candid.activities.SeeAllBadgesActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.JoinedFacebookData;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.views.BadgeInfoView;
import com.becandid.candid.views.TabViewPager;
import com.becandid.thirdparty.BlurTask;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

public class MeTabFragment
extends ht
implements TabLayout.a,
BadgeInfoView.a {
    @BindView(value=2131624819)
    LinearLayout buttonPanel;
    @BindView(value=2131624820)
    View connectContact;
    @BindView(value=2131624821)
    View connectFb;
    private final String d = "ACTIVITY";
    private final String e = "GROUPS";
    private final String f = "POSTS";
    private final String g = "HISTORY";
    private uj h;
    private boolean i;
    private long j = 0;
    private TabLayout k;
    private Context l;
    private BaseActivity m;
    @BindView(value=2131624079)
    ImageView mBadgeIcon;
    @BindView(value=2131624287)
    FrameLayout mBadgeInfoContainer;
    @BindView(value=2131624076)
    TextView mBadgeTitle;
    @BindView(value=2131624818)
    TextView mGroupsCount;
    @BindView(value=2131624816)
    TextView mNumContacts;
    @BindView(value=2131624815)
    TextView mNumFriends;
    @BindView(value=2131624817)
    TextView mPostsCount;
    @BindView(value=2131624809)
    View mProfileContainer;
    @BindView(value=2131624824)
    View mProfileSpinny;
    @BindView(value=2131624813)
    TextView mQualityScore;
    private BadgeInfoView n;
    private View o;
    private hq p;
    @BindView(value=2131624823)
    TabViewPager viewPager;

    private void a(View view) {
        Animation animation = AnimationUtils.loadAnimation((Context)this.getContext(), (int)2131034132);
        animation.setDuration(500);
        this.o.startAnimation(animation);
        view.postDelayed(new Runnable(){

            public void run() {
                MeTabFragment.this.mProfileContainer.setVisibility(0);
                MeTabFragment.this.mBadgeInfoContainer.removeView((View)MeTabFragment.this.n);
                MeTabFragment.this.mBadgeInfoContainer.setVisibility(8);
            }
        }, 500);
    }

    private void a(BadgeInfoView badgeInfoView) {
        badgeInfoView.setSeeAllBadgesListener((BadgeInfoView.a)this);
    }

    private void l() {
        ((hv)this.p.a("GROUPS")).b();
        ((hx)this.p.a("POSTS")).b();
        ((hw)this.p.a("HISTORY")).b();
    }

    @Override
    public void a() {
        super.a();
        this.a(false, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(in.as as2) {
        int n2 = this.viewPager.getCurrentItem();
        if (as2 != null && n2 != 0 && as2.a == 3 && AppState.config.getBoolean("messaging_turned_on", true)) {
            int n3 = as2.b > 0 ? 2130838257 : 0;
            ((TextView)this.k.a(0).a()).setCompoundDrawablesWithIntrinsicBounds(0, 0, n3, 0);
            ((TextView)this.k.a(0).a()).setMaxLines(1);
        }
    }

    public void a(final boolean bl2, final boolean bl3) {
        if (AppState.account == null || AppState.account.user_id <= 0) {
            Toast.makeText((Context)this.getContext(), (CharSequence)"Unable to find your profile.", (int)1).show();
            return;
        }
        this.i = true;
        if (bl2) {
            this.viewPager.setVisibility(8);
            this.mProfileSpinny.setVisibility(0);
        }
        ik.a().d(AppState.account.user_id).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

            /*
             * Enabled aggressive block sorting
             */
            public void a(NetworkData networkData) {
                if (AppState.account == null) {
                    return;
                }
                MeTabFragment.this.c = false;
                MeTabFragment.this.i = false;
                MeTabFragment.this.mProfileSpinny.setVisibility(8);
                MeTabFragment.this.viewPager.setVisibility(0);
                if (MeTabFragment.this.f()) {
                    if (MeTabFragment.this.p.a("ACTIVITY") != null) {
                        ((hu)MeTabFragment.this.p.a("ACTIVITY")).a(bl3);
                    }
                    MeTabFragment.this.l();
                } else {
                    if (MeTabFragment.this.p.a("ACTIVITY") != null) {
                        ((hu)MeTabFragment.this.p.a("ACTIVITY")).a(bl3);
                    }
                    if (bl2) {
                        MeTabFragment.this.l();
                    }
                }
                if (networkData.profile != null) {
                    AppState.account.num_posts = networkData.profile.num_posts;
                    AppState.account.num_groups = networkData.profile.num_groups;
                    AppState.account.num_fb_friends = networkData.profile.num_fb_friends;
                    AppState.account.num_phone_friends = networkData.profile.num_phone_friends;
                    AppState.account.quality_score = networkData.profile.quality_score;
                }
                MeTabFragment.this.j = System.currentTimeMillis() / 1000;
                MeTabFragment.this.d();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                MeTabFragment.this.c = false;
                MeTabFragment.this.i = false;
                if (MeTabFragment.this.viewPager == null || MeTabFragment.this.mProfileSpinny == null) {
                    return;
                }
                MeTabFragment.this.viewPager.setVisibility(0);
                MeTabFragment.this.mProfileSpinny.setVisibility(8);
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((NetworkData)object);
            }
        });
    }

    @Override
    public void b() {
        this.mProfileContainer.setVisibility(0);
    }

    @Override
    public void c() {
        this.mProfileContainer.setVisibility(8);
    }

    @OnClick(value={2131624820})
    public void connectContacts(View view) {
        if (AppState.contactsInfo == null) {
            AppState.contactsInfo = new ContactsInfo();
        }
        if (AppState.account.have_phone_number && bb.checkSelfPermission(view.getContext(), "android.permission.READ_CONTACTS") != 0) {
            ActivityCompat.requestPermissions((Activity)((Activity)view.getContext()), (String[])new String[]{"android.permission.READ_CONTACTS"}, (int)1);
            return;
        }
        Intent intent = new Intent(view.getContext(), (Class)OnboardingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("first_fragment", "phone");
        bundle.putString("second_fragment", "phone");
        intent.putExtras(bundle);
        view.getContext().startActivity(intent);
    }

    @OnClick(value={2131624821})
    public void connectFB(final View view) {
        view.setVisibility(8);
        if (this.h == null) {
            this.h = uj.a.a();
            wm.c().a(this.h, new uk<wn>(){

                public void a(wn wn2) {
                    Log.d((String)"FBConnect", (String)"success");
                    AppState.setFBInfo(wn2.a(), new FacebookInfo.LoadCallback(){

                        @Override
                        public void onNext(int n2) {
                            if (AppState.account != null) {
                                AppState.account.num_fb_friends = n2;
                            }
                            MeTabFragment.this.d();
                            MeTabFragment.this.i();
                        }
                    });
                }

                @Override
                public void onCancel() {
                    Log.d((String)"FBConnect", (String)"cancel");
                    view.setVisibility(0);
                }

                @Override
                public void onError(FacebookException facebookException) {
                    Log.e((String)"FBConnect", (String)facebookException.toString());
                    if (facebookException instanceof FacebookAuthorizationException && AccessToken.a() != null) {
                        wm.c().d();
                        wm.c().a((Activity)MeTabFragment.this.m, (Collection<String>)Arrays.asList((Object[])"public_profile,user_friends,user_work_history,user_education_history".split(",")));
                        return;
                    }
                    Toast.makeText((Context)GossipApplication.a(), (CharSequence)"Unable to connect to Facebook", (int)1).show();
                    view.setVisibility(0);
                }

                @Override
                public /* synthetic */ void onSuccess(Object object) {
                    this.a((wn)object);
                }

            });
        }
        wm.c().a((Activity)this.m, (Collection<String>)Arrays.asList((Object[])"public_profile,user_friends,user_work_history,user_education_history".split(",")));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d() {
        ig.a a2;
        if (AppState.account == null) {
            return;
        }
        this.mPostsCount.setText((CharSequence)Integer.toString((int)AppState.account.num_posts));
        this.mGroupsCount.setText((CharSequence)Integer.toString((int)AppState.account.num_groups));
        int n2 = AppState.account.num_fb_friends;
        this.mNumFriends.setText((CharSequence)Integer.toString((int)n2));
        Integer n3 = AppState.account.num_phone_friends;
        this.mNumContacts.setText((CharSequence)Integer.toString((int)n3));
        final String string2 = new DecimalFormat("#").format((double)AppState.account.quality_score);
        if (string2 != null && !string2.equals((Object)"0")) {
            this.mQualityScore.setVisibility(0);
            this.mQualityScore.setText((CharSequence)string2);
            this.mQualityScore.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    if (!AppState.blurTaskCalledOnFlight) {
                        AppState.blurTaskCalledOnFlight = true;
                        new BlurTask((Activity)MeTabFragment.this.l, ((Activity)MeTabFragment.this.l).findViewById(16908290), string2, BlurTask.BadgeType.d, null, null).execute((Object[])new Void[0]);
                    }
                }
            });
        } else {
            this.mQualityScore.setVisibility(8);
        }
        if ((a2 = ig.a().a(AppState.account.badge_status)) != null) {
            this.mBadgeIcon.setImageResource(a2.c);
            this.mBadgeTitle.setText((CharSequence)a2.b);
        }
        if (AppState.account.have_fb && AppState.account.have_phone_number) {
            this.buttonPanel.setVisibility(8);
            return;
        }
        this.buttonPanel.setVisibility(0);
        if (AppState.fbInfo != null) {
            this.connectFb.setVisibility(8);
        } else {
            this.connectFb.setVisibility(0);
        }
        if (AppState.account.have_phone_number) {
            this.connectContact.setVisibility(8);
            return;
        }
        this.connectContact.setVisibility(0);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void e() {
        if (this.viewPager == null) {
            return;
        }
        this.viewPager.setCurrentItem(0, true);
        this.a(true, true);
        if (this.getView() == null) return;
        ((AppBarLayout)this.getView().findViewById(2131624810)).setExpanded(true, true);
    }

    public boolean f() {
        if (System.currentTimeMillis() / 1000 - this.j > (long)AppState.config.getInt("profile_update_time", 300)) {
            return true;
        }
        return false;
    }

    public void g() {
        GossipApplication.a().d();
        this.j();
        this.connectContact.setVisibility(8);
    }

    public void h() {
        this.connectContact.setEnabled(true);
    }

    public void i() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"fb_token", (Object)AppState.fbInfo.fbToken.b());
        hashMap.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)"type", (Object)"fb");
        hashMap2.put((Object)"fb_uid", (Object)AppState.fbInfo.fbToken.i());
        hashMap2.put((Object)"id_list", (Object)DataUtil.join(AppState.fbInfo.friendIds));
        apl.a(ik.a().b((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()), ik.a().a(AppState.fbInfo).b(Schedulers.io()).a(apv.a()), new aqd<ain, NetworkData, JoinedFacebookData>(){

            public JoinedFacebookData a(ain ain2, NetworkData networkData) {
                return new JoinedFacebookData(ain2, networkData);
            }

            @Override
            public /* synthetic */ Object call(Object object, Object object2) {
                return this.a((ain)object, (NetworkData)object2);
            }
        }).b(new apr<JoinedFacebookData>(){

            public void a(JoinedFacebookData joinedFacebookData) {
                NetworkData networkData = joinedFacebookData.autoJoin;
                if (networkData != null && networkData.groups != null) {
                    for (Group group : networkData.groups) {
                        ix.a().a(new in.m(group));
                    }
                }
                if (networkData != null && networkData.my_info != null) {
                    AppState.account.num_groups = networkData.my_info.num_groups;
                }
                MeTabFragment.this.d();
            }

            @Override
            public void onCompleted() {
                ix.a().a(new in.au());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((JoinedFacebookData)object);
            }
        });
    }

    public void j() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"type", (Object)"phone_number");
        hashMap.put((Object)"id_list", (Object)DataUtil.join(AppState.contactsInfo.contacts));
        ik.a().c((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new apr<ain>(){

            public void a(ain ain2) {
                int n2;
                AppState.account.num_phone_friends = n2 = ain2.b("num_phone_friends").g();
                AppState.saveState((ContextWrapper)GossipApplication.a());
                MeTabFragment.this.d();
                ix.a().a(new in.au());
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
                this.a((ain)object);
            }
        });
    }

    @Override
    public void k() {
        this.a((View)this.mBadgeInfoContainer);
        final Context context = this.getContext();
        this.mProfileContainer.postDelayed(new Runnable(){

            public void run() {
                Intent intent = new Intent(context, (Class)SeeAllBadgesActivity.class);
                context.startActivity(intent);
            }
        }, 600);
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (this.h == null) {
            return;
        }
        this.h.a(n2, n3, intent);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(2130968743, viewGroup, false);
        this.b = ButterKnife.bind((Object)this, (View)view);
        this.l = this.getContext();
        this.m = (BaseActivity)this.getActivity();
        this.k = (TabLayout)view.findViewById(2131624822);
        this.k.setSelectedTabIndicatorColor(this.getResources().getColor(2131558476));
        this.k.setTabTextColors(Color.parseColor((String)"#888888"), this.getResources().getColor(2131558476));
        this.p = new hq(this.m.getSupportFragmentManager());
        hv hv2 = new hv();
        hx hx2 = new hx();
        hw hw2 = new hw();
        if (AppState.config.getBoolean("messaging_turned_on", true)) {
            hu hu2 = new hu();
            this.p.a(hu2, "ACTIVITY");
        }
        this.p.a(hv2, "GROUPS");
        this.p.a(hx2, "POSTS");
        this.p.a(hw2, "HISTORY");
        this.viewPager.setAdapter((ev)((Object)this.p));
        this.viewPager.setOffscreenPageLimit(3);
        this.viewPager.setCurrTab("me");
        this.k.setupWithViewPager((ViewPager)this.viewPager);
        this.k.setOnTabSelectedListener((TabLayout.a)this);
        for (int i2 = 0; i2 < this.k.getTabCount(); ++i2) {
            TextView textView = (TextView)LayoutInflater.from((Context)this.l).inflate(2130968649, null);
            textView.setText(this.k.a(i2).d());
            textView.setCompoundDrawablePadding(0);
            this.k.a(i2).a((View)textView);
        }
        view.findViewById(2131624814).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(MeTabFragment.this.getContext(), (Class)MeSettingsActivity.class);
                MeTabFragment.this.getContext().startActivity(intent);
            }
        });
        aps aps2 = ix.a().a(in.k.class, new apr<in.k>(){

            public void a(in.k k2) {
                ((hx)MeTabFragment.this.p.a("POSTS")).a(k2.a);
                User user = AppState.account;
                user.num_posts = 1 + user.num_posts;
                MeTabFragment.this.d();
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
        this.m.addToSubscriptionList(aps2);
        aps aps3 = ix.a().a(in.r.class, new apr<in.r>(){

            public void a(in.r r2) {
                ((hx)MeTabFragment.this.p.a("POSTS")).a(r2.a);
                User user = AppState.account;
                user.num_posts = -1 + user.num_posts;
                MeTabFragment.this.d();
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
                this.a((in.r)object);
            }
        });
        this.m.addToSubscriptionList(aps3);
        aps aps4 = ix.a().a(in.m.class, new apr<in.m>(){

            public void a(in.m m2) {
                ((hv)MeTabFragment.this.p.a("GROUPS")).a(m2.a);
                if (AppState.groups != null && AppState.account != null) {
                    AppState.account.num_groups = AppState.groups.size();
                }
                MeTabFragment.this.d();
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
                this.a((in.m)object);
            }
        });
        this.m.addToSubscriptionList(aps4);
        aps aps5 = ix.a().a(in.o.class, new apr<in.o>(){

            public void a(in.o o2) {
                ((hv)MeTabFragment.this.p.a("GROUPS")).a(o2.a);
                AppState.account.num_groups = AppState.groups.size();
                MeTabFragment.this.a();
                MeTabFragment.this.d();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.o)object);
            }
        });
        this.m.addToSubscriptionList(aps5);
        aps aps6 = ix.a().a(in.d.class, new apr<in.d>(){

            public void a(in.d d2) {
                String string2 = d2.a;
                MeTabFragment.this.n = new BadgeInfoView((Context)MeTabFragment.this.m, AppState.account.badge_status, true, string2);
                MeTabFragment.this.a(MeTabFragment.this.n);
                MeTabFragment.this.mBadgeInfoContainer.setVisibility(0);
                MeTabFragment.this.mProfileContainer.setVisibility(8);
                MeTabFragment.this.mBadgeInfoContainer.addView((View)MeTabFragment.this.n);
                Animation animation = AnimationUtils.loadAnimation((Context)MeTabFragment.this.m, (int)2131034137);
                animation.setDuration(500);
                MeTabFragment.this.o = MeTabFragment.this.mBadgeInfoContainer.findViewById(2131624074);
                MeTabFragment.this.o.startAnimation(animation);
                MeTabFragment.this.mBadgeInfoContainer.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {
                        MeTabFragment.this.a(view);
                    }
                });
                AppState.blurTaskCalledOnFlight = false;
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
                this.a((in.d)object);
            }

        });
        this.m.addToSubscriptionList(aps6);
        this.d();
        this.mBadgeIcon.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (AppState.account != null && AppState.account.badge_status != null && !AppState.blurTaskCalledOnFlight) {
                    AppState.blurTaskCalledOnFlight = true;
                    new BlurTask((Activity)MeTabFragment.this.m, 2131624809).execute((Object[])new Void[0]);
                }
            }
        });
        return view;
    }

    public void onResume() {
        super.onResume();
        if (!this.i && this.f()) {
            this.a(false, false);
        }
    }

    public void onTabReselected(TabLayout.d d2) {
        this.a();
    }

    public void onTabSelected(TabLayout.d d2) {
        this.viewPager.setCurrentItem(d2.c(), true);
        if (d2.c() == 0 && AppState.config.getBoolean("messaging_turned_on", true)) {
            TextView textView = (TextView)d2.a();
            textView.setTextColor(this.getResources().getColor(2131558476));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void onTabUnselected(TabLayout.d d2) {
        if (d2.c() == 0 && AppState.config.getBoolean("messaging_turned_on", true)) {
            TextView textView = (TextView)d2.a();
            textView.setTextColor(Color.parseColor((String)"#888888"));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

}

