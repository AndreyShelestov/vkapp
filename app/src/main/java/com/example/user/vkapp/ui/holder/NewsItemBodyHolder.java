package com.example.user.vkapp.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.example.user.vkapp.R;
import com.example.user.vkapp.model.view.NewsItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {
    public TextView tvText;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        tvText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void unbindViewHolder() {
        tvText.setText(null);
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        tvText.setText(item.getText());
    }
}
