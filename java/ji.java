/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.GradientDrawable
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ji
extends jc {
    public TextView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public ImageView g;
    public TextView h;
    public ImageView i;
    public GradientDrawable j;
    public RelativeLayout k;
    public TextView l;
    public FrameLayout m;

    public ji(View view) {
        super(view);
        this.a = (TextView)view.findViewById(2131624603);
        this.b = (TextView)view.findViewById(2131624605);
        this.c = (ImageView)view.findViewById(2131624608);
        this.d = (TextView)view.findViewById(2131624609);
        this.g = (ImageView)view.findViewById(2131624602);
        this.h = (TextView)view.findViewById(2131624601);
        this.i = (ImageView)view.findViewById(2131624607);
        this.j = new GradientDrawable();
        this.k = (RelativeLayout)view.findViewById(2131624598);
        this.l = (TextView)view.findViewById(2131624610);
        this.m = (FrameLayout)view.findViewById(2131624606);
    }
}

