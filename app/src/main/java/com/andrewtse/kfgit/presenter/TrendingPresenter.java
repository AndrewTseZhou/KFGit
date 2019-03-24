package com.andrewtse.kfgit.presenter;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.andrewtse.kfgit.contract.ITrendingContract;
import com.andrewtse.kfgit.data.api.RepoApi;
import com.andrewtse.kfgit.model.TrendingModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author xk
 * @date 2019/2/26
 */
public class TrendingPresenter extends BaseRepoPresenter<ITrendingContract.ITrendingView> {

    private static final String TAG = "TrendingPresenter";

    @Inject
    public TrendingPresenter(RepoApi trendingApi) {
        super(trendingApi);
    }

    public void getTrendingRepo(String languageType, String q) {
        mRepoApi.getTrendingRepo(languageType, q)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getBaseView().showLoading())
                .doOnTerminate(() -> getBaseView().dismissLoading())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d);
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                        getBaseView().showContent(htmlToModel(s));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    private List<TrendingModel> htmlToModel(String html) {
        ArrayList<TrendingModel> list = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.select("ol[class=repo-list] > li");
        for (Element element : elements) {
            TrendingModel model = new TrendingModel();
            model.setFullName(element.select("div[class=d-inline-block col-9 mb-1] > h3 > a").text());
            model.setDescription(element.select("div[class=py-1] > p").text());
            String colorStr = element.select("div[class=f6 text-gray mt-2] > span[class=d-inline-block mr-3] > span[class=repo-language-color ml-0]")
                                     .attr("style");
            if (!TextUtils.isEmpty(colorStr)) {
                String colorId = colorStr.substring(17, 24);
                model.setColor(colorId);
            } else {
                model.setColor("#FF888888");
            }

            String language = element.select("div[class=f6 text-gray mt-2] > span[class=d-inline-block mr-3] > span").text();
            model.setLanguage(!TextUtils.isEmpty(language) ? language : "Unknown");
            String[] strs = element.select("div[class=f6 text-gray mt-2] > a").text().split(" ");
            model.setStarredCount(strs[0]);
            model.setForksCount(strs[1]);

            Elements starState = element.select("div[class=float-right] > div[class=js-toggler-container js-social-container starring-container on]");
            model.setStarred(starState.size() != 0);

            model.setTrend(element.select("div[class=f6 text-gray mt-2] > span[class=d-inline-block float-sm-right]").text());
            list.add(model);
        }
        return list;
    }
}
