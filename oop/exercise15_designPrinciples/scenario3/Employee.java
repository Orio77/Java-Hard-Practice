package oop.exercise15_designPrinciples.scenario3;

public class Employee {
    private int ID;
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.ID = name.hashCode();
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
