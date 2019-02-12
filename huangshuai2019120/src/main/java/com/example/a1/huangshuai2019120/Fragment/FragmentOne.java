package com.example.a1.huangshuai2019120.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.a1.huangshuai2019120.R;
import com.example.a1.huangshuai2019120.adapter.CartAvity;
import com.example.a1.huangshuai2019120.contract.LoadContract;
import com.example.a1.huangshuai2019120.entity.User;
import com.example.a1.huangshuai2019120.presenter.LoadPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.Map;

public class FragmentOne extends Fragment implements LoadContract.LloadView {
    private XRecyclerView xrec;
    private CheckBox checkbox;
    private LoadPresenter presenter;
    private CartAvity cartAvity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentyi, container, false);
        xrec =view.findViewById(R.id.xrec);
        checkbox =view.findViewById(R.id.checkbox);

        presenter=new LoadPresenter(this);
        xrec.setLayoutManager(new LinearLayoutManager(getActivity()));
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","71");
        presenter.ppresenter(map);
        cartAvity = new CartAvity(getActivity());
        return view;
    }

    @Override
    public void onSuccess(String result) {
        User user = new Gson().fromJson(result, User.class);
        cartAvity.setList(user.data);
    }

    @Override
    public void onFailUre(String msg) {

    }
}
