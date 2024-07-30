package streamAPI.exercise1_basics.scenario3;

import java.util.List;

public class Student {
    private String name;
    private String grade;
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }
    public String getGrade() {
        return grade;
    }
    public String getName() {
        return name;
    }
}
