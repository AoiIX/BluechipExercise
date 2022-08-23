package com.ews.bluechip.exercise.weatherapi.recycleview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ews.bluechip.exercise.MainActivity;
import com.ews.bluechip.exercise.R;
import com.ews.bluechip.exercise.weatherapi.model.ListModel;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    private ArrayList<ListModel> weatherList;
    private Context mContext;

    public RecycleAdapter(ArrayList<ListModel> weatherList, Context context) {
        this.weatherList = weatherList;
        this.mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_weather, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListModel weatherData = weatherList.get(position);
        holder.tvTemperature.setText(String.valueOf(weatherData.main.temp));
        holder.tvWeather.setText(String.valueOf(weatherData.weather.get(0).description));

        String iconURL = "http://openweathermap.org/img/wn/" + weatherData.weather.get(0).icon + "@2x.png";

        Glide.with(holder.itemView)
                .load(iconURL) // image url
                .placeholder(R.drawable.ic_launcher_foreground) // any placeholder to load at start
                .error(R.drawable.ic_launcher_foreground)  // any image in case of error
                .override(100, 100) // resizing
                .centerCrop()
                .into(holder.ivIcon);  // imageview object

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWeatherDetails(weatherData);
            }
        });
    }

    private void showWeatherDetails(ListModel listModel){
        ((MainActivity)mContext).goToWeatherDetails(listModel);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivIcon;
        public TextView tvWeather;
        public TextView tvTemperature;
        public LinearLayout linearLayout;
        public View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.ivIcon = itemView.findViewById(R.id.ivIcon);
            this.tvWeather =  itemView.findViewById(R.id.tvWeather);
            this.tvTemperature = itemView.findViewById(R.id.tvTemperature);
            this.linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}