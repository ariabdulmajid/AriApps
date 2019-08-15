package com.ariabdulmajid.ariapps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.fragment.TentangFragmentManager;
import com.ariabdulmajid.ariapps.fragment.KontakFragment;
import com.ariabdulmajid.ariapps.fragment.TemanFragment;
import com.ariabdulmajid.ariapps.fragment.BerandaFragment;
import com.ariabdulmajid.ariapps.fragment.ProfilFragment;
import com.ariabdulmajid.ariapps.presenter.MainPresenter;
import com.ariabdulmajid.ariapps.view.MainView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;
    FragmentManager fm = getSupportFragmentManager();
    final Fragment Beranda = new BerandaFragment();
    final Fragment profil = new ProfilFragment();
    final Fragment kontak = new KontakFragment();
    final Fragment teman = new TemanFragment();
    final Fragment tentang = new TentangFragmentManager();
    Fragment active = profil;
    Fragment[] fragment = {tentang, teman, kontak, profil, Beranda};

    @Override
    public void showView(Fragment fragment) {
        fm.beginTransaction().hide(active).show(fragment).commit();
        active = fragment;
    }

    @Override
    public void addView() {
        for (int i = 0; i<5; i++) {
            fm.beginTransaction().add(R.id.content, fragment[i]).hide(fragment[i]).commit();
        }
    }

    @Override
    public void toLogin() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_beranda:
                    presenter.changeView(Beranda);
                    return true;
                case R.id.nav_profil:
                    presenter.changeView(profil);
                    return true;
                case R.id.nav_kontak:
                    presenter.changeView(kontak);
                    return true;
                case R.id.nav_teman:
                    presenter.changeView(teman);
                    return true;
                case R.id.nav_tentang:
                    presenter.changeView(tentang);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this,this);
        presenter.isLogin();
        presenter.addView();
        presenter.changeView(Beranda);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
