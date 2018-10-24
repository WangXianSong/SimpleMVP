package com.songsong.simplemvp2.MVPRequst2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.songsong.simplemvp2.MVPRequst2.contract;
import com.songsong.simplemvp2.MVPRequst2.presenter.MyPresenter;
import com.songsong.simplemvp2.R;

public class Requst2Activity extends BaseActivity<MyPresenter> implements contract.IMyView {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requst);

        Button btn = findViewById(R.id.button);
        tv = findViewById(R.id.tv_id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //请求数据
                mPresenter.getData();
            }
        });
    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }

    @Override
    public void updateText(String text) {
        tv.setText(text);
    }


}
