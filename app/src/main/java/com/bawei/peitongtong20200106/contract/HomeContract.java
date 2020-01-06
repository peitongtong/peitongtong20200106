package com.bawei.peitongtong20200106.contract;

import java.util.HashMap;

public interface HomeContract {
    interface IModel{
        void getLeftData(ModelCallBack modelCallBack);
        void getRightData(HashMap<String,String> params, ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(Object o);
            void failure(Throwable throwable);
        }
    }
    interface IView{
        void success(Object o);
        void failure(Throwable throwable);
    }
    interface IPresenter{
        void getLeftData();
        void getRightData(HashMap<String,String> params);
    }
}
