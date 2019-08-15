package com.ariabdulmajid.ariapps.presenter;

import android.content.Context;
import android.widget.EditText;

import com.ariabdulmajid.ariapps.data.model.User;
import com.ariabdulmajid.ariapps.data.repo.UserRepository;
import com.ariabdulmajid.ariapps.view.RegisterView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class RegisterPresenter {

    private RegisterView view;
    private UserRepository repo;

    public RegisterPresenter(Context context, RegisterView view) {
        this.view = view;
        repo = new UserRepository(context);
    }

    public void signUp(User user) {
        try {
            repo.insertUser(user);
            view.signUpSuccess();
        } catch (Exception ex) {
            view.signUpFailed();
        }
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Please fill this box !");
    }

    public void setPassError(EditText editText) {
        editText.requestFocus();
        editText.setError("Password length minimal 8 character !");
    }
}
