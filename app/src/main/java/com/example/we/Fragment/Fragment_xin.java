package com.example.we.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.we.R;
import com.example.we.img.BannerImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 第二个Fragment 播放音乐，点击这个就有开始音乐
 * Created by 石头 on 2018/3/9.
 */

public class Fragment_xin extends Fragment implements View.OnClickListener {
    private View view;
    private Banner ban;
    /**
     * xiaren
     * 播放
     */
    private Button btn_Bofang;
    /**
     * 暂停
     */
    private Button btn_Zanting;
    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xin, container, false);

        initView(view);
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.zuimieqidai);
        mediaPlayer.setLooping(true);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<Integer> li = new ArrayList<>();
//进行放入
// li.add("http://a0.att.hudong.com/15/08/300218769736132194086202411_950.jpg");
        li.add(R.drawable.a2);
        li.add(R.drawable.a1);
        li.add(R.drawable.a3);
        li.add(R.drawable.a4);
        li.add(R.drawable.a5);
        li.add(R.drawable.a12);
        li.add(R.drawable.a11);
        li.add(R.drawable.a6);
        li.add(R.drawable.a7);
        li.add(R.drawable.a8);
        li.add(R.drawable.a9);
        li.add(R.drawable.a10);
        li.add(R.drawable.a13);
        li.add(R.drawable.a14);
        ban.setImageLoader(new BannerImageLoader());
        ban.setImages(li);
        ban.start();
//        onstart();

    }

    private void initView(View view) {
        ban = (Banner) view.findViewById(R.id.ban);
        btn_Bofang = (Button) view.findViewById(R.id.btn_bofang);
        btn_Bofang.setOnClickListener(this);
        btn_Zanting = (Button) view.findViewById(R.id.btn_zanting);
        btn_Zanting.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            default:
//                break;//zheli是干什么的？
            case R.id.btn_bofang:
                if (mediaPlayer.isPlaying() == true) {
                    break;
                } else if (mediaPlayer.isPlaying() != true) {
                    onstart();
                    break;
                }//终于好了...等一下，我看看,keyile ba 6
            case R.id.btn_zanting:
                mediaPlayer.pause();
                break;
        }
    }

    /**
     * 这是我给你改的方法，
     */
    private void onstop() {//<--这个是我自己的停止方法
        mediaPlayer.stop();//停止
    }

    private void onstart() {//<--这个是我自己的播放方法
        mediaPlayer.start();//播放
    }

    /**
     * 这个是fragment的显示出来的函数
     */
    @Override
    public void onStart() {
        super.onStart();
        onstart();
    }

    /**
     * 这个是fragment的消失函数
     */
    @Override
    public void onStop() {
        super.onStop();
        onstop();
    }
}
