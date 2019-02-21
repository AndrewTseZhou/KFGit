package com.andrewtse.kfgit.ui.module.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.common.utils.StringUtils;
import com.andrewtse.kfgit.data.pref.UserPref;
import com.andrewtse.kfgit.model.User;
import com.andrewtse.kfgit.ui.adapter.ProfileFragmentAdapter;
import com.andrewtse.kfgit.ui.base.BaseFragment;
import com.andrewtse.kfgit.ui.entity.ProfileItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xk
 * @date 2019/2/19
 */
public class ProfileFragment extends BaseFragment {

    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.tv_user_name)
    TextView mTvUserName;
    @BindView(R.id.tv_user_description)
    TextView mTvUserDescription;
    @BindView(R.id.tv_join_date)
    TextView mTvJoinDate;
    @BindView(R.id.navigate_next)
    ImageView mNavigateNext;
    @BindView(R.id.tv_repo_count)
    TextView mTvRepoCount;
    @BindView(R.id.tv_following)
    TextView mTvFollowing;
    @BindView(R.id.tv_followers)
    TextView mTvFollowers;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private ProfileFragmentAdapter mAdapter;
    private List<ProfileItem> mItemList = new ArrayList<>();

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, null);
        ButterKnife.bind(this, view);
        initListData();
        initView();
        initAdapter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadHeaderData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initListData() {
        mItemList.clear();
        int[] icons = {R.drawable.email, R.drawable.blog, R.drawable.company, R.drawable.location};
        String[] itemNames = new String[4];
        User userInfo = UserPref.getLoginUser(getActivity());
        itemNames[0] = !StringUtils.isEmpty(userInfo.getEmail()) ? userInfo.getEmail() : "Email";
        itemNames[1] = !StringUtils.isEmpty(userInfo.getBlog()) ? userInfo.getBlog() : "Blog";
        itemNames[2] = !StringUtils.isEmpty(userInfo.getCompany()) ? userInfo.getCompany() : "Company";
        itemNames[3] = !StringUtils.isEmpty(userInfo.getLocation()) ? userInfo.getLocation() : "Location";
        for (int i = 0; i < 4; i++) {
            ProfileItem item = new ProfileItem();
            item.setIconId(icons[i]);
            item.setItemName(itemNames[i]);
            mItemList.add(item);
        }
    }

    private void initView() {
        mRvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    private void initAdapter() {
        mAdapter = new ProfileFragmentAdapter(R.layout.item_profile, mItemList);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {

        });
        mAdapter.setEnableLoadMore(false);
        mAdapter.setUpFetchEnable(false);
        mAdapter.bindToRecyclerView(mRvList);
        mAdapter.disableLoadMoreIfNotFullPage();
    }

    private void loadHeaderData() {
        User userInfo = UserPref.getLoginUser(this.getContext());
        Glide.with(this).asBitmap().load(userInfo.getAvatarUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(mIvAvatar);
        mTvUserName.setText(userInfo.getLogin());
        mTvUserDescription.setText(userInfo.getBio());
        mTvJoinDate.setText(getString(R.string.joined_at) + " " + userInfo.getCreatedAt().substring(0, 10));
        mTvRepoCount.setText(getString(R.string.repo_count) + " " + userInfo.getPublicRepos());
        mTvFollowing.setText(getString(R.string.following_count) + " " + userInfo.getFollowing());
        mTvFollowers.setText(getString(R.string.followers_count) + " " + userInfo.getFollowers());
    }
}
