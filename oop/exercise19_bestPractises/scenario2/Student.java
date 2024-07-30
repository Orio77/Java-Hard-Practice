package oop.exercise19_bestPractises.scenario2;

public class Student extends Member implements Membercategory{

    public Student(String name) {
        super(name);
    }

    @Override
    public int calculatemaxBooks() {
       return 3;
    }
    
}
