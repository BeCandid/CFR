/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.SignInButtonConfig
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.SignInButtonConfig;

public interface yz
extends IInterface {
    public aag a(aag var1, int var2, int var3) throws RemoteException;

    public aag a(aag var1, SignInButtonConfig var2) throws RemoteException;

    public static abstract class yz$a
    extends Binder
    implements yz {
        public static yz a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            if (iInterface != null && iInterface instanceof yz) {
                return (yz)iInterface;
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
                    parcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    aag aag2 = this.a(aag.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
                case 2: 
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            aag aag3 = aag.a.a(parcel.readStrongBinder());
            SignInButtonConfig signInButtonConfig = parcel.readInt() != 0 ? (SignInButtonConfig)SignInButtonConfig.CREATOR.createFromParcel(parcel) : null;
            aag aag4 = this.a(aag3, signInButtonConfig);
            parcel2.writeNoException();
            IBinder iBinder = null;
            if (aag4 != null) {
                iBinder = aag4.asBinder();
            }
            parcel2.writeStrongBinder(iBinder);
            return true;
        }

        static class a
        implements yz {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public aag a(aag aag2, int n2, int n3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    this.a.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    aag aag3 = aag.a.a(parcel2.readStrongBinder());
                    return aag3;
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
            public aag a(aag aag2, SignInButtonConfig signInButtonConfig) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    IBinder iBinder = aag2 != null ? aag2.asBinder() : null;
                    parcel.writeStrongBinder(iBinder);
                    if (signInButtonConfig != null) {
                        parcel.writeInt(1);
                        signInButtonConfig.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(2, parcel, parcel2, 0);
                    parcel2.readException();
                    aag aag3 = aag.a.a(parcel2.readStrongBinder());
                    return aag3;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

    }

}

