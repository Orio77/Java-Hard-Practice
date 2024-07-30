package oop.exercise8_interfacesAndAbstractClasses.scenario3;

public class Listener extends User implements IListener{

    public Listener(String login, String password) {
        super(login, password);
    }
    
    @Override
    public void listen() {
        System.out.println("Listener listening");
    }
}
