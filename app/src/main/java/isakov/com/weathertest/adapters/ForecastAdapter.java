package isakov.com.weathertest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import isakov.com.weathertest.R;
import isakov.com.weathertest.models.DayList;
import isakov.com.weathertest.utils.Constants;

public class ForecastAdapter extends BaseAdapter {
    private List<DayList> list;
    private Context context;

    public ForecastAdapter(Context context, List<DayList> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.forecast_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvCurTemp.setText(String.format(context.getString(R.string.celsius), String.format(Locale.getDefault(), "%.2f", list.get(position).getMain().getTemp())));
        holder.tvDay.setText("Date: " + list.get(position).getDt_txt());
        holder.tvDetails.setText("Humidity:" + String.valueOf(list.get(position).getMain().getHumidity()));
        holder.tvSpeed.setText("Speed: " + String.format(Locale.getDefault(), "%.2f", list.get(position).getWind().getSpeed()));
        holder.tvPressure.setText("Pressure: " + String.format(Locale.getDefault(), "%.2f", list.get(position).getMain().getPressure()));
        Picasso.with(context)
                .load(String.format(Locale.getDefault(), Constants.WEATHER_ICON, list.get(position).getWeather().get(0).getIcon()))
                .into(holder.imageView);

        return view;
    }

    private class ViewHolder {
        private TextView tvDay, tvPressure, tvCurTemp, tvDetails, tvSpeed;
        private ImageView imageView;

        ViewHolder(View convertView) {
            tvDay = convertView.findViewById(R.id.tvDay);
            tvPressure = convertView.findViewById(R.id.tvPressure);
            imageView = convertView.findViewById(R.id.imageView);
            tvCurTemp = convertView.findViewById(R.id.tvCurTemp);
            tvDetails = convertView.findViewById(R.id.tvDetails);
            tvSpeed = convertView.findViewById(R.id.tvSpeed);
        }
    }
}
