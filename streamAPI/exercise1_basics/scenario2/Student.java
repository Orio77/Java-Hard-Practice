package streamAPI.exercise1_basics.scenario2;

public class Student {
    private String name;
    private double testScores;
    private double attendenceRecords;

    public Student(String name, double testScores, double attendenceRecords) {
        this.name = name;
        this.testScores = testScores;
        this.attendenceRecords = attendenceRecords;
    }

    public double getAttendenceRecords() {
        return attendenceRecords;
    }
    public String getName() {
        return name;
    }
    public double getTestScores() {
        return testScores;
    }
    
}
