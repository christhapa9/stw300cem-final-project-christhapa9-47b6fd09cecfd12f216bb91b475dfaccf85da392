package com.example.bookyourvenue.Activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookyourvenue.Adapter.VenueRecyclerAdapter;
import com.example.bookyourvenue.Api.Url;
import com.example.bookyourvenue.Businesslogic.Userlogic;
import com.example.bookyourvenue.R;
import com.example.bookyourvenue.Venue;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Dash extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rv;
    Button btnAdd;
    List<Venue> Venuelist = new ArrayList<>();
SharedPreferences shared;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        rv = findViewById(R.id.recyler);
       shared=getSharedPreferences("APP",MODE_PRIVATE);
        editor=shared.edit();
        editor.putString("token", Userlogic.token);
        editor.commit();
        getAllItem();
        getSupportActionBar().hide();
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        rv.setAdapter(new VenueRecyclerAdapter(Venuelist, this));
        btnAdd = findViewById(R.id.Addbutton);
        btnAdd.setOnClickListener(this);

    }
    //Setting List oF items in Recycler View
    private void getAllItem() {
        Url url = new Url();
        Call<List<Venue>> listCall = url.createInstanceofRetrofit().getAllVenue();
        listCall.enqueue(new Callback<List<Venue>>() {
            @Override
            public void onResponse(Call<List<Venue>> call, Response<List<Venue>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Dash.this, "Code:" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Venue>itemList=response.body();
                VenueRecyclerAdapter itemadapter=new VenueRecyclerAdapter(itemList, Dash.this);
                rv.setAdapter(itemadapter);
                rv.setLayoutManager(new LinearLayoutManager(Dash.this));
            }

            @Override
            public void onFailure(Call<List<Venue>> call, Throwable t) {
                Toast.makeText(Dash.this, "Code:" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Addbutton:
                Intent intent = new Intent(Dash.this, VenueAdd.class);
                startActivity(intent);

                break;
        }
    }
}
