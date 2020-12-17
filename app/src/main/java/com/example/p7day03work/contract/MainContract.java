package com.example.p7day03work.contract;

import com.example.p7day03work.base.BaseView;
import com.example.p7day03work.bean.Bean;
import com.example.p7day03work.utils.CallBack;

public class MainContract {

    public interface IModel{
        <T>  void getModel(String url, CallBack<T> callBack);
    }

    public interface IPresenter{
        void pre();
    }
    public interface IViews extends BaseView {
        void getData(Bean bean);

        void no(String error);
    }
}
