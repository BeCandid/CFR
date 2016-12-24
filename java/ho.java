/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 */
import android.content.Context;
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
import com.becandid.candid.data.Group;
import com.becandid.candid.util.RoundedCornersTransformation;
import java.util.Iterator;
import java.util.List;

public class ho
extends hd<Group> {
    private Context d;
    private RoundedCornersTransformation e;

    public ho(Context context) {
        this.d = context;
        float f2 = this.d.getResources().getDisplayMetrics().density;
        this.e = new RoundedCornersTransformation(this.d, (int)(10.0f * f2), 0, RoundedCornersTransformation.CornerType.f);
    }

    public a a(ViewGroup viewGroup, int n2) {
        return new a(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968742, viewGroup, false));
    }

    @Override
    public void a(Group group) {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (((Group)iterator.next()).group_id != group.group_id) continue;
            return;
        }
        this.a.add(0, (Object)group);
        this.notifyDataSetChanged();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(jc jc2, int n2) {
        Group group = (Group)this.a.get(n2);
        a a2 = (a)jc2;
        a2.b.setText((CharSequence)group.group_name);
        a2.c.setText((CharSequence)("" + group.num_members + " members"));
        TextView textView = a2.d;
        int n3 = group.moderator == 1 ? 0 : 8;
        textView.setVisibility(n3);
        jt<int> jt2 = GossipApplication.c.a(group.imageUrl()).a().a((String)((int)17301613));
        kr[] arrkr = new kr[]{this.e};
        jt2.a(arrkr).a(a2.a);
    }

    public Group b(int n2) {
        if (n2 < this.a.size() && n2 >= 0) {
            return (Group)this.a.get(n2);
        }
        return null;
    }

    @Override
    public /* synthetic */ jc b(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void c(int n2) {
        int n3 = 0;
        while (n3 < this.a.size()) {
            if (((Group)this.a.get((int)n3)).group_id == n2) {
                this.a.remove(n3);
                this.notifyDataSetChanged();
                return;
            }
            ++n3;
        }
    }

    @Override
    public int getItemCount() {
        return this.a.size();
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((jc)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.a(viewGroup, n2);
    }

    public static class a
    extends jc {
        ImageView a;
        TextView b;
        TextView c;
        TextView d;

        public a(View view) {
            super(view);
            this.a = (ImageView)view.findViewById(2131624379);
            this.b = (TextView)view.findViewById(2131624110);
            this.c = (TextView)view.findViewById(2131624807);
            this.d = (TextView)view.findViewById(2131624808);
        }
    }

}

