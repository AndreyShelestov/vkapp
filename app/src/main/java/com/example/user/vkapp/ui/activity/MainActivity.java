package com.example.user.vkapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.user.vkapp.CurrentUser;
import com.example.user.vkapp.MyApplication;
import com.example.user.vkapp.R;
import com.example.user.vkapp.mvp.presenter.MainPresenter;
import com.example.user.vkapp.mvp.view.MainView;
import com.example.user.vkapp.ui.fragment.NewsFeedFragment;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import static com.example.user.vkapp.consts.ApiConstants.DEFAULT_LOGIN_SCOPE;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        mPresenter.checkAuth();
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                mPresenter.checkAuth();
            }
            @Override
            public void onError(VKError error) {

            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, DEFAULT_LOGIN_SCOPE);
    }

    @Override
    public void signedId() {
        Toast.makeText(this, "your current id: " + CurrentUser.getId(), Toast.LENGTH_SHORT).show();
        setContent(new NewsFeedFragment());
    }
}
