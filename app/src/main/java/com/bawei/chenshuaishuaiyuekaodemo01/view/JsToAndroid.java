package com.bawei.chenshuaishuaiyuekaodemo01.view;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.bawei.chenshuaishuaiyuekaodemo01.app.App;

public class JsToAndroid {
    @JavascriptInterface
    public void aaa(){
        Toast.makeText(App.getContext(), "我是无参", Toast.LENGTH_SHORT).show();

    }
    @JavascriptInterface
    public void bbb(String name){
        Toast.makeText(App.getContext(), name, Toast.LENGTH_SHORT).show();
    }
}
