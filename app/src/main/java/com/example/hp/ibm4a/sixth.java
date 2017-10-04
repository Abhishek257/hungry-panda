package com.example.hp.ibm4a;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class sixth extends Activity {
WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        w= (WebView) findViewById(R.id.webView);
        w.setWebViewClient(new MyBrowser());
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl("https://www.zomato.com");

    }
    private class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
