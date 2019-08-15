package com.ariabdulmajid.ariapps.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.presenter.TentangPresenter;
import com.ariabdulmajid.ariapps.view.TentangView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class TentangFragment extends Fragment implements TentangView {

    int tab;
    LinearLayout viewpager1, viewpager2, viewpager3;
    TentangPresenter presenter;

    public TentangFragment() {
        // Required empty public constructor
    }

    public static TentangFragment newInstance(int tab) {
        TentangFragment fragment = new TentangFragment();
        Bundle args = new Bundle();
        args.putInt("tab", tab);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tentang, container, false);

        viewpager1 = view.findViewById(R.id.viewpager1);
        viewpager2 = view.findViewById(R.id.viewpager2);
        viewpager3 = view.findViewById(R.id.viewpager3);

        presenter = new TentangPresenter(this);

        if (getArguments() != null) {
            tab = getArguments().getInt("tab");
            presenter.selectionView(tab);
        }
        return view;
    }

    @Override
    public void showApp() {
        viewpager1.setVisibility(View.VISIBLE);
        viewpager2.setVisibility(View.GONE);
        viewpager3.setVisibility(View.GONE);
    }

    @Override
    public void showUniv() {
        viewpager1.setVisibility(View.GONE);
        viewpager2.setVisibility(View.VISIBLE);
        viewpager3.setVisibility(View.GONE);
    }

    @Override
    public void showCreator() {
        viewpager1.setVisibility(View.GONE);
        viewpager2.setVisibility(View.GONE);
        viewpager3.setVisibility(View.VISIBLE);
    }
}
