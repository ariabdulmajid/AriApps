package com.ariabdulmajid.ariapps.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariabdulmajid.ariapps.R;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class ProfilFragment extends Fragment {

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

}
