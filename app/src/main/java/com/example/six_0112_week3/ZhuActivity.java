package com.example.six_0112_week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.six_0112_week3.bean.HomeBean;
import com.example.six_0112_week3.login.presenter.ILoginPresenter;
import com.example.six_0112_week3.login.presenter.LoginPresenter;
import com.example.six_0112_week3.login.view.LoginView;
import com.google.gson.Gson;

public class ZhuActivity extends AppCompatActivity implements LoginView {
    private EditText res_phone;
    private EditText res_pwd;
    private Button but_ok;
    private LoginPresenter iPresenter;
    private String phone;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        res_phone = (EditText) findViewById(R.id.res_phone);
        res_pwd = (EditText) findViewById(R.id.res_pwd);
        but_ok = (Button) findViewById(R.id.but_ok);
        iPresenter = new LoginPresenter(this);
        but_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = res_phone.getText().toString();
                pwd = res_pwd.getText().toString();
                if(phone !=""|| pwd !=""){
                    iPresenter.GetZhuModelData(phone, pwd);
                }else{
                    Toast.makeText(ZhuActivity.this,"账号密码不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void GetLoginData(String data) {

    }

    @Override
    public void GetZhuData(String data) {
        Gson gson = new Gson();
        final HomeBean beanRes = gson.fromJson(data, HomeBean.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZhuActivity.this,beanRes.getMsg(),Toast.LENGTH_SHORT).show();
                if (!beanRes.getMsg().equals("天呢！用户已注册")){
                    startActivity(new Intent(ZhuActivity.this,MainActivity.class));
                }
            }
        });
    }
}
