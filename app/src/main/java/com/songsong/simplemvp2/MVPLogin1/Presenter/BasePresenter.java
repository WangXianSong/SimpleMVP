package com.songsong.simplemvp2.MVPLogin1.Presenter;

import com.songsong.simplemvp2.MVPLogin1.View.BaseView;

/**
 * Created by SongSong on 2018/10/9
 */
public abstract class BasePresenter<T extends BaseView> {

    private T mView;

    public void attachView(T view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }

    protected boolean isViewAttached() {
        return mView != null;
    }

    public T getBaseView() {
        return mView;
    }

    /**
     * 每次调用业务请求的时候都要先调用方法检查是否与View建立连接，没有则抛出异常
     */
    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("请求数据前请先调用 attachView(MvpView) 方法与View建立连接");
        }
    }
}
