package com.example.p7day03work.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract  class BaseActivity<T> extends AppCompatActivity {

  protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter==null){
            presenter=getPresenter();
        }
        setContentView(getDataId());
        initData();
        initView();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getDataId();

    protected abstract T getPresenter();
}
