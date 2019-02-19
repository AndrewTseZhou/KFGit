package com.andrewtse.kfgit.ui.module.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.ui.base.BaseFragment;

import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/19
 */
public class SearchFragment extends BaseFragment {

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);
        TextView content = view.findViewById(R.id.fragment_content);
        content.setText("SearchFragment");
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
