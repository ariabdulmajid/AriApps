package com.ariabdulmajid.ariapps.presenter;

import com.ariabdulmajid.ariapps.view.TentangView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class TentangPresenter {

    private TentangView view;

    public TentangPresenter(TentangView view) {
        this.view = view;
    }

    public void selectionView(int tab) {
        if (tab == 0) {
            view.showApp();
        } else if (tab == 1) {
            view.showUniv();
        } else {
            view.showCreator();
        }
    }
}
