package com.example.we.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.we.R;

/**第三个Fragment 不播放音乐，点击这个就停止音乐
 * Created by 石头 on 2018/3/9.
 */

public class Fragment_nanian extends Fragment{
    private View view;
    private WebView cong_Webview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nanian,container,false);
        initView(view);
        // 设置支持javascript
        cong_Webview.getSettings().setJavaScriptEnabled(true);
//启动缓存
        cong_Webview.getSettings().setAppCacheEnabled(true);
//设置缓存模式
        cong_Webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        cong_Webview.loadUrl("https://www.baidu.com/");
        return view;
    }
    private void initView(View view) {
        cong_Webview = (WebView) view.findViewById(R.id.cong_webview);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
