package com.example.six_0112_week3.model;

public interface IShowModel {
    void GetData(String url, GetShowCallBack getShowCallBack);
    void GetImgData(String url, GetShowCallBack getShowCallBack);
    interface GetShowCallBack{
        void succ(Object oj);
    }
}
