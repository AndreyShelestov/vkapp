package com.example.user.vkapp.di.component;

import com.example.user.vkapp.di.modules.ApplicationModule;
import com.example.user.vkapp.di.modules.ManagerModule;
import com.example.user.vkapp.di.modules.RestModule;
import com.example.user.vkapp.ui.activity.BaseActivity;
import com.example.user.vkapp.ui.activity.MainActivity;
import com.example.user.vkapp.ui.fragment.NewsFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {


    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);
    void inject(NewsFeedFragment fragment);
}
