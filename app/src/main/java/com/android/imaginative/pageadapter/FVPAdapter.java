package com.android.imaginative.pageadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FVPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragment;

    public FVPAdapter(@NonNull FragmentManager fm , ArrayList<Fragment> fragments) {
        super(fm);
        mFragment = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
