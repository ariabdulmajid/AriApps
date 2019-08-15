package com.ariabdulmajid.ariapps.view;

import com.ariabdulmajid.ariapps.data.model.TemanModel;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public interface DetailTemanView {
    void showDetail(TemanModel fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void onFriendDeleted();
}
