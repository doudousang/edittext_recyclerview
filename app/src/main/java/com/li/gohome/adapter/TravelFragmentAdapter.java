package com.li.gohome.adapter;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TravelFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    List<String> titles;

    public TravelFragmentAdapter(FragmentManager mFragmentManager,
                                 List<Fragment> fragmentList, List<String> titles) {
        super(mFragmentManager);
        this.mFragmentList = fragmentList;
        this.titles = titles;
    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
            return titles.get(position);
    }

    public void getData(List<Fragment> fragmentList, List<String> titles){
        this.mFragmentList = fragmentList;
        this.titles = titles;
        notifyDataSetChanged();
    }
}
