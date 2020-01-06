package com.bawei.peitongtong20200106.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.bawei.peitongtong20200106.R;
import com.bawei.peitongtong20200106.adapter.LeftAdapter;
import com.bawei.peitongtong20200106.adapter.RightAdapter;
import com.bawei.peitongtong20200106.contract.HomeContract;
import com.bawei.peitongtong20200106.entity.ClsEntity;
import com.bawei.peitongtong20200106.entity.GreenDaoEntity;
import com.bawei.peitongtong20200106.entity.RightEntity;
import com.bawei.peitongtong20200106.greendao.DaoMaster;
import com.bawei.peitongtong20200106.greendao.DaoSession;
import com.bawei.peitongtong20200106.presenter.HomePresenter;
import com.bawei.peitongtong20200106.utils.Retrofltutils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

/*
*1707B裴童童
*2020.01.06
*1.git
2.Retrofit+OKHTTP+Rxjava+网络状态
3.EventBus
4.ButterKnife
5.基类
6.分类联动
* */
public class MainActivity extends AppCompatActivity implements HomeContract.IView {
    RecyclerView rv_left;
    RecyclerView rv_right;
    private DaoMaster.DevOpenHelper helper1;
    private HomePresenter homePresenter;
    private SQLiteDatabase sqLiteDatabase;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_left = findViewById(R.id.rv_left);
        rv_right = findViewById(R.id.rv_right);
        rv_left.setLayoutManager(new LinearLayoutManager(this));
        rv_right.setLayoutManager(new GridLayoutManager(this,2));
        EventBus.getDefault().register(this);
        helper1 = new DaoMaster.DevOpenHelper(this,"clsdb");
        sqLiteDatabase = helper1.getWritableDatabase();
        daoSession = daoMaster.newSession();
        if (Retrofltutils.getInstance().isNet()){

        }else {
            List<GreenDaoEntity> greendaoEntities = daoSession.getGreenDaoEntityDao().loadAll();
            if (greendaoEntities!=null&&greendaoEntities.size()>0){
                GreenDaoEntity greendaoEntity = greendaoEntities.get(0);
                String json = greendaoEntity.getName();
                ClsEntity clsEntity = new Gson().fromJson(json, ClsEntity.class);
                LeftAdapter leftAdapter = new LeftAdapter(this,clsEntity.result.get(0).secondCategoryVo);
                homePresenter.getLeftData();
                rv_left.setAdapter(leftAdapter);
               leftAdapter.setLeftOnClick(new LeftAdapter.LeftOnClick() {
                   @Override
                   public void getName(String id) {
                       EventBus.getDefault().post(id);
                   }
               });
            }
        }
    }

    @Override
    public void success(Object o) {
        if (o instanceof  ClsEntity){
            ClsEntity clsEntity = (ClsEntity) o;
            LeftAdapter leftAdapter = new LeftAdapter(this,clsEntity.result.get(0).secondCategoryVo);
            rv_left.setAdapter(leftAdapter);
            leftAdapter.setLeftOnClick(new LeftAdapter.LeftOnClick() {
                @Override
                public void getName(String id) {
                    EventBus.getDefault().post(id);
                }
            });
            GreenDaoEntity greendaoEntity = new GreenDaoEntity();
            String json = new Gson().toJson(clsEntity);
            daoSession.getGreenDaoEntityDao().insert(greendaoEntity);
        }else if (o instanceof RightEntity) {
            RightEntity rightEntity = (RightEntity) o;
            Log.e("TAG", "o"+o );
            RightAdapter rightAdapter = new RightAdapter(this,rightEntity.getData());
            rv_right.setAdapter(rightAdapter);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getId(String id){

        HashMap<String,String> params = new HashMap<>();
        params.put("categoryId",id);
        params.put("page","1");
        params.put("count","10");
        homePresenter.getRightData(params);

    }
    @Override
    public void failure(Throwable throwable) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
