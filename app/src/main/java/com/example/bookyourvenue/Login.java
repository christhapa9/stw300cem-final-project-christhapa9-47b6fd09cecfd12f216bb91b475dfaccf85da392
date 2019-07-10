package com.example.bookyourvenue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookyourvenue.Activity.Dash;
import com.example.bookyourvenue.Api.Url;
import com.example.bookyourvenue.Businesslogic.Userlogic;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends Fragment implements View.OnClickListener {
    private EditText username, password;
    private Button btnlogin;
    SharedPreferences shared;
    SharedPreferences.Editor editor;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        initiate(view);
        return view;
    }

    //this is a method that will initiate in oncreateview
    public void initiate(View view) {
        username = view.findViewById(R.id.lg_username);
        password = view.findViewById(R.id.lg_password);
        btnlogin = view.findViewById(R.id.btn_login);

        btnlogin.setOnClickListener(this);
    }

    public void StrictMode(){
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    //this method will validate Login Page
    public boolean checkLogin(){
        if(username.getText().toString().isEmpty()){
            username.setError("Type your Username ");
            username.requestFocus();
            return false;
        }
        if(password.getText().toString().isEmpty()){
            password.setError("Type your Username ");
            password.requestFocus();
            return false;
        }
        return true;
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            if(checkLogin()==true){
                Userlogic ul=new Userlogic();
                StrictMode();
                if(ul.LoginUser(username.getText().toString(),password.getText().toString())==true){
             Toast.makeText(getActivity(),"You are successfully logged in"+Userlogic.token,Toast.LENGTH_SHORT).show();

             Intent intent=new Intent(getContext(),Dash.class);
             startActivity(intent);
                }else{
                    Toast.makeText(getActivity(),"Your passwordor username is incorrect",Toast.LENGTH_SHORT).show();

                }
          }
        }
    }
}
