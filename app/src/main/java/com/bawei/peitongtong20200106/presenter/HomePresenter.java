package com.bawei.peitongtong20200106.presenter;

import com.bawei.peitongtong20200106.contract.HomeContract;
import com.bawei.peitongtong20200106.model.HomeModel;

import java.util.HashMap;

public class HomePresenter implements HomeContract.IPresenter {
    private HomeContract.IView view;
    private HomeModel model;

    public HomePresenter(HomeContract.IView view) {
        this.view = view;
        this.model = new HomeModel();
    }

    @Override
    public void getLeftData() {
        model.getLeftData(new HomeContract.IModel.ModelCallBack() {
            @Override
            public void success(Object o) {
                view.success(o);
            }

            @Override
            public void failure(Throwable throwable) {
                view.failure(throwable);
            }
        });
    }

    @Override
    public void getRightData(HashMap<String, String> params) {
        model.getRightData(params, new HomeContract.IModel.ModelCallBack() {
            @Override
            public void success(Object o) {
                view.success(o);
            }

            @Override
            public void failure(Throwable throwable) {
                view.failure(throwable);
            }
        });
    }
}
