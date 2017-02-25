package com.zyy.m;

import android.view.View;

/**
 * Created by Administrator on 2017/2/25.
 */

public interface BaseView<T> {
    // 为View设置Presenter
    void setPresenter(T presenter);
    // 初始化界面控件
    void initView(View view);
}
