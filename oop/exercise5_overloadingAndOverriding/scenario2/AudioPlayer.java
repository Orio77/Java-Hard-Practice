package oop.exercise5_overloadingAndOverriding.scenario2;

import java.util.ArrayList;

public class AudioPlayer {
    private int volume;
    private ArrayList<String> settings;

    public AudioPlayer() {
        this.volume = 5;
        settings = new ArrayList<>();
    }
    private void setVolume(int volume) {
        if (volume >= 0 && volume <= 10)
            this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }
    public void setSettings(ArrayList<String> settings) {
        this.settings = settings;
    }

    public void play(int volume) {
        setVolume(volume);
    }

    public void play(int volume, ArrayList<String> settings) {
        setVolume(volume);
        this.settings = settings;
    }

    public void setEqualizerSettings(ArrayList<String> settings) {
        this.setSettings(settings);
    }
    public ArrayList<String> getEqualizerSettings() {
        return settings;
    }
    public void resetEqualizerSettings() {
        this.settings = new ArrayList<>();
    }

    public void play(AudioPlayer audioPlayer) {
        this.settings = audioPlayer.getEqualizerSettings();
    }

    public void play(PlayList playList) {
        for (Song song : playList.getSongs()) {
            song.play();
        }
    }
}
