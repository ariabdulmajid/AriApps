package com.ariabdulmajid.ariapps.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.data.model.TemanModel;
import com.ariabdulmajid.ariapps.data.model.TemanData;
import com.ariabdulmajid.ariapps.data.repo.TemanRepository;
import com.ariabdulmajid.ariapps.preference.UserPreference;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


public class SplashActivity extends AppCompatActivity {

    TemanRepository repo;
    UserPreference prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        repo = new TemanRepository(this);
        prefs = new UserPreference(this);

        Boolean isFirstRun = prefs.isFirstRun();
        if (isFirstRun) {
            TemanModel temanModel;
            for (String[] aData : TemanData.initFriendsData) {
                temanModel = new TemanModel(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5]);
                repo.insertFriend(temanModel);
            }

            prefs.setFirstRun(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
    }
}
