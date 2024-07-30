package oop.exercise1_classesAndObjects.scenario1;

public class SchoolInterface {
    private School school;

    public SchoolInterface() {
        school = new School();
    }

    public void createStudent(String name, int studentID, String[] courses) {
        school.addStudent(new Student(name, studentID, courses));
    }

    public void removeStudent(Student student) {
        school.removeStudent(student);
    }

    public void removeStudent(int studentID) {
        school.removeStudent(studentID);
    }

    // Playground
    public static void main(String[] args) {

        SchoolInterface schoolInterface = new SchoolInterface();

        schoolInterface.createStudent(null, 0, args);
        schoolInterface.removeStudent(0);

    }
}
