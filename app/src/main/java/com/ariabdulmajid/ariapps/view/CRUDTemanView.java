package com.ariabdulmajid.ariapps.view;

import android.widget.EditText;

import com.ariabdulmajid.ariapps.data.model.TemanModel;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public interface CRUDTemanView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(TemanModel friend);
    void showError(EditText et);
    void showFailed(String msg);
}
