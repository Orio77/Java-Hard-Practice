package oop.exercise8_interfacesAndAbstractClasses.scenario1;

public class AutoCompletePlugin implements Plugin {
    private final String name = "AutoComplete Plugin";

    @Override
    public void initialize() {
        System.out.println("Initializing " + name);
    }

    @Override
    public void execute() {
        System.out.println("Executing " + name);
    }

    @Override
    public void terminate() {
        System.out.println("Terminating " + name);
    }
}
