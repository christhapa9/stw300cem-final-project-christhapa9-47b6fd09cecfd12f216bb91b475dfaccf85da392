package com.example.bookyourvenue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookyourvenue.Api.Url;
import com.example.bookyourvenue.Businesslogic.Userlogic;
import com.example.bookyourvenue.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Register extends Fragment implements View.OnClickListener {
    private EditText userfname, userlname, username, password, email;
    private Button btnregister;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initiate(view);

        return view;
    }

    //initiating edittext and buttons
    public void initiate(View view) {
        userfname = view.findViewById(R.id.userfname);
        userlname = view.findViewById(R.id.userlname);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        email = view.findViewById(R.id.email);
        btnregister = view.findViewById(R.id.btnRegister);

        btnregister.setOnClickListener(this);

    }

    //this method will validate user while registering
    public boolean validateuser() {
        if (userfname.getText().toString().isEmpty()) {
            userfname.setError("Enter your first name");
            userfname.requestFocus();
            return false;
        }
        if (userlname.getText().toString().isEmpty()) {
            userlname.setError("Enter your  last name");
            userlname.requestFocus();
            return false;
        }
        if (username.getText().toString().isEmpty()) {
            username.setError("Enter your  last name");
            username.requestFocus();
            return false;
        }
        if (password.getText().toString().isEmpty() || password.getText().toString().length() < 6) {
            password.setError("Enter your password with digit more than 6");
            password.requestFocus();
            return false;
        }
        if (email.getText().toString().isEmpty()) {
            email.setError("Enter your password with digit more than 6");
            email.requestFocus();
            return false;
        }
        return true;
    }

    //this method will register users when clicked at register
    public void Register() {
        Url url = new Url();
        User user = new User(userfname.getText().toString(), userlname.getText().toString(), username.getText().toString(), password.getText().toString(), email.getText().toString());
        Call<Void> registerUser = url.createInstanceofRetrofit().addNewUser(user);
        registerUser.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getActivity(), "User Registered successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
            if (validateuser() == true) {
                Userlogic ul = new Userlogic();
                StrictMode();
                if (ul.RegisterUser(userfname.getText().toString(), userlname.getText().toString(), username.getText().toString(), password.getText().toString(),
                        email.getText().toString()) == true) {
                    Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();

                }
            }
            break;
        }
    }
}

