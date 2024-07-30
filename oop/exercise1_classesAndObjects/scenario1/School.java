package oop.exercise1_classesAndObjects.scenario1;

import java.util.ArrayList;

public class School {
    ArrayList<Student> studentBase;

    public School() {
        studentBase = new ArrayList<>();
    }

    public boolean removeStudent(Student student) {
        if (studentBase.contains(student)) {
            studentBase.remove(student);
            return true;
        }

        return false;
    }

    public boolean addStudent(Student student) {

        if (!studentBase.contains(student)) {
            studentBase.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(int studentID) {
        for (Student student : studentBase) {
            if (student.getStudentID() == studentID) {
                studentBase.remove(student);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getStudentBase() {
        return studentBase;
    }
}
