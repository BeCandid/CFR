/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.MeSettingsActivity;
import com.becandid.candid.activities.WebViewActivity;
import java.util.List;

public class hk
extends hd<MeSettingsActivity.Setting> {
    private Context d;

    public hk(List<MeSettingsActivity.Setting> list, Context context) {
        this.a = list;
        this.d = context;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public jf a(ViewGroup viewGroup, int n2) {
        View view;
        if (n2 == 0) {
            view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968696, viewGroup, false);
            do {
                return new jf(view);
                break;
            } while (true);
        }
        view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968697, viewGroup, false);
        return new jf(view);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(jc jc2, int n2) {
        jf jf2 = (jf)jc2;
        final MeSettingsActivity.Setting setting = (MeSettingsActivity.Setting)this.a.get(n2);
        if (setting instanceof MeSettingsActivity.WebViewSetting) {
            jf2.c.setVisibility(0);
            jf2.a.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent(hk.this.d, (Class)WebViewActivity.class);
                    intent.putExtra("url", GossipApplication.d + ((MeSettingsActivity.WebViewSetting)setting).url);
                    hk.this.d.startActivity(intent);
                }
            });
        } else if (setting instanceof MeSettingsActivity.ActivitySetting) {
            jf2.c.setVisibility(0);
            jf2.a.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Intent intent = new Intent(hk.this.d, ((MeSettingsActivity.ActivitySetting)setting).toStart);
                    if (((MeSettingsActivity.ActivitySetting)setting).bundle != null) {
                        intent.putExtras(((MeSettingsActivity.ActivitySetting)setting).bundle);
                    }
                    hk.this.d.startActivity(intent);
                }
            });
        } else if (setting.name.equals((Object)"Disown Permanently")) {
            jf2.c.setVisibility(8);
            jf2.b.setTextColor(this.d.getResources().getColor(2131558513));
            jf2.a.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    new AlertDialog.Builder(hk.this.d).setIconAttribute(16843605).setTitle((CharSequence)"Disown this account?").setMessage((CharSequence)"Once you disconnect you can never log in to this account again.").setPositiveButton((CharSequence)"Yes", new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            dialogInterface.dismiss();
                            ((MeSettingsActivity)hk.this.d).disownAccount();
                        }
                    }).setNegativeButton((CharSequence)"No", null).show();
                }

            });
        }
        jf2.b.setText((CharSequence)setting.name);
    }

    @Override
    public /* synthetic */ jc b(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

    @Override
    public int getItemViewType(int n2) {
        return ((MeSettingsActivity.Setting)this.a.get((int)n2)).type;
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((jc)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

}

