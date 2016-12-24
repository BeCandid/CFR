/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.v4.app.Fragment
 *  android.support.v4.widget.SwipeRefreshLayout
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.becandid.candid.data.MessageThread;
import java.util.List;

public class hy
extends Fragment {
    protected View a;
    protected View b;
    protected RecyclerView c;
    protected hl d;
    protected SwipeRefreshLayout e;

    public void a() {
        if (this.d.d()) {
            this.c.setVisibility(0);
            this.b.setVisibility(8);
            return;
        }
        this.c.setVisibility(8);
        this.b.setVisibility(0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(int n2, String string2) {
        if (this.d.f()) {
            return;
        }
        int n3 = 0;
        while (n3 < this.d.getItemCount()) {
            MessageThread messageThread = this.d.b(n3);
            if (messageThread != null) {
                try {
                    if (messageThread.post_id == n2 && messageThread.other_user_post_name.equals((Object)string2)) {
                        this.d.c(n3);
                        return;
                    }
                }
                catch (NullPointerException var5_5) {
                    rk.c().a((ru)new ru("Display Messaging Thread").a("Thread", messageThread.toString()));
                }
            }
            ++n3;
        }
    }

    public void a(MessageThread messageThread) {
        if (this.d != null) {
            this.d.a(messageThread);
            this.a();
        }
    }

    public void a(String string2) {
        if (this.d != null) {
            this.d.a(string2);
        }
    }

    public void a(List<MessageThread> list) {
        if (this.d != null) {
            this.d.a(list);
        }
        this.e.setRefreshing(false);
    }

    public boolean a(in.ae ae2) {
        if (this.d != null) {
            return this.d.a(ae2);
        }
        return false;
    }

    public MessageThread b() {
        if (this.d != null) {
            return (MessageThread)this.d.b();
        }
        return null;
    }
}

