package com.example.bookyourvenue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private  final List<String> fragmentlisttitles = new ArrayList<>();

    public PageAdapter(FragmentManager fm){
        super (fm);
    }
    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentlisttitles.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlisttitles.size();
    }

    public void AddFragment(Fragment fragment, String Title){
        fragmentList.add(fragment);
        fragmentlisttitles.add(Title);
    }
}

