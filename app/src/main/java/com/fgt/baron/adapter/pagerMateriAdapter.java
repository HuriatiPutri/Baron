package com.fgt.baron.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fgt.baron.ArMateriFragment;
import com.fgt.baron.TextMateriFragment;
import com.fgt.baron.VideoMateriFragment;
import com.fgt.baron.VrMateriFragment;

public class pagerMateriAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public pagerMateriAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                TextMateriFragment textMateriFragment = new TextMateriFragment();
                return textMateriFragment;
            case 1:
                VideoMateriFragment videoMateriFragment = new VideoMateriFragment();
                return videoMateriFragment;
            case 2:
                VrMateriFragment vrMateriFragment = new VrMateriFragment();
                return vrMateriFragment;
            case 3:
                ArMateriFragment arMateriFragment = new ArMateriFragment();
                return arMateriFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}

