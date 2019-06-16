package com.fgt.baron.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fgt.baron.ContentFragment;
import com.fgt.baron.IklanFragment;
import com.fgt.baron.InformasiFragment;

public class pagerAccountAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public pagerAccountAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                InformasiFragment informasiFragment = new InformasiFragment();
                return informasiFragment;
            case 1:
                ContentFragment contentFragment = new ContentFragment();
                return contentFragment;
            case 2:
                IklanFragment iklanFragment = new IklanFragment();
                return iklanFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
