package isakov.com.weathertest.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by Isakov on 04-Oct-17.
 */

data class GeneralModel constructor(var coord: Coord?,
                                    @SerializedName("weather")
                                    var weatherList: List<Weather>?,
                                    var base: String?,
                                    var main: Main?,
                                    var wind: Wind?,
                                    var clouds: Clouds?,
                                    var rain: Rain?,
                                    var dt: Int = 0,
                                    var sys: Sys?,
                                    var id: Int = 0,
                                    var name: String?,
                                    var cod: Int = 0) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(Coord::class.java.classLoader),
            parcel.createTypedArrayList(Weather.CREATOR),
            parcel.readString(),
            parcel.readParcelable(Main::class.java.classLoader),
            parcel.readParcelable(Wind::class.java.classLoader),
            parcel.readParcelable(Clouds::class.java.classLoader),
            parcel.readParcelable(Rain::class.java.classLoader),
            parcel.readInt(),
            parcel.readParcelable(Sys::class.java.classLoader),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(coord, flags)
        parcel.writeTypedList(weatherList)
        parcel.writeString(base)
        parcel.writeParcelable(main, flags)
        parcel.writeParcelable(wind, flags)
        parcel.writeParcelable(clouds, flags)
        parcel.writeParcelable(rain, flags)
        dt?.let { parcel.writeInt(it) }
        parcel.writeParcelable(sys, flags)
        id?.let { parcel.writeInt(it) }
        parcel.writeString(name)
        cod?.let { parcel.writeInt(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GeneralModel> {
        override fun createFromParcel(parcel: Parcel): GeneralModel {
            return GeneralModel(parcel)
        }

        override fun newArray(size: Int): Array<GeneralModel?> {
            return arrayOfNulls(size)
        }
    }
}