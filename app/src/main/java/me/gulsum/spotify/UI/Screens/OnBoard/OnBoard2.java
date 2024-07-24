package me.gulsum.spotify.UI.Screens.OnBoard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import me.gulsum.spotify.R;
import me.gulsum.spotify.UI.Screens.Artist.ArtistDashboard;
import me.gulsum.spotify.UI.Screens.Music.HomePageDashboard;
import me.gulsum.spotify.UI.Screens.Music.MusicDashboard;

public class OnBoard2 extends AppCompatActivity {

    private LinearLayout darkMode;
    private LinearLayout lightMode;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard_2);

        initializeComponents();
        buttonClickListeners();
    }

    private void initializeComponents() {
        darkMode = findViewById(R.id.darkModeButton);
        lightMode = findViewById(R.id.lightModeButton);
        nextButton = findViewById(R.id.nextButton);
    }

    private void buttonClickListeners() {
        nextButton.setOnClickListener(v -> {
            //TODO
            //Butona tıklandığında sonraki ekrana aktar
            Intent artistIntent = new Intent(OnBoard2.this, HomePageDashboard.class);
            startActivity(artistIntent);
            finish();
        });

        darkMode.setOnClickListener(v -> {
            //TODO
            //Koyu tema eklenecek
        });

        lightMode.setOnClickListener(v -> {
            //TODO
            //Açık tema eklenecek
        });
    }
}
