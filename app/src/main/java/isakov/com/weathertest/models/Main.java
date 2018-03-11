package isakov.com.weathertest.models;

/**
 * Created by Isakov on 04-Oct-17.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Main implements Parcelable {
    private double temp;
    private double pressure;
    private double temp_min;
    private double temp_max;
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Main(double temp, double pressure, double temp_min, double temp_max, int humidity) {

        this.temp = temp;
        this.pressure = pressure;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.humidity = humidity;
    }

    protected Main(Parcel in) {
        temp = in.readDouble();
        pressure = in.readDouble();
        temp_min = in.readDouble();
        temp_max = in.readDouble();
        humidity = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(temp);
        dest.writeDouble(pressure);
        dest.writeDouble(temp_min);
        dest.writeDouble(temp_max);
        dest.writeInt(humidity);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Main> CREATOR = new Parcelable.Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };
}