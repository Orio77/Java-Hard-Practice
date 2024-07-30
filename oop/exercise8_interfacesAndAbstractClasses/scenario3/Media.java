package oop.exercise8_interfacesAndAbstractClasses.scenario3;

public abstract class Media implements IPlayable, IDownloadable{
    
    public abstract void play();
    public abstract void download(String title);

}