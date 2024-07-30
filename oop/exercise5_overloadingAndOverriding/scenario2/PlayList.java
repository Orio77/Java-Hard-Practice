package oop.exercise5_overloadingAndOverriding.scenario2;

import java.util.ArrayList;

public class PlayList {
    private ArrayList<Song> songs;

    public PlayList() {
        songs = new ArrayList<>();
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
