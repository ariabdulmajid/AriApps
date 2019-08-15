package com.ariabdulmajid.ariapps.presenter;

import com.ariabdulmajid.ariapps.view.KontakView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class KontakPresenter {

    private KontakView view;

    public KontakPresenter(KontakView view) {
        this.view = view;
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

    public void openFacebook() {

        view.actionFacebook();
    }
}
