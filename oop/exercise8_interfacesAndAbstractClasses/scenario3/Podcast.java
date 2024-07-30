package oop.exercise8_interfacesAndAbstractClasses.scenario3;

public class Podcast extends Media{
    
    @Override
    public void play() {
        System.out.println("Playing a Podcast");
    }

    @Override
    public void download(String title) {
        System.out.println("Downloaded the podcast: '" + title + "'");
    }
}
