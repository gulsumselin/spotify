package me.gulsum.spotify.Util.Model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import me.gulsum.spotify.R;

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Music> musicList;

    public MusicAdapter(Context context, ArrayList<Music> musicList) {
        this.context = context;
        this.musicList = musicList;
    }

    @Override
    public int getCount() {return musicList.size();}

    @Override
    public Object getItem(int position) {return musicList.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.artist_musics_item, parent, false);
            holder = new ViewHolder();
            holder.musicCoverImageView = convertView.findViewById(R.id.musicCoverImageView);
            holder.musicNameTextView = convertView.findViewById(R.id.musicNameTextView);
            holder.artistNameTextView = convertView.findViewById(R.id.artistNameTextView);
            holder.musicDurationTextView = convertView.findViewById(R.id.musicDurationTextView);
            holder.redirectLinkImageView = convertView.findViewById(R.id.redirectLinkImageView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Music currentMusic = musicList.get(position);

        Drawable tempDrawable = ContextCompat.getDrawable(context, R.drawable.data_music_cover);
        holder.musicCoverImageView.setImageDrawable(tempDrawable);
        holder.musicNameTextView.setText(currentMusic.getMusicName());
        holder.artistNameTextView.setText(currentMusic.getArtistName());
        holder.musicDurationTextView.setText(currentMusic.getMusicDuration());
        //TODO
        //redirect için herhangi bir şey düşün

        return convertView;
    }

    private static class ViewHolder {
        ImageView musicCoverImageView;
        TextView musicNameTextView;
        TextView artistNameTextView;
        TextView musicDurationTextView;
        ImageView redirectLinkImageView;
    }
}
