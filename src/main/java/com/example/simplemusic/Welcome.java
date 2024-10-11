package com.example.simplemusic;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.simplemusic.Login.Login;

public class Welcome extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 2000;
    //此内容用于实现一段简单的启动动画，和activity_welcome绑定，播放图片动画
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.activity_welcome);
        Thread myThread= new Thread(){//创建子线程
            @Override
            public void run() {
                try{
                    sleep(2000);//休眠两秒
                    Intent Intent = new Intent(Welcome.this, Login.class);//启动MainActivity
                    startActivity(Intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程
    }
}