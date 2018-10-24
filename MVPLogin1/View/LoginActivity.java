package com.songsong.simplemvp2.MVPLogin1.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.songsong.simplemvp2.MVPLogin1.BaseActivity;
import com.songsong.simplemvp2.MVPLogin1.Model.UserModel;
import com.songsong.simplemvp2.MVPLogin1.Presenter.LoginPresenter;
import com.songsong.simplemvp2.R;

public class LoginActivity extends BaseActivity implements ILoginView {


    private EditText username;
    private EditText password;
    private Button login_btn;
    private TextView success_tv;
    private LoginPresenter mPresenter;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        success_tv = findViewById(R.id.tv_login);
        mProgressBar = findViewById(R.id.progressbar_login);

        mPresenter = new LoginPresenter(new UserModel());
        mPresenter.attachView(this);//这里与View建立连接

        login_btn = findViewById(R.id.login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login();
            }
        });
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();//这里与View断开连接
        super.onDestroy();
    }

    @Override
    public String getUsername() {
        return username.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void showResult(String result) {
        success_tv.setVisibility(View.VISIBLE);
        success_tv.setText(result);
//        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(String msg) {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }
}