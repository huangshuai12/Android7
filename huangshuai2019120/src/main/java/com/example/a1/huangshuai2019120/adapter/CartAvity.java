package com.example.a1.huangshuai2019120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.a1.huangshuai2019120.R;
import com.example.a1.huangshuai2019120.entity.User;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartAvity  extends XRecyclerView.Adapter<CartAvity.ViewHolder> {
    private Context context;
    public List<User.UserData> list;

    public CartAvity(Context context) {
        this.context = context;
        this.list=new ArrayList<>();
    }

    public void setList(List<User.UserData> list) {
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartAvity.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view=LayoutInflater.from(context).inflate(R.layout.cartmain,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartAvity.ViewHolder viewHolder, int position) {
        User.UserData userData = list.get(position);
        viewHolder.text.setText(list.get(position).sellerName);
        viewHolder.xrec.setLayoutManager(new LinearLayoutManager(context));
        viewHolder.xrec.setAdapter(new ProudAvity(context,list.get(position).list));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private XRecyclerView xrec;
        private CheckBox checkbox;
        private TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            xrec=itemView.findViewById(R.id.xrec);
            checkbox=itemView.findViewById(R.id.checkbox);
            text=itemView.findViewById(R.id.text);
        }
    }
}
