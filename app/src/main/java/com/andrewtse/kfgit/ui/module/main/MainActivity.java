package com.andrewtse.kfgit.ui.module.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.ui.base.BaseActivity;
import com.andrewtse.kfgit.ui.module.main.fragment.FragmentsDataGenerator;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xk
 * @date 2019/2/19
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.action_bar)
    Toolbar mActionBar;

    private Fragment[] mFragments;
    private String[] mTitles = {"Trending", "Search", "Stars", "Profile"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragments = FragmentsDataGenerator.getFragments();
        initView();
    }

    private void initView() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            onTabItemSelected(item.getItemId());
            return true;
        });
        onTabItemSelected(R.id.tab_menu_trending);
    }

    private void onTabItemSelected(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.tab_menu_trending:
                fragment = mFragments[0];
                mTvTitle.setText(mTitles[0]);
                mActionBar.setVisibility(View.VISIBLE);
                break;
            case R.id.tab_menu_search:
                fragment = mFragments[1];
                mTvTitle.setText(mTitles[1]);
                mActionBar.setVisibility(View.GONE);
                break;
            case R.id.tab_menu_stars:
                fragment = mFragments[2];
                mTvTitle.setText(mTitles[2]);
                mActionBar.setVisibility(View.VISIBLE);
                break;
            case R.id.tab_menu_profile:
                fragment = mFragments[3];
                mTvTitle.setText(mTitles[3]);
                mActionBar.setVisibility(View.VISIBLE);
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }
}
