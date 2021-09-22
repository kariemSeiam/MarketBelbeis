package com.erots.marketbelbeis.ui.main.marketplace;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
interface PostDao {

    @Query("SELECT * FROM posts_table ORDER BY price ASC")
    LiveData<List<PostModel>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(PostModel word);

    @Query("DELETE FROM posts_table")
    void deleteAll();

}

