package com.example.six_0112_week3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.six_0112_week3.R;
import com.example.six_0112_week3.ZxingActivity;
import com.example.six_0112_week3.adapter.MyAdapter;
import com.example.six_0112_week3.bean.HomeBean;
import com.example.six_0112_week3.presenter.ShowPresenter;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;


public class ShowFragment extends Fragment{
    private RecyclerView recy;
    private LinearLayoutManager linearLayoutManager;
    private ShowPresenter showPresenter;
    private MyAdapter myAdapter;
    private XBanner xbanner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou_layout, container, false);
        recy = view.findViewById(R.id.recy);
        xbanner=view.findViewById(R.id.xbanner);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recy.setLayoutManager(linearLayoutManager);
        showPresenter = new ShowPresenter(this);
        showPresenter.GetShowModelData();
        showPresenter.GetImgModelData();
        return view;
    }

    public void GetViewData(Object oj) {
        HomeBean data= (HomeBean) oj;
        myAdapter = new MyAdapter(getActivity(), data);
        recy.setAdapter(myAdapter);

    }
    public void GetImgData(Object oj){
        final List<String> list = new ArrayList<>();
        HomeBean homeBean = (HomeBean) oj;
        List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
        for (int i = 0; i < banner.size(); i++) {
            list.add(banner.get(i).getIcon());
        }
        xbanner.setData(list, null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);
            }
        });
        xbanner.setPageTransformer(Transformer.Default);
        xbanner.setPageChangeDuration(1000);
    }
}
