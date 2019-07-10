package com.example.bookyourvenue.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.bookyourvenue.Activity.Description;
import com.example.bookyourvenue.Api.Url;
import com.example.bookyourvenue.R;
import com.example.bookyourvenue.Venue;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static com.example.bookyourvenue.Api.Url.BASE_URL;

public class VenueRecyclerAdapter extends RecyclerView.Adapter<VenueRecyclerAdapter.VenuesViewHolder> {
    List<Venue> venueList;
    Context context;

    public VenueRecyclerAdapter(List<Venue> venueList, Context context) {
        this.venueList = venueList;
        this.context = context;
    }
//implementing ItemRecyclerAdapter on RecyclerView
    @NonNull
    @Override
    public VenuesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample_row, viewGroup, false);
        return new VenuesViewHolder(itemview);
    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
//this will set list of item and images to recycler view
    @Override
    public void onBindViewHolder(@NonNull final VenuesViewHolder venuesViewHolder, int i) {
        final Venue venues = venueList.get(i);
        String imgpath = BASE_URL + venues.getVenueimage();
        System.out.println(imgpath);
        StrictMode();
        try {
            URL ur = new URL(imgpath);
            venuesViewHolder.img.setImageBitmap(BitmapFactory.decodeStream((InputStream) ur.getContent()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        venuesViewHolder.Venue_Name.setText("VenueName:" + venues.getVenuename());
        venuesViewHolder.Venue_place.setText("Address:" + venues.getAddress());
        venuesViewHolder.Venue_details.setText("Description:" + venues.getDetails());
        venuesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Description.class);

                intent.putExtra("Venue_name", venues.getVenuename());
                intent.putExtra("Venue_Place", venues.getAddress());
                intent.putExtra("Venue_desc", venues.getDetails());
                intent.putExtra("Venue_img", BASE_URL +"/venueimage/" + venues.getVenueimage());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }
//Creating abstarct class ItemViewHolder
    public class VenuesViewHolder extends RecyclerView.ViewHolder {
        public TextView Venue_Name;
        public TextView Venue_details;
        public TextView Venue_place;
        public ImageView img;

        public VenuesViewHolder(@NonNull View itemView) {
            super(itemView);
            Venue_Name = itemView.findViewById(R.id.rvvenuename);
            Venue_details = itemView.findViewById(R.id.rvItemPrice);
            Venue_place = itemView.findViewById(R.id.rvItemDesc);
            img = itemView.findViewById(R.id.rvimage);
        }
    }
}
