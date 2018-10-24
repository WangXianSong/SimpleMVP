package com.songsong.simplemvp2.MVPRequst2.model;

/**
 * Created by SongSong on 2018/10/11
 */
public interface Callback<T> {
    void onSuccess(T data);
    void onError(String errorMsg);
}
