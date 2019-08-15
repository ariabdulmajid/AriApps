package com.ariabdulmajid.ariapps.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.ariabdulmajid.ariapps.data.model.TemanModel;

import java.util.List;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


@Dao
public interface TemanDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addFriend(TemanModel... temanModel);

    @Delete
    void deleteFriend(TemanModel... temanModel);

    @Update
    void updateFriend(TemanModel... temanModel);

    @Query("SELECT * FROM teman ORDER BY nim")
    LiveData<List<TemanModel>> getAll();
}
