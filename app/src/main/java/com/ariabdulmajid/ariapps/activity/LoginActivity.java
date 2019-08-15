package com.ariabdulmajid.ariapps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.presenter.LoginPresenter;
import com.ariabdulmajid.ariapps.view.LoginView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    LoginPresenter presenter;
    EditText etUsername, etPassword;
    Button btnLogin, btnSignUp;

    @Override
    public void loginSuccess() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void loginFail() {
        Snackbar.make(btnLogin, "Failed to Logged in!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        presenter = new LoginPresenter(this, this);
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) login();
        else if (v.getId() == R.id.btnSignUp) {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        }
    }

    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void login() {
        if (!etUsername.getText().toString().isEmpty()) {
            if (!etPassword.getText().toString().isEmpty()){

                presenter.login(this, etUsername.getText().toString(), etPassword.getText().toString());

            } else presenter.setError(etPassword);
        } else presenter.setError(etUsername);
    }
}
