package com.example.user.vkapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.user.vkapp.MyApplication;
import com.example.user.vkapp.R;
import com.example.user.vkapp.common.manager.MyFragmentManager;
import com.example.user.vkapp.ui.fragment.BaseFragment;

import javax.inject.Inject;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    MyFragmentManager myFragmentManager;

    public void fragmentOnScreen(BaseFragment fragment) {
        setToolbarTitle(fragment.createToolbarTitle(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        MyApplication.getApplicationComponent().inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void setContent(BaseFragment fragment) {
        myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment) {
        myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment() {
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment) {
        return myFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }

    public void setToolbarTitle(String title) {
         if (getSupportActionBar() != null) {
             getSupportActionBar().setTitle(title);
         }
    }
}
