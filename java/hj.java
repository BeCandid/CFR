/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.FragmentManager
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 */
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.fragments.main_tabs.ActivityTabFragment;
import com.becandid.candid.fragments.main_tabs.FeedTabFragment;
import com.becandid.candid.fragments.main_tabs.GroupTabFragment;
import com.becandid.candid.fragments.main_tabs.MeTabFragment;
import com.becandid.candid.fragments.main_tabs.MessageTabFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class hj
extends hp {
    private int a = 5;
    private final List<String> b = new ArrayList();

    public hj(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public View a(int var1) {
        var2_2 = LayoutInflater.from((Context)GossipApplication.a().getApplicationContext()).inflate(2130968693, null);
        var3_3 = (ImageView)var2_2.findViewById(2131624522);
        var4_4 = (TextView)var2_2.findViewById(2131624523);
        switch (var1) {
            case 0: {
                var3_3.setImageResource(2130837716);
                var4_4.setTextColor(var2_2.getResources().getColor(2131558476));
                var2_2.findViewById(2131624521).setAlpha(1.0f);
                ** break;
            }
            case 1: {
                var3_3.setImageResource(2130838001);
                ** break;
            }
            case 3: {
                var3_3.setImageResource(2130838064);
            }
lbl15: // 4 sources:
            default: {
                ** GOTO lbl19
            }
            case 4: 
        }
        var3_3.setImageResource(2130838057);
lbl19: // 2 sources:
        var4_4.setText((CharSequence)this.b.get(var1));
        return var2_2;
    }

    public void a(List<String> list) {
        this.b.addAll(list);
    }

    public int getCount() {
        return this.a;
    }

    public Fragment getItem(int n2) {
        switch (n2) {
            default: {
                return null;
            }
            case 0: {
                return new FeedTabFragment();
            }
            case 1: {
                return new GroupTabFragment();
            }
            case 2: {
                return new Fragment();
            }
            case 3: {
                if (AppState.config.experimentConfig.containsKey((Object)"messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
                    return new MessageTabFragment();
                }
                return new MeTabFragment();
            }
            case 4: 
        }
        if (AppState.config.experimentConfig.containsKey((Object)"messaging_turned_on") && AppState.config.getBoolean("messaging_turned_on")) {
            return new MeTabFragment();
        }
        return new ActivityTabFragment();
    }
}

