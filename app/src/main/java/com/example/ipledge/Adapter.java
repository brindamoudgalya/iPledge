package com.example.ipledge;

// reference: https://www.youtube.com/watch?v=kxdVo4RH3nE

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<String> plantURL;

    public Adapter(Context context, List<String> plantURL){
        this.inflater= LayoutInflater.from(context);
        this.plantURL = plantURL;

//        Log.d("TAG", "Adapter: " + plantName);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String plantUrl = plantURL.get(position);

        // load text into individual textViews

        // load picture into imageView for the picture
//        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(holder.image);
        Picasso.get().load(plantUrl).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return plantURL.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView store, plant, price;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.pictureOfCompany);
        }
    }
}
