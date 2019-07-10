package com.example.bookyourvenue.Businesslogic;

import com.example.bookyourvenue.Api.API;
import com.example.bookyourvenue.Api.Url;
import com.example.bookyourvenue.Model.LoginResponse;
import com.example.bookyourvenue.Model.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Userlogic {


    public static User user;
public static String token;

    public boolean LoginUser(String username, String password){
        boolean isSuccess=false;
        Url url=new Url();
        API api= url.createInstanceofRetrofit();
        Call<LoginResponse> usercall=api.checkUser(username,password);
        try{
            Response<LoginResponse> loginresponse =usercall.execute();
            if (!loginresponse.body().getToken().isEmpty()){
                token=loginresponse.body().getToken();
                user=loginresponse.body().getUser();
                isSuccess=true;


            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    public boolean RegisterUser(String userfname,String userlname,String username,String password,String email) {
        boolean register = false;
        Url url=new Url();
        API api= url.createInstanceofRetrofit();
        User user=new User(userfname,userlname,username,password,email);
        Call<Void>addNewUser=api.addNewUser(user);
        try{
            Response<Void>adduser=addNewUser.execute();
            if (adduser.isSuccessful()){
                register=true;
            }

}catch (IOException e){
        e.printStackTrace();
        }

        return register;
        }
        }
