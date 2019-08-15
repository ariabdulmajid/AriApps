package com.ariabdulmajid.ariapps.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.data.model.TemanModel;
import com.ariabdulmajid.ariapps.presenter.DetailTemanPresenter;
import com.ariabdulmajid.ariapps.view.DetailTemanView;

import java.util.Objects;
import java.util.Random;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class DetailTemanActivity extends AppCompatActivity implements DetailTemanView, View.OnClickListener {

    Toolbar toolbar;
    ImageView imgAva;
    TextView tvNama, tvNIM, tvKelas, tvTelp, tvEmail, tvIg;
    DetailTemanPresenter presenter;
    TemanModel temanModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teman);
        initView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        presenter = new DetailTemanPresenter(this, this);
        temanModel = getIntent().getParcelableExtra("friend");
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarDetail);
        imgAva = findViewById(R.id.imgTeman);
        tvNama = findViewById(R.id.tvNamaTeman);
        tvNIM = findViewById(R.id.tvNIMTeman);
        tvKelas = findViewById(R.id.tvKelasTeman);
        tvTelp = findViewById(R.id.tvTelpTeman);
        tvEmail = findViewById(R.id.tvEmailTeman);
        tvIg = findViewById(R.id.tvIGTeman);
    }

    private String data(String value) {
        String newValue = "N/A";
        if (!value.isEmpty()) newValue = value;

        return newValue;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getFriendsDetail(temanModel);
    }

    @Override
    public void showDetail(TemanModel fr) {
        int[] ava = {R.drawable.ava1, R.drawable.ava2, R.drawable.ava3, R.drawable.ava4, R.drawable.ava5};
        Random ran = new Random();
        int i = ran.nextInt(ava.length);

        imgAva.setImageResource(ava[i]);

        tvNama.setText(temanModel.getNama());
        tvNIM.setText(temanModel.getNim());
        tvKelas.setText(temanModel.getKelas());
        tvTelp.setText(data(temanModel.getTelp()));
        tvEmail.setText(data(temanModel.getEmail()));
        tvIg.setText(data(temanModel.getIg()));
    }

    @Override
    public void actionCall() {
        if (!temanModel.getTelp().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", temanModel.getTelp(), null));
            startActivity(i);
        }
    }

    @Override
    public void actionEmail() {
        if (!temanModel.getEmail().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + temanModel.getEmail()));
            startActivity(i);
        }
    }

    @Override
    public void actionInstagram() {
        if (!temanModel.getIg().isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/" + temanModel.getIg().replace("@", "")));
            startActivity(i);
        }
    }

    @Override
    public void onFriendDeleted() {
        Toast.makeText(this, "Friend Deleted", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lytPhone:
                presenter.makeCall();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.openInstagram();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.nav_delete:
                presenter.removeFriend(temanModel);
                break;
            case R.id.nav_edit:
                Intent i = new Intent(DetailTemanActivity.this, CRUDTemanActivity.class);
                i.putExtra("type", 1);
                i.putExtra("friend", temanModel);
                startActivityForResult(i, 1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                temanModel = data.getParcelableExtra("newData");
            }
        }
    }
}
