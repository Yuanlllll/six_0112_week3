package com.example.six_0111_week3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.six_0111_week3.R;
import com.example.six_0111_week3.adapter.MyAdapter;
import com.example.six_0111_week3.bean.HomeBean;
import com.example.six_0111_week3.bean.ShowBean;
import com.example.six_0111_week3.presenter.ShowPresenter;

import java.util.ArrayList;
import java.util.List;


public class ShowFragment extends Fragment{
    private RecyclerView recy;
    private LinearLayoutManager linearLayoutManager;
    private MyAdapter myAdapter;
    private GridLayoutManager gridLayoutManager;
    private ArrayList<HomeBean> list;
    private ShowPresenter showPresenter;
    private String name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou_layout, container, false);
        recy = view.findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recy.setLayoutManager(linearLayoutManager);
        showPresenter = new ShowPresenter(this);
        showPresenter.GetShowModelData();
        return view;
    }

    public void GetViewData(Object oj) {
        ShowBean productBean= (ShowBean) oj;
        name = productBean.result.mlss.get(0).name;
        Log.d("dddd", "getData: "+name);
        List<ShowBean.ProductItemBean> list = new ArrayList<>();
        list.addAll(productBean.result.rxxp);//添加集合数据到当前集合内
        list.addAll(productBean.result.pzsh);
        list.addAll(productBean.result.mlss);
        MyAdapter shouYeAdapter = new MyAdapter(getActivity(),list);
        recy.setAdapter(shouYeAdapter);
    }
}
