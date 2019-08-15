package com.ariabdulmajid.ariapps.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.data.model.TemanModel;
import com.ariabdulmajid.ariapps.presenter.CRUDTemanPresenter;
import com.ariabdulmajid.ariapps.view.CRUDTemanView;

import java.util.Objects;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class CRUDTemanActivity extends AppCompatActivity implements CRUDTemanView {

    Toolbar toolbar;
    TextView tvTitle;
    EditText etNama, etNIM, etKelas, etTelp, etEmail, etIG;
    CRUDTemanPresenter presenter;
    int type;

    @Override
    public void showData() {
        tvTitle.setText(getResources().getString(R.string.edit_teman));

        TemanModel f = getIntent().getParcelableExtra("teman");
        etNama.setText(f.getNama());
        etNIM.setText(f.getNim());
        etKelas.setText(f.getKelas());
        etTelp.setText(f.getTelp());
        etEmail.setText(f.getEmail());
        etIG.setText(f.getIg());
    }

    @Override
    public void onFriendAdded() {
        Toast.makeText(this, "Teman ditambahkan", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFriendUpdated(TemanModel friend) {
        Intent i = new Intent();
        i.putExtra("newData", friend);
        setResult(Activity.RESULT_OK, i);

        Toast.makeText(this, "Update Teman", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showError(EditText et) {
        et.requestFocus();
        et.setError("Please Fill This Box !");
    }

    @Override
    public void showFailed(String msg) {
        Snackbar.make(etNIM, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_teman);
        initView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        type = getIntent().getIntExtra("type", 0);

        presenter = new CRUDTemanPresenter(this, this);
        presenter.isEdit(type);
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarTambahTeman);
        tvTitle = findViewById(R.id.tvTitle);
        etNama = findViewById(R.id.etNama);
        etNIM = findViewById(R.id.etNIM);
        etKelas = findViewById(R.id.etKelas);
        etTelp = findViewById(R.id.etTelp);
        etEmail = findViewById(R.id.etEmail);
        etIG = findViewById(R.id.etIG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            case R.id.nav_done:
                TemanModel teman = new TemanModel(
                        etNama.getText().toString(),
                        etNIM.getText().toString(),
                        etKelas.getText().toString(),
                        etTelp.getText().toString(),
                        etEmail.getText().toString(),
                        etIG.getText().toString()
                );

                if (!etNama.getText().toString().isEmpty()) {
                    if (!etNIM.getText().toString().isEmpty()) {
                        if (!etKelas.getText().toString().isEmpty()) {

                            if (type == 0) presenter.addFriend(teman);
                            else presenter.updateFriend(teman);

                        } else presenter.setError(etKelas);
                    } else presenter.setError(etNIM);
                } else presenter.setError(etNama);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
