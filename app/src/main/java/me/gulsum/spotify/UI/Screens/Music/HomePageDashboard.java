package me.gulsum.spotify.UI.Screens.Music;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.gulsum.spotify.R;
import me.gulsum.spotify.Util.Model.Item;
import me.gulsum.spotify.Util.Model.ItemAdapter;

public class HomePageDashboard extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        itemList = generateDummyItems();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }

    private List<Item> generateDummyItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.billy_song, "Billy Song", "Artist 1", R.raw.yasak_ask));
        items.add(new Item(R.drawable.drake, "Drake Song", "Artist 2", R.raw.olacak));
        items.add(new Item(R.drawable.billy_songs, "Billy's Songs", "Artist 3", R.raw.bir_firt));

        return items;
    }
}
