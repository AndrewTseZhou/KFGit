package com.andrewtse.kfgit.presenter;

import android.app.Application;
import android.util.Log;

import com.andrewtse.kfgit.contract.ILoginContract;
import com.andrewtse.kfgit.data.api.UserApi;
import com.andrewtse.kfgit.model.User;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xk
 * @date 2019/2/17
 */
public class LoginPresenter extends BasePresenterImpl<ILoginContract.ILoginView> {

    private static final String TAG = "LoginPresenter";

    private final UserApi mUserApi;

    @Inject
    Application mContext;

    @Inject
    public LoginPresenter(UserApi userApi) {
        mUserApi = userApi;
    }

    public void login(String username, String password) {
        mUserApi.login(username, password)
                .retryWhen(throwableObservable -> throwableObservable.flatMap((Function<Throwable, ObservableSource<?>>) throwable -> {
                    Log.d(TAG, "apply: throwable: " + throwable.toString());
                    if (throwable instanceof IOException) {
                        if (mCurrentRetryCount < mMaxConnectCount) {
                            mCurrentRetryCount++;
                            mWaitRetryTime = 1000 + mCurrentRetryCount * 1000;
                            Log.d(TAG, "apply: mCurrentRetryCount = " + mCurrentRetryCount + ", mWaitRetryTime = " + mWaitRetryTime);
                            return Observable.just(1).delay(mWaitRetryTime, TimeUnit.MILLISECONDS);
                        } else {
                            Log.d(TAG, "apply: 重试次数已超过设置次数");
                            return Observable.error(new Throwable("开小差了"));
                        }
                    } else {
                        Log.d(TAG, "apply: 发生了非IO异常");
                        return Observable.error(new Throwable("开小差了"));
                    }
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getBaseView().showLoading())
                .doOnTerminate(() -> getBaseView().dismissLoading())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d);
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext: " + user.toString());
                        getBaseView().loginSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                        getBaseView().error(e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    public void getUserInfo(String accessToken) {
        mUserApi.getUserInfo(accessToken)
                .retryWhen(throwableObservable -> throwableObservable.flatMap((Function<Throwable, ObservableSource<?>>) throwable -> {
                    Log.d(TAG, "apply: throwable: " + throwable.toString());
                    if (throwable instanceof IOException) {
                        if (mCurrentRetryCount < mMaxConnectCount) {
                            mCurrentRetryCount++;
                            mWaitRetryTime = 1000 + mCurrentRetryCount * 1000;
                            Log.d(TAG, "apply: mCurrentRetryCount = " + mCurrentRetryCount + ", mWaitRetryTime = " + mWaitRetryTime);
                            return Observable.just(1).delay(mWaitRetryTime, TimeUnit.MILLISECONDS);
                        } else {
                            Log.d(TAG, "apply: 重试次数已超过设置次数");
                            return Observable.error(new Throwable("开小差了"));
                        }
                    } else {
                        Log.d(TAG, "apply: 发生了非IO异常");
                        return Observable.error(new Throwable("开小差了"));
                    }
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getBaseView().showLoading())
                .doOnTerminate(() -> getBaseView().dismissLoading())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d);
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext: " + user.toString());
                        getBaseView().loginSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                        getBaseView().error(e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }
}
