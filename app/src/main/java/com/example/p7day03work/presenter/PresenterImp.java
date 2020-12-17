package com.example.p7day03work.presenter;

import com.example.p7day03work.base.BasePresenter;
import com.example.p7day03work.bean.Bean;
import com.example.p7day03work.contract.MainContract;
import com.example.p7day03work.model.ModelImp;
import com.example.p7day03work.utils.CallBack;

public class PresenterImp extends BasePresenter<MainContract.IViews> implements MainContract.IPresenter {
    private final ModelImp modelImp;

    public PresenterImp() {

        modelImp = new ModelImp(this);
    }

    @Override
    public void pre() {
        modelImp.getModel("dish_list.php?stage_id=1&limit=20&page=1", new CallBack<Bean>() {

            @Override
            public void OnSuccess(Bean bean) {
                Iviews.getData(bean);
            }

            @Override
            public void OnFail(String error) {
               Iviews.no(error);
            }
        });
    }
}
