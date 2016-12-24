/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.NoSuchElementException
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package okhttp3.internal;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.FaultHidingSink;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache
implements Closeable,
Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final Sink NULL_SINK;
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable;
    private boolean closed;
    private final File directory;
    private final Executor executor;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber = 0;
    private int redundantOpCount;
    private long size = 0;
    private final int valueCount;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2 = !DiskLruCache.class.desiredAssertionStatus();
        $assertionsDisabled = bl2;
        LEGAL_KEY_PATTERN = Pattern.compile((String)"[a-z0-9_-]{1,120}");
        NULL_SINK = new Sink(){

            @Override
            public void close() throws IOException {
            }

            @Override
            public void flush() throws IOException {
            }

            @Override
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override
            public void write(Buffer buffer, long l2) throws IOException {
                buffer.skip(l2);
            }
        };
    }

    DiskLruCache(FileSystem fileSystem, File file, int n2, int n3, long l2, Executor executor) {
        this.cleanupRunnable = new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                DiskLruCache diskLruCache;
                boolean bl2 = true;
                DiskLruCache diskLruCache2 = diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache2) {
                    if (DiskLruCache.this.initialized) {
                        bl2 = false;
                    }
                    if (bl2 | DiskLruCache.this.closed) {
                        return;
                    }
                    try {
                        DiskLruCache.this.trimToSize();
                    }
                    catch (IOException var4_4) {
                        DiskLruCache.this.mostRecentTrimFailed = true;
                    }
                    try {
                        if (DiskLruCache.this.journalRebuildRequired()) {
                            DiskLruCache.this.rebuildJournal();
                            DiskLruCache.this.redundantOpCount = 0;
                        }
                        return;
                    }
                    catch (IOException var6_5) {
                        throw new RuntimeException((Throwable)var6_5);
                    }
                }
            }
        };
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = n2;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = n3;
        this.maxSize = l2;
        this.executor = executor;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void checkNotClosed() {
        DiskLruCache diskLruCache = this;
        synchronized (diskLruCache) {
            if (!this.isClosed()) return;
            throw new IllegalStateException("cache is closed");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void completeEdit(Editor var1, boolean var2_2) throws IOException {
        var26_3 = this;
        // MONITORENTER : var26_3
        var4_4 = Editor.access$1800(var1);
        if (Entry.access$1000(var4_4) != var1) {
            throw new IllegalStateException();
        }
        if (var2_2 && !Entry.access$900(var4_4)) {
            for (var25_5 = 0; var25_5 < this.valueCount; ++var25_5) {
                if (!Editor.access$1900(var1)[var25_5]) {
                    var1.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + var25_5);
                }
                if (this.fileSystem.exists(Entry.access$1500(var4_4)[var25_5])) continue;
                var1.abort();
                return;
            }
        }
        var5_6 = 0;
        ** GOTO lbl19
        do {
            // MONITOREXIT : var26_3
            return;
            break;
        } while (true);
lbl19: // 1 sources:
        do {
            if (var5_6 < this.valueCount) {
                var19_8 = Entry.access$1500(var4_4)[var5_6];
                if (var2_2) {
                    if (this.fileSystem.exists(var19_8)) {
                        var20_10 = Entry.access$1400(var4_4)[var5_6];
                        this.fileSystem.rename(var19_8, var20_10);
                        var21_9 = Entry.access$1300(var4_4)[var5_6];
                        Entry.access$1300((Entry)var4_4)[var5_6] = var23_7 = this.fileSystem.size(var20_10);
                        this.size = var23_7 + (this.size - var21_9);
                    }
                } else {
                    this.fileSystem.delete(var19_8);
                }
            } else {
                this.redundantOpCount = 1 + this.redundantOpCount;
                Entry.access$1002(var4_4, null);
                if (var2_2 | Entry.access$900(var4_4)) {
                    Entry.access$902(var4_4, true);
                    this.journalWriter.writeUtf8("CLEAN").writeByte(32);
                    this.journalWriter.writeUtf8(Entry.access$1600(var4_4));
                    var4_4.writeLengths(this.journalWriter);
                    this.journalWriter.writeByte(10);
                    if (var2_2) {
                        var15_11 = this.nextSequenceNumber;
                        this.nextSequenceNumber = 1 + var15_11;
                        Entry.access$1702(var4_4, var15_11);
                    }
                } else {
                    this.lruEntries.remove((Object)Entry.access$1600(var4_4));
                    this.journalWriter.writeUtf8("REMOVE").writeByte(32);
                    this.journalWriter.writeUtf8(Entry.access$1600(var4_4));
                    this.journalWriter.writeByte(10);
                }
                this.journalWriter.flush();
                if (this.size <= this.maxSize && !super.journalRebuildRequired()) ** continue;
                this.executor.execute(this.cleanupRunnable);
                return;
            }
            ++var5_6;
        } while (true);
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int n2, int n3, long l2) {
        if (l2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        return new DiskLruCache(fileSystem, file, n2, n3, l2, (Executor)new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Editor edit(String string2, long l2) throws IOException {
        void var15_3 = this;
        synchronized (var15_3) {
            Editor editor;
            this.initialize();
            super.checkNotClosed();
            super.validateKey(string2);
            Entry entry = (Entry)this.lruEntries.get((Object)string2);
            if (l2 != -1) {
                editor = null;
                if (entry == null) return editor;
                long l3 = entry.sequenceNumber;
                long l4 = l3 LCMP l2;
                editor = null;
                if (l4 != false) return editor;
            }
            if (entry != null) {
                Editor editor2 = entry.currentEditor;
                editor = null;
                if (editor2 != null) return editor;
            }
            if (this.mostRecentTrimFailed) {
                this.executor.execute(this.cleanupRunnable);
                return null;
            }
            this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(string2).writeByte(10);
            this.journalWriter.flush();
            boolean bl2 = this.hasJournalErrors;
            editor = null;
            if (bl2) return editor;
            if (entry == null) {
                entry = new Entry((DiskLruCache)this, string2, null);
                this.lruEntries.put((Object)string2, (Object)entry);
            }
            editor = new Editor((DiskLruCache)this, entry, null);
            entry.currentEditor = editor;
            return editor;
        }
    }

    private boolean journalRebuildRequired() {
        if (this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size()) {
            return true;
        }
        return false;
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)){
            static final /* synthetic */ boolean $assertionsDisabled;

            /*
             * Enabled aggressive block sorting
             */
            static {
                boolean bl2 = !DiskLruCache.class.desiredAssertionStatus();
                $assertionsDisabled = bl2;
            }

            @Override
            protected void onException(IOException iOException) {
                if (!$assertionsDisabled && !Thread.holdsLock((Object)DiskLruCache.this)) {
                    throw new AssertionError();
                }
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry)iterator.next();
            if (entry.currentEditor == null) {
                for (int i2 = 0; i2 < this.valueCount; ++i2) {
                    this.size += entry.lengths[i2];
                }
                continue;
            }
            entry.currentEditor = null;
            for (int i3 = 0; i3 < this.valueCount; ++i3) {
                this.fileSystem.delete(entry.cleanFiles[i3]);
                this.fileSystem.delete(entry.dirtyFiles[i3]);
            }
            iterator.remove();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void readJournal() throws IOException {
        var1_1 = Okio.buffer(this.fileSystem.source(this.journalFile));
        var3_2 = var1_1.readUtf8LineStrict();
        var4_3 = var1_1.readUtf8LineStrict();
        var5_4 = var1_1.readUtf8LineStrict();
        var6_5 = var1_1.readUtf8LineStrict();
        var7_6 = var1_1.readUtf8LineStrict();
        if ("libcore.io.DiskLruCache".equals((Object)var3_2) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if ("1".equals((Object)var4_3) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if (Integer.toString((int)this.appVersion).equals((Object)var5_4) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if (Integer.toString((int)this.valueCount).equals((Object)var6_5) == false) throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        if (!"".equals((Object)var7_6)) {
            throw new IOException("unexpected journal header: [" + var3_2 + ", " + var4_3 + ", " + var6_5 + ", " + var7_6 + "]");
        }
        ** GOTO lbl18
        finally {
            Util.closeQuietly(var1_1);
        }
lbl18: // 1 sources:
        var8_8 = 0;
        do {
            this.readJournalLine(var1_1.readUtf8LineStrict());
            ++var8_8;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void readJournalLine(String string2) throws IOException {
        Entry entry;
        String string3;
        int n2 = string2.indexOf(32);
        if (n2 == -1) {
            throw new IOException("unexpected journal line: " + string2);
        }
        int n3 = n2 + 1;
        int n4 = string2.indexOf(32, n3);
        if (n4 == -1) {
            string3 = string2.substring(n3);
            if (n2 == "REMOVE".length() && string2.startsWith("REMOVE")) {
                this.lruEntries.remove((Object)string3);
                return;
            }
        } else {
            string3 = string2.substring(n3, n4);
        }
        if ((entry = (Entry)this.lruEntries.get((Object)string3)) == null) {
            entry = new Entry((DiskLruCache)this, string3, null);
            this.lruEntries.put((Object)string3, (Object)entry);
        }
        if (n4 != -1 && n2 == "CLEAN".length() && string2.startsWith("CLEAN")) {
            String[] arrstring = string2.substring(n4 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(arrstring);
            return;
        }
        if (n4 == -1 && n2 == "DIRTY".length() && string2.startsWith("DIRTY")) {
            entry.currentEditor = new Editor((DiskLruCache)this, entry, null);
            return;
        }
        if (n4 == -1 && n2 == "READ".length() && string2.startsWith("READ")) return;
        {
            throw new IOException("unexpected journal line: " + string2);
        }
    }

    /*
     * Exception decompiling
     */
    private void rebuildJournal() throws IOException {
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
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.hasErrors = true;
        }
        for (int i2 = 0; i2 < this.valueCount; ++i2) {
            this.fileSystem.delete(entry.cleanFiles[i2]);
            this.size -= entry.lengths[i2];
            Entry.access$1300((Entry)entry)[i2] = 0;
        }
        this.redundantOpCount = 1 + this.redundantOpCount;
        this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(entry.key).writeByte(10);
        this.lruEntries.remove((Object)entry.key);
        if (super.journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            this.removeEntry((Entry)this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    private void validateKey(String string2) {
        if (!LEGAL_KEY_PATTERN.matcher((CharSequence)string2).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + string2 + "\"");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        DiskLruCache diskLruCache = this;
        // MONITORENTER : diskLruCache
        if (!this.initialized || this.closed) {
            this.closed = true;
            // MONITOREXIT : diskLruCache
            return;
        }
        Entry[] arrentry = (Entry[])this.lruEntries.values().toArray((Object[])new Entry[this.lruEntries.size()]);
        int n2 = arrentry.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            Entry entry = arrentry[n3];
            if (entry.currentEditor != null) {
                entry.currentEditor.abort();
            }
            ++n3;
        } while (true);
    }

    public void delete() throws IOException {
        this.close();
        this.fileSystem.deleteContents(this.directory);
    }

    public Editor edit(String string2) throws IOException {
        return super.edit(string2, -1);
    }

    public void evictAll() throws IOException {
        DiskLruCache diskLruCache = this;
        synchronized (diskLruCache) {
            this.initialize();
            Entry[] arrentry = (Entry[])this.lruEntries.values().toArray((Object[])new Entry[this.lruEntries.size()]);
            int n2 = arrentry.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.removeEntry(arrentry[i2]);
            }
            this.mostRecentTrimFailed = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void flush() throws IOException {
        DiskLruCache diskLruCache = this;
        synchronized (diskLruCache) {
            boolean bl2 = this.initialized;
            if (bl2) {
                this.checkNotClosed();
                this.trimToSize();
                this.journalWriter.flush();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Snapshot get(String string2) throws IOException {
        void var7_2 = this;
        synchronized (var7_2) {
            this.initialize();
            super.checkNotClosed();
            super.validateKey(string2);
            Entry entry = (Entry)this.lruEntries.get((Object)string2);
            if (entry == null) return null;
            boolean bl2 = entry.readable;
            if (!bl2) {
                return null;
            }
            Snapshot snapshot = entry.snapshot();
            if (snapshot == null) {
                return null;
            }
            this.redundantOpCount = 1 + this.redundantOpCount;
            this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(string2).writeByte(10);
            if (!super.journalRebuildRequired()) return snapshot;
            this.executor.execute(this.cleanupRunnable);
            return snapshot;
        }
    }

    public File getDirectory() {
        return this.directory;
    }

    public long getMaxSize() {
        DiskLruCache diskLruCache = this;
        synchronized (diskLruCache) {
            long l2 = this.maxSize;
            return l2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void initialize() throws IOException {
        boolean bl2;
        DiskLruCache diskLruCache = this;
        // MONITORENTER : diskLruCache
        if (!$assertionsDisabled && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        boolean bl3 = this.initialized;
        if (bl3) {
            // MONITOREXIT : diskLruCache
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        if (bl2 = this.fileSystem.exists(this.journalFile)) {
            try {
                this.readJournal();
                this.processJournal();
                this.initialized = true;
                return;
            }
            catch (IOException var4_4) {
                Platform.get().logW("DiskLruCache " + (Object)this.directory + " is corrupt: " + var4_4.getMessage() + ", removing");
                this.delete();
                this.closed = false;
            }
        }
        this.rebuildJournal();
        this.initialized = true;
    }

    public boolean isClosed() {
        DiskLruCache diskLruCache = this;
        synchronized (diskLruCache) {
            boolean bl2 = this.closed;
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean remove(String string2) throws IOException {
        void var5_2 = this;
        synchronized (var5_2) {
            this.initialize();
            super.checkNotClosed();
            super.validateKey(string2);
            Entry entry = (Entry)this.lruEntries.get((Object)string2);
            boolean bl2 = false;
            if (entry != null && (bl2 = super.removeEntry(entry)) && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return bl2;
        }
    }

    public void setMaxSize(long l2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.maxSize = l2;
            if (this.initialized) {
                this.executor.execute(this.cleanupRunnable);
            }
            return;
        }
    }

    public long size() throws IOException {
        DiskLruCache diskLruCache = this;
        synchronized (diskLruCache) {
            this.initialize();
            long l2 = this.size;
            return l2;
        }
    }

    public Iterator<Snapshot> snapshots() throws IOException {
        DiskLruCache diskLruCache = this;
        synchronized (diskLruCache) {
            this.initialize();
            Iterator<Snapshot> iterator = new Iterator<Snapshot>(){
                final Iterator<Entry> delegate;
                Snapshot nextSnapshot;
                Snapshot removeSnapshot;

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public boolean hasNext() {
                    DiskLruCache diskLruCache;
                    if (this.nextSnapshot != null) {
                        return true;
                    }
                    DiskLruCache diskLruCache2 = diskLruCache = DiskLruCache.this;
                    synchronized (diskLruCache2) {
                        Snapshot snapshot;
                        if (DiskLruCache.this.closed) {
                            return false;
                        }
                        do {
                            if (this.delegate.hasNext()) continue;
                            return false;
                        } while ((snapshot = ((Entry)this.delegate.next()).snapshot()) == null);
                        this.nextSnapshot = snapshot;
                        return true;
                    }
                }

                public Snapshot next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.removeSnapshot = this.nextSnapshot;
                    this.nextSnapshot = null;
                    return this.removeSnapshot;
                }

                public void remove() {
                    if (this.removeSnapshot == null) {
                        throw new IllegalStateException("remove() before next()");
                    }
                    try {
                        DiskLruCache.this.remove(this.removeSnapshot.key);
                        return;
                    }
                    catch (IOException var2_1) {
                        return;
                    }
                    finally {
                        this.removeSnapshot = null;
                    }
                }
            };
            return iterator;
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        /*
         * Enabled aggressive block sorting
         */
        private Editor(DiskLruCache diskLruCache, Entry entry) {
            this.this$0 = diskLruCache;
            this.entry = entry;
            Object var3_3 = entry.readable ? null : new boolean[diskLruCache.valueCount];
            this.written = var3_3;
        }

        /* synthetic */ Editor(DiskLruCache diskLruCache, Entry entry, okhttp3.internal.DiskLruCache$1 var3_2) {
            super(diskLruCache, entry);
        }

        static /* synthetic */ Entry access$1800(Editor editor) {
            return editor.entry;
        }

        static /* synthetic */ boolean[] access$1900(Editor editor) {
            return editor.written;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void abort() throws IOException {
            DiskLruCache diskLruCache;
            DiskLruCache diskLruCache2 = diskLruCache = this.this$0;
            synchronized (diskLruCache2) {
                this.this$0.completeEdit(this, false);
                return;
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public void abortUnlessCommitted() {
            var5_2 = var1_1 = this.this$0;
            // MONITORENTER : var5_2
            var3_3 = this.committed;
            if (var3_3) ** GOTO lbl7
            try {
                DiskLruCache.access$2700(this.this$0, this, false);
lbl7: // 2 sources:
                // MONITOREXIT : var5_2
                return;
            }
            catch (IOException var4_4) {
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void commit() throws IOException {
            DiskLruCache diskLruCache;
            DiskLruCache diskLruCache2 = diskLruCache = this.this$0;
            synchronized (diskLruCache2) {
                if (this.hasErrors) {
                    this.this$0.completeEdit(this, false);
                    this.this$0.removeEntry(this.entry);
                } else {
                    this.this$0.completeEdit(this, true);
                }
                this.committed = true;
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Sink newSink(int n2) throws IOException {
            DiskLruCache diskLruCache;
            DiskLruCache diskLruCache2 = diskLruCache = this.this$0;
            synchronized (diskLruCache2) {
                Sink sink;
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[n2] = true;
                }
                File file = this.entry.dirtyFiles[n2];
                try {
                    sink = this.this$0.fileSystem.sink(file);
                }
                catch (FileNotFoundException var5_7) {
                    return NULL_SINK;
                }
                return new FaultHidingSink(sink){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    @Override
                    protected void onException(IOException iOException) {
                        DiskLruCache diskLruCache;
                        DiskLruCache diskLruCache2 = diskLruCache = Editor.this.this$0;
                        synchronized (diskLruCache2) {
                            Editor.this.hasErrors = true;
                            return;
                        }
                    }
                };
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Source newSource(int n2) throws IOException {
            DiskLruCache diskLruCache;
            DiskLruCache diskLruCache2 = diskLruCache = this.this$0;
            synchronized (diskLruCache2) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    return null;
                }
                try {
                    return this.this$0.fileSystem.source(this.entry.cleanFiles[n2]);
                }
                catch (FileNotFoundException var4_5) {
                    return null;
                }
            }
        }

    }

    final class Entry {
        private final File[] cleanFiles;
        private Editor currentEditor;
        private final File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        private Entry(DiskLruCache diskLruCache, String string2) {
            this.this$0 = diskLruCache;
            this.key = string2;
            this.lengths = new long[diskLruCache.valueCount];
            this.cleanFiles = new File[diskLruCache.valueCount];
            this.dirtyFiles = new File[diskLruCache.valueCount];
            StringBuilder stringBuilder = new StringBuilder(string2).append('.');
            int n2 = stringBuilder.length();
            for (int i2 = 0; i2 < diskLruCache.valueCount; ++i2) {
                stringBuilder.append(i2);
                this.cleanFiles[i2] = new File(diskLruCache.directory, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.dirtyFiles[i2] = new File(diskLruCache.directory, stringBuilder.toString());
                stringBuilder.setLength(n2);
            }
        }

        /* synthetic */ Entry(DiskLruCache diskLruCache, String string2,  var3_2) {
            super(diskLruCache, string2);
        }

        static /* synthetic */ long access$1702(Entry entry, long l2) {
            entry.sequenceNumber = l2;
            return l2;
        }

        private IOException invalidLengths(String[] arrstring) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString((Object[])arrstring));
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void setLengths(String[] arrstring) throws IOException {
            if (arrstring.length != this.this$0.valueCount) {
                throw super.invalidLengths(arrstring);
            }
            try {
                for (int i2 = 0; i2 < arrstring.length; ++i2) {
                    this.lengths[i2] = Long.parseLong((String)arrstring[i2]);
                }
                return;
            }
            catch (NumberFormatException var3_3) {
                throw super.invalidLengths(arrstring);
            }
        }

        Snapshot snapshot() {
            if (!Thread.holdsLock((Object)this.this$0)) {
                throw new AssertionError();
            }
            Source[] arrsource = new Source[this.this$0.valueCount];
            long[] arrl = (long[])this.lengths.clone();
            int n2 = 0;
            do {
                if (n2 >= this.this$0.valueCount) break;
                arrsource[n2] = this.this$0.fileSystem.source(this.cleanFiles[n2]);
                ++n2;
            } while (true);
            try {
                Snapshot snapshot = this.this$0.new Snapshot(this.key, this.sequenceNumber, arrsource, arrl);
                return snapshot;
            }
            catch (FileNotFoundException var4_5) {
                for (int i2 = 0; i2 < this.this$0.valueCount && arrsource[i2] != null; ++i2) {
                    Util.closeQuietly(arrsource[i2]);
                }
                return null;
            }
        }

        void writeLengths(BufferedSink bufferedSink) throws IOException {
            for (long l2 : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(l2);
            }
        }
    }

    public final class Snapshot
    implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        private Snapshot(String string2, long l2, Source[] arrsource, long[] arrl) {
            this.key = string2;
            this.sequenceNumber = l2;
            this.sources = arrsource;
            this.lengths = arrl;
        }

        public void close() {
            Source[] arrsource = this.sources;
            int n2 = arrsource.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Util.closeQuietly(arrsource[i2]);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public long getLength(int n2) {
            return this.lengths[n2];
        }

        public Source getSource(int n2) {
            return this.sources[n2];
        }

        public String key() {
            return this.key;
        }
    }

}

