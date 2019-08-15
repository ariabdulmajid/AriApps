package com.ariabdulmajid.ariapps.presenter;

import android.content.Context;
import android.widget.EditText;

import com.ariabdulmajid.ariapps.data.model.TemanModel;
import com.ariabdulmajid.ariapps.data.repo.TemanRepository;
import com.ariabdulmajid.ariapps.view.CRUDTemanView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class CRUDTemanPresenter {

    private TemanRepository repo;
    private CRUDTemanView view;

    public CRUDTemanPresenter(Context context, CRUDTemanView view) {
        this.view = view;
        repo = new TemanRepository(context);
    }

    public void isEdit(int type) {
        if (type == 1) {
            view.showData();
        }
    }

    public void addFriend(TemanModel friend) {
        try {
            repo.insertFriend(friend);
            view.onFriendAdded();
        } catch (Exception ex) {
            view.showFailed("Failed to add friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void updateFriend(TemanModel friend) {
        try {
            repo.updateFriend(friend);
            view.onFriendUpdated(friend);
        } catch (Exception ex) {
            view.showFailed("Failed to update friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void setError(EditText et) {
        view.showError(et);
    }
}
