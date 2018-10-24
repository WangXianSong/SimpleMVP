package com.songsong.simplemvp2.MVPRequst2.model;

import android.os.Handler;

import com.songsong.simplemvp2.MVPRequst2.contract;

import java.util.Random;

/**
 * Created by SongSong on 2018/10/11
 */
public class MyModel implements contract.IMyModel {

    @Override
    public  void getData(final String token, final Callback callback) {
        //不要在主线程执行耗时操作
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                switch (token) {
                    case "local":
                        getLocalData(callback);
                        break;
                    case "net":
                        getNetData(callback);
                        break;
                }
            }
        });
    }

    private  void getLocalData(Callback callback) {
        try {
            Thread.sleep(1000);
            if (new Random().nextBoolean()) {
                callback.onSuccess("This is local data#" + new Random().nextInt(100));
            } else {
                //模拟本地数据不存在
                callback.onError("local data not found!");
            }
        } catch (InterruptedException e) {
            callback.onError(e.getMessage());
        }
    }

    private  void getNetData(Callback callback) {
        try {
            Thread.sleep(1500);
            if (new Random().nextBoolean()) {
                callback.onSuccess("This is Internet data#" + new Random().nextInt(100));
            } else {
                //模拟网络请求失败
                callback.onError("request internet data failed!");
            }
        } catch (InterruptedException e) {
            callback.onError(e.getMessage());
        }
    }


}