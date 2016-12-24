/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 */
package okhttp3.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.framed.Header;
import okhttp3.internal.framed.Spdy3;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.InflaterSource;
import okio.Okio;
import okio.Source;

class NameValueBlockReader {
    private int compressedLimit;
    private final InflaterSource inflaterSource;
    private final BufferedSource source;

    public NameValueBlockReader(BufferedSource bufferedSource) {
        this.inflaterSource = new InflaterSource(new ForwardingSource(bufferedSource){

            @Override
            public long read(Buffer buffer, long l2) throws IOException {
                if (NameValueBlockReader.this.compressedLimit == 0) {
                    return -1;
                }
                long l3 = super.read(buffer, Math.min((long)l2, (long)NameValueBlockReader.this.compressedLimit));
                if (l3 == -1) {
                    return -1;
                }
                NameValueBlockReader.this.compressedLimit = (int)((long)NameValueBlockReader.this.compressedLimit - l3);
                return l3;
            }
        }, new Inflater(){

            public int inflate(byte[] arrby, int n2, int n3) throws DataFormatException {
                int n4 = super.inflate(arrby, n2, n3);
                if (n4 == 0 && this.needsDictionary()) {
                    this.setDictionary(Spdy3.DICTIONARY);
                    n4 = super.inflate(arrby, n2, n3);
                }
                return n4;
            }
        });
        this.source = Okio.buffer(this.inflaterSource);
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit > 0) {
            this.inflaterSource.refill();
            if (this.compressedLimit != 0) {
                throw new IOException("compressedLimit > 0: " + this.compressedLimit);
            }
        }
    }

    private ByteString readByteString() throws IOException {
        int n2 = this.source.readInt();
        return this.source.readByteString(n2);
    }

    public void close() throws IOException {
        this.source.close();
    }

    public List<Header> readNameValueBlock(int n2) throws IOException {
        this.compressedLimit = n2 + this.compressedLimit;
        int n3 = this.source.readInt();
        if (n3 < 0) {
            throw new IOException("numberOfPairs < 0: " + n3);
        }
        if (n3 > 1024) {
            throw new IOException("numberOfPairs > 1024: " + n3);
        }
        ArrayList arrayList = new ArrayList(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            ByteString byteString = super.readByteString().toAsciiLowercase();
            ByteString byteString2 = super.readByteString();
            if (byteString.size() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add((Object)new Header(byteString, byteString2));
        }
        super.doneReading();
        return arrayList;
    }

}

