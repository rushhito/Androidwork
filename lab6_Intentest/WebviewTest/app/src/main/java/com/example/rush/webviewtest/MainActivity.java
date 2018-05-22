package com.example.rush.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView webView =(WebView)findViewById(R.id.webview);
        webView.loadUrl("https://www.baidu.com");//网址为主页

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return true;
            }
            });
        Button home =(Button)findViewById(R.id.home);
        Button go =(Button)findViewById(R.id.go);
        Button goback=(Button)findViewById(R.id.goback);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    for (int i=0;i<20;i++){
                        webView.goBack();
                    }
                }

        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<20;i++){
                    webView.goForward();
                }
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goBack();
            }
        });

    }
}
