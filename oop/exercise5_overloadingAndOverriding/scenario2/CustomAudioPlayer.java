package oop.exercise5_overloadingAndOverriding.scenario2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CustomAudioPlayer extends AudioPlayer{
    private HashMap<String, String> preferences;

    public CustomAudioPlayer() {
        preferences = new HashMap<>();
    }
    public HashMap<String, String> getPreferences() {
        return preferences;
    }
    public void setPreferences(HashMap<String, String> preferences) {
        this.preferences = preferences;
    }
    
    @Override
    public void play(PlayList playList) {
        Random random = new Random();
        boolean played = false;
        for (String string : preferences.keySet()) {
            if (string.matches("order")) {
                played = true;
                if (preferences.get(string).matches("random")); {
                    playList.getSongs().get(random.nextInt(playList.getSongs().size())).play();
                }
            }
        }
        if (!played)
            super.play(playList);
    }

    @Override
    public void play(AudioPlayer audioPlayer) {
        super.play(audioPlayer);
    }

    @Override
    public void play(int volume) {
        super.play(volume);
    }

    @Override
    public void play(int volume, ArrayList<String> settings) {
        super.play(volume, settings);
    }


}
