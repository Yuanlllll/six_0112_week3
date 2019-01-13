package com.example.six_0112_week3.presenter;


import android.util.Log;

import com.example.six_0112_week3.fragment.ShowFragment;
import com.example.six_0112_week3.model.IShowModel;
import com.example.six_0112_week3.model.ShowModel;

public class ShowPresenter implements IShowPresenter {
    private final ShowModel showModel;
    ShowFragment showFragment;

    public ShowPresenter(ShowFragment showFragment) {
        this.showFragment = showFragment;
        showModel = new ShowModel();
    }



    @Override
    public void GetShowModelData() {
        showModel.GetData("http://120.27.23.105/home/getHome", new IShowModel.GetShowCallBack() {
            @Override
            public void succ(Object oj) {
             showFragment.GetViewData(oj);
                Log.i( "succ: ",oj.toString());
            }
        });
    }

    @Override
    public void GetImgModelData() {
        showModel.GetData("http://120.27.23.105/home/getHome", new IShowModel.GetShowCallBack() {
            @Override
            public void succ(Object oj) {
                showFragment.GetImgData(oj);
            }
        });
    }
}
