package isakov.com.weathertest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Isakov on 04-Oct-17.
 */

public class ExtendedCity implements Parcelable {
    private int geoname_id;
    private String name;
    private double lat;
    private double lon;
    private String country;
    private String iso2;
    private String type;
    private int population;

    public int getGeoname_id() {
        return geoname_id;
    }

    public void setGeoname_id(int geoname_id) {
        this.geoname_id = geoname_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ExtendedCity(int geoname_id, String name, double lat, double lon, String country, String iso2, String type, int population) {

        this.geoname_id = geoname_id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.iso2 = iso2;
        this.type = type;
        this.population = population;
    }

    protected ExtendedCity(Parcel in) {
        geoname_id = in.readInt();
        name = in.readString();
        lat = in.readDouble();
        lon = in.readDouble();
        country = in.readString();
        iso2 = in.readString();
        type = in.readString();
        population = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(geoname_id);
        dest.writeString(name);
        dest.writeDouble(lat);
        dest.writeDouble(lon);
        dest.writeString(country);
        dest.writeString(iso2);
        dest.writeString(type);
        dest.writeInt(population);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ExtendedCity> CREATOR = new Parcelable.Creator<ExtendedCity>() {
        @Override
        public ExtendedCity createFromParcel(Parcel in) {
            return new ExtendedCity(in);
        }

        @Override
        public ExtendedCity[] newArray(int size) {
            return new ExtendedCity[size];
        }
    };
}