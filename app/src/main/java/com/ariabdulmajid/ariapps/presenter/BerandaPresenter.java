package com.ariabdulmajid.ariapps.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.ariabdulmajid.ariapps.data.model.User;
import com.ariabdulmajid.ariapps.data.repo.UserRepository;
import com.ariabdulmajid.ariapps.preference.UserPreference;
import com.ariabdulmajid.ariapps.view.BerandaView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class BerandaPresenter {

    private BerandaView view;
    private UserRepository repo;
    private UserPreference prefs;

    public BerandaPresenter(Context context, BerandaView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new UserPreference(context);
    }

    public void getUserData(LifecycleOwner owner) {
        String email = prefs.userLogin();
        String password = prefs.passwordLogin();

        repo.selectUser(email, password).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                view.showUser(user);
            }
        });
    }

    public void signOut() {
        prefs.setIsLogin(null, null);
        view.onSignOut();
    }
}
