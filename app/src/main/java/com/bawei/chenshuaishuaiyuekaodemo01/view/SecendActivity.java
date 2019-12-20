package com.bawei.chenshuaishuaiyuekaodemo01.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import com.bawei.chenshuaishuaiyuekaodemo01.R;
import com.bawei.chenshuaishuaiyuekaodemo01.base.BaseActivity;

public class SecendActivity extends BaseActivity {

    private WebView webview;
    private Button btn;


    @Override
    protected void initdata() {
        webview.loadUrl("file:///android_asset/hellow.html");
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        JsToAndroid jsToAndroid = new JsToAndroid();
        webview.addJavascriptInterface(jsToAndroid,"wo");

    }

    @Override
    protected void initview() {
        webview = (WebView) findViewById(R.id.webview);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.post(new Runnable() {
                    @Override
                    public void run() {

                        webview.loadUrl("javascript:calljs()");
                    }
                });
            }
        });

    }

    @Override
    protected int layoutid() {
        return R.layout.activity_secend;
    }
}
