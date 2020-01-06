package com.bawei.peitongtong20200106.api;


import com.bawei.peitongtong20200106.entity.ClsEntity;
import com.bawei.peitongtong20200106.entity.RightEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ClsApiservice {
    @GET("small/commodity/v1/findCategory")
    Observable<ClsEntity> getCls();
    @GET("small/commodity/v1/findCommodityByCategory")
    Observable<RightEntity> getRight(@QueryMap HashMap<String, String> params);
}
