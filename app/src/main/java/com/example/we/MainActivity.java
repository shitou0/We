package com.example.we;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView hong_xin;
    private int height;
    private int width;
//    private ImageView mose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        //获取屏幕的尺寸
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        startAnimator(hong_xin);
    }

    //创建方法
    public void startAnimator(View view) {
//        ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", 0, height / 4);
//        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, height / 4);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 10, 1);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 10, 1);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, "rotation", 360);
        //创建动画合集
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alpha, scaleX, scaleY, rotation);
        animatorSet.setDuration(10000);
        animatorSet.start();
        //设置监听
        animatorSet.addListener(new Animator.AnimatorListener() {
            // 动画开始
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //动画结束
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                finish();
            }
            //动画取消
            @Override
            public void onAnimationCancel(Animator animator) {
            }
            //动画重复
            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }


    private void initView() {
        hong_xin = (ImageView) findViewById(R.id.hongxin);
    }
}
