package com.example.a1.huangshuai2019120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a1.huangshuai2019120.R;
import com.example.a1.huangshuai2019120.entity.User;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProudAvity extends XRecyclerView.Adapter<ProudAvity.ViewHolder> {
    private Context context;
    public List<User.UserData.DataBase> list;

    public ProudAvity(Context context, List<User.UserData.DataBase> list) {
        this.context = context;
        this.list=new ArrayList<>();
    }

    public void setList(List<User.UserData.DataBase> list) {
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProudAvity.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view=LayoutInflater.from(context).inflate(R.layout.productmain,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProudAvity.ViewHolder viewHolder, int position) {
        User.UserData.DataBase dataBase = list.get(position);
        viewHolder.name.setText(list.get(position).subhead);
        viewHolder.price.setText(list.get(position).price+"");
        String[] images = dataBase.images.split("\\|");
        Glide.with(context).load(images[0]).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private XRecyclerView xr;
        private CheckBox checkbox;
        private TextView name;
        private TextView price;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            xr=itemView.findViewById(R.id.xr);
            checkbox=itemView.findViewById(R.id.checkbox);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.image);
        }
    }
}
