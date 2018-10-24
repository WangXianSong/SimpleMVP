package com.songsong.simplemvp2.MVPLogin1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.songsong.simplemvp2.MVPLogin1.View.BaseView;

/**
 * Created by SongSong on 2018/10/9
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}

