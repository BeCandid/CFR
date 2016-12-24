/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.becandid.candid.data;

import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookInfo {
    public String age;
    public AccessToken fbToken;
    public List<String> friendIds;
    public List<String> jobIds;
    public List<String> schoolIds;

    private String parseFriends(JSONObject jSONObject) throws JSONException {
        String string2;
        JSONObject jSONObject2;
        JSONArray jSONArray = jSONObject.getJSONArray("data");
        if (this.friendIds == null) {
            this.friendIds = new ArrayList(jSONArray.length());
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
            this.friendIds.add((Object)jSONObject3.getString("id"));
        }
        if (jSONObject.has("paging") && jSONArray.length() > 20 && (jSONObject2 = jSONObject.getJSONObject("paging")).has("next") && (string2 = jSONObject2.getString("next")).contains((CharSequence)"/friends")) {
            return string2.substring(1 + string2.lastIndexOf("/", -1 + string2.indexOf("/friends")));
        }
        Log.d((String)"FBINFO", (String)("Friend ids: " + this.friendIds));
        return null;
    }

    private void parseJobs(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("work");
        this.jobIds = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            this.jobIds.add((Object)jSONObject2.getJSONObject("employer").getString("id"));
        }
        Log.d((String)"FBINFO", (String)("Jobs ids: " + this.jobIds));
    }

    private void parseSchools(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("education");
        this.schoolIds = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            this.schoolIds.add((Object)jSONObject2.getJSONObject("school").getString("id"));
        }
        Log.d((String)"FBINFO", (String)("School ids: " + this.schoolIds));
    }

    public void load() {
        this.load(null);
    }

    public void load(final LoadCallback loadCallback) {
        this.loadUserInfo(new LoadCallback(){

            @Override
            public void onNext(int n2) {
                apl.a(100, TimeUnit.MILLISECONDS).a(apv.a()).b(new apz<Long>(){

                    @Override
                    public void call(Long l2) {
                        FacebookInfo.this.loadFriends(loadCallback);
                    }
                });
            }

        });
    }

    public void loadFriends(LoadCallback loadCallback) {
        this.friendIds = null;
        this.loadFriends("me/friends", loadCallback);
    }

    public void loadFriends(String string2, final LoadCallback loadCallback) {
        if (this.fbToken == null) {
            return;
        }
        Log.d((String)"FBINFO", (String)("Loading url: " + string2));
        Bundle bundle = new Bundle();
        if (string2.contains((CharSequence)"?")) {
            String string3 = string2.substring(1 + string2.indexOf("?"));
            try {
                for (Map.Entry entry : iz.b(string3).entrySet()) {
                    bundle.putString((String)entry.getKey(), (String)entry.getValue());
                }
            }
            catch (UnsupportedEncodingException var10_7) {
                var10_7.printStackTrace();
            }
            string2 = string2.substring(0, string2.indexOf("?"));
        }
        AccessToken accessToken = this.fbToken;
        GraphRequest.b b2 = new GraphRequest.b(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void onCompleted(uo uo2) {
                JSONObject jSONObject = uo2.b();
                if (jSONObject != null) {
                    try {
                        String string2 = FacebookInfo.this.parseFriends(jSONObject);
                        if (string2 != null) {
                            FacebookInfo.this.loadFriends(string2, loadCallback);
                        } else if (loadCallback != null) {
                            loadCallback.onNext(FacebookInfo.this.friendIds.size());
                        }
                    }
                    catch (JSONException var3_4) {
                        var3_4.printStackTrace();
                    }
                    ix.a().a(new in.v());
                }
            }
        };
        GraphRequest graphRequest = new GraphRequest(accessToken, string2, null, null, b2);
        bundle.putString("limit", "100");
        bundle.putString("fields", "data,paging");
        graphRequest.a(bundle);
        graphRequest.j();
    }

    public void loadUserInfo(final LoadCallback loadCallback) {
        if (this.fbToken == null) {
            return;
        }
        GraphRequest graphRequest = GraphRequest.a(this.fbToken, new GraphRequest.c(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void onCompleted(JSONObject jSONObject, uo uo2) {
                if (jSONObject != null) {
                    Log.d((String)"FBINFO", (String)("Me response: " + (Object)jSONObject));
                    try {
                        FacebookInfo.this.parseJobs(jSONObject);
                    }
                    catch (JSONException var5_3) {
                        var5_3.printStackTrace();
                    }
                    try {
                        FacebookInfo.this.parseSchools(jSONObject);
                    }
                    catch (JSONException var6_4) {
                        var6_4.printStackTrace();
                    }
                    try {
                        FacebookInfo.this.age = jSONObject.getString("age_range");
                    }
                    catch (JSONException var7_5) {
                        var7_5.printStackTrace();
                    }
                } else {
                    Log.d((String)"FBINFO", (String)("Error getting /me: " + uo2.a()));
                }
                if (loadCallback != null) {
                    loadCallback.onNext(0);
                }
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields", "work,education,age_range,gender,hometown");
        graphRequest.a(bundle);
        graphRequest.j();
    }

    public static interface LoadCallback {
        public void onNext(int var1);
    }

}

