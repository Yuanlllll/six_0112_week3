package com.example.six_0112_week3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.six_0112_week3.R;
import com.example.six_0112_week3.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private HomeBean list;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int SAN = 3;
    private HListAdapter hListAdapter;
    private TwoListAdapter twoListAdapter;
    private SanListAdapter sanListAdapter;
    public MyAdapter(Context context, HomeBean list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView;
        if(i==ONE)
        {
            mView=View.inflate(viewGroup.getContext(),R.layout.shouye_1,null);
            return new Item1ViewHolder(mView);
        }else if(i == TWO)
        {
            return new Item2ViewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_2,viewGroup,false));
        }
        else {
            return new Item3ViewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_3,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof Item1ViewHolder)
        {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            ((Item1ViewHolder) viewHolder).rv.setLayoutManager(linearLayoutManager);
            hListAdapter = new HListAdapter(context,list.getData().getFenlei());
            ((Item1ViewHolder) viewHolder).rv.setAdapter(hListAdapter);
        }if(viewHolder instanceof  Item2ViewHolder)
        {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
            ((Item2ViewHolder) viewHolder).rv2.setLayoutManager(linearLayoutManager);
            twoListAdapter = new TwoListAdapter(context,list.getData().getMiaosha());
            ((Item2ViewHolder) viewHolder).rv2.setAdapter(twoListAdapter);
        }
        if(viewHolder instanceof  Item3ViewHolder)
        {   
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            ((Item3ViewHolder) viewHolder).rv3.setLayoutManager(gridLayoutManager);
            sanListAdapter = new SanListAdapter(context,list.getData().getTuijian());
            ((Item3ViewHolder) viewHolder).rv3.setAdapter(sanListAdapter);
        }

    }
  public int getItemViewType(int position){
   switch (position){
       case 1:
           return ONE;
       case 2:
           return TWO;
   }
   return SAN;
  }
    @Override
    public int getItemCount() {
        return 3;
    }
    class Item1ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;
        public Item1ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv);
        }
    }
    class Item2ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv2;
        public Item2ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv2 = itemView.findViewById(R.id.rv);
        }
    }
    class Item3ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv3;
        public Item3ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv3 = itemView.findViewById(R.id.rv);
        }
    }
}
