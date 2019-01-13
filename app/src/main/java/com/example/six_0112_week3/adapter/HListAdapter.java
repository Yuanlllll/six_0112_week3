package com.example.six_0112_week3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.six_0112_week3.R;
import com.example.six_0112_week3.bean.HomeBean;

import java.util.List;

public class HListAdapter extends RecyclerView.Adapter<HListAdapter.HlistViewHodel> {
    Context context;
    List<HomeBean.DataBean.FenleiBean> list;


    public HListAdapter(Context context, List<HomeBean.DataBean.FenleiBean> fenlei) {
        this.context = context;
        this.list = fenlei;
    }

    @NonNull
    @Override
    public HlistViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView;
        mView=View.inflate(viewGroup.getContext(),R.layout.layout_list,null);
        return new HlistViewHodel(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull HlistViewHodel hlistViewHodel, int i) {
        hlistViewHodel.name.setText(list.get(i).getName());

        Glide.with(context).load(list.get(i).getIcon()).into(hlistViewHodel.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HlistViewHodel extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public HlistViewHodel(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.price);
            name =  itemView.findViewById(R.id.title);
        }
    }
}
