package com.andrewtse.kfgit.ui.module.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andrewtse.kfgit.KFGitApplication;
import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.contract.ITrendingContract;
import com.andrewtse.kfgit.di.IHasComponent;
import com.andrewtse.kfgit.di.component.DaggerITrendingComponent;
import com.andrewtse.kfgit.di.component.ITrendingComponent;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.TrendingModule;
import com.andrewtse.kfgit.model.TrendingModel;
import com.andrewtse.kfgit.presenter.TrendingPresenter;
import com.andrewtse.kfgit.ui.adapter.TrendingFragmentAdapter;
import com.andrewtse.kfgit.ui.base.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xk
 * @date 2019/2/19
 */
public class TrendingFragment extends BaseFragment implements ITrendingContract.ITrendingView, IHasComponent<ITrendingComponent> {

    @BindView(R.id.rv_trending_list)
    RecyclerView mRvTrendingList;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private TrendingFragmentAdapter mAdapter;
    private boolean mIsLoadingMore = false;

    @Inject
    TrendingPresenter mTrendingPresenter;


    public static TrendingFragment newInstance() {
        return new TrendingFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        mTrendingPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trending, null);
        ButterKnife.bind(this, view);
        initView();
        initAdapter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTrendingPresenter.getTrendingRepo("all", "weekly");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTrendingPresenter.detachView();
    }

    private void initView() {
        mRefreshLayout.setOnRefreshListener(() -> {
            mAdapter.setEnableLoadMore(false);
            mTrendingPresenter.getTrendingRepo("all", "weekly");
        });
        mRvTrendingList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initAdapter() {
        mAdapter = new TrendingFragmentAdapter(R.layout.item_trending, null);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {

        });

        mAdapter.setEnableLoadMore(true);
        mAdapter.setOnLoadMoreListener(() -> {
            mAdapter.setUpFetchEnable(false);
            mTrendingPresenter.getTrendingRepo("all", "weekly");
            mIsLoadingMore = true;
        }, mRvTrendingList);
        mAdapter.disableLoadMoreIfNotFullPage();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNotDoAnimationCount(5);

        mRvTrendingList.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {
        if (!mIsLoadingMore) {
            mRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void dismissLoading() {
        if (!mIsLoadingMore) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showContent(List<TrendingModel> data) {
        if (data != null && data.size() > 0) {
            if (mIsLoadingMore && mAdapter.getData().size() > 0) {
                mAdapter.addData(data);
                mAdapter.loadMoreComplete();
                mIsLoadingMore = false;
            } else {
                mAdapter.setNewData(data);
            }
        } else {
            if (mIsLoadingMore) {
                mAdapter.loadMoreEnd();
                mIsLoadingMore = false;
            } else {
                mAdapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.stars_empty_view, null));
            }
        }

        mAdapter.setUpFetchEnable(true);
        mAdapter.setEnableLoadMore(true);
    }

    @Override
    public void showError(Throwable e) {
        if (mIsLoadingMore) {
            mAdapter.loadMoreFail();
        }
        if (mAdapter.getData().size() == 0) {
            mAdapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.stars_error_view, null));
        }
        Toast.makeText(getContext(), getString(R.string.load_failed), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public ITrendingComponent getComponent() {
        return DaggerITrendingComponent.builder()
                                       .iApplicationComponent(KFGitApplication.get(getActivity()).getComponent())
                                       .activityModule(new ActivityModule(getActivity()))
                                       .trendingModule(new TrendingModule())
                                       .build();
    }
}
