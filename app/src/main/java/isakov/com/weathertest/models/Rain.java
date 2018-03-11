package isakov.com.weathertest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Isakov on 04-Oct-17.
 */

public class Rain implements Parcelable {

    @SerializedName("3h")
    private double h;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Rain(double h) {

        this.h = h;
    }

    protected Rain(Parcel in) {
        h = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(h);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Rain> CREATOR = new Parcelable.Creator<Rain>() {
        @Override
        public Rain createFromParcel(Parcel in) {
            return new Rain(in);
        }

        @Override
        public Rain[] newArray(int size) {
            return new Rain[size];
        }
    };
}