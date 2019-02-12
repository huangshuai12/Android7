package com.example.a1.huangshuai2019120.entity;

import java.util.List;

public class User {
    public String msg;
    public String code;
    public List<UserData> data;
    public class UserData{
        public String checkbox;
        public String sellerName;
        public String sellerid;
        public List<DataBase> list;
            public class DataBase{
                public String ischeckeds;
                public String subhead;
                public Double price;
                public String images;
                public String uid;
            }
    }
}
