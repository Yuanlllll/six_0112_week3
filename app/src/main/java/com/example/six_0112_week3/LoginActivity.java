package com.example.six_0112_week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.six_0112_week3.bean.HomeBean;
import com.example.six_0112_week3.login.presenter.LoginPresenter;
import com.example.six_0112_week3.login.view.LoginView;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    EditText mLogin,mRegister;
    Button mLoginBut;
    private LoginPresenter loginPresenter;
    private TextView but_res;
    private String name;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogin = findViewById(R.id.login_name_et);
        mRegister =  findViewById(R.id.login_pswd_et);
        mLoginBut=  findViewById(R.id.login_lgbt);
        but_res=  findViewById(R.id.but_res);
        //初始persenter
        loginPresenter = new LoginPresenter(this);
        mLoginBut.setOnClickListener(this);
        but_res.setOnClickListener(this);
    }

    @Override
    public void GetLoginData(final String data) {
        new Thread(){
            @Override
            public void run() {
                runOnUiThread(new Runnable() {



                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        HomeBean bean = gson.fromJson(data, HomeBean.class);
                        Toast.makeText(LoginActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                        if(bean.getMsg().equals("登录成功")){
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }
                    }
                });
            }
        }.start();

    }

    @Override
    public void GetZhuData(String data) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_lgbt:
                name = mLogin.getText().toString();
                pwd = mRegister.getText().toString();
                if(name !=null&& pwd !=null){
                    loginPresenter.GetLoginModelData(name,pwd);
                }
                break;
            case R.id.but_res:
                startActivity(new Intent(LoginActivity.this,ZhuActivity.class));
                break;
        }

    }
}
