package com.songsong.simplemvp2.MVPRequst2.presenter;

import com.songsong.simplemvp2.MVPRequst2.contract;
import com.songsong.simplemvp2.MVPRequst2.model.Callback;
import com.songsong.simplemvp2.MVPRequst2.model.MyModel;

/**
 * Created by SongSong on 2018/10/11
 */
public class MyPresenter extends BasePresenter<contract.IMyView> implements contract.IMyPresenter {

    private void updateText(String text) {
        if (isViewAttached()) {
            mView.updateText(text);
        }
    }

    private void showToast(String msg) {
        if (isViewAttached()) {
            mView.showToast(msg);
        }
    }

    @Override
    public void getData() {
        updateText("I'm working, please wait...");
        MyModel model = new MyModel();
        model.getData("net", new Callback<String>() {

            @Override
            public void onSuccess(String data) {
                updateText(data);
            }

            @Override
            public void onError(String errorMsg) {
                showToast(errorMsg);
                updateText("get data failed!");
            }
        });
    }
}
