package com.example.six_0112_week3.model;

import android.util.Log;


import com.example.six_0112_week3.bean.HomeBean;
import com.example.six_0112_week3.okhttp.HttpUtils;

public class ShowModel implements IShowModel {
    @Override
    public void GetData(String url, final GetShowCallBack getShowCallBack) {
        HttpUtils.getInstance().doGet(url, HomeBean.class, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
                getShowCallBack.succ(oj);
                Log.d("onSuccess: ",oj.toString());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @Override
    public void GetImgData(String url, final GetShowCallBack getShowCallBack) {
        HttpUtils.getInstance().doGet(url, HomeBean.class, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
             getShowCallBack.succ(oj);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
