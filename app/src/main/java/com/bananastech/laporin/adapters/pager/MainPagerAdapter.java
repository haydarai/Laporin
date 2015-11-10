package com.bananastech.laporin.adapters.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bananastech.laporin.fragments.ConFragment;
import com.bananastech.laporin.fragments.HomeFragment;
import com.bananastech.laporin.fragments.ReportFragment;

/**
 * Created by Haydar Ali Ismail on 24-Oct-15.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private String titles[] = new String[] {"Home", "Daftar Penipu"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : return new HomeFragment();
            case 1 : return new ConFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
