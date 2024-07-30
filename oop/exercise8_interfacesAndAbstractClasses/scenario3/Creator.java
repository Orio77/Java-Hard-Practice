package oop.exercise8_interfacesAndAbstractClasses.scenario3;

public class Creator extends User implements ICreator{
    
    public Creator(String login, String password) {
        super(login, password);
    }

    @Override
    public void create() {
        System.out.println("Creator creating");
    }
}
