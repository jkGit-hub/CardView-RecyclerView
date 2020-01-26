package com.jkapps.cardviewwithrecyclerview;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


public class WebViewActivity  extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_layout);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("shopUrl")) {
            String shopUrl = getIntent().getStringExtra("shopUrl");
            openUrl(shopUrl);
        }
    }

    private void openUrl(String shopUrl) {
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(shopUrl);
    }
}

