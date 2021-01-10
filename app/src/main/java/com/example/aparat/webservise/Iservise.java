package com.example.aparat.webservise;

import com.example.aparat.Models.Category;
import com.example.aparat.Models.Video;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Iservise {
    @GET("getNewVideos.php")
    Call<ResponseBody> exmaplegetnewvideo();

    @GET("getNewVideos.php")
    Call<List<Video>> getnewvideo();

    @GET("getSpecial.php")
    Call<List<Video>> getSpecialVideo();

    @POST("register.php")
    Call<ResponseBody> register(@Field("username") String user,
                                @Field("password") String pass);
    @GET("getCategory.php")
    Call<List<Category>> getcategory();

    @FormUrlEncoded
    @POST("getVideosCategory.php")
    Call<List<Video>> getVideoCategory(@Field("catId") String id);
}
