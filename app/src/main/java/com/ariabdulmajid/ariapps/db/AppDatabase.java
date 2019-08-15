package com.ariabdulmajid.ariapps.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ariabdulmajid.ariapps.model.TemanModel;
import com.ariabdulmajid.ariapps.model.User;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


@Database(entities = {TemanModel.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TemanDao temanDao();
    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "ariapps_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
