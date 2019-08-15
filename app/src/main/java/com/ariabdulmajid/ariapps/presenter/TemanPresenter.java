package com.ariabdulmajid.ariapps.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.ariabdulmajid.ariapps.model.TemanModel;
import com.ariabdulmajid.ariapps.repo.TemanRepository;
import com.ariabdulmajid.ariapps.view.TemanView;

import java.util.List;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class TemanPresenter {

    private TemanRepository repo;
    private TemanView view;
    private LiveData<List<TemanModel>> allFriends;

    public TemanPresenter(Context context, TemanView view) {
        this.view = view;
        repo = new TemanRepository(context);
        allFriends = repo.getAllFriends();
    }

    public void setFriendsList(LifecycleOwner owner) {
        allFriends.observe(owner, new Observer<List<TemanModel>>() {
            @Override
            public void onChanged(@Nullable List<TemanModel> friends) {
                view.showFriendsList(friends);
            }
        });
    }
}
