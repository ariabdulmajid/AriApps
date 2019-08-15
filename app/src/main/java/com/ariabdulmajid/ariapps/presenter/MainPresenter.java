package com.ariabdulmajid.ariapps.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.ariabdulmajid.ariapps.preference.UserPreference;
import com.ariabdulmajid.ariapps.view.MainView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
