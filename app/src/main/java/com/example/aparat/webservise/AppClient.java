package com.example.aparat.webservise;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {

    private static String baseUrl = "http://www.androidsupport.ir/pack/aparat/";
    public static Retrofit retrofit = null;
    private AppClient(){

    }
    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
