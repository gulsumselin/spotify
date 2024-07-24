package me.gulsum.spotify.UI.Screens.Artist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import me.gulsum.spotify.R;
import me.gulsum.spotify.UI.Screens.Music.MusicDashboard;
import me.gulsum.spotify.UI.Screens.OnBoard.OnBoard2;
import me.gulsum.spotify.Util.Model.Music;
import me.gulsum.spotify.Util.Model.MusicAdapter;

public class ArtistDashboard extends AppCompatActivity {

    private ListView musicListView;
    private ArrayList<Music> musicArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        initializeComponents();
        initializeData();
    }

    private void initializeComponents() {
        musicListView = findViewById(R.id.playlistsListView);
    }

    private void initializeData() {
        musicArrayList = new ArrayList<>();
        Music tempMusic = new Music("coverData", "As It Was", "Harry Styles", "5:33", "null");

        for(int i=0; i<10; i++) {
            musicArrayList.add(tempMusic);
        }

        MusicAdapter musicAdapter = new MusicAdapter(this, musicArrayList);
        musicListView.setAdapter(musicAdapter);
    }

}
