package oop.exercise1_classesAndObjects.scenario1;

import java.util.Arrays;

public class Student {
    private String name;
    private int studentID;
    private String[] courses;

    public Student(String name, int studentID, String[] courses) {
        this.name = name;
        this.studentID = studentID;
        this.courses = courses;
    }

    public String[] getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + studentID);
        System.out.println("Courses: " + Arrays.toString(courses));
    }
}
