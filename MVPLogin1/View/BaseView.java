package com.songsong.simplemvp2.MVPLogin1.View;

/**
 * Created by SongSong on 2018/10/9
 */
public interface BaseView {

    void showLoading(String msg);

    void hideLoading();

    void showError(String errorMsg);
}
