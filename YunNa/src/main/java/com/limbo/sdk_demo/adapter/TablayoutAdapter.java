package com.limbo.sdk_demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by wangqi on 2018/5/15.
 */

public class TablayoutAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list;
    private String[] titles;

    public TablayoutAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

