package com.example.user.vkapp.di.modules;

import com.example.user.vkapp.common.manager.MyFragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {

    @Provides
    @Singleton
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }
}
