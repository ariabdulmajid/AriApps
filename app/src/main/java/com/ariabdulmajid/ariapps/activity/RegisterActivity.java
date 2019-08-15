package com.ariabdulmajid.ariapps.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.model.User;
import com.ariabdulmajid.ariapps.presenter.RegisterPresenter;
import com.ariabdulmajid.ariapps.view.RegisterView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    RegisterPresenter presenter;
    EditText etUsername, etNama, etPassword;
    TextView tvFailed;
    Button btnSignUp;

    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void signUpFailed() {
        tvFailed.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        presenter = new RegisterPresenter(this, this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etNama = findViewById(R.id.etNama);
        etPassword = findViewById(R.id.etPassword);
        tvFailed = findViewById(R.id.tvFailed);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void signUp() {
        String username = etUsername.getText().toString();
        String name = etNama.getText().toString();
        String pass = etPassword.getText().toString();

        User user = new User(username, name, pass);

        if (!username.isEmpty()) {
            if (!name.isEmpty()) {
                if (pass.length() >= 8) {

                    presenter.signUp(user);

                } else presenter.setPassError(etPassword);
            } else presenter.setError(etNama);
        } else presenter.setError(etUsername);
    }
}
