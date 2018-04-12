package com.example.user.vkapp.ui.fragment;




import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.user.vkapp.CurrentUser;
import com.example.user.vkapp.MyApplication;
import com.example.user.vkapp.R;
import com.example.user.vkapp.rest.api.WallApi;
import com.example.user.vkapp.rest.model.response.BaseItemResponse;
import com.example.user.vkapp.rest.model.response.Full;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }


    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get("-86529522", CurrentUser.getAccessToken(), 1, "5.74").enqueue(new Callback<Full<BaseItemResponse>>() {
            @Override
            public void onResponse(Call<Full<BaseItemResponse>> call, Response<Full<BaseItemResponse>> response) {
                Toast.makeText(getActivity(), "Count: " + response.body().response.getCount(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Full<BaseItemResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}