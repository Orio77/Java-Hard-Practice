package dataStructures.exercise1_basics.scenario1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Playlist {
    private String name;
    private LinkedList<Song> playlist;
    Iterator<Song> iterator;

    public Playlist(String name) {
        playlist = new LinkedList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //adds Song
    public void addSong(Song song) {
        iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            if (iterator.next() == song) {
                System.out.println("Song is already added to the playlist");
                break;
            }
        }

        playlist.add(song);
    }

    //removes Song with given title
    public void removeSong(String title) {
        iterator = playlist.listIterator();
        while (iterator.hasNext()) {
            Song nextSong = iterator.next();
            if (nextSong.getTitle().equals(title)) {
                playlist.remove(nextSong);
                return;
            }
        }
    }

    //removes Song with given position
    public void removeSong(int position) {
        if (position < 0 || position > playlist.size()) {
            System.out.println("There is no such position on your playlist");
            return;
        }
        playlist.remove(position + 1);
    }

    //shuffles the playlist
    public void shuffle() {
        Collections.shuffle(playlist);
    }

    @Override
    public String toString() {
        return playlist.toString();
    }
}
