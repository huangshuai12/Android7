package com.example.a1.huangshuai2019120.model;

import android.os.Handler;

import com.example.a1.huangshuai2019120.Api.UserApi;
import com.example.a1.huangshuai2019120.contract.LoadContract;
import com.example.a1.huangshuai2019120.net.OkHttpCallback;
import com.example.a1.huangshuai2019120.net.OkHttpUtiles;
import com.example.a1.huangshuai2019120.net.RequestCallback;

import java.util.HashMap;

public class LoadModel implements LoadContract.LloadModel{
    private Handler handler=new Handler();
    @Override
    public void model(HashMap<String, String> map, final RequestCallback callback) {
        OkHttpUtiles.getmInsxcvczmn().doPost(UserApi.USER_API, map, new OkHttpCallback() {
            @Override
            public void onSuccess(final String result) {
                if (callback!=null){
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                          callback.onSuccess(result);
                      }
                  });
                }
            }

            @Override
            public void onFailUre(final String msg) {
                if (callback!=null){
                   handler.post(new Runnable() {
                       @Override
                       public void run() {
                           callback.onSuccess(msg);
                       }
                   });
                }
            }
        });
    }
}
