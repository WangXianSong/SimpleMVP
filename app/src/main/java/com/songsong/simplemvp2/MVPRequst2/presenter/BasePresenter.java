package com.songsong.simplemvp2.MVPRequst2.presenter;


import com.songsong.simplemvp2.MVPRequst2.contract;

/**
 * Created by SongSong on 2018/10/11
 */
public abstract class BasePresenter<T extends contract.IBaseView> {

    protected T mView;
    public void attachView(T view){
        mView = view;
    }
    public void detachView(){
        mView = null;
    }
    protected boolean isViewAttached(){
        return mView != null;
    }
}
