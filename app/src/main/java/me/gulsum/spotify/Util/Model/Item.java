package me.gulsum.spotify.Util.Model;

public class Item {
    private int imageResource;
    private String title;
    private String artist;
    private int songResourceId;

    public Item(int imageResource, String title, String artist, int songResourceId) {
        this.imageResource = imageResource;
        this.title = title;
        this.artist = artist;
        this.songResourceId = songResourceId;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongResourceId() {
        return songResourceId;
    }

    public void setSongResourceId(int songResourceId) {
        this.songResourceId = songResourceId;
    }
}
