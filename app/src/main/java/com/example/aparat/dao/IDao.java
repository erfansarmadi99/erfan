package com.example.aparat.dao;

import com.example.aparat.Models.Video;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface IDao {

    @Insert
    Long insert(Video video);

    @Delete
    void delete(Video video);

    @Query("select * from tbl_video")
    List<Video> getVideoList();

}
