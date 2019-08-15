package com.ariabdulmajid.ariapps.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ariabdulmajid.ariapps.R;
import com.ariabdulmajid.ariapps.presenter.KontakPresenter;
import com.ariabdulmajid.ariapps.view.KontakView;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class KontakFragment extends Fragment implements KontakView, View.OnClickListener {

    RelativeLayout lytPhone, lytEmail, lytIG, lytFb;
    KontakPresenter presenter;

    public KontakFragment() {
        // Required empty public constructor
    }

    public static KontakFragment newInstance() {
        return new KontakFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        lytPhone = view.findViewById(R.id.lytPhone);
        lytEmail = view.findViewById(R.id.lytEmail);
        lytIG = view.findViewById(R.id.lytIg);
        lytFb = view.findViewById(R.id.lytFb);

        lytPhone.setOnClickListener(this);
        lytEmail.setOnClickListener(this);
        lytIG.setOnClickListener(this);
        lytFb.setOnClickListener(this);

        presenter = new KontakPresenter(this);

        return view;
    }

    @Override
    public void actionCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","6287726572124", null));
        startActivity(i);
    }

    @Override
    public void actionEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ariabdulmajid@gmail.com"));
        startActivity(i);
    }

    @Override
    public void actionInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/ariabdulmajid"));
        startActivity(i);
    }

    @Override
    public void actionFacebook() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/ariabdulmajid"));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lytPhone:
                presenter.makeCall();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.openInstagram();
                break;
            case R.id.lytFb:
                presenter.openFacebook();
                break;
        }
    }
}
