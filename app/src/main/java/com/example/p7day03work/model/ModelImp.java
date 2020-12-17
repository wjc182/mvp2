package com.example.p7day03work.model;

import com.example.p7day03work.contract.MainContract;
import com.example.p7day03work.utils.CallBack;
import com.example.p7day03work.utils.ImWorkNextUtils;

public class ModelImp implements MainContract.IModel {
  private MainContract.IPresenter presenter;

    public ModelImp(MainContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getModel(String url, CallBack<T> callBack) {
        //方法
        ImWorkNextUtils.getInstance().getModel(url,callBack);
    }
}
