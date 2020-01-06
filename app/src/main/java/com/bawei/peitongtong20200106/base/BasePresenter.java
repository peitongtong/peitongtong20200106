package com.bawei.peitongtong20200106.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    private WeakReference<V> weakReference;
    private M model;
    private BasePresenter(){
        model = initModel();
    }

    protected abstract M initModel();
    public void Attach(V v){
        weakReference = new WeakReference<>(v);
    }
    public void Detach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

}
