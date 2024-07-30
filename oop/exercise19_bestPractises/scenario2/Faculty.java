package oop.exercise19_bestPractises.scenario2;

public class Faculty extends Member implements Membercategory {

    public Faculty(String name) {
        super(name);
    }

    @Override
    public int calculatemaxBooks() {
        return 7;
    }
    
}
