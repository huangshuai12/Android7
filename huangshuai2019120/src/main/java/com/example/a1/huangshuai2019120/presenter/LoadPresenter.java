package com.example.a1.huangshuai2019120.presenter;

import com.example.a1.huangshuai2019120.contract.LoadContract;
import com.example.a1.huangshuai2019120.model.LoadModel;
import com.example.a1.huangshuai2019120.net.RequestCallback;

import java.util.HashMap;

public class LoadPresenter extends LoadContract.LoadPresenter{
    private LoadContract.LloadView lloadView;
    private final LoadModel loadModel;

    public LoadPresenter(LoadContract.LloadView lloadView) {
        this.lloadView = lloadView;
        loadModel = new LoadModel();
    }

    @Override
    public void ppresenter(HashMap<String, String> map) {
     if (loadModel!=null){
         loadModel.model(map, new RequestCallback() {
             @Override
             public void onSuccess(String result) {
                 if (lloadView!=null){
                     lloadView.onSuccess(result);
                 }
             }

             @Override
             public void onFailUre(String msg) {
                if (lloadView!=null){
                    lloadView.onFailUre(msg);
                }
             }
         });
     }
    }
}
