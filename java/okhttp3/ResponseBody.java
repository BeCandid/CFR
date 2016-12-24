/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

public abstract class ResponseBody
implements Closeable {
    private Reader reader;

    private Charset charset() {
        MediaType mediaType = this.contentType();
        if (mediaType != null) {
            return mediaType.charset(Util.UTF_8);
        }
        return Util.UTF_8;
    }

    public static ResponseBody create(final MediaType mediaType, final long l2, final BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        return new ResponseBody(){

            @Override
            public long contentLength() {
                return l2;
            }

            @Override
            public MediaType contentType() {
                return mediaType;
            }

            @Override
            public BufferedSource source() {
                return bufferedSource;
            }
        };
    }

    public static ResponseBody create(MediaType mediaType, String string2) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        Buffer buffer = new Buffer().writeString(string2, charset);
        return ResponseBody.create(mediaType, buffer.size(), buffer);
    }

    public static ResponseBody create(MediaType mediaType, byte[] arrby) {
        Buffer buffer = new Buffer().write(arrby);
        return ResponseBody.create(mediaType, arrby.length, buffer);
    }

    public final InputStream byteStream() {
        return this.source().inputStream();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final byte[] bytes() throws IOException {
        long l2 = this.contentLength();
        if (l2 > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + l2);
        }
        BufferedSource bufferedSource = this.source();
        byte[] arrby = bufferedSource.readByteArray();
        if (l2 == -1 || l2 == (long)arrby.length) return arrby;
        throw new IOException("Content-Length and stream length disagree");
        finally {
            Util.closeQuietly(bufferedSource);
        }
    }

    public final Reader charStream() {
        InputStreamReader inputStreamReader;
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        this.reader = inputStreamReader = new InputStreamReader(this.byteStream(), this.charset());
        return inputStreamReader;
    }

    public void close() {
        Util.closeQuietly(this.source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        return new String(this.bytes(), this.charset().name());
    }

}

