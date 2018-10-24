package com.songsong.simplemvp2.MVPLogin1.View;

/**
 * Created by SongSong on 2018/10/9
 */
public interface ILoginView extends BaseView {

    String getUsername();

    String getPassword();

    void showResult(String result);
}

