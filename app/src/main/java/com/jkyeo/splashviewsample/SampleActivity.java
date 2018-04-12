package com.jkyeo.splashviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jkyeo.splashview.SplashView;

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Log.e("backinfo","是否完成："+SplashView.isExistsLocalSplashData(this));

        // call after setContentView(R.layout.activity_sample);
        SplashView.showSplashView(this, 6, R.drawable.default_img, new SplashView.OnSplashViewActionListener() {
            @Override
            public void onSplashImageClick(String actionUrl) {
                Log.d("SplashView", "img clicked. actionUrl: " + actionUrl);
                Toast.makeText(SampleActivity.this, "img clicked.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSplashViewDismiss(boolean initiativeDismiss) {
                Log.d("SplashView", "dismissed, initiativeDismiss: " + initiativeDismiss);
            }

            @Override
            public void onCompleteCaching(boolean isCache) {

            }
        });

        // call this method anywhere to update splash view data
        SplashView.updateSplashData(this, "http://img5.imgtn.bdimg.com/it/u=2167672004,1418153925&fm=27&gp=0.jpg", "http://jkyeo.com");
    }
}
