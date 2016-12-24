/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.location.Address
 *  android.location.Location
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 */
package io.nlopez.smartlocation.geocoding.utils;

import android.location.Address;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

public class LocationAddress
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public LocationAddress a(Parcel parcel) {
            return new LocationAddress(parcel);
        }

        public LocationAddress[] a(int n2) {
            return new LocationAddress[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private Location a;
    private Address b;

    public LocationAddress(Address address) {
        this.b = address;
        this.a = new Location(LocationAddress.class.getCanonicalName());
        this.a.setLatitude(address.getLatitude());
        this.a.setLongitude(address.getLongitude());
    }

    public LocationAddress(Parcel parcel) {
        this.a = (Location)parcel.readParcelable(Location.class.getClassLoader());
        this.b = (Address)parcel.readParcelable(Address.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a, n2);
        parcel.writeParcelable((Parcelable)this.b, n2);
    }

}

