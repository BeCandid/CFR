/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$ViewHolder
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MessageActivity;
import com.becandid.candid.data.Message;
import com.becandid.candid.data.User;
import com.becandid.candid.views.viewholders.MessagePostViewHolder;
import com.becandid.candid.views.viewholders.MessagesHeaderViewHolder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class hm
extends hd<Message> {
    private Context d;
    private User e;
    private User f;

    public hm(Context context) {
        this.d = context;
        aps aps2 = ix.a().a(in.aj.class, new apr<in.aj>(){

            public void a(in.aj aj2) {
                int n2 = hm.this.a.indexOf((Object)aj2.a);
                hm.this.a.remove((Object)aj2.a);
                hm.this.notifyItemRemoved(n2);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
                rj.a(throwable);
            }

            @Override
            public /* synthetic */ void onNext(Object object) {
                this.a((in.aj)object);
            }
        });
        ((BaseActivity)context).addToSubscriptionList(aps2);
    }

    public void a(int n2, List<Message> list) {
        this.a.addAll(n2, list);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(long l2, boolean bl2, boolean bl3, Message message) {
        int n2 = 0;
        while (n2 < this.a.size()) {
            Message message2 = (Message)this.a.get(n2);
            if (message2.messageTempId == l2) {
                if (bl2 && message != null) {
                    this.a.set(n2, (Object)message);
                } else {
                    if (bl3) {
                        this.a.remove(n2);
                        this.notifyItemRemoved(n2);
                        return;
                    }
                    message2.failedSend = true;
                    this.a.set(n2, (Object)message2);
                }
                this.notifyItemChanged(n2);
            }
            ++n2;
        }
    }

    @Override
    public void a(Message message) {
        this.a.add((Object)message);
        this.notifyItemInserted(-1 + this.a.size());
    }

    @Override
    public void a(User user) {
        this.e = user;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(jc jc2, int n2) {
        Message message = (Message)this.a.get(n2);
        if (jc2 instanceof jh) {
            jh jh2 = (jh)jc2;
            Message message2 = null;
            if (n2 >= 1) {
                message2 = (Message)this.a.get(n2 - 1);
            }
            if (this.e == null) return;
            {
                if (message.sent_time != 0 && (message2 == null || message.sent_time - message2.sent_time >= 6000)) {
                    jh.a(jh2, message, message2, this.f, this.e, true, this.d, (hm)this);
                    return;
                }
                jh.a(jh2, message, message2, this.f, this.e, false, this.d, (hm)this);
                return;
            }
        }
        if (jc2 instanceof MessagePostViewHolder) {
            MessagePostViewHolder.a((MessagePostViewHolder)jc2, message);
            return;
        }
        if (!(jc2 instanceof MessagesHeaderViewHolder)) {
            return;
        }
        MessagesHeaderViewHolder.a((MessagesHeaderViewHolder)jc2, this.f);
    }

    @Override
    public jc b(ViewGroup viewGroup, int n2) {
        switch (n2) {
            default: {
                return null;
            }
            case 0: {
                return new jh(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968699, viewGroup, false), 0);
            }
            case 1: {
                return new jh(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968698, viewGroup, false), 1);
            }
            case 2: {
                return new MessagePostViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968664, viewGroup, false), (Activity)((MessageActivity)this.d));
            }
            case 3: 
        }
        return new MessagesHeaderViewHolder(LayoutInflater.from((Context)viewGroup.getContext()).inflate(2130968701, viewGroup, false));
    }

    public void b(User user) {
        this.f = user;
    }

    public boolean b(int n2) {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (n2 != ((Message)iterator.next()).message_id) continue;
            return true;
        }
        return false;
    }

    public void c(List<Message> list) {
        this.a.addAll(0, list);
        this.notifyItemRangeInserted(0, list.size());
    }

    @Override
    public int getItemViewType(int n2) {
        Message message = (Message)this.a.get(n2);
        if (message.messagePost) {
            return 2;
        }
        if (message.messageHeader) {
            return 3;
        }
        if (message.sender.equals((Object)"self")) {
            return 0;
        }
        if (message.sender.equals((Object)"other")) {
            return 1;
        }
        return -1;
    }

    @Override
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n2) {
        this.a((jc)viewHolder, n2);
    }

    @Override
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return this.b(viewGroup, n2);
    }

}

