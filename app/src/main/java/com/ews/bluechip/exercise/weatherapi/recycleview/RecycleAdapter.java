package com.ews.bluechip.exercise.weatherapi.recycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.ews.bluechip.exercise.R;
import com.ews.bluechip.exercise.weatherapi.model.WeatherResponseModel;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    private ArrayList<WeatherResponseModel> weatherList;

    public RecycleAdapter(ArrayList<WeatherResponseModel> weatherList) {
        this.weatherList = weatherList;

        Log.e("RecycleAdapter", "SIZE " + weatherList.size());
        Log.e("RecycleAdapter", "CONTENT " + weatherList.get(0).name);
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
        Log.e("onBindViewHolder", "SIZE " + weatherList.size());
        Log.e("onBindViewHolder", "CONTENT " + weatherList.get(0).name);

        final WeatherResponseModel weatherData = weatherList.get(position);
        holder.tvTemperature.setText(String.valueOf(weatherData.main.temp));
        holder.tvWeather.setText(String.valueOf(weatherData.weather.get(0).description));
        //holder.ivIcon.setImageResource(weatherData.getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: " + weatherData.name,Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivIcon;
        public TextView tvWeather;
        public TextView tvTemperature;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.ivIcon = itemView.findViewById(R.id.ivIcon);
            this.tvWeather =  itemView.findViewById(R.id.tvWeather);
            this.tvTemperature = itemView.findViewById(R.id.tvTemperature);
            //this.relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}