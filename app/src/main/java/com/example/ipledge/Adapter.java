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
    List<String> companyEmissions, companyName, companyRating, photoURL;

    public Adapter(Context context, List<String> companyEmissions, List<String> companyName,
                   List<String> companyRating, List<String> companyURL){
        this.inflater= LayoutInflater.from(context);
        this.companyEmissions = companyEmissions;
        this.companyName = companyName;
        this.companyRating = companyRating;
        this.photoURL = companyURL;

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
        String emissions = companyEmissions.get(position);
        String rating = companyRating.get(position);
        String url = photoURL.get(position);

        // load text into individual textViews
        holder.rating.setText(rating);
        holder.emissions.setText(emissions);

        // load picture into imageView for the picture
//        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(holder.image);
        Picasso.get().load(url).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return photoURL.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rating;
        TextView emissions;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emissions = itemView.findViewById(R.id.emissionsTextView);
            rating = itemView.findViewById(R.id.ratingTextView);
            image = itemView.findViewById(R.id.pictureOfCompany);
        }
    }
}
