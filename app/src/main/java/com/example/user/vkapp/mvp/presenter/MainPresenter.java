package com.example.user.vkapp.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.user.vkapp.CurrentUser;
import com.example.user.vkapp.mvp.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public void checkAuth() {
         if (!CurrentUser.isAuthorized()) {
             getViewState().startSignIn();
         } else {
             getViewState().signedId();
         }
    }
}
