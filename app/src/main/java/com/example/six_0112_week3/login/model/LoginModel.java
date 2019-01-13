package com.example.six_0112_week3.login.model;


import android.util.Log;

import com.example.six_0112_week3.okhttp.OkHttp3;

public class LoginModel implements ILoginModel{
    @Override
    public void GetData(String url, String name, String pwd, final LoginCallBack loginCallBack) {
        OkHttp3.okHttpPost(url, name, pwd, new OkHttp3.GetBackPost() {
            @Override
            public void getTrue(String succ) {
                loginCallBack.succ(succ);
                Log.i( "getTrue: ",succ);
            }
        });
    }
}
