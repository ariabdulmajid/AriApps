package com.ariabdulmajid.ariapps.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class UserPreference {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public UserPreference(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setFirstRun(Boolean check) {
        editor = preferences.edit();
        editor.putBoolean("firstRun", check);
        editor.apply();
    }

    public void setIsLogin(String username, String password){
        editor = preferences.edit();
        editor.putString("email", username);
        editor.putString("password", password);
        editor.apply();
    }

    public Boolean isFirstRun() {
        return preferences.getBoolean("firstRun", true);
    }

    public String userLogin(){
        return preferences.getString("email",null);
    }

    public String passwordLogin(){
        return preferences.getString("password",null);
    }
}
