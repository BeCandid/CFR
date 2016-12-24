/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.location.Location
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.net.CookieStore
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  rx.schedulers.Schedulers
 */
package com.becandid.candid.data;

import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Log;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.ContactsInfo;
import com.becandid.candid.data.DataUtil;
import com.becandid.candid.data.FacebookInfo;
import com.becandid.candid.data.Group;
import com.becandid.candid.data.Post;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.facebook.AccessToken;
import java.lang.reflect.Type;
import java.net.CookieStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.schedulers.Schedulers;

public class AppState {
    public static User account;
    public static ArrayList<String> activeTags;
    private static List<String> adultTags;
    public static String age;
    public static boolean blurTaskCalledOnFlight;
    public static Config config;
    public static ContactsInfo contactsInfo;
    public static HashSet<Integer> expandedPostIds;
    public static FacebookInfo fbInfo;
    public static List<String> feedColors;
    public static List<String> groupTags;
    public static List<Group> groups;
    public static boolean hasLinkSearched;
    public static boolean hasMessagedFromAlert;
    public static boolean hasMessagingShown;
    public static boolean hasMuted;
    public static boolean hasPosted;
    public static boolean hasShownMutePopup;
    public static boolean hasShownUnmutePopup;
    public static boolean internal;
    public static Location location;
    public static String locationProvider;
    public static MainTabsActivity mainTabsActivity;
    public static int needAge;
    public static int needOnboarding;
    public static String nickname;
    public static ArrayList<NetworkData.NotificationSetting> notificationSettings;
    public static String referralId;
    public static int referralPostId;
    public static List<Post> relatedPosts;
    public static List<String> tabsOrder;
    public static List<String> tags;
    private static List<String> teenTags;

    static {
        blurTaskCalledOnFlight = false;
    }

    public static void clearState(ContextWrapper contextWrapper) {
        Log.d((String)"APP", (String)"Clear app state");
        SharedPreferences.Editor editor = contextWrapper.getSharedPreferences("com.becandid.candid", 0).edit();
        editor.remove("account");
        editor.remove("tags");
        editor.remove("colors");
        editor.remove("contactsInfo");
        editor.remove("hasPosted");
        editor.remove("hasMuted");
        editor.remove("hasMessagingShown");
        editor.remove("hasShownUnmutePopup");
        editor.remove("hasMessagedFromAlerts");
        editor.remove("hasLinkSearched");
        editor.remove("age");
        editor.remove("nickname");
        editor.clear();
        editor.commit();
    }

    public static void disownAccount() {
        tags = null;
        activeTags = null;
        location = null;
        locationProvider = null;
        fbInfo = null;
        contactsInfo = null;
        account = null;
        groups = null;
        hasPosted = false;
        hasMuted = false;
        hasShownMutePopup = false;
        hasShownUnmutePopup = false;
        hasMessagingShown = false;
        hasLinkSearched = false;
        age = null;
        teenTags = null;
        adultTags = null;
        nickname = null;
        if (AccessToken.a() != null) {
            wm.c().d();
        }
        ((NotificationManager)GossipApplication.a.getSystemService("notification")).cancelAll();
        ik.a.removeAll();
        AppState.clearState((ContextWrapper)GossipApplication.a());
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean isGroupMember(int n2) {
        if (groups == null) {
            return false;
        }
        Iterator iterator = groups.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (((Group)iterator.next()).group_id != n2);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean isGroupModerator(int n2) {
        if (groups == null) {
            return false;
        }
        Iterator iterator = groups.iterator();
        do {
            if (!iterator.hasNext()) return false;
            Group group = (Group)iterator.next();
        } while (group.group_id != n2 || group.moderator != 1);
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static void loadState(ContextWrapper var0) {
        var1_1 = var0.getSharedPreferences("com.becandid.candid", 0);
        Log.d((String)"APP", (String)"Checking shared prefs for app state");
        if (var1_1.contains("config")) {
            AppState.setConfig(DataUtil.toMap(var1_1.getString("config", "{}")));
        }
        if (var1_1.contains("account")) {
            var14_2 = var1_1.getString("account", null);
            if (var14_2 != null) {
                AppState.account = (User)DataUtil.gson.a(var14_2, User.class);
            }
            if (AppState.account != null) {
                ik.a().b().b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
            }
        }
        if (var1_1.contains("tags")) {
            var12_3 = new aju<List<String>>(){}.getType();
            var13_4 = var1_1.getString("tags", "{}");
            AppState.tags = (List)new aih().a(var13_4, var12_3);
        }
lbl16: // 4 sources:
        do {
            if (var1_1.contains("teenTags")) {
                var9_5 = new aju<List<String>>(){}.getType();
                var10_6 = var1_1.getString("teenTags", "{}");
                AppState.teenTags = (List)new aih().a(var10_6, var9_5);
            }
lbl22: // 4 sources:
            do {
                if (var1_1.contains("adultTags")) {
                    var6_7 = new aju<List<String>>(){}.getType();
                    var7_8 = var1_1.getString("adultTags", "{}");
                    AppState.adultTags = (List)new aih().a(var7_8, var6_7);
                }
lbl28: // 4 sources:
                do {
                    if (AppState.feedColors != null) ** GOTO lbl32
                    if (var1_1.contains("colors")) {
                        AppState.feedColors = new ArrayList((Collection)var1_1.getStringSet("colors", null));
lbl32: // 3 sources:
                        do {
                            if (var1_1.contains("hasPosted")) {
                                AppState.hasPosted = var1_1.getBoolean("hasPosted", false);
                            }
                            if (var1_1.contains("hasMuted")) {
                                AppState.hasMuted = var1_1.getBoolean("hasMuted", false);
                            }
                            if (var1_1.contains("hasShownMutePopup")) {
                                AppState.hasShownMutePopup = var1_1.getBoolean("hasShownMutePopup", false);
                            }
                            if (var1_1.contains("hasShownUnmutePopup")) {
                                AppState.hasShownUnmutePopup = var1_1.getBoolean("hasShownUnmutePopup", false);
                            }
                            if (var1_1.contains("hasMessagingShown")) {
                                AppState.hasMessagingShown = var1_1.getBoolean("hasMessagingShown", false);
                            }
                            if (var1_1.contains("hasMessagedFromAlert")) {
                                AppState.hasMessagedFromAlert = var1_1.getBoolean("hasMessagedFromAlert", false);
                            }
                            if (var1_1.contains("hasLinkSearched")) {
                                AppState.hasLinkSearched = var1_1.getBoolean("hasLinkSearched", false);
                            }
                            if (AccessToken.a() != null) {
                                AppState.fbInfo = new FacebookInfo();
                                AppState.fbInfo.fbToken = AccessToken.a();
                            }
                            if (var1_1.contains("tabsOrder")) {
                                var3_9 = new aju<List<String>>(){}.getType();
                                var4_10 = var1_1.getString("tabsOrder", "{}");
                                AppState.tabsOrder = (List)new aih().a(var4_10, var3_9);
                            }
                            if (var1_1.contains("age")) {
                                AppState.age = var1_1.getString("age", null);
                            }
                            if (var1_1.contains("nickname")) {
                                AppState.nickname = var1_1.getString("nickname", null);
                            }
                            return;
                            break;
                        } while (true);
                    }
                    AppState.feedColors = Arrays.asList((Object[])new String[]{"#3b6c9e", "#23cbba", "#5cc396", "#e3c02a", "#603785", "#1daff1", "#fd9231", "#94bb65", "#d2822c", "#945319", "#9ccb46", "#147b40", "#e6ad38", "#a837aa", "#e3515d", "#cc333e", "#465163", "#d46342"});
                    ** continue;
                    break;
                } while (true);
                catch (ClassCastException var5_11) {
                    ** continue;
                }
                break;
            } while (true);
            catch (ClassCastException var8_12) {
                ** continue;
            }
            break;
        } while (true);
        catch (ClassCastException var11_13) {
            ** continue;
        }
    }

    public static boolean loggedin() {
        if (account != null) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void saveState(ContextWrapper contextWrapper) {
        Log.d((String)"APP", (String)"Save app state");
        SharedPreferences.Editor editor = contextWrapper.getSharedPreferences("com.becandid.candid", 0).edit();
        if (config != null && AppState.config.experimentConfig != null) {
            editor.putString("config", DataUtil.toJson(AppState.config.experimentConfig));
        }
        if (account != null) {
            editor.putString("account", DataUtil.toJson(account));
        }
        if (tags != null) {
            editor.putString("tags", DataUtil.toJson(tags));
        }
        if (teenTags != null) {
            editor.putString("teenTags", DataUtil.toJson(teenTags));
        }
        if (adultTags != null) {
            editor.putString("adultTags", DataUtil.toJson(adultTags));
        }
        if (feedColors != null) {
            editor.putStringSet("colors", (Set)new LinkedHashSet(feedColors));
        }
        if (tabsOrder != null) {
            editor.putString("tabsOrder", DataUtil.toJson(tabsOrder));
        }
        editor.putBoolean("hasPosted", hasPosted);
        editor.putBoolean("hasMuted", hasMuted);
        editor.putBoolean("hasMessagingShown", hasMessagingShown);
        editor.putBoolean("hasShownMutePopup", hasShownMutePopup);
        editor.putBoolean("hasShownUnmutePopup", hasShownUnmutePopup);
        editor.putBoolean("hasMessagedFromAlert", hasMessagedFromAlert);
        editor.putBoolean("hasLinkSearched", hasLinkSearched);
        if (age != null) {
            editor.putString("age", age);
            if ("under_18".equals((Object)age) && teenTags != null && !teenTags.isEmpty()) {
                tags = teenTags;
                editor.putString("tags", DataUtil.toJson(tags));
            } else if (age != null && adultTags != null && !adultTags.isEmpty()) {
                tags = adultTags;
                editor.putString("tags", DataUtil.toJson(tags));
            }
        }
        if (nickname != null) {
            editor.putString("nickname", nickname);
        }
        editor.commit();
    }

    public static void setConfig(Map<String, Object> map) {
        config = new Config();
        config.setExperimentConfig(map);
    }

    public static void setFBInfo(AccessToken accessToken) {
        if (account != null) {
            AppState.account.have_fb = true;
        }
        fbInfo = new FacebookInfo();
        AppState.fbInfo.fbToken = accessToken;
        fbInfo.load();
    }

    public static void setFBInfo(AccessToken accessToken, FacebookInfo.LoadCallback loadCallback) {
        if (account != null) {
            AppState.account.have_fb = true;
        }
        fbInfo = new FacebookInfo();
        AppState.fbInfo.fbToken = accessToken;
        fbInfo.load(loadCallback);
    }

    public static void setOnboardingAdultTags(List<String> list) {
        adultTags = list;
    }

    public static void setOnboardingTags(Map<String, Object> map) {
        tags = (ArrayList)map.get((Object)"tags");
    }

    public static void setOnboardingTeenTags(List<String> list) {
        teenTags = list;
    }

}

