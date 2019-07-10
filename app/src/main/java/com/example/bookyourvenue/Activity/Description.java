package com.example.bookyourvenue.Activity;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookyourvenue.Api.Url;
import com.example.bookyourvenue.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

public class Description extends AppCompatActivity {
    ActionBar action;
    TextView name, address,des;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        action=getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);
        action.setTitle("Description");
        initiate();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem venues) {
        if(venues.getItemId()==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(venues);
    }
    //initiating buttons and textfield
    public void initiate(){
        name=findViewById(R.id.txtvenuename);
        address =findViewById(R.id.txtvenueplace);
        des=findViewById(R.id.txtvenuedesc);
        img1=findViewById(R.id.imgdisplay);
        Bundle bundle=getIntent().getExtras();
        //setting images and data from Recycler View to Description Activity
        if(bundle!=null){
            String imgpath = Url.BASE_URL + bundle.getString("Venue_img");
            try {
                URL ur = new URL(imgpath);
                img1.setImageBitmap(BitmapFactory.decodeStream((InputStream) ur.getContent()));

            }catch (Exception e){
                Log.d("Venue_img", "error"+e);
            }
            
            name.setText("Venue Name:" + bundle.getString("Venue_name"));
            address.setText("Address:" + bundle.getString("Venue_Place"));
            des.setText("Details:" + bundle.getString("Venue_desc"));

        }
    }
}

