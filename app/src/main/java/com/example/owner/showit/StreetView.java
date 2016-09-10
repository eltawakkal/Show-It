package com.example.owner.showit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StreetView extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        String judul;
        judul = getIntent().getStringExtra("nama");
        getSupportActionBar().setTitle(judul);

        String url = "https://www.google.com/maps/place/Monumen+Nasional/@-6.1789049,106.8305331,3a,75y,54.51h,90t/data=!3m5!1e1!3m3!1srNwX3oHX2LqNgwVAH8m-cg!2e0!6s%2F%2Fgeo3.ggpht.com%2Fcbk%3Fpanoid%3DrNwX3oHX2LqNgwVAH8m-cg%26output%3Dthumbnail%26cb_client%3Dmaps_sv.tactile.gps%26thumb%3D2%26w%3D203%26h%3D100%26yaw%3D54.352005%26pitch%3D0!4m5!3m4!1s0x2e69f5d2e764b12d:0x3d2ad6e1e0e9bcc8!8m2!3d-6.1753924!4d106.8271528!6m1!1e1?hl=id-ID";

        wv1=(WebView)findViewById(R.id.webViewQ);
        wv1.setWebViewClient(new MyBrowser());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(url);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
