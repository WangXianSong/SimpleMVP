package com.songsong.simplemvp2.MVPLogin1.Model;

/**
 * Created by SongSong on 2018/10/9
 */
public interface IUserModel {
    void login(String username, String password, Callback callback);
}
