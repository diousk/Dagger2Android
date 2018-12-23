package com.example.david_chen.mydaggerdemoapplication;

import com.example.david_chen.mydaggerdemoapplication.api.PageResponse;
import com.example.david_chen.mydaggerdemoapplication.api.WikiApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainPresenter {
    private WikiApi wikiApi;
    private MainView mainView;
    public MainPresenter(MainView mainView, WikiApi wikiApi) {
        this.mainView = mainView;
        this.wikiApi = wikiApi;
    }

    public void fetchPageId(final int pageId) {
        Disposable disposable = wikiApi.getPage(pageId)
                .map(new Function<PageResponse, PageResponse.Page>() {
                    @Override
                    public PageResponse.Page apply(PageResponse response) throws Exception {
                        return response.query.pages.get(String.valueOf(pageId));
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PageResponse.Page>() {
                    @Override
                    public void accept(PageResponse.Page page) throws Exception {
                        mainView.onPhotoFetched(page.title, page.thumbnail.source);
                    }
                });
    }
}
