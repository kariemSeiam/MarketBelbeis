package com.erots.marketbelbeis.ui.main.marketplace;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = PostModel.class, version = 5 ,exportSchema = false)
abstract class PostDatabase extends RoomDatabase {


    private static PostDatabase instance;
    public abstract PostDao postsDao();

    public static synchronized PostDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PostDatabase.class, "posts_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }



}


