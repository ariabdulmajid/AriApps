package com.ariabdulmajid.ariapps.data.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import com.ariabdulmajid.ariapps.data.db.AppDatabase;
import com.ariabdulmajid.ariapps.data.db.TemanDao;
import com.ariabdulmajid.ariapps.data.model.TemanModel;

import java.util.List;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


public class TemanRepository {
    private TemanDao temanDao;
    private LiveData<List<TemanModel>> friendsList;

    public TemanRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        temanDao = db.temanDao();
        friendsList = temanDao.getAll();
    }

    public LiveData<List<TemanModel>> getAllFriends() {
        return friendsList;
    }

    public void insertFriend(TemanModel temanModel) {
        new insertAsync(temanDao).execute(temanModel);
    }

    public void updateFriend(TemanModel temanModel) {
        new updateAsync(temanDao).execute(temanModel);
    }

    public void deleteFriend(TemanModel temanModel) {
        new deleteAsync(temanDao).execute(temanModel);
    }

    private static class insertAsync extends AsyncTask<TemanModel, Void, Void> {
        private TemanDao temanDao;

        insertAsync(TemanDao temanDao) {
            this.temanDao = temanDao;
        }

        @Override
        protected Void doInBackground(TemanModel... friends) {
            temanDao.addFriend(friends);
            return null;
        }
    }

    private static class updateAsync extends AsyncTask<TemanModel, Void, Void> {
        private TemanDao temanDao;

        updateAsync(TemanDao temanDao) {
            this.temanDao = temanDao;
        }

        @Override
        protected Void doInBackground(TemanModel... friends) {
            temanDao.updateFriend(friends);
            return null;
        }
    }

    private static class deleteAsync extends AsyncTask<TemanModel, Void, Void> {
        private TemanDao temanDao;

        deleteAsync(TemanDao temanDao) {
            this.temanDao = temanDao;
        }

        @Override
        protected Void doInBackground(TemanModel... friends) {
            temanDao.deleteFriend(friends);
            return null;
        }
    }
}
