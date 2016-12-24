/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.List
 *  java.util.Locale
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

public class akm
extends BaseAdapter {
    List<akp> a;
    LayoutInflater b;
    private Context c;

    public akm(Context context, List<akp> list) {
        this.c = context;
        this.a = list;
        this.b = (LayoutInflater)this.c.getSystemService("layout_inflater");
    }

    private int a(String string2) {
        try {
            int n2 = akl.b.class.getField(string2).getInt((Object)null);
            return n2;
        }
        catch (Exception var2_3) {
            Log.e((String)"CountryCodePicker", (String)"Failure to get drawable id.", (Throwable)var2_3);
            return -1;
        }
    }

    public int getCount() {
        return this.a.size();
    }

    public Object getItem(int n2) {
        return null;
    }

    public long getItemId(int n2) {
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public View getView(int n2, View view, ViewGroup viewGroup) {
        a a2;
        View view2 = view;
        akp akp2 = (akp)this.a.get(n2);
        if (view == null) {
            a2 = new a();
            view2 = this.b.inflate(akl.d.row, null);
            a2.a = (TextView)view2.findViewById(akl.c.row_title);
            a2.b = (ImageView)view2.findViewById(akl.c.row_icon);
            view2.setTag((Object)a2);
        } else {
            a2 = (a)view2.getTag();
        }
        a2.a.setText((CharSequence)akp2.c());
        int n3 = super.a("flag_" + akp2.b().toLowerCase(Locale.ENGLISH));
        akp2.a(n3);
        a2.b.setImageResource(n3);
        return view2;
    }

    static class a {
        public TextView a;
        public ImageView b;

        a() {
        }
    }

}

