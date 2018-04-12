package com.example.user.vkapp;

import android.app.Application;

import com.example.user.vkapp.di.component.ApplicationComponent;
import com.example.user.vkapp.di.component.DaggerApplicationComponent;
import com.example.user.vkapp.di.modules.ApplicationModule;
import com.vk.sdk.VKSdk;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
        initComponent();
    }

    private static ApplicationComponent sApplicationComponent;

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
