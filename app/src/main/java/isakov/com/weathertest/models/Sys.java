package isakov.com.weathertest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Isakov on 04-Oct-17.
 */

public class Sys implements Parcelable {
    private double type;
    private double id;
    private double message;
    private double sunrise;
    private double sunset;
    private String country;

    public double getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Sys(int type, int id, int message, int sunrise, int sunset, String country) {

        this.type = type;
        this.id = id;
        this.message = message;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.country = country;
    }

    protected Sys(Parcel in) {
        type = in.readDouble();
        id = in.readDouble();
        message = in.readDouble();
        sunrise = in.readDouble();
        sunset = in.readDouble();
        country = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(type);
        dest.writeDouble(id);
        dest.writeDouble(message);
        dest.writeDouble(sunrise);
        dest.writeDouble(sunset);
        dest.writeString(country);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sys> CREATOR = new Parcelable.Creator<Sys>() {
        @Override
        public Sys createFromParcel(Parcel in) {
            return new Sys(in);
        }

        @Override
        public Sys[] newArray(int size) {
            return new Sys[size];
        }
    };
}