/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.util.Log
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package com.becandid.candid.services;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.becandid.candid.activities.GroupDetailsActivity;
import com.becandid.candid.activities.MainTabsActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.activities.PostDetailsActivity;
import com.becandid.candid.data.DataUtil;
import java.io.Serializable;
import java.util.Set;

public class PushNotificationReceiver
extends BroadcastReceiver {
    private Context a;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private PendingIntent a(Bundle var1, String var2_2) {
        if (!var1.containsKey("notification_type")) {
            return null;
        }
        var3_3 = var1.getString("notification_type", "");
        var4_4 = -1;
        switch (var3_3.hashCode()) {
            case -2059463938: {
                if (var3_3.equals((Object)"new_post_friend")) {
                    var4_4 = 0;
                    ** break;
                }
                ** GOTO lbl49
            }
            case -641874555: {
                if (var3_3.equals((Object)"new_post_trending")) {
                    var4_4 = 1;
                    ** break;
                }
                ** GOTO lbl49
            }
            case 205758144: {
                if (var3_3.equals((Object)"new_comment")) {
                    var4_4 = 2;
                    ** break;
                }
                ** GOTO lbl49
            }
            case -72322863: {
                if (var3_3.equals((Object)"new_comment_other")) {
                    var4_4 = 3;
                    ** break;
                }
                ** GOTO lbl49
            }
            case -163723192: {
                if (var3_3.equals((Object)"like_post")) {
                    var4_4 = 4;
                    ** break;
                }
                ** GOTO lbl49
            }
            case -1348026953: {
                if (var3_3.equals((Object)"like_comment")) {
                    var4_4 = 5;
                    ** break;
                }
                ** GOTO lbl49
            }
            case -242382124: {
                if (var3_3.equals((Object)"group_invite_friend")) {
                    var4_4 = 6;
                    ** break;
                }
                ** GOTO lbl49
            }
            case -1659251239: {
                if (var3_3.equals((Object)"friend_signup")) {
                    var4_4 = 7;
                    ** break;
                }
                ** GOTO lbl49
            }
            case -877257620: {
                if (var3_3.equals((Object)"new_post_small_groups")) {
                    var4_4 = 8;
                }
            }
lbl49: // 20 sources:
            default: {
                ** GOTO lbl54
            }
            case 954925063: 
        }
        if (var3_3.equals((Object)"message")) {
            var4_4 = 9;
        }
lbl54: // 4 sources:
        switch (var4_4) {
            default: {
                if (!var1.containsKey("post_id")) break;
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                ** GOTO lbl112
            }
            case 0: {
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                ** GOTO lbl112
            }
            case 1: {
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                ** GOTO lbl112
            }
            case 2: {
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                var5_5.putExtra("scrollToBottom", true);
                var5_5.putExtra("comment_id", (Serializable)Integer.valueOf((String)var1.getString("comment_id")));
                ** GOTO lbl112
            }
            case 3: {
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                var5_5.putExtra("scrollToBottom", true);
                var5_5.putExtra("comment_id", (Serializable)Integer.valueOf((String)var1.getString("comment_id")));
                ** GOTO lbl112
            }
            case 4: {
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                ** GOTO lbl112
            }
            case 5: {
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                var5_5.putExtra("scrollToBottom", true);
                var5_5.putExtra("comment_id", (Serializable)Integer.valueOf((String)var1.getString("comment_id")));
                ** GOTO lbl112
            }
            case 6: {
                var5_5 = new Intent(this.a, (Class)GroupDetailsActivity.class);
                var11_6 = new aio().a(var1.getString("group")).m();
                var5_5.putExtra("group_id", var11_6.b("group_id").g());
                var5_5.putExtra("group_name", var11_6.b("group_name").c());
                ** GOTO lbl112
            }
            case 7: {
                var5_5 = new Intent(this.a, (Class)MainTabsActivity.class);
                var5_5.putExtra("selected_tab", "me");
                ** GOTO lbl112
            }
            case 8: {
                var5_5 = new Intent(this.a, (Class)PostDetailsActivity.class);
                var5_5.putExtra("post_id", (Serializable)Integer.valueOf((String)var1.getString("post_id")));
                ** GOTO lbl112
            }
            case 9: {
                var5_5 = new Intent(this.a, (Class)MessageActivity.class);
                var5_5.putExtra("post_id", var1.getString("post_id"));
                if (var1.getString("user_info") != null) {
                    var5_5.putExtra("user_name", (String)DataUtil.toMap(var1.getString("user_info")).get((Object)"post_name"));
                }
                ** GOTO lbl112
            }
        }
        var5_5 = new Intent(this.a, (Class)MainTabsActivity.class);
        var5_5.putExtra("selected_tab", "feed");
lbl112: // 12 sources:
        if (var1.containsKey("orig_notification_id") == false) return PendingIntent.getActivity((Context)this.a, (int)Integer.parseInt((String)var2_2), (Intent)var5_5, (int)134217728);
        var5_5.putExtra("click_notification", var1.getString("orig_notification_id"));
        return PendingIntent.getActivity((Context)this.a, (int)Integer.parseInt((String)var2_2), (Intent)var5_5, (int)134217728);
    }

    /*
     * Exception decompiling
     */
    private void a(String var1_4, String var2_5, String var3_2, String var4_3, Bundle var5_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Bundle bundle) {
        if (bundle != null) {
            for (String string2 : bundle.keySet()) {
                Object object = bundle.get(string2);
                if (object == null) continue;
                Object[] arrobject = new Object[]{string2, object.toString(), object.getClass().getName()};
                Log.d((String)"PushNotificationPayload", (String)String.format((String)"%s %s (%s)", (Object[])arrobject));
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void onReceive(Context var1, Intent var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }
}

