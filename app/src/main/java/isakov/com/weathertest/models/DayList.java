package isakov.com.weathertest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isakov on 04-Oct-17.
 */

public class DayList implements Parcelable {
    private double dt;
    private Main main;
    @SerializedName("weather")
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Sys sys;
    private String dt_txt;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public DayList(double dt, Main main, List<Weather> weather, Clouds clouds, Wind wind, Rain rain, Sys sys, String dt_txt) {

        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }


    protected DayList(Parcel in) {
        dt = in.readDouble();
        main = (Main) in.readValue(Main.class.getClassLoader());
        if (in.readByte() == 0x01) {
            weather = new ArrayList<Weather>();
            in.readList(weather, Weather.class.getClassLoader());
        } else {
            weather = null;
        }
        clouds = (Clouds) in.readValue(Clouds.class.getClassLoader());
        wind = (Wind) in.readValue(Wind.class.getClassLoader());
        rain = (Rain) in.readValue(Rain.class.getClassLoader());
        sys = (Sys) in.readValue(Sys.class.getClassLoader());
        dt_txt = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(dt);
        dest.writeValue(main);
        if (weather == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(weather);
        }
        dest.writeValue(clouds);
        dest.writeValue(wind);
        dest.writeValue(rain);
        dest.writeValue(sys);
        dest.writeString(dt_txt);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DayList> CREATOR = new Parcelable.Creator<DayList>() {
        @Override
        public DayList createFromParcel(Parcel in) {
            return new DayList(in);
        }

        @Override
        public DayList[] newArray(int size) {
            return new DayList[size];
        }
    };
}