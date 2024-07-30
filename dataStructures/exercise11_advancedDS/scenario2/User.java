package dataStructures.exercise11_advancedDS.scenario2;

import java.util.LinkedList;

public class User {
    private String login;
    private LinkedList<Content> viewedContent;

    public User(String login) {
        this.login = login;
        viewedContent = new LinkedList<>();
    }

    public String getLogin() {
        return login;
    }

    public LinkedList<Content> getViewedContent() {
        return viewedContent;
    }

    public void watchVideo(Content content) {
        viewedContent.add(content);
    }

    public void simulateContentConsumption(int numberOfVideosWatched) {
        for (int i = 1; i <= numberOfVideosWatched + 1; i++) {
            watchVideo(new Content("Video" + i));
        }
    }
}
