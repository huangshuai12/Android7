package com.example.a1.huangshuai2019120.contract;

import com.example.a1.huangshuai2019120.net.RequestCallback;

import java.util.HashMap;

public interface LoadContract {
    //p层
    public abstract class LoadPresenter{
        public abstract void ppresenter(HashMap<String,String> map);
    }
    //model层
    interface LloadModel{
        void model(HashMap<String,String> map, RequestCallback callback);
    }
    //view层
    interface LloadView{
        void onSuccess(String result);
        void onFailUre(String msg);
    }

}
