package com.songsong.simplemvp2.MVPLogin1.Model;

import android.os.Handler;

/**
 * Created by SongSong on 2018/10/9
 */
public class UserModel implements IUserModel {

    Handler handler = new Handler();

    @Override
    public void login(final String username, final String password, final Callback callback) {
        //模拟网络请求
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("SongSong".equals(username) && "123".equals(password)) {
                    callback.onSuccess();
                } else {
                    callback.onFailure("用户名或密码错误");
                }
            }
        }, 1000);
    }
}
