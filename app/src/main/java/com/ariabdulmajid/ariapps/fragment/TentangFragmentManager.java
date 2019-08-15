package com.ariabdulmajid.ariapps.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ariabdulmajid.ariapps.R;

/**
 * 14-08-2019, 10116322 - ARI ABDUL MAJID - IF8
 */

public class TentangFragmentManager extends Fragment {

    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager viewPager;
    TabLayout tab;

    public TentangFragmentManager() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manager_tentang, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        tab = view.findViewById(R.id.tabs);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new Fragment();
            if (i == 0) {
                fragment = TentangFragment.newInstance(0);
            } else if (i == 1) {
                fragment = TentangFragment.newInstance(1);
            } else if (i == 2) {
                fragment = TentangFragment.newInstance(2);
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
