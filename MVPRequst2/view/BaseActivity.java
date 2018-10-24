package com.songsong.simplemvp2.MVPRequst2.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.songsong.simplemvp2.MVPRequst2.contract;
import com.songsong.simplemvp2.MVPRequst2.presenter.BasePresenter;

/**
 * Created by SongSong on 2018/10/11
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements contract.IBaseView {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    //子类必须重写绑定Presenter的方法（如果View不需要绑定Presenter，就不会继承这个类）
    protected abstract T createPresenter();

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
