package com.andrewtse.kfgit.ui.module.repo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andrewtse.kfgit.KFGitApplication;
import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.common.utils.ConvertUtils;
import com.andrewtse.kfgit.common.utils.GlideUtils;
import com.andrewtse.kfgit.contract.IRepoDetailInfoContract;
import com.andrewtse.kfgit.di.IHasComponent;
import com.andrewtse.kfgit.di.component.DaggerIRepoComponent;
import com.andrewtse.kfgit.di.component.IRepoComponent;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.RepoModule;
import com.andrewtse.kfgit.model.RepoDetailInfoModel;
import com.andrewtse.kfgit.presenter.RepoDetailInfoPresenter;
import com.andrewtse.kfgit.ui.adapter.RepoInfoAdapter;
import com.andrewtse.kfgit.ui.entity.RepoInfoItem;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoDetailInfoActivity extends AppCompatActivity implements IRepoDetailInfoContract.IRepoDetailInfoView, IHasComponent<IRepoComponent> {

    public static final String OWNER_NAME = "owner_name";

    public static final String REPO_NAME = "repo_name";

    @Inject
    RepoDetailInfoPresenter mDetailInfoPresenter;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.action_bar)
    Toolbar mToolbar;
    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.tv_full_name)
    TextView mTvFullName;
    @BindView(R.id.tv_description)
    TextView mTvDescription;
    @BindView(R.id.tv_updated_at)
    TextView mTvUpdatedAt;
    @BindView(R.id.tv_watcher_count)
    TextView mTvWatcherCount;
    @BindView(R.id.tv_starred_count)
    TextView mTvStarredCount;
    @BindView(R.id.tv_forks_count)
    TextView mTvForksCount;
    @BindView(R.id.loading)
    ImageView mLoading;
    @BindView(R.id.cv_repo_info)
    CardView mCvRepoInfo;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    @BindView(R.id.rv_repo_info_list)
    RecyclerView mRvRepoInfoList;

    private RepoInfoAdapter mAdapter;
    private List<RepoInfoItem> mRepoInfoItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_detail_info);
        ButterKnife.bind(this);
        getComponent().inject(this);
        mDetailInfoPresenter.attachView(this);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String ownerName = bundle.getString(OWNER_NAME);
                String repoName = bundle.getString(REPO_NAME);
                mDetailInfoPresenter.getRepoDetailInfo(ownerName, repoName);
            }
        }

        mToolbar.setNavigationOnClickListener(v -> finish());

        initView();
        initAdapter();
    }

    private void initView() {
        mRvRepoInfoList.setLayoutManager(new LinearLayoutManager(this));
        mRvRepoInfoList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initAdapter() {
        mAdapter = new RepoInfoAdapter(R.layout.item_repo_info, mRepoInfoItems);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        mAdapter.setEnableLoadMore(false);
        mAdapter.setUpFetchEnable(false);
        mAdapter.bindToRecyclerView(mRvRepoInfoList);
        mAdapter.disableLoadMoreIfNotFullPage();
    }

    @Override
    public void showLoading() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_loading);
        loadAnimation.setRepeatMode(Animation.RESTART);
        loadAnimation.setRepeatCount(Animation.INFINITE);
        mLoading.setVisibility(View.VISIBLE);
        mLoading.startAnimation(loadAnimation);
    }

    @Override
    public void dismissLoading() {
        mLoading.setVisibility(View.GONE);
        mLoading.clearAnimation();
    }

    @Override
    public void showContent(RepoDetailInfoModel data) {
        loadMainData(data);
        loadListData(data);
        mCvRepoInfo.setVisibility(View.VISIBLE);
        mLlContainer.setVisibility(View.VISIBLE);
        mRvRepoInfoList.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showEmpty() {

    }

    private void loadMainData(RepoDetailInfoModel data) {
        GlideUtils.loadImg(this, data.getOwner().getAvatarUrl(), mIvAvatar);
        mTvFullName.setText(data.getFullName());
        mTvDescription.setText(data.getDescription());
        mTvUpdatedAt.setText(ConvertUtils.convertTime(data.getUpdatedAt()));
        mTvWatcherCount.setText("Watchers\n" + data.getSubscribersCount());
        mTvStarredCount.setText("Stars\n" + data.getStargazersCount());
        mTvForksCount.setText("Forks\n" + data.getForksCount());
    }

    private void loadListData(RepoDetailInfoModel data) {
        mRepoInfoItems.clear();
        int[] icons = {R.drawable.code, R.drawable.protocol, R.drawable.issue, R.drawable.branch};
        String[] keys = {data.getLanguage(), "Protocol", "Issues", "Branch"};
        String[] values = new String[icons.length];
        values[0] = String.valueOf(data.getSize() / 1000f) + " MB";
        values[1] = data.getLicense() != null ? data.getLicense().getName() : "Uknown";
        values[2] = String.valueOf(data.getOpenIssuesCount());
        values[3] = data.getDefaultBranch();

        for (int i = 0; i < icons.length; i++) {
            RepoInfoItem item = new RepoInfoItem();
            item.setIconId(icons[i]);
            item.setKey(keys[i]);
            item.setValue(values[i]);
            mRepoInfoItems.add(item);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public IRepoComponent getComponent() {
        return DaggerIRepoComponent.builder()
                                   .iApplicationComponent(KFGitApplication.get(this).getComponent())
                                   .activityModule(new ActivityModule(this))
                                   .repoModule(new RepoModule())
                                   .build();
    }
}
