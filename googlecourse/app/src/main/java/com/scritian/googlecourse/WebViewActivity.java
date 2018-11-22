package com.scritian.googlecourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class WebViewActivity extends AppCompatActivity {
    private WebView wvUrl;
    private String movie_url="https://www.imdb.com/title/tt0816692/";
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        wvUrl=findViewById(R.id.wvUrl);
        ivBack=findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WebViewActivity.this, MovieActivity.class));
            }
        });
        wvUrl.getSettings().setJavaScriptEnabled(true);
        wvUrl.setWebViewClient(new WebViewClient());
        wvUrl.loadUrl(movie_url);
    }
}
