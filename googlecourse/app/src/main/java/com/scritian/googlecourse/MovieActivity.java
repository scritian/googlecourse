package com.scritian.googlecourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity {

    private TextView tvLinkIMDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        tvLinkIMDB=findViewById(R.id.tvLinkIMDB);
        tvLinkIMDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieActivity.this, WebViewActivity.class));
            }
        });
    }
}
