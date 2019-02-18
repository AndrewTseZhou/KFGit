package com.andrewtse.kfgit.presenter;

import com.andrewtse.kfgit.contract.IBaseContract;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author xk
 * @date 2019/2/17
 */
public class BasePresenterImpl<V extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<V> {

    private V mBaseView;

    protected CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(V baseView) {
        mBaseView = baseView;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        mBaseView = null;
        mCompositeDisposable.clear();
        mCompositeDisposable = null;
    }

    public boolean isViewAttached() {
        return mBaseView != null;
    }

    public V getBaseView() {
        return mBaseView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before requesting data to the Presenter");
        }
    }
}
