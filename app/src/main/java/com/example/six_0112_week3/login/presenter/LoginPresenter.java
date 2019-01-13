package com.example.six_0112_week3.login.presenter;


import android.util.Log;

import com.example.six_0112_week3.LoginActivity;
import com.example.six_0112_week3.ZhuActivity;
import com.example.six_0112_week3.login.model.ILoginModel;
import com.example.six_0112_week3.login.model.LoginModel;

public class LoginPresenter implements ILoginPresenter {
    private LoginModel loginModel;
    LoginActivity mainActivity;
    ZhuActivity zhuActivity;



    public LoginPresenter(LoginActivity mainActivity) {
        this.mainActivity = mainActivity;
        loginModel = new LoginModel();
    }

    public LoginPresenter(ZhuActivity zhuActivity) {
        this.zhuActivity=zhuActivity;
        loginModel = new LoginModel();
    }

    @Override
    public void GetLoginModelData(String name,String pwd) {
        loginModel.GetData("http://120.27.23.105/user/login", name,pwd,new  ILoginModel.LoginCallBack() {
            @Override
            public void succ(String oj) {
             mainActivity.GetLoginData(oj);
                Log.i( "succ: ",oj);
            }
        });
    }

    @Override
    public void GetZhuModelData(String name, String pwd) {
        loginModel.GetData("http://120.27.23.105/user/reg", name, pwd, new ILoginModel.LoginCallBack() {
            @Override
            public void succ(String oj) {
                zhuActivity.GetZhuData(oj);
            }
        });
    }
}
