package com.example.bookyourvenue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bookyourvenue.Activity.Dash;
import com.example.bookyourvenue.Activity.MainActivity;

public class splash extends AppCompatActivity {
Handler handler;
SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
preferences=getSharedPreferences("APP",MODE_PRIVATE);
String value=preferences.getString("token","");
if(value.isEmpty()){
    handler= new Handler();

    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }, 3000);
}else{
    Intent intent1=new Intent(this, Dash.class);
    startActivity(intent1);
}


    }
}
