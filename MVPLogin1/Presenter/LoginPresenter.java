package com.songsong.simplemvp2.MVPLogin1.Presenter;

import com.songsong.simplemvp2.MVPLogin1.Model.Callback;
import com.songsong.simplemvp2.MVPLogin1.Model.UserModel;
import com.songsong.simplemvp2.MVPLogin1.View.ILoginView;

/**
 * Created by SongSong on 2018/10/9
 */
public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {

    private UserModel mUserModel;

    public LoginPresenter(UserModel userModel) {
        this.mUserModel = userModel;
    }

    @Override
    public void login() {
        getBaseView().showLoading("正在加载中...");
        mUserModel.login(getBaseView().getUsername(), getBaseView().getPassword(), new Callback() {
            @Override
            public void onSuccess() {
                getBaseView().hideLoading();
                getBaseView().showResult("登录成功");
            }

            @Override
            public void onFailure(String errorMsg) {
                getBaseView().hideLoading();
                getBaseView().showResult(errorMsg);
            }
        });
    }
}
