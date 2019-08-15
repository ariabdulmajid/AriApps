package com.ariabdulmajid.ariapps.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import com.ariabdulmajid.ariapps.db.AppDatabase;
import com.ariabdulmajid.ariapps.db.UserDao;
import com.ariabdulmajid.ariapps.model.User;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        userDao = db.userDao();
    }

    public LiveData<User> selectUser(String username, String password) {
        return userDao.login(username, password);
    }

    public void insertUser(User user) {
        new insertAsync(userDao).execute(user);
    }

    private static class insertAsync extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        insertAsync(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... user) {
            userDao.addUser(user);
            return null;
        }
    }
}
