/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
public abstract class apr<T>
implements apm<T>,
aps {
    private static final Long NOT_SET = Long.MIN_VALUE;
    private apn producer;
    private long requested;
    private final apr<?> subscriber;
    private final aqz subscriptions;

    public apr() {
        this(null, false);
    }

    protected apr(apr<?> apr2) {
        super(apr2, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected apr(apr<?> apr2, boolean bl2) {
        this.requested = NOT_SET;
        this.subscriber = apr2;
        aqz aqz2 = bl2 && apr2 != null ? apr2.subscriptions : new aqz();
        this.subscriptions = aqz2;
    }

    private void addToRequested(long l2) {
        if (this.requested == NOT_SET) {
            this.requested = l2;
            return;
        }
        long l3 = l2 + this.requested;
        if (l3 < 0) {
            this.requested = Long.MAX_VALUE;
            return;
        }
        this.requested = l3;
    }

    public final void add(aps aps2) {
        this.subscriptions.a(aps2);
    }

    @Override
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void request(long l2) {
        if (l2 < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + l2);
        }
        void var5_2 = this;
        synchronized (var5_2) {
            if (this.producer != null) {
                apn apn2 = this.producer;
                // MONITOREXIT [3, 2] lbl7 : MonitorExitStatement: MONITOREXIT : var5_2
                apn2.a(l2);
                return;
            }
            super.addToRequested(l2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setProducer(apn apn2) {
        void var8_2 = this;
        synchronized (var8_2) {
            long l2 = this.requested;
            this.producer = apn2;
            apr apr2 = this.subscriber;
            boolean bl2 = false;
            if (apr2 != null) {
                long l3 = l2 LCMP NOT_SET;
                bl2 = false;
                if (l3 == false) {
                    bl2 = true;
                    // MONITOREXIT [6, 5, 2] lbl12 : MonitorExitStatement: MONITOREXIT : var8_2
                    if (bl2) {
                        this.subscriber.setProducer(this.producer);
                        return;
                    }
                }
            }
            if (l2 == NOT_SET) {
                this.producer.a(Long.MAX_VALUE);
                return;
            }
            this.producer.a(l2);
            return;
        }
    }

    @Override
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }
}

