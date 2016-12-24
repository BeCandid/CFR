/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.BufferedOutputStream
 *  java.io.Closeable
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.ObjectStreamClass
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.List
 */
import android.util.Log;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.PersistedEvents;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

class uz {
    private static final String a = uz.class.getName();

    uz() {
    }

    /*
     * Exception decompiling
     */
    public static PersistedEvents a() {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(AccessTokenAppIdPair accessTokenAppIdPair, vb vb2) {
        reference var6_2 = uz.class;
        synchronized (uz.class) {
            uz.b();
            PersistedEvents persistedEvents = uz.a();
            if (persistedEvents.containsKey((Object)accessTokenAppIdPair)) {
                ((List)persistedEvents.get((Object)accessTokenAppIdPair)).addAll(vb2.b());
            } else {
                persistedEvents.put((Object)accessTokenAppIdPair, vb2.b());
            }
            uz.a(persistedEvents);
            // ** MonitorExit[var6_2] (shouldn't be in output)
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void a(PersistedEvents var0) {
        var1_1 = null;
        var2_2 = new ObjectOutputStream((OutputStream)new BufferedOutputStream((OutputStream)AppEventsLogger.d().openFileOutput("AppEventsLogger.persistedevents", 0)));
        try {
            var2_2.writeObject((Object)var0);
        }
        catch (Throwable var4_8) {
            var1_1 = var2_2;
            ** GOTO lbl-1000
        }
        catch (Exception var3_5) {
            var1_1 = var2_2;
        }
        we.a((Closeable)var2_2);
        return;
        catch (Exception var3_3) {}
        {
            try {
                Log.w((String)uz.a, (String)("Got unexpected exception while persisting events: " + var3_4.toString()));
            }
            catch (Throwable var4_6) lbl-1000: // 2 sources:
            {
                we.a((Closeable)var1_1);
                throw var4_7;
            }
            we.a((Closeable)var1_1);
            return;
        }
    }

    private static void b() {
    }

    static class a
    extends ObjectInputStream {
        public a(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass objectStreamClass = super.readClassDescriptor();
            if (objectStreamClass.getName().equals((Object)"com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup((Class)AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            if (!objectStreamClass.getName().equals((Object)"com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1")) return objectStreamClass;
            return ObjectStreamClass.lookup((Class)AppEvent.SerializationProxyV1.class);
        }
    }

}

