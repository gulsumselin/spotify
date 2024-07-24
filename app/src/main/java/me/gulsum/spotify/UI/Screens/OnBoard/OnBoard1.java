package me.gulsum.spotify.UI.Screens.OnBoard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import me.gulsum.spotify.R;

public class OnBoard1 extends AppCompatActivity {

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard_1);

        initializeComponents();
        buttonClickListeners();
    }

    private void initializeComponents() {
        nextButton = findViewById(R.id.nextButton);
    }

    private void buttonClickListeners() {
        nextButton.setOnClickListener(v -> {
            Intent onboard2Intent = new Intent(OnBoard1.this, OnBoard2.class);
            startActivity(onboard2Intent);
            finish();
        });
    }
}
