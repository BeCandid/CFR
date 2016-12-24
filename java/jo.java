/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Float
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  javax.xml.parsers.DocumentBuilder
 *  javax.xml.parsers.DocumentBuilderFactory
 *  javax.xml.parsers.ParserConfigurationException
 *  org.w3c.dom.Document
 *  org.w3c.dom.Element
 *  org.w3c.dom.NamedNodeMap
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 *  org.xml.sax.SAXException
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class jo {
    public static final String[] a;
    public static int b;
    public static Map<String, c> c;
    private static final String d;
    private static b e;

    static {
        d = null;
        a = new String[]{"TopLeft", "TopRight", "BottomRight", "BottomLeft"};
        b = 1234567;
        e = null;
    }

    public static int a(int n2, float f2) {
        int n3 = n2 & 255;
        int n4 = n2 & 255;
        return (int)(f2 * (float)(n2 & 255)) + ((int)(f2 * (float)n4) << 8) + ((int)(f2 * (float)n3) << 16);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(View view, String string2) {
        if (!(view instanceof ViewGroup)) {
            return 0;
        }
        if (!(view.getTag() instanceof a)) {
            return 0;
        }
        a a2 = (a)view.getTag();
        if (a2.a.containsKey((Object)string2)) return (Integer)a2.a.get((Object)string2);
        ViewGroup viewGroup = (ViewGroup)view;
        int n2 = 0;
        while (n2 < viewGroup.getChildCount()) {
            int n3 = jo.a(viewGroup.getChildAt(n2), string2);
            if (n3 != 0) return n3;
            ++n2;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static View a(Context context, InputStream inputStream, ViewGroup viewGroup) {
        View view;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        Document document = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
        try {
            view = jo.a(context, (Node)document.getDocumentElement(), viewGroup);
        }
        catch (Throwable var8_6) {
            try {
                inputStream.close();
                throw var8_6;
            }
            catch (IOException var5_7) {
                var5_7.printStackTrace();
                do {
                    return null;
                    break;
                } while (true);
            }
            catch (ParserConfigurationException var4_8) {
                var4_8.printStackTrace();
                return null;
            }
            catch (SAXException var3_9) {
                var3_9.printStackTrace();
                return null;
            }
        }
        inputStream.close();
        return view;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static View a(Context context, String string2) {
        try {
            if (string2.contains((CharSequence)".")) return (View)Class.forName((String)string2).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            string2 = "android.widget." + string2;
            return (View)Class.forName((String)string2).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        }
        catch (ClassNotFoundException var6_3) {
            var6_3.printStackTrace();
            do {
                return null;
                break;
            } while (true);
        }
        catch (NoSuchMethodException var5_4) {
            var5_4.printStackTrace();
            return null;
        }
        catch (InvocationTargetException var4_5) {
            var4_5.printStackTrace();
            return null;
        }
        catch (InstantiationException var3_6) {
            var3_6.printStackTrace();
            return null;
        }
        catch (IllegalAccessException var2_7) {
            var2_7.printStackTrace();
            return null;
        }
    }

    public static View a(Context context, String string2, ViewGroup viewGroup) {
        return jo.a(context, (InputStream)new ByteArrayInputStream(string2.getBytes()), viewGroup);
    }

    public static View a(Context context, Node node, ViewGroup viewGroup) {
        View view = jo.a(context, node.getNodeName());
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
        jo.a(view, jo.a(node), viewGroup);
        if (view instanceof ViewGroup && node.hasChildNodes()) {
            jo.b(context, node, (ViewGroup)view);
        }
        return view;
    }

    private static HashMap<String, String> a(Node node) {
        NamedNodeMap namedNodeMap = node.getAttributes();
        int n2 = namedNodeMap.getLength();
        HashMap hashMap = new HashMap(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Node node2 = namedNodeMap.item(i2);
            String string2 = node2.getNodeName();
            if (string2.startsWith("android:")) {
                string2 = string2.substring(8);
            }
            hashMap.put((Object)string2, (Object)node2.getNodeValue());
        }
        return hashMap;
    }

    private static a a(View view) {
        if (view.getTag() != null && view.getTag() instanceof a) {
            return (a)view.getTag();
        }
        a a2 = new a();
        view.setTag((Object)a2);
        return a2;
    }

    public static void a() {
        c = new HashMap(30);
        c.put((Object)"scaleType", (Object)new c(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void a(View var1_2, String var2_4, ViewGroup var3_3, Map<String, String> var4) {
                if (var1_2 instanceof ImageView == false) return;
                var5_5 = ((ImageView)var1_2).getScaleType();
                var6_6 = var2_4.toLowerCase();
                var7_7 = -1;
                switch (var6_6.hashCode()) {
                    case -1364013995: {
                        if (var6_6.equals((Object)"center")) {
                            var7_7 = 0;
                            ** break;
                        }
                        ** GOTO lbl39
                    }
                    case 1671566394: {
                        if (var6_6.equals((Object)"center_crop")) {
                            var7_7 = 1;
                            ** break;
                        }
                        ** GOTO lbl39
                    }
                    case 225732390: {
                        if (var6_6.equals((Object)"center_inside")) {
                            var7_7 = 2;
                            ** break;
                        }
                        ** GOTO lbl39
                    }
                    case -2021672893: {
                        if (var6_6.equals((Object)"fit_center")) {
                            var7_7 = 3;
                            ** break;
                        }
                        ** GOTO lbl39
                    }
                    case -847785043: {
                        if (var6_6.equals((Object)"fit_end")) {
                            var7_7 = 4;
                            ** break;
                        }
                        ** GOTO lbl39
                    }
                    case 1335468724: {
                        if (var6_6.equals((Object)"fit_start")) {
                            var7_7 = 5;
                            ** break;
                        }
                        ** GOTO lbl39
                    }
                    case -1274273297: {
                        if (var6_6.equals((Object)"fit_xy")) {
                            var7_7 = 6;
                        }
                    }
lbl39: // 16 sources:
                    default: {
                        ** GOTO lbl44
                    }
                    case -1081239615: 
                }
                if (var6_6.equals((Object)"matrix")) {
                    var7_7 = 7;
                }
lbl44: // 4 sources:
                switch (var7_7) {
                    case 0: {
                        var5_5 = ImageView.ScaleType.CENTER;
                        ** break;
                    }
                    case 1: {
                        var5_5 = ImageView.ScaleType.CENTER_CROP;
                        ** break;
                    }
                    case 2: {
                        var5_5 = ImageView.ScaleType.CENTER_INSIDE;
                        ** break;
                    }
                    case 3: {
                        var5_5 = ImageView.ScaleType.FIT_CENTER;
                        ** break;
                    }
                    case 4: {
                        var5_5 = ImageView.ScaleType.FIT_END;
                        ** break;
                    }
                    case 5: {
                        var5_5 = ImageView.ScaleType.FIT_START;
                        ** break;
                    }
                    case 6: {
                        var5_5 = ImageView.ScaleType.FIT_XY;
                    }
lbl65: // 8 sources:
                    default: {
                        ** GOTO lbl69
                    }
                    case 7: 
                }
                var5_5 = ImageView.ScaleType.MATRIX;
lbl69: // 2 sources:
                ((ImageView)var1_2).setScaleType(var5_5);
            }
        });
        c.put((Object)"orientation", (Object)new c(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout)view;
                    int n2 = string2.equals((Object)"vertical") ? 1 : 0;
                    linearLayout.setOrientation(n2);
                }
            }
        });
        c.put((Object)"text", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof TextView) {
                    ((TextView)view).setText((CharSequence)string2);
                }
            }
        });
        c.put((Object)"textSize", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof TextView) {
                    ((TextView)view).setTextSize(0, jn.b(string2, view.getResources().getDisplayMetrics()));
                }
            }
        });
        c.put((Object)"textColor", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof TextView) {
                    ((TextView)view).setTextColor(jo.b(view, string2));
                }
            }
        });
        c.put((Object)"textStyle", (Object)new c(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof TextView) {
                    int n2;
                    if (string2.contains((CharSequence)"bold")) {
                        n2 = false | true;
                    } else {
                        boolean bl2 = string2.contains((CharSequence)"italic");
                        n2 = 0;
                        if (bl2) {
                            n2 = 0 | 2;
                        }
                    }
                    ((TextView)view).setTypeface(null, n2);
                }
            }
        });
        c.put((Object)"textAlignment", (Object)new c(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void a(View var1_2, String var2_4, ViewGroup var3_3, Map<String, String> var4) {
                var5_5 = -1;
                if (Build.VERSION.SDK_INT <= 19) ** GOTO lbl37
                var8_6 = 2;
                switch (var2_4.hashCode()) {
                    case -1364013995: {
                        if (var2_4.equals((Object)"center")) {
                            var5_5 = 0;
                            ** break;
                        }
                        ** GOTO lbl23
                    }
                    case 3317767: {
                        if (var2_4.equals((Object)"left")) {
                            var5_5 = 1;
                            ** break;
                        }
                        ** GOTO lbl23
                    }
                    case -1048657099: {
                        if (var2_4.equals((Object)"textStart")) {
                            var5_5 = 2;
                            ** break;
                        }
                        ** GOTO lbl23
                    }
                    case 108511772: {
                        if (var2_4.equals((Object)"right")) {
                            var5_5 = 3;
                        }
                    }
lbl23: // 10 sources:
                    default: {
                        ** GOTO lbl28
                    }
                    case -1417863058: 
                }
                if (var2_4.equals((Object)"textEnd")) {
                    var5_5 = 4;
                }
lbl28: // 4 sources:
                switch (var5_5) {
                    case 0: {
                        var8_6 = 4;
                    }
                    default: {
                        break;
                    }
                    case 3: 
                    case 4: {
                        var8_6 = 3;
                    }
                }
                var1_2.setTextAlignment(var8_6);
                return;
lbl37: // 1 sources:
                var6_7 = 3;
                switch (var2_4.hashCode()) {
                    case -1364013995: {
                        if (!var2_4.equals((Object)"center")) ** GOTO lbl55
                        var7_8 = 0;
                        ** GOTO lbl62
                    }
                    case 3317767: {
                        if (!var2_4.equals((Object)"left")) ** GOTO lbl55
                        var7_8 = 1;
                        ** GOTO lbl62
                    }
                    case -1048657099: {
                        if (!var2_4.equals((Object)"textStart")) ** GOTO lbl55
                        var7_8 = 2;
                        ** GOTO lbl62
                    }
                    case 108511772: {
                        if (!var2_4.equals((Object)"right")) ** GOTO lbl55
                        var7_8 = 3;
                        ** GOTO lbl62
                    }
lbl55: // 5 sources:
                    default: {
                        ** GOTO lbl-1000
                    }
                    case -1417863058: 
                }
                if (var2_4.equals((Object)"textEnd")) {
                    var7_8 = 4;
                } else lbl-1000: // 2 sources:
                {
                    var7_8 = var5_5;
                }
lbl62: // 6 sources:
                switch (var7_8) {
                    case 0: {
                        var6_7 = 17;
                    }
                    default: {
                        break;
                    }
                    case 3: 
                    case 4: {
                        var6_7 = 5;
                    }
                }
                ((TextView)var1_2).setGravity(var6_7);
            }
        });
        c.put((Object)"ellipsize", (Object)new c(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void a(View var1_2, String var2_4, ViewGroup var3_3, Map<String, String> var4) {
                if (var1_2 instanceof TextView == false) return;
                var5_5 = TextUtils.TruncateAt.END;
                var6_6 = -1;
                switch (var2_4.hashCode()) {
                    case 109757538: {
                        if (var2_4.equals((Object)"start")) {
                            var6_6 = 0;
                            ** break;
                        }
                        ** GOTO lbl18
                    }
                    case -1074341483: {
                        if (var2_4.equals((Object)"middle")) {
                            var6_6 = 1;
                            ** break;
                        }
                        ** GOTO lbl18
                    }
                    case 839444514: {
                        if (var2_4.equals((Object)"marquee")) {
                            var6_6 = 2;
                        }
                    }
lbl18: // 8 sources:
                    default: {
                        ** GOTO lbl23
                    }
                    case 100571: 
                }
                if (var2_4.equals((Object)"end")) {
                    var6_6 = 3;
                }
lbl23: // 4 sources:
                switch (var6_6) {
                    case 0: {
                        var5_5 = TextUtils.TruncateAt.START;
                        ** break;
                    }
                    case 1: {
                        var5_5 = TextUtils.TruncateAt.MIDDLE;
                    }
lbl29: // 3 sources:
                    default: {
                        ** GOTO lbl33
                    }
                    case 2: 
                }
                var5_5 = TextUtils.TruncateAt.MARQUEE;
lbl33: // 2 sources:
                ((TextView)var1_2).setEllipsize(var5_5);
            }
        });
        c.put((Object)"singleLine", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof TextView) {
                    ((TextView)view).setSingleLine();
                }
            }
        });
        c.put((Object)"hint", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof EditText) {
                    ((EditText)view).setHint((CharSequence)string2);
                }
            }
        });
        c.put((Object)"inputType", (Object)new c(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public void a(View var1_2, String var2_4, ViewGroup var3_3, Map<String, String> var4) {
                if (var1_2 instanceof TextView == false) return;
                var5_5 = -1;
                switch (var2_4.hashCode()) {
                    case 1727340165: {
                        if (var2_4.equals((Object)"textEmailAddress")) {
                            var5_5 = 0;
                            ** break;
                        }
                        ** GOTO lbl12
                    }
                    case -1034364087: {
                        if (var2_4.equals((Object)"number")) {
                            var5_5 = 1;
                        }
                    }
lbl12: // 6 sources:
                    default: {
                        ** GOTO lbl17
                    }
                    case 106642798: 
                }
                if (var2_4.equals((Object)"phone")) {
                    var5_5 = 2;
                }
lbl17: // 4 sources:
                var6_6 = 0;
                switch (var5_5) {
                    case 0: {
                        var6_6 = 0 | 33;
                        ** break;
                    }
                    case 1: {
                        var6_6 = 0 | 2;
                    }
lbl24: // 3 sources:
                    default: {
                        ** GOTO lbl28
                    }
                    case 2: 
                }
                var6_6 = 0 | 3;
lbl28: // 2 sources:
                if (var6_6 <= 0) return;
                ((TextView)var1_2).setInputType(var6_6);
            }
        });
        c.put((Object)"gravity", (Object)new c(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                int n2 = jo.c(string2);
                if (view instanceof TextView) {
                    ((TextView)view).setGravity(n2);
                    return;
                } else {
                    if (view instanceof LinearLayout) {
                        ((LinearLayout)view).setGravity(n2);
                        return;
                    }
                    if (!(view instanceof RelativeLayout)) return;
                    {
                        ((RelativeLayout)view).setGravity(n2);
                        return;
                    }
                }
            }
        });
        c.put((Object)"src", (Object)new c(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (!(view instanceof ImageView)) return;
                {
                    String string3 = string2;
                    if (string3.startsWith("//")) {
                        string3 = "http:" + string3;
                    }
                    if (string3.startsWith("http")) {
                        if (e == null) return;
                        {
                            if (!map.containsKey((Object)"cornerRadius")) {
                                e.a((ImageView)view, string3);
                                return;
                            }
                            int n2 = jn.a((String)map.get((Object)"cornerRadius"), view.getResources().getDisplayMetrics());
                            e.a((ImageView)view, string3, n2);
                            return;
                        }
                    } else {
                        if (string3.startsWith("@drawable/")) {
                            String string4 = string3.substring("@drawable/".length());
                            ((ImageView)view).setImageDrawable(jo.c(view, string4));
                            return;
                        }
                        if (!string3.startsWith("@mipmap/")) return;
                        {
                            String string5 = string3.substring("@mipmap/".length());
                            ((ImageView)view).setImageDrawable(jo.d(view, string5));
                            return;
                        }
                    }
                }
            }
        });
        c.put((Object)"visibility", (Object)new c(){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                int n2;
                String string3 = string2.toLowerCase();
                if (string3.equals((Object)"gone")) {
                    n2 = 8;
                } else {
                    boolean bl2 = string3.equals((Object)"invisible");
                    n2 = 0;
                    if (bl2) {
                        n2 = 4;
                    }
                }
                view.setVisibility(n2);
            }
        });
        c.put((Object)"alpha", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                view.setAlpha(Float.valueOf((String)string2).floatValue());
            }
        });
        c.put((Object)"textAllCaps", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view instanceof TextView) {
                    ((TextView)view).setAllCaps(string2.equals((Object)"true"));
                }
            }
        });
        c.put((Object)"clickable", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                view.setClickable(string2.equals((Object)"true"));
            }
        });
        c.put((Object)"tag", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (view.getTag() == null) {
                    view.setTag((Object)string2);
                }
            }
        });
        c.put((Object)"onClick", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                view.setOnClickListener(jo.b(viewGroup, string2));
            }
        });
        c.put((Object)"elevation", (Object)new c(){

            @Override
            public void a(View view, String string2, ViewGroup viewGroup, Map<String, String> map) {
                if (Build.VERSION.SDK_INT >= 21) {
                    view.setElevation((float)jn.a(string2, view.getResources().getDisplayMetrics()));
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(View view, Object object) {
        a a2;
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            a2 = new a();
            view.setTag((Object)a2);
        } else {
            a2 = (a)view.getTag();
        }
        a2.b = object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"NewApi"})
    private static void a(View var0_1, Map<String, String> var1, ViewGroup var2_2) {
        if (jo.c == null) {
            jo.a();
        }
        var3_3 = var0_1.getLayoutParams();
        var4_4 = 0;
        var5_5 = 0;
        var6_6 = 0;
        var7_7 = 0;
        var8_8 = 0;
        var9_9 = 0;
        var10_10 = 0;
        var11_11 = 0;
        var12_12 = false;
        var13_13 = false;
        for (Map.Entry var40_29 : var1.entrySet()) {
            var41_18 = (String)var40_29.getKey();
            if (jo.c.containsKey((Object)var41_18)) {
                ((c)jo.c.get((Object)var41_18)).a(var0_1, (String)var40_29.getValue(), var2_2, var1);
                continue;
            }
            if (var41_18.startsWith("cornerRadius")) {
                var12_12 = true;
                if (!var41_18.equals((Object)"cornerRadius")) {
                    var13_13 = true;
                    continue;
                }
                var13_13 = false;
                continue;
            }
            var42_20 = -999;
            var43_27 = -1;
            switch (var41_18.hashCode()) {
                case 3355: {
                    if (!var41_18.equals((Object)"id")) break;
                    var43_27 = 0;
                    break;
                }
                case 113126854: {
                    if (!var41_18.equals((Object)"width")) break;
                    var43_27 = 1;
                    break;
                }
                case -2062351247: {
                    if (!var41_18.equals((Object)"layout_width")) break;
                    var43_27 = 2;
                    break;
                }
                case -1221029593: {
                    if (!var41_18.equals((Object)"height")) break;
                    var43_27 = 3;
                    break;
                }
                case 58626012: {
                    if (!var41_18.equals((Object)"layout_height")) break;
                    var43_27 = 4;
                    break;
                }
                case 1295141433: {
                    if (!var41_18.equals((Object)"layout_gravity")) break;
                    var43_27 = 5;
                    break;
                }
                case 488063277: {
                    if (!var41_18.equals((Object)"layout_weight")) break;
                    var43_27 = 6;
                    break;
                }
                case -2081856804: {
                    if (!var41_18.equals((Object)"layout_below")) break;
                    var43_27 = 7;
                    break;
                }
                case -2082866616: {
                    if (!var41_18.equals((Object)"layout_above")) break;
                    var43_27 = 8;
                    break;
                }
                case -603137010: {
                    if (!var41_18.equals((Object)"layout_toLeftOf")) break;
                    var43_27 = 9;
                    break;
                }
                case -372205757: {
                    if (!var41_18.equals((Object)"layout_toRightOf")) break;
                    var43_27 = 10;
                    break;
                }
                case -2116816901: {
                    if (!var41_18.equals((Object)"layout_alignBottom")) break;
                    var43_27 = 11;
                    break;
                }
                case -1187005051: {
                    if (!var41_18.equals((Object)"layout_alignTop")) break;
                    var43_27 = 12;
                    break;
                }
                case 1857300951: {
                    if (!var41_18.equals((Object)"layout_alignLeft")) break;
                    var43_27 = 13;
                    break;
                }
                case 1748661394: {
                    if (!var41_18.equals((Object)"layout_alignStart")) break;
                    var43_27 = 14;
                    break;
                }
                case 1747415628: {
                    if (!var41_18.equals((Object)"layout_alignRight")) break;
                    var43_27 = 15;
                    break;
                }
                case -1187019509: {
                    if (!var41_18.equals((Object)"layout_alignEnd")) break;
                    var43_27 = 16;
                    break;
                }
                case -1768054459: {
                    if (!var41_18.equals((Object)"layout_alignParentBottom")) break;
                    var43_27 = 17;
                    break;
                }
                case 543334523: {
                    if (!var41_18.equals((Object)"layout_alignParentTop")) break;
                    var43_27 = 18;
                    break;
                }
                case -336747103: {
                    if (!var41_18.equals((Object)"layout_alignParentLeft")) break;
                    var43_27 = 19;
                    break;
                }
                case -1842318840: {
                    if (!var41_18.equals((Object)"layout_alignParentStart")) break;
                    var43_27 = 20;
                    break;
                }
                case -1843564606: {
                    if (!var41_18.equals((Object)"layout_alignParentRight")) break;
                    var43_27 = 21;
                    break;
                }
                case 543320065: {
                    if (!var41_18.equals((Object)"layout_alignParentEnd")) break;
                    var43_27 = 22;
                    break;
                }
                case -1725075762: {
                    if (!var41_18.equals((Object)"layout_centerHorizontal")) break;
                    var43_27 = 23;
                    break;
                }
                case 524348576: {
                    if (!var41_18.equals((Object)"layout_centerVertical")) break;
                    var43_27 = 24;
                    break;
                }
                case 2044548953: {
                    if (!var41_18.equals((Object)"layout_centerInParent")) break;
                    var43_27 = 25;
                    break;
                }
                case 198345827: {
                    if (!var41_18.equals((Object)"layout_margin")) break;
                    var43_27 = 26;
                    break;
                }
                case 478654218: {
                    if (!var41_18.equals((Object)"layout_marginLeft")) break;
                    var43_27 = 27;
                    break;
                }
                case -954382862: {
                    if (!var41_18.equals((Object)"layout_marginTop")) break;
                    var43_27 = 28;
                    break;
                }
                case 1959039865: {
                    if (!var41_18.equals((Object)"layout_marginRight")) break;
                    var43_27 = 29;
                    break;
                }
                case 148567150: {
                    if (!var41_18.equals((Object)"layout_marginBottom")) break;
                    var43_27 = 30;
                    break;
                }
                case -806339567: {
                    if (!var41_18.equals((Object)"padding")) break;
                    var43_27 = 31;
                    break;
                }
                case -1501175880: {
                    if (!var41_18.equals((Object)"paddingLeft")) break;
                    var43_27 = 32;
                    break;
                }
                case 90130308: {
                    if (!var41_18.equals((Object)"paddingTop")) break;
                    var43_27 = 33;
                    break;
                }
                case 713848971: {
                    if (!var41_18.equals((Object)"paddingRight")) break;
                    var43_27 = 34;
                    break;
                }
                case 202355100: {
                    if (!var41_18.equals((Object)"paddingBottom")) break;
                    var43_27 = 35;
                    break;
                }
            }
            var44_25 = false;
            block38 : switch (var43_27) {
                case 0: {
                    var52_21 = jo.b((String)var40_29.getValue());
                    var44_25 = false;
                    if (var2_2 != null) {
                        var53_16 = jo.a((View)var2_2);
                        var54_19 = jo.b;
                        jo.b = var54_19 + 1;
                        var0_1.setId(var54_19);
                        var53_16.a.put((Object)var52_21, (Object)var54_19);
                        var44_25 = false;
                        break;
                    }
                    break;
                }
                case 1: 
                case 2: {
                    var50_17 = (String)var40_29.getValue();
                    switch (var50_17.hashCode()) {
                        case 343327108: {
                            if (!var50_17.equals((Object)"wrap_content")) ** GOTO lbl198
                            var51_23 = 0;
                            ** GOTO lbl205
                        }
                        case 1261922022: {
                            if (!var50_17.equals((Object)"fill_parent")) ** GOTO lbl198
                            var51_23 = 1;
                            ** GOTO lbl205
                        }
lbl198: // 3 sources:
                        default: {
                            ** GOTO lbl-1000
                        }
                        case 1386124388: 
                    }
                    if (var50_17.equals((Object)"match_parent")) {
                        var51_23 = 2;
                    } else lbl-1000: // 2 sources:
                    {
                        var51_23 = -1;
                    }
lbl205: // 4 sources:
                    switch (var51_23) {
                        default: {
                            var3_3.width = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics(), var2_2, true);
                            var44_25 = false;
                            break block38;
                        }
                        case 0: {
                            var3_3.width = -2;
                            var44_25 = false;
                            break block38;
                        }
                        case 1: 
                        case 2: 
                    }
                    var3_3.width = -1;
                    var44_25 = false;
                    break;
                }
                case 3: 
                case 4: {
                    var48_28 = (String)var40_29.getValue();
                    switch (var48_28.hashCode()) {
                        case 343327108: {
                            if (!var48_28.equals((Object)"wrap_content")) ** GOTO lbl229
                            var49_24 = 0;
                            ** GOTO lbl236
                        }
                        case 1261922022: {
                            if (!var48_28.equals((Object)"fill_parent")) ** GOTO lbl229
                            var49_24 = 1;
                            ** GOTO lbl236
                        }
lbl229: // 3 sources:
                        default: {
                            ** GOTO lbl-1000
                        }
                        case 1386124388: 
                    }
                    if (var48_28.equals((Object)"match_parent")) {
                        var49_24 = 2;
                    } else lbl-1000: // 2 sources:
                    {
                        var49_24 = -1;
                    }
lbl236: // 4 sources:
                    switch (var49_24) {
                        default: {
                            var3_3.height = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics(), var2_2, false);
                            var44_25 = false;
                            break block38;
                        }
                        case 0: {
                            var3_3.height = -2;
                            var44_25 = false;
                            break block38;
                        }
                        case 1: 
                        case 2: 
                    }
                    var3_3.height = -1;
                    var44_25 = false;
                    break;
                }
                case 5: {
                    if (var2_2 != null && var2_2 instanceof LinearLayout) {
                        ((LinearLayout.LayoutParams)var3_3).gravity = jo.c((String)var40_29.getValue());
                        var44_25 = false;
                        break;
                    }
                    var44_25 = false;
                    if (var2_2 != null) {
                        var47_26 = var2_2 instanceof FrameLayout;
                        var44_25 = false;
                        if (var47_26) {
                            ((FrameLayout.LayoutParams)var3_3).gravity = jo.c((String)var40_29.getValue());
                            var44_25 = false;
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    var44_25 = false;
                    if (var2_2 != null) {
                        var46_22 = var2_2 instanceof LinearLayout;
                        var44_25 = false;
                        if (var46_22) {
                            ((LinearLayout.LayoutParams)var3_3).weight = Float.parseFloat((String)((String)var40_29.getValue()));
                            var44_25 = false;
                            break;
                        }
                    }
                    break;
                }
                case 7: {
                    var42_20 = 3;
                    var44_25 = true;
                    break;
                }
                case 8: {
                    var42_20 = 2;
                    var44_25 = true;
                    break;
                }
                case 9: {
                    var44_25 = true;
                    var42_20 = 0;
                    break;
                }
                case 10: {
                    var42_20 = 1;
                    var44_25 = true;
                    break;
                }
                case 11: {
                    var42_20 = 8;
                    var44_25 = true;
                    break;
                }
                case 12: {
                    var42_20 = 6;
                    var44_25 = true;
                    break;
                }
                case 13: 
                case 14: {
                    var42_20 = 5;
                    var44_25 = true;
                    break;
                }
                case 15: 
                case 16: {
                    var42_20 = 7;
                    var44_25 = true;
                    break;
                }
                case 17: {
                    var42_20 = 12;
                    var44_25 = false;
                    break;
                }
                case 18: {
                    var42_20 = 10;
                    var44_25 = false;
                    break;
                }
                case 19: 
                case 20: {
                    var42_20 = 9;
                    var44_25 = false;
                    break;
                }
                case 21: 
                case 22: {
                    var42_20 = 11;
                    var44_25 = false;
                    break;
                }
                case 23: {
                    var42_20 = 14;
                    var44_25 = false;
                    break;
                }
                case 24: {
                    var42_20 = 15;
                    var44_25 = false;
                    break;
                }
                case 25: {
                    var42_20 = 13;
                    var44_25 = false;
                    break;
                }
                case 26: {
                    var6_6 = var7_7 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics());
                    var5_5 = var7_7;
                    var4_4 = var7_7;
                    var44_25 = false;
                    break;
                }
                case 27: {
                    var4_4 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics(), var2_2, true);
                    var44_25 = false;
                    break;
                }
                case 28: {
                    var6_6 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics(), var2_2, false);
                    var44_25 = false;
                    break;
                }
                case 29: {
                    var5_5 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics(), var2_2, true);
                    var44_25 = false;
                    break;
                }
                case 30: {
                    var7_7 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics(), var2_2, false);
                    var44_25 = false;
                    break;
                }
                case 31: {
                    var9_9 = var10_10 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics());
                    var8_8 = var10_10;
                    var11_11 = var10_10;
                    var44_25 = false;
                    break;
                }
                case 32: {
                    var8_8 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics());
                    var44_25 = false;
                    break;
                }
                case 33: {
                    var10_10 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics());
                    var44_25 = false;
                    break;
                }
                case 34: {
                    var9_9 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics());
                    var44_25 = false;
                    break;
                }
                case 35: {
                    var11_11 = jn.a((String)var40_29.getValue(), var0_1.getResources().getDisplayMetrics());
                    var44_25 = false;
                }
            }
            if (var42_20 == -999 || !(var2_2 instanceof RelativeLayout)) continue;
            if (var44_25) {
                var45_15 = jo.a((View)var2_2, jo.b((String)var40_29.getValue()));
                ((RelativeLayout.LayoutParams)var3_3).addRule(var42_20, var45_15);
                continue;
            }
            if (!((String)var40_29.getValue()).equals((Object)"true")) continue;
            ((RelativeLayout.LayoutParams)var3_3).addRule(var42_20);
        }
        if (var1.containsKey((Object)"background") || var1.containsKey((Object)"borderColor")) {
            var15_30 = var1.containsKey((Object)"background") != false ? (String)var1.get((Object)"background") : null;
            if (var15_30 != null && var15_30.startsWith("@drawable/")) {
                var0_1.setBackground(jo.c(var0_1, var15_30));
            } else if (var15_30 == null || var15_30.startsWith("#") || var15_30.startsWith("@color")) {
                if (var0_1 instanceof Button || var1.containsKey((Object)"pressedColor")) {
                    if (var15_30 == null) {
                        var15_30 = "#00000000";
                    }
                    var16_31 = jo.b(var0_1, var15_30);
                    var17_32 = var1.containsKey((Object)"pressedColor") != false ? jo.b(var0_1, (String)var1.get((Object)"pressedColor")) : jo.a(var16_31, 0.9f);
                    var18_33 = new GradientDrawable();
                    var18_33.setColor(var16_31);
                    var19_34 = new GradientDrawable();
                    var19_34.setColor(var17_32);
                    if (var13_13) {
                        var24_35 = new float[8];
                        for (var25_36 = 0; var25_36 < (var26_38 = jo.a.length); ++var25_36) {
                            var27_41 = jo.a[var25_36];
                            if (var1.containsKey((Object)("cornerRadius" + var27_41))) {
                                var28_37 = var25_36 * 2;
                                var29_40 = 1 + var25_36 * 2;
                                var24_35[var29_40] = var30_39 = jn.b((String)var1.get((Object)("cornerRadius" + var27_41)), var0_1.getResources().getDisplayMetrics());
                                var24_35[var28_37] = var30_39;
                            }
                            var18_33.setCornerRadii(var24_35);
                            var19_34.setCornerRadii(var24_35);
                        }
                    } else if (var12_12) {
                        var23_42 = jn.b((String)var1.get((Object)"cornerRadius"), var0_1.getResources().getDisplayMetrics());
                        var18_33.setCornerRadius(var23_42);
                        var19_34.setCornerRadius(var23_42);
                    }
                    if (var1.containsKey((Object)"borderColor")) {
                        var21_43 = "1dp";
                        if (var1.containsKey((Object)"borderWidth")) {
                            var21_43 = (String)var1.get((Object)"borderWidth");
                        }
                        var22_44 = jn.a(var21_43, var0_1.getResources().getDisplayMetrics());
                        var18_33.setStroke(var22_44, jo.b(var0_1, (String)var1.get((Object)"borderColor")));
                        var19_34.setStroke(var22_44, jo.b(var0_1, (String)var1.get((Object)"borderColor")));
                    }
                    var20_45 = new StateListDrawable();
                    var20_45.addState(new int[]{16842919}, (Drawable)var19_34);
                    var20_45.addState(new int[0], (Drawable)var18_33);
                    var0_1.setBackground((Drawable)var20_45);
                    jo.a((View)var0_1).c = var18_33;
                } else if (var12_12 || var1.containsKey((Object)"borderColor")) {
                    var31_46 = new GradientDrawable();
                    if (var15_30 == null) {
                        var15_30 = "#00000000";
                    }
                    var31_46.setColor(jo.b(var0_1, var15_30));
                    if (var13_13) {
                        var33_47 = new float[8];
                        for (var34_48 = 0; var34_48 < (var35_53 = jo.a.length); ++var34_48) {
                            var36_50 = jo.a[var34_48];
                            if (var1.containsKey((Object)("cornerRadius" + var36_50))) {
                                var37_49 = var34_48 * 2;
                                var38_52 = 1 + var34_48 * 2;
                                var33_47[var38_52] = var39_51 = jn.b((String)var1.get((Object)("cornerRadius" + var36_50)), var0_1.getResources().getDisplayMetrics());
                                var33_47[var37_49] = var39_51;
                            }
                            var31_46.setCornerRadii(var33_47);
                        }
                    } else if (var12_12) {
                        var31_46.setCornerRadius(jn.b((String)var1.get((Object)"cornerRadius"), var0_1.getResources().getDisplayMetrics()));
                    }
                    if (var1.containsKey((Object)"borderColor")) {
                        var32_54 = "1dp";
                        if (var1.containsKey((Object)"borderWidth")) {
                            var32_54 = (String)var1.get((Object)"borderWidth");
                        }
                        var31_46.setStroke(jn.a(var32_54, var0_1.getResources().getDisplayMetrics()), jo.b(var0_1, (String)var1.get((Object)"borderColor")));
                    }
                    var0_1.setBackground((Drawable)var31_46);
                    jo.a((View)var0_1).c = var31_46;
                } else {
                    var0_1.setBackgroundColor(jo.b(var0_1, var15_30));
                }
            }
        }
        if (var3_3 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)var3_3).setMargins(var4_4, var6_6, var5_5, var7_7);
        }
        var0_1.setPadding(var8_8, var10_10, var9_9, var11_11);
        var0_1.setLayoutParams(var3_3);
    }

    public static int b(View view, String string2) {
        if (string2.startsWith("@color/")) {
            Resources resources = view.getResources();
            return resources.getColor(resources.getIdentifier(string2.substring("@color/".length()), "color", view.getContext().getPackageName()));
        }
        if (string2.length() == 4 && string2.startsWith("#")) {
            string2 = "#" + string2.charAt(1) + string2.charAt(1) + string2.charAt(2) + string2.charAt(2) + string2.charAt(3) + string2.charAt(3);
        }
        return Color.parseColor((String)string2);
    }

    private static View.OnClickListener b(final ViewGroup viewGroup, final String string2) {
        return new View.OnClickListener(){

            /*
             * Exception decompiling
             */
            private void a(Object var1_1, String var2_4, boolean var3_3, View var4) {
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
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
                // org.benf.cfr.reader.Main.doJar(Main.java:128)
                // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
                // java.lang.Thread.run(Thread.java:818)
                throw new IllegalStateException("Decompilation failed");
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void onClick(View view) {
                a a2 = null;
                for (ViewGroup viewGroup2 = viewGroup; viewGroup2 != null; viewGroup2 = (ViewGroup)viewGroup2.getParent()) {
                    if (viewGroup2.getParent() instanceof ViewGroup) {
                        if (viewGroup2.getTag() == null || !(viewGroup2.getTag() instanceof a)) continue;
                        a2 = (a)viewGroup2.getTag();
                        if (a2.b == null) continue;
                    }
                    if (a2 == null || a2.b == null) break;
                    super.a(a2.b, string2, false, view);
                    return;
                }
                Log.e((String)"DynamicLayoutInflator", (String)("Unable to find valid delegate for click named " + string2));
            }
        };
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String b(String string2) {
        if (string2.startsWith("@+id/")) {
            return string2.substring(5);
        }
        if (!string2.startsWith("@id/")) return string2;
        return string2.substring(4);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void b(Context context, Node node, ViewGroup viewGroup) {
        NodeList nodeList = node.getChildNodes();
        int n2 = 0;
        while (n2 < nodeList.getLength()) {
            Node node2 = nodeList.item(n2);
            if (node2.getNodeType() == 1) {
                jo.a(context, node2, viewGroup);
            }
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static int c(String var0) {
        var1_1 = 0;
        var2_2 = var0.toLowerCase().split("[|]");
        var3_3 = var2_2.length;
        var4_4 = 0;
        while (var4_4 < var3_3) {
            var5_5 = var2_2[var4_4];
            var6_6 = -1;
            switch (var5_5.hashCode()) {
                case -1364013995: {
                    if (var5_5.equals((Object)"center")) {
                        var6_6 = 0;
                        ** break;
                    }
                    ** GOTO lbl47
                }
                case 3317767: {
                    if (var5_5.equals((Object)"left")) {
                        var6_6 = 1;
                        ** break;
                    }
                    ** GOTO lbl47
                }
                case -1048657099: {
                    if (var5_5.equals((Object)"textStart")) {
                        var6_6 = 2;
                        ** break;
                    }
                    ** GOTO lbl47
                }
                case 108511772: {
                    if (var5_5.equals((Object)"right")) {
                        var6_6 = 3;
                        ** break;
                    }
                    ** GOTO lbl47
                }
                case -1417863058: {
                    if (var5_5.equals((Object)"textEnd")) {
                        var6_6 = 4;
                        ** break;
                    }
                    ** GOTO lbl47
                }
                case 115029: {
                    if (var5_5.equals((Object)"top")) {
                        var6_6 = 5;
                        ** break;
                    }
                    ** GOTO lbl47
                }
                case -1383228885: {
                    if (var5_5.equals((Object)"bottom")) {
                        var6_6 = 6;
                        ** break;
                    }
                    ** GOTO lbl47
                }
                case 1063616078: {
                    if (var5_5.equals((Object)"center_horizontal")) {
                        var6_6 = 7;
                    }
                }
lbl47: // 18 sources:
                default: {
                    ** GOTO lbl52
                }
                case -348726240: 
            }
            if (var5_5.equals((Object)"center_vertical")) {
                var6_6 = 8;
            }
lbl52: // 4 sources:
            switch (var6_6) {
                case 0: {
                    var1_1 |= 17;
                    ** break;
                }
                case 1: 
                case 2: {
                    var1_1 |= 3;
                    ** break;
                }
                case 3: 
                case 4: {
                    var1_1 |= 5;
                    ** break;
                }
                case 5: {
                    var1_1 |= 48;
                    ** break;
                }
                case 6: {
                    var1_1 |= 80;
                    ** break;
                }
                case 7: {
                    var1_1 |= 1;
                }
lbl70: // 7 sources:
                default: {
                    ** GOTO lbl74
                }
                case 8: 
            }
            var1_1 |= 16;
lbl74: // 2 sources:
            ++var4_4;
        }
        return var1_1;
    }

    public static Drawable c(View view, String string2) {
        Resources resources = view.getResources();
        return resources.getDrawable(resources.getIdentifier(string2, "drawable", view.getContext().getPackageName()));
    }

    public static Drawable d(View view, String string2) {
        Resources resources = view.getResources();
        return resources.getDrawable(resources.getIdentifier(string2, "mipmap", view.getContext().getPackageName()));
    }

    public static class a {
        public HashMap<String, Integer> a = new HashMap();
        public Object b;
        public GradientDrawable c;
    }

    public static interface b {
        public void a(ImageView var1, String var2);

        public void a(ImageView var1, String var2, int var3);
    }

    public static interface c {
        public void a(View var1, String var2, ViewGroup var3, Map<String, String> var4);
    }

}

