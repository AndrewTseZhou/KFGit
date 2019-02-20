package com.andrewtse.kfgit.ui.module.main.fragment;

import androidx.fragment.app.Fragment;

/**
 * @author xk
 * @date 2019/2/19
 */
public class FragmentsDataGenerator {

    public static Fragment[] getFragments() {
        Fragment[] fragments = new Fragment[4];
        fragments[0] = TrendingFragment.newInstance();
        fragments[1] = SearchFragment.newInstance();
        fragments[2] = StarredFragment.newInstance();
        fragments[3] = ProfileFragment.newInstance();
        return fragments;
    }
}
