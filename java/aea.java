/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.zzd
 *  com.google.android.gms.maps.GoogleMapOptions
 *  com.google.android.gms.maps.StreetViewPanoramaOptions
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public interface aea
extends IInterface {
    public adi a() throws RemoteException;

    public adm a(aag var1, GoogleMapOptions var2) throws RemoteException;

    public adq a(aag var1, StreetViewPanoramaOptions var2) throws RemoteException;

    public void a(aag var1) throws RemoteException;

    public void a(aag var1, int var2) throws RemoteException;

    public adl b(aag var1) throws RemoteException;

    public afc b() throws RemoteException;

    public adp c(aag var1) throws RemoteException;

    public static abstract class aea$a
    extends Binder
    implements aea {
        public static aea a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            if (iInterface != null && iInterface instanceof aea) {
                return (aea)iInterface;
            }
            return new a(iBinder);
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    this.a((aag)aag.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    adl adl2 = this.b((aag)aag.a.zzbs((IBinder)parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (adl2 != null) {
                        iBinder = adl2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzd zzd2 = aag.a.zzbs((IBinder)parcel.readStrongBinder());
                    GoogleMapOptions googleMapOptions = parcel.readInt() != 0 ? GoogleMapOptions.CREATOR.a(parcel) : null;
                    adm adm2 = this.a((aag)zzd2, googleMapOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (adm2 != null) {
                        iBinder = adm2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    adi adi2 = this.a();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (adi2 != null) {
                        iBinder = adi2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    afc afc2 = this.b();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (afc2 != null) {
                        iBinder = afc2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    this.a((aag)aag.a.zzbs((IBinder)parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzd zzd3 = aag.a.zzbs((IBinder)parcel.readStrongBinder());
                    StreetViewPanoramaOptions streetViewPanoramaOptions = parcel.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.a(parcel) : null;
                    adq adq2 = this.a((aag)zzd3, streetViewPanoramaOptions);
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (adq2 != null) {
                        iBinder = adq2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 8: 
            }
            parcel.enforceInterface("com.google.android.gms.maps.internal.ICreator");
            adp adp2 = this.c((aag)aag.a.zzbs((IBinder)parcel.readStrongBinder()));
            parcel2.writeNoException();
            IBinder iBinder = null;
            if (adp2 != null) {
                iBinder = adp2.asBinder();
            }
            parcel2.writeStrongBinder(iBinder);
            return true;
        }

        static class a
        implements aea {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public adi a() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.a.transact(4, parcel, parcel2, 0);
                    parcel2.readException();
                    adi adi2 = adi.a.a(parcel2.readStrongBinder());
                    return adi2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public adm a(aag aag2, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    if (googleMapOptions != null) {
                        parcel.writeInt(1);
                        googleMapOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    adm adm2 = adm.a.a(parcel2.readStrongBinder());
                    return adm2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public adq a(aag aag2, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    if (streetViewPanoramaOptions != null) {
                        parcel.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(7, parcel, parcel2, 0);
                    parcel2.readException();
                    adq adq2 = adq.a.a(parcel2.readStrongBinder());
                    return adq2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(aag aag2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void a(aag aag2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    parcel.writeInt(n2);
                    this.a.transact(6, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public adl b(aag aag2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    adl adl2 = adl.a.a(parcel2.readStrongBinder());
                    return adl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public afc b() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.a.transact(5, parcel, parcel2, 0);
                    parcel2.readException();
                    afc afc2 = afc.a.a(parcel2.readStrongBinder());
                    return afc2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public adp c(aag aag2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    this.a.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    adp adp2 = adp.a.a(parcel2.readStrongBinder());
                    return adp2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

