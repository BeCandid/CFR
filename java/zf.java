/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
public final class zf {
    public static abr<Integer> a = abr.a("gms:common:stats:max_num_of_events", 100);
    public static abr<Integer> b = abr.a("gms:common:stats:max_chunk_size", 100);

    public static final class a {
        public static abr<Integer> a = abr.a("gms:common:stats:connections:level", zg.b);
        public static abr<String> b = abr.a("gms:common:stats:connections:ignored_calling_processes", "");
        public static abr<String> c = abr.a("gms:common:stats:connections:ignored_calling_services", "");
        public static abr<String> d = abr.a("gms:common:stats:connections:ignored_target_processes", "");
        public static abr<String> e = abr.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static abr<Long> f = abr.a("gms:common:stats:connections:time_out_duration", 600000);
    }

    public static final class b {
        public static abr<Integer> a = abr.a("gms:common:stats:wakeLocks:level", zg.b);
        public static abr<Long> b = abr.a("gms:common:stats:wakelocks:time_out_duration", 600000);
    }

}

