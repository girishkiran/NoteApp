package com.girish.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.girish.notes.R;
import com.girish.notes.BaseActivity;


public class SplashscreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashscreenActivity.this , NotesActivity.class));
            }
        } , getResources().getInteger(R.integer.screen_delay));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
