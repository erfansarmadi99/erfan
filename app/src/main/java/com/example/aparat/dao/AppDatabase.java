package com.example.aparat.dao;

import android.content.Context;

import com.example.aparat.Models.Video;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Video.class},version = 1,exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance = null;
    public abstract IDao dao();

    public synchronized static AppDatabase getInstance(Context context){

        if(instance == null){
            instance = Room.databaseBuilder(context,AppDatabase.class,"video.db")
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
}


