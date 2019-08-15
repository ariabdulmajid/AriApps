package com.ariabdulmajid.ariapps.presenter;

import android.content.Context;

import com.ariabdulmajid.ariapps.model.TemanModel;
import com.ariabdulmajid.ariapps.repo.TemanRepository;
import com.ariabdulmajid.ariapps.view.DetailTemanView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class DetailTemanPresenter {

    private DetailTemanView view;
    private TemanRepository repo;

    public DetailTemanPresenter(Context context, DetailTemanView view) {
        this.view = view;
        repo = new TemanRepository(context);
    }

    public void getFriendsDetail(TemanModel fr) {
        view.showDetail(fr);
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void removeFriend(TemanModel friend) {
        repo.deleteFriend(friend);
        view.onFriendDeleted();
    }
}
