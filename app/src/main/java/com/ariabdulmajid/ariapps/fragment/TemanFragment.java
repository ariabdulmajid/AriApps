package com.ariabdulmajid.ariapps.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.activity.CRUDTemanActivity;
import com.ariabdulmajid.ariapps.adapter.TemanAdapter;
import com.ariabdulmajid.ariapps.model.TemanModel;
import com.ariabdulmajid.ariapps.presenter.TemanPresenter;
import com.ariabdulmajid.ariapps.view.TemanView;

import java.util.ArrayList;
import java.util.List;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class TemanFragment extends Fragment implements TemanView, View.OnClickListener {

    TemanAdapter adapter;
    ArrayList<TemanModel> temanModel;
    static TemanPresenter presenter;
    RecyclerView rvTeman;
    FloatingActionButton fab;

    public TemanFragment() {
        // Required empty public constructor
    }

    @Override
    public void showFriendsList(List<TemanModel> friends) {
        this.temanModel.clear();
        this.temanModel.addAll(friends);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daftar_teman, container, false);
        rvTeman = view.findViewById(R.id.rvTeman);
        fab = view.findViewById(R.id.fabTambahTeman);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        temanModel = new ArrayList<>();
        adapter = new TemanAdapter(temanModel, getActivity());
        rvTeman.setHasFixedSize(true);
        rvTeman.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTeman.setAdapter(adapter);

        presenter = new TemanPresenter(getContext(),this);
        presenter.setFriendsList(this);

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabTambahTeman) {
            Intent i = new Intent(getContext(), CRUDTemanActivity.class);
            i.putExtra("type", 0);
            startActivity(i);
        }
    }
}
