package com.example.user.vkapp.di.modules;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    LayoutInflater provideLayoutInflater() {
        return (LayoutInflater) mApplication.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}
