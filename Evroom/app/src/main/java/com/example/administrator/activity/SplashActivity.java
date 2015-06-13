package com.example.administrator.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.administrator.R;


public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TransitionDrawable transitionDrawable = (TransitionDrawable) getResources().
                getDrawable(R.drawable.splash_drawable);
        ((ImageView) findViewById(R.id.imageView)).setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(800);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (isFinishing()) {
                    return;
                }
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
                SplashActivity.this.overridePendingTransition(
                        R.anim.fade_in, R.anim.fade_out);
            }
        }, 2000);
    }

}
