package com.example.aparat.webservise;

import android.util.Log;

import com.example.aparat.Models.Category;
import com.example.aparat.Models.IMessageListener;
import com.example.aparat.Models.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiseCaller {
    Iservise iservise;

    public WebServiseCaller(){
        iservise = AppClient.getRetrofit().create(Iservise.class);
    }

    public void getnewvideo(IMessageListener listener){
        Call<List<Video>> call = iservise.getnewvideo();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.OnFailer(t.getMessage().toString());
            }
        });
    }
    public void getSpecial(IMessageListener listener){
        Call<List<Video>> call = iservise.getSpecialVideo();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.OnFailer(t.getMessage().toString());
            }
        });
    }

    public void getcategory(IMessageListener listener){

        Call<List<Category>> call = iservise.getcategory();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                listener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                listener.OnFailer(t.getMessage().toString());
            }
        });
    }

    public void getvideocategory(IMessageListener listener,String id){

        Call<List<Video>> call = iservise.getVideoCategory(id);

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {

                listener.OnSuccess(response.body());

            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {

                listener.OnFailer("");

            }
        });




    }
}
