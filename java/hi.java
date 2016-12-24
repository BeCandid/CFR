/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$Adapter
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.LinkSearchActivity;
import com.becandid.candid.activities.WebViewActivity;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.becandid.candid.views.viewholders.LinkSearchViewholder;
import java.util.List;

public class hi
extends RecyclerView.Adapter<LinkSearchViewholder> {
    private List<LinkSearchActivity.LinkSearchResult> a;
    private RoundedCornersTransformation b;
    private Activity c;

    public hi(List<LinkSearchActivity.LinkSearchResult> list, Activity activity) {
        this.a = list;
        this.c = activity;
        this.b = new RoundedCornersTransformation((Context)activity, (int)(10.0f * activity.getResources().getDisplayMetrics().density), 0, RoundedCornersTransformation.CornerType.a);
    }

    public LinkSearchViewholder a(ViewGroup viewGroup, int n2) {
        return new LinkSearchViewholder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968692, viewGroup, false));
    }

    public void a(LinkSearchViewholder linkSearchViewholder, int n2) {
        final LinkSearchActivity.LinkSearchResult linkSearchResult = (LinkSearchActivity.LinkSearchResult)this.a.get(n2);
        linkSearchViewholder.linkTitle.setText((CharSequence)linkSearchResult.title);
        linkSearchViewholder.linkDesc.setText((CharSequence)linkSearchResult.description);
        linkSearchViewholder.linkHost.setText((CharSequence)linkSearchResult.host);
        jt<int> jt2 = GossipApplication.c.a(linkSearchResult.source_url).a().a((String)((int)17301613));
        kr[] arrkr = new kr[]{this.b};
        jt2.a(arrkr).a(linkSearchViewholder.linkImage);
        linkSearchViewholder.itemView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent((Context)hi.this.c, (Class)WebViewActivity.class);
                intent.putExtra("title", "Web Result");
                intent.putExtra("url", linkSearchResult.final_link_url);
                intent.putExtra("show_copy_link", true);
                hi.this.c.startActivity(intent);
            }
        });
        linkSearchViewholder.linkSearchResultIcon.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                in.z z2 = new in.z(linkSearchResult.final_link_url);
                ix.a().a(z2);
                hi.this.c.finish();
            }
        });
    }

    public int getItemCount() {
        return this.a.size();
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((LinkSearchViewholder)viewHolder, n2);
    }

    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

}

