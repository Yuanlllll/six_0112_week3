package com.example.six_0112_week3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class SanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI umShareAPI=UMShareAPI.get(SanActivity.this);
                umShareAPI.getPlatformInfo(SanActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(SanActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Log.i("Tag",map+"");
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(SanActivity.this).onActivityResult(requestCode,resultCode,data);
    }
}
