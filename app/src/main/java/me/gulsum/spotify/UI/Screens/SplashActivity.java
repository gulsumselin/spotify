package me.gulsum.spotify.UI.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import me.gulsum.spotify.R;
import me.gulsum.spotify.UI.Screens.OnBoard.OnBoard1;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent onBoardIntent = new Intent(SplashActivity.this, OnBoard1.class);
            startActivity(onBoardIntent);
            finish();
        }, SPLASH_DELAY);
    }
}
