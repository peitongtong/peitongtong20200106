package com.bawei.peitongtong20200106.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class GreenDaoEntity {
    @Id
    public Long id;
    public String name;
    public String price;
    @Generated(hash = 1182996680)
    public GreenDaoEntity(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Generated(hash = 1963997359)
    public GreenDaoEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
