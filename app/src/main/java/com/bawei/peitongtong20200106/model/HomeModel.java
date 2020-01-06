package com.bawei.peitongtong20200106.model;

import com.bawei.peitongtong20200106.api.ClsApiservice;
import com.bawei.peitongtong20200106.contract.HomeContract;
import com.bawei.peitongtong20200106.entity.ClsEntity;
import com.bawei.peitongtong20200106.entity.RightEntity;
import com.bawei.peitongtong20200106.utils.Retrofltutils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements HomeContract.IModel {
    @Override
    public void getLeftData(final ModelCallBack modelCallBack) {
        Retrofltutils.getInstance().createservice(ClsApiservice.class)
                .getCls()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClsEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClsEntity clsEntity) {
                        modelCallBack.success(clsEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRightData(HashMap<String, String> params, final ModelCallBack modelCallBack) {
        Retrofltutils.getInstance().createservice(ClsApiservice.class)
                .getRight(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightEntity rightEntity) {
                        modelCallBack.success(rightEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
