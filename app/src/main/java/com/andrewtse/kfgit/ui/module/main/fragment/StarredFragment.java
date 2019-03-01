package com.andrewtse.kfgit.ui.module.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andrewtse.kfgit.KFGitApplication;
import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.contract.IStarredContract;
import com.andrewtse.kfgit.data.pref.UserPref;
import com.andrewtse.kfgit.di.IHasComponent;
import com.andrewtse.kfgit.di.component.DaggerIStarredComponent;
import com.andrewtse.kfgit.di.component.IStarredComponent;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.StarredModule;
import com.andrewtse.kfgit.model.StarredModel;
import com.andrewtse.kfgit.presenter.StarredPresenter;
import com.andrewtse.kfgit.ui.adapter.StarredFragmentAdapter;
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
public class StarredFragment extends BaseFragment implements IStarredContract.IStarredView, IHasComponent<IStarredComponent> {

    @BindView(R.id.rv_stars_list)
    RecyclerView mRvStarsList;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private StarredFragmentAdapter mAdapter;

    @Inject
    StarredPresenter mStarsPresenter;

    private int mPage = 1;
    private boolean mIsLoadingMore = false;
    private final int mPerPage = 10;

    public static StarredFragment newInstance() {
        return new StarredFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        mStarsPresenter.attachView(this);
        mPage = 1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_starred, null);
        ButterKnife.bind(this, view);
        initView();
        initAdapter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStarsPresenter.loadStarsRepo(UserPref.getLoginToken(getActivity()), mPage++, mPerPage);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mStarsPresenter.detachView();
    }

    private void initView() {
        mRefreshLayout.setOnRefreshListener(() -> {
            mAdapter.setEnableLoadMore(false);
            mPage = 1;
            mStarsPresenter.loadStarsRepo(UserPref.getLoginToken(getActivity()), mPage++, mPerPage);
        });
        mRvStarsList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initAdapter() {
        mAdapter = new StarredFragmentAdapter(R.layout.item_starred, null);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {

        });
        //上滑加载
        mAdapter.setEnableLoadMore(true);
        mAdapter.setOnLoadMoreListener(() -> {
            mAdapter.setUpFetchEnable(false);
            mStarsPresenter.loadStarsRepo(UserPref.getLoginToken(getActivity()), mPage++, mPerPage);
            mIsLoadingMore = true;
        }, mRvStarsList);
        mAdapter.disableLoadMoreIfNotFullPage();
        //动画
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //动画默认只执行一次,如果想重复执行可设置
        mAdapter.isFirstOnly(false);
        //设置不显示动画数量
        mAdapter.setNotDoAnimationCount(5);

        mRvStarsList.setAdapter(mAdapter);
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
    public void showContent(List<StarredModel> data) {
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
        mPage--;
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
    public IStarredComponent getComponent() {
        return DaggerIStarredComponent.builder()
                                      .iApplicationComponent(KFGitApplication.get(this.getActivity()).getComponent())
                                      .activityModule(new ActivityModule(this.getActivity()))
                                      .starredModule(new StarredModule())
                                      .build();
    }
}
