/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.System
 */
package okio;

import okio.SegmentPool;

final class Segment {
    static final int SIZE = 2048;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[2048];
        this.owner = true;
        this.shared = false;
    }

    Segment(Segment segment) {
        super(segment.data, segment.pos, segment.limit);
        segment.shared = true;
    }

    Segment(byte[] arrby, int n2, int n3) {
        this.data = arrby;
        this.pos = n2;
        this.limit = n3;
        this.owner = false;
        this.shared = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void compact() {
        if (this.prev == this) {
            throw new IllegalStateException();
        }
        if (!this.prev.owner) {
            return;
        }
        int n2 = this.limit - this.pos;
        int n3 = 2048 - this.prev.limit;
        int n4 = this.prev.shared ? 0 : this.prev.pos;
        if (n2 > n3 + n4) return;
        this.writeTo(this.prev, n2);
        this.pop();
        SegmentPool.recycle(this);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Segment pop() {
        Segment segment = this.next != this ? this.next : null;
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public Segment split(int n2) {
        if (n2 <= 0 || n2 > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        Segment segment = new Segment((Segment)this);
        segment.limit = n2 + segment.pos;
        this.pos = n2 + this.pos;
        this.prev.push(segment);
        return segment;
    }

    public void writeTo(Segment segment, int n2) {
        if (!segment.owner) {
            throw new IllegalArgumentException();
        }
        if (n2 + segment.limit > 2048) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            if (n2 + segment.limit - segment.pos > 2048) {
                throw new IllegalArgumentException();
            }
            System.arraycopy((Object)segment.data, (int)segment.pos, (Object)segment.data, (int)0, (int)(segment.limit - segment.pos));
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        System.arraycopy((Object)this.data, (int)this.pos, (Object)segment.data, (int)segment.limit, (int)n2);
        segment.limit = n2 + segment.limit;
        this.pos = n2 + this.pos;
    }
}

