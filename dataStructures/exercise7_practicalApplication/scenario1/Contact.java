package dataStructures.exercise7_practicalApplication.scenario1;

public class Contact {
    private String name;
    private String surName;
    private int number;

    public Contact(String name, String surName, int number) {
        this.name = name;
        this.surName = surName;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}