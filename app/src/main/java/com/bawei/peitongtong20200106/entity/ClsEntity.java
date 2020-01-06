package com.bawei.peitongtong20200106.entity;

import java.util.List;

public class ClsEntity {
    public String message;
    public String status;
    public List<Cls> result;


    public static class Cls{

        public String id;
        public String name;
        public List<Category>  secondCategoryVo;


        public static class Category{
            public String id;
            public String name;
        }

    }
}
