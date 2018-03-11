package isakov.com.weathertest.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Isakov on 04-Oct-17.
 */

public class Constants {

    public static final String BASE_URL = "http://api.openweathermap.org";
    public static final String GET_CITY_WEATHER = "/data/2.5/weather";
    public static final String GET_CITY_FORECAST = "/data/2.5/forecast";
//    public static final String GET_CITY_FORECAST = "/data/2.5/forecast/daily";

    public static final String WEATHER_ICON = "http://openweathermap.org/img/w/%s.png";

    public static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
