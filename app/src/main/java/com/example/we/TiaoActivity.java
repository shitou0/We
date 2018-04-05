package com.example.we;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TiaoActivity extends AppCompatActivity {

    private ImageView image_View;
    /**
     * 111
     */
    private TextView tv;
    private TextView tv_2;
    Handler handler = new Handler();
    // 设置跳转时长
    int time = 5;
    private Runnable run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiao);
        initView();
//倒计时
       handler.postDelayed(run = new Runnable() {
           @Override
           public void run() {//这个方法？对的
               tv.setText(time + "秒");
               time--;
               if (time == 0) {
                   Intent intent = new Intent(TiaoActivity.this, MainActivity.class);
                   startActivity(intent);
                   finish();
                   return;
               }else {

                   handler.postDelayed(this, 1000);//这是一个递归
               }
           }
       }, 1000);
        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TiaoActivity.this, MainActivity.class));
                handler.removeCallbacks(run);
                finish();
            }
        });
    }
//    销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        image_View = findViewById(R.id.imageView1);
        tv = findViewById(R.id.tv);
        tv_2 = findViewById(R.id.tv_2);
    }
}
