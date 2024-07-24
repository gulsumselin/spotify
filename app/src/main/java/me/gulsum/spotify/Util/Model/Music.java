package me.gulsum.spotify.Util.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {

    private String musicCover;
    private String musicName;
    private String artistName;
    private String musicDuration;
    private String redirectLink;

    public Music(String musicCover, String musicName, String artistName, String musicDuration, String redirectLink) {
        this.musicCover = musicCover;
        this.musicName = musicName;
        this.artistName = artistName;
        this.musicDuration = musicDuration;
        this.redirectLink = redirectLink;
    }

    protected Music(Parcel in) {
        musicCover = in.readString();
        musicName = in.readString();
        artistName = in.readString();
        musicDuration = in.readString();
        redirectLink = in.readString();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {return new Music(in);}

        @Override
        public Music[] newArray(int size){return new Music[size];}
    };

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(musicCover);
        dest.writeString(musicName);
        dest.writeString(artistName);
        dest.writeString(musicDuration);
        dest.writeString(redirectLink);
    }

    public String getMusicCover() {
        return musicCover;
    }

    public void setMusicCover(String musicCover) {
        this.musicCover = musicCover;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getMusicDuration() {
        return musicDuration;
    }

    public void setMusicDuration(String musicDuration) {
        this.musicDuration = musicDuration;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }
}
