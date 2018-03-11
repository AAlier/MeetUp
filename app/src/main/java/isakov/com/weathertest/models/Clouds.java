package isakov.com.weathertest.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Clouds implements Parcelable {
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public Clouds(int all) {

        this.all = all;
    }

    protected Clouds(Parcel in) {
        all = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(all);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Clouds> CREATOR = new Parcelable.Creator<Clouds>() {
        @Override
        public Clouds createFromParcel(Parcel in) {
            return new Clouds(in);
        }

        @Override
        public Clouds[] newArray(int size) {
            return new Clouds[size];
        }
    };
}
