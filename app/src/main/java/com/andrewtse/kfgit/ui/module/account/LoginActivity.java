package com.andrewtse.kfgit.ui.module.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.andrewtse.kfgit.KFGitApplication;
import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.common.utils.NetworkUtils;
import com.andrewtse.kfgit.contract.ILoginContract;
import com.andrewtse.kfgit.data.pref.UserPref;
import com.andrewtse.kfgit.di.IHasComponent;
import com.andrewtse.kfgit.di.component.DaggerIUserComponent;
import com.andrewtse.kfgit.di.component.IUserComponent;
import com.andrewtse.kfgit.di.module.ActivityModule;
import com.andrewtse.kfgit.di.module.UserModule;
import com.andrewtse.kfgit.model.User;
import com.andrewtse.kfgit.presenter.LoginPresenter;
import com.andrewtse.kfgit.ui.base.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.jakewharton.rxbinding2.widget.RxTextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

public class LoginActivity extends BaseActivity implements ILoginContract.ILoginView, IHasComponent<IUserComponent> {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.text_input_username)
    TextInputEditText mEtUserName;
    @BindView(R.id.text_input_password)
    TextInputEditText mEtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @Inject
    LoginPresenter mLoginPresenter;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    public static void launchForResult(Activity activity) {
        activity.startActivityForResult(new Intent(activity, LoginActivity.class), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter.attachView(this);

        Observable<CharSequence> nameObservable = RxTextView.textChanges(mEtUserName).skip(1);
        Observable<CharSequence> passwordObservable = RxTextView.textChanges(mEtPassword).skip(1);

        Observable.combineLatest(nameObservable, passwordObservable, (charSequence, charSequence2) -> {
            boolean isUserNameEmpty = !TextUtils.isEmpty(mEtUserName.getText().toString());
            boolean isPasswordEmpty = !TextUtils.isEmpty(mEtPassword.getText().toString());
            return isUserNameEmpty && isPasswordEmpty;
        }).subscribe(enable -> mBtnLogin.setEnabled(enable));
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        String userName = mEtUserName.getText().toString();
        String password = mEtPassword.getText().toString();
        Log.d(TAG, "onClick: userName = " + userName + ", password = " + password);
        if (NetworkUtils.isConnected() && NetworkUtils.isAvailableByPing()) {
            mLoginPresenter.login(userName, password);
        } else {
            Toast.makeText(this, getString(R.string.check_network), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.detachView();
    }

    @Override
    public IUserComponent getComponent() {
        return DaggerIUserComponent.builder()
                                   .iApplicationComponent(KFGitApplication.get(this).getComponent())
                                   .activityModule(new ActivityModule(this))
                                   .userModule(new UserModule())
                                   .build();
    }

    @Override
    public void loginSuccess(User user) {
        UserPref.saveLoginUser(this, user);
        Log.d(TAG, "loginSuccess: 登录成功");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void error(Throwable e) {
        Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_SHORT).show();
    }
}
