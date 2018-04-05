package com.example.we;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.we.Fragment.Fragment_cong;
import com.example.we.Fragment.Fragment_nanian;
import com.example.we.Fragment.Fragment_xin;

public class TwoActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout fragment_Layout;
    /**
     * 这个是
     * 匆匆
     */
    private RadioButton rb_Baidu;
    /**
     * ❤
     */
    private RadioButton rb_Lunbo;
    /**
     * 那年
     */
    private RadioButton rb_Nanian;
    private RadioGroup radio_Group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
        Toast.makeText(TwoActivity.this, "四人帮加油", Toast.LENGTH_LONG).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new Fragment_xin()).commit();

    }

    private void initView() {
        fragment_Layout = (FrameLayout) findViewById(R.id.fragment_layout);
        rb_Baidu = (RadioButton) findViewById(R.id.rb_baidu);
        rb_Baidu.setOnClickListener(this);
        rb_Lunbo = (RadioButton) findViewById(R.id.rb_lunbo);
        rb_Lunbo.setOnClickListener(this);
        rb_Nanian = (RadioButton) findViewById(R.id.rb_nanian);
        rb_Nanian.setOnClickListener(this);
        radio_Group = (RadioGroup) findViewById(R.id.radio_group);
        radio_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_baidu:
                        Toast.makeText(TwoActivity.this, "一直", Toast.LENGTH_SHORT).show();
                        rb_Baidu.setBackgroundDrawable(getResources().getDrawable(R.drawable.jia));
                        rb_Lunbo.setBackgroundDrawable(getResources().getDrawable(R.drawable.li));
                        rb_Nanian.setBackgroundDrawable(getResources().getDrawable(R.drawable.li));
                        break;//嗯嗯  有两种办法，一种是写代码，有点臃肿，但是理解起来简单    还有一种使用xml比较简单
                    case R.id.rb_lunbo:
                        Toast.makeText(TwoActivity.this, "在", Toast.LENGTH_SHORT).show();
                        rb_Baidu.setBackgroundDrawable(getResources().getDrawable(R.drawable.li));
                        rb_Lunbo.setBackgroundDrawable(getResources().getDrawable(R.drawable.jia));
                        rb_Nanian.setBackgroundDrawable(getResources().getDrawable(R.drawable.li));
                        break;
//                那年shibai a    yinggia meiyou weninti   nizhenjishiyixia  都安装不成功你晚上有事？恩

                    case R.id.rb_nanian:
                        Toast.makeText(TwoActivity.this, "思念", Toast.LENGTH_SHORT).show();
                        rb_Baidu.setBackgroundDrawable(getResources().getDrawable(R.drawable.li));
                        rb_Lunbo.setBackgroundDrawable(getResources().getDrawable(R.drawable.li));
                        rb_Nanian.setBackgroundDrawable(getResources().getDrawable(R.drawable.jia));;
                        break;
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
//                匆匆
            case R.id.rb_baidu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new Fragment_cong()).commit();
                break;//嗯嗯  有两种办法，一种是写代码，有点臃肿，但是理解起来简单    还有一种使用xml比较简单
            case R.id.rb_lunbo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new Fragment_xin()).commit();
                break;
//                那年shibai a
            case R.id.rb_nanian:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new Fragment_nanian()).commit();
//              finish();
                break;
        }
    }
}
