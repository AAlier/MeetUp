package isakov.com.weathertest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isakov on 04-Oct-17.
 */

public class ForecastModel implements Parcelable {
    private String cod;
    private double message;
    private double cnt;

    private List<DayList> list;
    private ExtendedCity city;

    public List<DayList> getList() {
        return list;
    }

    public void setList(List<DayList> list) {
        this.list = list;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public double getCnt() {
        return cnt;
    }

    public void setCnt(double cnt) {
        this.cnt = cnt;
    }

    public ExtendedCity getCity() {
        return city;
    }

    public void setCity(ExtendedCity city) {
        this.city = city;
    }

    public ForecastModel(String cod, double message, double cnt, List<DayList> list, ExtendedCity city) {

        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    protected ForecastModel(Parcel in) {
        cod = in.readString();
        message = in.readDouble();
        cnt = in.readDouble();
        if (in.readByte() == 0x01) {
            list = new ArrayList<DayList>();
            in.readList(list, DayList.class.getClassLoader());
        } else {
            list = null;
        }
        city = (ExtendedCity) in.readValue(ExtendedCity.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cod);
        dest.writeDouble(message);
        dest.writeDouble(cnt);
        if (list == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(list);
        }
        dest.writeValue(city);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ForecastModel> CREATOR = new Parcelable.Creator<ForecastModel>() {
        @Override
        public ForecastModel createFromParcel(Parcel in) {
            return new ForecastModel(in);
        }

        @Override
        public ForecastModel[] newArray(int size) {
            return new ForecastModel[size];
        }
    };
}