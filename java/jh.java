/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Color
 *  android.graphics.Point
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Environment
 *  android.support.v7.app.AlertDialog
 *  android.support.v7.app.AlertDialog$Builder
 *  android.support.v7.widget.PopupMenu
 *  android.support.v7.widget.PopupMenu$OnMenuItemClickListener
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.StateSet
 *  android.view.Display
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Map
 *  rx.schedulers.Schedulers
 */
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.StateSet;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.becandid.candid.GossipApplication;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.FullScreenImageActivity;
import com.becandid.candid.data.AppState;
import com.becandid.candid.data.Config;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;
import com.becandid.candid.models.EmptySubscriber;
import com.becandid.candid.models.NetworkData;
import com.becandid.candid.util.RoundedCornersTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import rx.schedulers.Schedulers;

public class jh
extends jc {
    public static io o;
    public RelativeLayout a;
    public TextView b;
    public TextView c;
    public LinearLayout d;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public int l;
    public View m;
    public View n;

    public jh(View view, int n2) {
        super(view);
        o = io.a();
        this.l = n2;
        this.c = (TextView)view.findViewById(2131624532);
        this.g = (TextView)view.findViewById(2131624541);
        this.h = (ImageView)view.findViewById(2131624536);
        this.i = (ImageView)view.findViewById(2131624537);
        this.j = (TextView)view.findViewById(2131624538);
        this.d = (LinearLayout)view.findViewById(2131624535);
        this.m = view.findViewById(2131624539);
        this.n = view.findViewById(2131624540);
        if (n2 == 0) {
            this.k = (TextView)view.findViewById(2131624542);
            return;
        }
        this.a = (RelativeLayout)view.findViewById(2131624533);
        this.b = (TextView)view.findViewById(2131624534);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(final jh jh2, final Message message, Message message2, User user, final User user2, boolean bl2, final Context context, final hm hm2) {
        if (bl2) {
            jh2.c.setVisibility(0);
            jh2.c.setText((CharSequence)ip.a(message.sent_time));
        } else {
            jh2.c.setVisibility(8);
        }
        jh2.i.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(context, (Class)FullScreenImageActivity.class);
                intent.putExtra("source_url", message.source_url);
                context.startActivity(intent);
            }
        });
        switch (jh2.l) {
            case 0: {
                GradientDrawable gradientDrawable = (GradientDrawable)context.getResources().getDrawable(2130838059).mutate();
                gradientDrawable.setColor(context.getResources().getColor(2131558476));
                GradientDrawable gradientDrawable2 = (GradientDrawable)context.getResources().getDrawable(2130838059).mutate();
                gradientDrawable2.setColor(context.getResources().getColor(2131558477));
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, (Drawable)gradientDrawable2);
                stateListDrawable.addState(StateSet.WILD_CARD, (Drawable)gradientDrawable);
                jh2.g.setBackground((Drawable)stateListDrawable);
                if (message.failedSend) {
                    jh2.k.setVisibility(0);
                    jh2.i.setOnClickListener(new View.OnClickListener(){

                        public void onClick(View view) {
                            jh2.g.setEnabled(false);
                            jh2.i.setEnabled(false);
                            jh2.h.setEnabled(false);
                            if (message.params != null) {
                                ik.a().o(message.params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                                    /*
                                     * Enabled aggressive block sorting
                                     */
                                    public void a(NetworkData networkData) {
                                        if (networkData != null && !networkData.success) {
                                            Toast.makeText((Context)context, (CharSequence)networkData.error, (int)1).show();
                                            if (!networkData.error.contains((CharSequence)"blocked") && !networkData.error.contains((CharSequence)"disabled")) {
                                                hm2.a(message.messageTempId, false, false, null);
                                                jh2.g.setEnabled(true);
                                                jh2.i.setEnabled(true);
                                                jh2.h.setEnabled(true);
                                                return;
                                            }
                                            hm2.a(message.messageTempId, false, true, null);
                                            return;
                                        } else {
                                            if (networkData == null || networkData.message == null) return;
                                            {
                                                hm2.a(message.messageTempId, true, false, networkData.message);
                                                return;
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCompleted() {
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                        Log.d((String)"AddMessage", (String)throwable.toString());
                                        Toast.makeText((Context)context, (CharSequence)throwable.toString(), (int)1).show();
                                        hm2.a(message.messageTempId, false, false, null);
                                    }

                                    @Override
                                    public /* synthetic */ void onNext(Object object) {
                                        this.a((NetworkData)object);
                                    }
                                });
                            }
                        }

                    });
                    jh2.g.setOnClickListener(new View.OnClickListener(){

                        public void onClick(View view) {
                            jh2.g.setEnabled(false);
                            jh2.i.setEnabled(false);
                            jh2.h.setEnabled(false);
                            if (message.params != null) {
                                ik.a().o(message.params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                                    /*
                                     * Enabled aggressive block sorting
                                     */
                                    public void a(NetworkData networkData) {
                                        if (networkData != null && !networkData.success) {
                                            Toast.makeText((Context)context, (CharSequence)networkData.error, (int)1).show();
                                            if (!networkData.error.contains((CharSequence)"blocked") && !networkData.error.contains((CharSequence)"disabled")) {
                                                hm2.a(message.messageTempId, false, false, null);
                                                jh2.g.setEnabled(true);
                                                jh2.i.setEnabled(true);
                                                jh2.h.setEnabled(true);
                                                return;
                                            }
                                            hm2.a(message.messageTempId, false, true, null);
                                            return;
                                        } else {
                                            if (networkData == null || networkData.message == null) return;
                                            {
                                                hm2.a(message.messageTempId, true, false, networkData.message);
                                                return;
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCompleted() {
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                        Log.d((String)"AddMessage", (String)throwable.toString());
                                        Toast.makeText((Context)context, (CharSequence)throwable.toString(), (int)1).show();
                                        hm2.a(message.messageTempId, false, false, null);
                                    }

                                    @Override
                                    public /* synthetic */ void onNext(Object object) {
                                        this.a((NetworkData)object);
                                    }
                                });
                            }
                        }

                    });
                    jh2.h.setOnClickListener(new View.OnClickListener(){

                        public void onClick(View view) {
                            jh2.g.setEnabled(false);
                            jh2.i.setEnabled(false);
                            jh2.h.setEnabled(false);
                            if (message.params != null) {
                                ik.a().o(message.params).b(Schedulers.io()).a(apv.a()).b(new apr<NetworkData>(){

                                    /*
                                     * Enabled aggressive block sorting
                                     */
                                    public void a(NetworkData networkData) {
                                        if (networkData != null && !networkData.success) {
                                            Toast.makeText((Context)context, (CharSequence)networkData.error, (int)1).show();
                                            if (!networkData.error.contains((CharSequence)"blocked") && !networkData.error.contains((CharSequence)"disabled")) {
                                                hm2.a(message.messageTempId, false, false, null);
                                                jh2.g.setEnabled(true);
                                                jh2.i.setEnabled(true);
                                                jh2.h.setEnabled(true);
                                                return;
                                            }
                                            hm2.a(message.messageTempId, false, true, null);
                                            return;
                                        } else {
                                            if (networkData == null || networkData.message == null) return;
                                            {
                                                hm2.a(message.messageTempId, true, false, networkData.message);
                                                return;
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCompleted() {
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                        Log.d((String)"AddMessage", (String)throwable.toString());
                                        Toast.makeText((Context)context, (CharSequence)throwable.toString(), (int)1).show();
                                        hm2.a(message.messageTempId, false, false, null);
                                    }

                                    @Override
                                    public /* synthetic */ void onNext(Object object) {
                                        this.a((NetworkData)object);
                                    }
                                });
                            }
                        }

                    });
                } else {
                    jh2.k.setVisibility(8);
                }
                jh2.i.setOnLongClickListener(new View.OnLongClickListener(){

                    public boolean onLongClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(context, view);
                        popupMenu.setOnMenuItemClickListener(jh.b(message, context, user2));
                        popupMenu.getMenu().add(1, 2131624852, 0, 2131230875);
                        popupMenu.show();
                        return false;
                    }
                });
                jh2.g.setOnLongClickListener(new View.OnLongClickListener(){

                    public boolean onLongClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(context, view);
                        popupMenu.setOnMenuItemClickListener(jh.b(message, context, user2));
                        popupMenu.getMenu().add(1, 2131624851, 0, 2131230873);
                        popupMenu.show();
                        return false;
                    }
                });
                break;
            }
            case 1: {
                GradientDrawable gradientDrawable = (GradientDrawable)context.getResources().getDrawable(2130838059).mutate();
                int n2 = Color.parseColor((String)"#DDDDDD");
                gradientDrawable.setColor(n2);
                GradientDrawable gradientDrawable3 = (GradientDrawable)context.getResources().getDrawable(2130838059).mutate();
                gradientDrawable3.setColor(-7829368 & n2);
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, (Drawable)gradientDrawable3);
                stateListDrawable.addState(StateSet.WILD_CARD, (Drawable)gradientDrawable);
                jh2.g.setBackground((Drawable)stateListDrawable);
                if (message2 == null || message2.sender.equals((Object)"self") || bl2) {
                    jh2.b.setVisibility(0);
                    int n3 = Color.parseColor((String)user2.icon_color);
                    jh2.b.setTextColor(n3);
                    TextView textView = jh2.b;
                    textView.setTypeface(io.b());
                    TextView textView2 = jh2.b;
                    textView2.setText((CharSequence)io.a(user2.icon_name));
                    int n4 = jh2.a.getWidth();
                    if (n4 == 0) {
                        n4 = (int)(30.0f * context.getResources().getDisplayMetrics().density);
                    }
                    int n5 = 1073741824 | 16777215 & n3;
                    GradientDrawable gradientDrawable4 = new GradientDrawable();
                    gradientDrawable4.setColor(n5);
                    gradientDrawable4.setCornerRadius((float)(n4 / 2));
                    jh2.a.setBackground((Drawable)gradientDrawable4);
                } else {
                    jh2.b.setVisibility(8);
                    jh2.a.setBackground(null);
                }
                jh2.i.setOnLongClickListener(new View.OnLongClickListener(){

                    public boolean onLongClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(context, view);
                        popupMenu.setOnMenuItemClickListener(jh.b(message, context, user2));
                        popupMenu.getMenu().add(1, 2131624852, 0, 2131230875);
                        popupMenu.getMenu().add(1, 2131624853, 0, 2131230874);
                        popupMenu.show();
                        return false;
                    }
                });
                jh2.g.setOnLongClickListener(new View.OnLongClickListener(){

                    public boolean onLongClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(context, view);
                        popupMenu.setOnMenuItemClickListener(jh.b(message, context, user2));
                        popupMenu.getMenu().add(1, 2131624851, 0, 2131230873);
                        popupMenu.getMenu().add(1, 2131624853, 0, 2131230874);
                        popupMenu.show();
                        return false;
                    }
                });
            }
        }
        if (message.message == null || message.message.equals((Object)"")) {
            jh2.g.setVisibility(8);
        } else {
            jh2.g.setVisibility(0);
            jh2.g.setText((CharSequence)message.message);
        }
        if (message.source_url != null) {
            jh2.i.setVisibility(0);
            if (message.uploaded == 0 && AppState.config.getInt("android_msg_image_upload", 1) == 1) {
                jh2.j.setVisibility(0);
            } else {
                jh2.j.setVisibility(8);
            }
            Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int n6 = point.x;
            float f2 = context.getResources().getDisplayMetrics().density;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n6 / 2, (int)(0.05f + f2 * (float)message.image_height));
            layoutParams.setMargins(0, jb.a(3, context), 0, jb.a(3, context));
            jh2.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            if (AppState.config.getInt("android_enable_image_progress") == 1) {
                is.a(jh2.n, jh2.m, jh2.f, layoutParams.width, 80, message.source_url, jh2.i, null, 0, true);
            } else {
                jh2.i.setBackgroundResource(17301613);
                ju<String> ju2 = GossipApplication.c.a(message.source_url);
                kr[] arrkr = new kr[]{new RoundedCornersTransformation(context, jb.a(10, context), 0)};
                ju2.a(arrkr).a(new qf<String, oh>(){

                    public boolean a(Exception exception, String string2, qy<oh> qy2, boolean bl2) {
                        return false;
                    }

                    public boolean a(oh oh2, String string2, qy<oh> qy2, boolean bl2, boolean bl3) {
                        jh2.i.setBackground(null);
                        return false;
                    }

                    @Override
                    public /* synthetic */ boolean onException(Exception exception, Object object, qy qy2, boolean bl2) {
                        return this.a(exception, (String)object, qy2, bl2);
                    }

                    @Override
                    public /* synthetic */ boolean onResourceReady(Object object, Object object2, qy qy2, boolean bl2, boolean bl3) {
                        return this.a((oh)((Object)object), (String)object2, qy2, bl2, bl3);
                    }
                }).a((String)DiskCacheStrategy.c).a(jh2.i);
            }
        } else {
            jh2.i.setVisibility(8);
            jh2.j.setVisibility(8);
            jh2.m.setVisibility(8);
        }
        if (message.sticker_name != null) {
            int n7 = GossipApplication.a.getResources().getIdentifier(message.sticker_name.toLowerCase(), "drawable", GossipApplication.a.getPackageName());
            jh2.h.setImageDrawable(GossipApplication.a.getResources().getDrawable(n7));
            jh2.h.setVisibility(0);
            return;
        }
        jh2.h.setVisibility(8);
    }

    private static PopupMenu.OnMenuItemClickListener b(final Message message, final Context context, final User user) {
        return new PopupMenu.OnMenuItemClickListener(){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public boolean onMenuItemClick(MenuItem var1) {
                switch (var1.getItemId()) {
                    case 2131624852: {
                        GossipApplication.c.a(message.source_url).j().a(new qf<String, Bitmap>(){

                            /*
                             * Enabled force condition propagation
                             * Lifted jumps to return sites
                             */
                            public boolean a(Bitmap bitmap, String string2, qy<Bitmap> qy2, boolean bl2, boolean bl3) {
                                File file = new File((Object)Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Candid" + File.separator);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                String string3 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                                File file2 = new File(file, string3 + ".png");
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)fileOutputStream);
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    Toast.makeText((Context)context, (CharSequence)"Image saved", (int)1).show();
                                    do {
                                        return false;
                                        break;
                                    } while (true);
                                }
                                catch (Exception var10_10) {
                                    Log.d((String)"FullscreenImage", (String)var10_10.toString());
                                    Toast.makeText((Context)context, (CharSequence)"An error occured. Please try again later.", (int)1).show();
                                    return false;
                                }
                            }

                            public boolean a(Exception exception, String string2, qy<Bitmap> qy2, boolean bl2) {
                                return false;
                            }

                            @Override
                            public /* synthetic */ boolean onException(Exception exception, Object object, qy qy2, boolean bl2) {
                                return this.a(exception, (String)object, qy2, bl2);
                            }

                            @Override
                            public /* synthetic */ boolean onResourceReady(Object object, Object object2, qy qy2, boolean bl2, boolean bl3) {
                                return this.a((Bitmap)object, (String)object2, qy2, bl2, bl3);
                            }
                        });
                        ** break;
                    }
                    case 2131624851: {
                        ((ClipboardManager)context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)"Candid Message", (CharSequence)message.message));
                    }
lbl7: // 3 sources:
                    default: {
                        return false;
                    }
                    case 2131624853: 
                }
                var2_2 = new int[]{-1};
                var3_3 = new String[]{context.getString(2131230893), context.getString(2131230928), context.getString(2131230855)};
                var4_4 = new String[]{"nsfw", "spam", "hate"};
                var5_5 = new AlertDialog.Builder(context);
                var5_5.setTitle((CharSequence)context.getString(2131230951)).setSingleChoiceItems(var3_3, -1, new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        var2_2[0] = n2;
                        ((AlertDialog)dialogInterface).getButton(-1).setEnabled(true);
                    }
                }).setPositiveButton(2131230895, new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialogInterface, int n2) {
                        if (var2_2[0] < 0) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put((Object)"message_id", (Object)Integer.toString((int)message.message_id));
                        hashMap.put((Object)"reason", (Object)var4_4[var2_2[0]]);
                        ik.a().q((Map<String, String>)hashMap).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put((Object)"post_id", (Object)Integer.toString((int)message.post_id));
                        hashMap2.put((Object)"post_name", (Object)user.post_name);
                        ik.a().s((Map<String, String>)hashMap2).b(Schedulers.io()).a(apv.a()).b(new EmptySubscriber());
                        ix.a().a(new in.j(message.post_id, user.post_name));
                        ((BaseActivity)context).finish();
                    }
                }).setNegativeButton((CharSequence)"Cancel", null);
                var7_6 = var5_5.create();
                var7_6.setOnShowListener(new DialogInterface.OnShowListener(){

                    public void onShow(DialogInterface dialogInterface) {
                        if (var2_2[0] < 0) {
                            ((AlertDialog)dialogInterface).getButton(-1).setEnabled(false);
                        }
                    }
                });
                var7_6.show();
                return true;
            }

        };
    }

}

