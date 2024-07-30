package streamAPI.exercise17_codeReadibility.scenario3;

import java.util.List;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private List<String> coursesTaken;
    private Map<String, Integer> courseGrades;

    public Map<String, Integer> getCourseGrades() {
        return courseGrades;
    }
    public List<String> getCoursesTaken() {
        return coursesTaken;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
