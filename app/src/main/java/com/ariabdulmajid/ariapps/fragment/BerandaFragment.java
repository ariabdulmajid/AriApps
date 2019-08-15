package com.ariabdulmajid.ariapps.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.activity.LoginActivity;
import com.ariabdulmajid.ariapps.data.model.User;
import com.ariabdulmajid.ariapps.presenter.BerandaPresenter;
import com.ariabdulmajid.ariapps.view.BerandaView;

import java.util.Objects;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */


public class BerandaFragment extends Fragment implements BerandaView {

    BerandaPresenter presenter;
    TextView tvUser;
    Button btnKeluar;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public void showUser(User user) {
        String email = user.getNamalengkap();
        tvUser.setText(email);
    }

    @Override
    public void onSignOut() {
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
        Toast.makeText(getContext(), "Signed Out", Toast.LENGTH_SHORT).show();
        Objects.requireNonNull(getActivity()).finish();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        tvUser = view.findViewById(R.id.tvUser);
        btnKeluar = view.findViewById(R.id.btnKeluar);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new BerandaPresenter(getContext(), this);
        presenter.getUserData(this);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signOut();
            }
        });
    }
}
