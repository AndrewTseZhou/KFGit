package com.andrewtse.kfgit.ui.module.main.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.andrewtse.kfgit.KFGitApplication;
import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.common.utils.ClickUtils;
import com.andrewtse.kfgit.common.utils.KeyboardUtils;
import com.andrewtse.kfgit.contract.ISearchContract;
import com.andrewtse.kfgit.data.net.datasource.RepoDataSource;
import com.andrewtse.kfgit.di.IHasComponent;
import com.andrewtse.kfgit.di.component.DaggerIRepoComponent;
import com.andrewtse.kfgit.di.component.IRepoComponent;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.RepoModule;
import com.andrewtse.kfgit.model.SearchModel;
import com.andrewtse.kfgit.presenter.SearchPresenter;
import com.andrewtse.kfgit.ui.adapter.SearchFragmentAdapter;
import com.andrewtse.kfgit.ui.base.BaseFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xk
 * @date 2019/2/19
 */
public class SearchFragment extends BaseFragment implements ISearchContract.ISearchView, IHasComponent<IRepoComponent> {

    @BindView(R.id.et_search)
    TextInputEditText mEtSearch;
    @BindView(R.id.rv_search_list)
    RecyclerView mRvSearchList;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    @BindView(R.id.loading)
    ImageView mLoading;
    @BindView(R.id.ib_switcher)
    ImageButton mIbSwitcher;

    private SearchFragmentAdapter mAdapter;

    @Inject
    SearchPresenter mSearchPresenter;

    private int mPage = 1;
    private final int mPerPage = 20;
    private boolean mIsLoadingMore = false;
    private boolean mIsCanLoadMore = true;
    private String mInput;
    private Animation mLoadAnimation;
    private int mSearchType = RepoDataSource.SEARCH_REPOS;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        mSearchPresenter.attachView(this);
        mPage = 1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);
        ButterKnife.bind(this, view);
        initView();
        initAdapter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSearchPresenter.detachView();
    }

    private void initView() {
        mEtSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (EditorInfo.IME_ACTION_SEARCH == actionId) {
                KeyboardUtils.hideSoftInput(getActivity());
                mInput = mEtSearch.getText().toString().trim();
                if (!TextUtils.isEmpty(mInput)) {
                    mSearchPresenter.getSearchResult(mInput, mPage++, mPerPage, mSearchType);
                }
                return true;
            }
            return false;
        });

        mIvSearch.setOnClickListener(v -> {
            mPage = 1;
            KeyboardUtils.hideSoftInput(getActivity());
            mInput = mEtSearch.getText().toString().trim();
            if (!TextUtils.isEmpty(mInput)) {
                mSearchPresenter.getSearchResult(mInput, mPage++, mPerPage, mSearchType);
            }
        });

        mIbSwitcher.setOnClickListener(v -> {
            if (mSearchType == RepoDataSource.SEARCH_REPOS) {
                mSearchType = RepoDataSource.SEARCH_USERS;
                mIbSwitcher.setBackgroundResource(R.drawable.ic_search_users);
            } else {
                mSearchType = RepoDataSource.SEARCH_REPOS;
                mIbSwitcher.setBackgroundResource(R.drawable.ic_search_repo);
            }
        });

        mRvSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLoadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_loading);
        mLoadAnimation.setRepeatMode(Animation.RESTART);
        mLoadAnimation.setRepeatCount(Animation.INFINITE);
    }

    private void initAdapter() {
        mAdapter = new SearchFragmentAdapter(R.layout.item_search, null);
        mAdapter.setOnItemClickListener(ClickUtils::handleBaseRepoClick);

        mAdapter.setUpFetchEnable(false);
        mAdapter.setEnableLoadMore(true);
        mAdapter.setOnLoadMoreListener(() -> {
            if (mIsCanLoadMore) {
                mInput = mEtSearch.getText().toString().trim();
                if (!TextUtils.isEmpty(mInput)) {
                    mIsLoadingMore = true;
                    mSearchPresenter.getSearchResult(mInput, mPage++, mPerPage, mSearchType);
                }
            } else {
                Toast.makeText(getActivity(), getString(R.string.loadmore_end), Toast.LENGTH_SHORT).show();
            }
        }, mRvSearchList);
        mAdapter.disableLoadMoreIfNotFullPage();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mAdapter.isFirstOnly(false);
        mAdapter.setNotDoAnimationCount(5);

        mRvSearchList.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
        mLoading.startAnimation(mLoadAnimation);
    }

    @Override
    public void dismissLoading() {
        mLoading.setVisibility(View.GONE);
        mLoading.clearAnimation();
    }

    @Override
    public void showContent(List<SearchModel> data) {
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
                mIsCanLoadMore = false;
            } else {
                mAdapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.stars_empty_view, null));
            }
        }
    }

    @Override
    public void showError(Throwable e) {
        mAdapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.stars_error_view, null));
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public IRepoComponent getComponent() {
        return DaggerIRepoComponent.builder()
                                   .iApplicationComponent(KFGitApplication.get(getActivity()).getComponent())
                                   .activityModule(new ActivityModule(getActivity()))
                                   .repoModule(new RepoModule())
                                   .build();
    }
}
