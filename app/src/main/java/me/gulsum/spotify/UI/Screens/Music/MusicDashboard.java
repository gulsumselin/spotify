package me.gulsum.spotify.UI.Screens.Music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import me.gulsum.spotify.R;

public class MusicDashboard extends AppCompatActivity {
    private ImageView seventyImageView;
    private ImageView seekBarImageView;
    private LinearLayout progressBarLayout;
    private MediaPlayer mediaPlayer;
    private Handler handler;
    private Runnable updateProgressRunnable;
    private boolean isSeekBarChanging = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_page);

        // Initialize views
        seventyImageView = findViewById(R.id.seventy);
        progressBarLayout = findViewById(R.id.progress_bar_layout);
        seekBarImageView = findViewById(R.id.seekBar);

        // Get song information from Intent
        int songResId = getIntent().getIntExtra("songResId", 0);
        String songTitle = getIntent().getStringExtra("songTitle");
        String artistName = getIntent().getStringExtra("artistName");

        // Initialize and start MediaPlayer if songResId is valid
        if (songResId != 0) {
            mediaPlayer = MediaPlayer.create(this, songResId);
            mediaPlayer.start();

            // Initialize Handler for updating progress
            handler = new Handler();
            updateProgressRunnable = new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        int duration = mediaPlayer.getDuration();
                        updateProgress(currentPosition, duration);
                        handler.postDelayed(this, 1000); // Update progress every second
                    }
                }
            };

            handler.post(updateProgressRunnable);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    seventyImageView.setVisibility(View.GONE);
                }
            }, 70000);

            // Set MediaPlayer completion listener
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    handler.removeCallbacks(updateProgressRunnable);
                }
            });
        }
    }

    private void updateProgress(int currentPosition, int duration) {
        // Calculate progress percentage
        float progressPercentage = (float) currentPosition / duration;

        // Update ImageView position based on progress
        int progressBarWidth = progressBarLayout.getWidth();
        int newProgressX = (int) (progressBarWidth * progressPercentage);

        // Update the ImageView layout parameters to reflect progress
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) seekBarImageView.getLayoutParams();
        params.leftMargin = newProgressX;
        seekBarImageView.setLayoutParams(params);

        // Optionally, update any other UI elements
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer and remove callbacks to prevent memory leaks
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (handler != null) {
            handler.removeCallbacks(updateProgressRunnable);
            handler = null;
        }
    }
}
