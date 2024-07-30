package oop.exercise8_interfacesAndAbstractClasses.scenario3;

public class Song extends Media{
    
    @Override
    public void play() {
        System.out.println("Playing a song");
    }

    @Override
    public void download(String title) {
        System.out.println("Downloading a song: '" + title + "'");
    }
}
