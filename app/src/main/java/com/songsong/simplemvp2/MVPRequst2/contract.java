package com.songsong.simplemvp2.MVPRequst2;

import com.songsong.simplemvp2.MVPRequst2.model.Callback;

/**
 * Created by SongSong on 2018/10/11
 */
public interface contract {
    interface IMyModel {
        void getData(final String token, final Callback callback);
    }
    interface IMyPresenter {
        void getData();
    }
    interface IMyView extends IBaseView {
        void updateText(String text);
    }
    interface IBaseView {
        void showToast(String msg);
    }
}
