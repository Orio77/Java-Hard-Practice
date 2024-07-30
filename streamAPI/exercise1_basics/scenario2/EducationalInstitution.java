package streamAPI.exercise1_basics.scenario2;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import streamAPI.exercise4_collectors.scenario1.Pair;

public class EducationalInstitution {
    private List<Student> students;

    
    public void sortStudentNames() {
        students.stream().filter(s -> s.getAttendenceRecords()*100 > 80).map(Student::getName).sorted().forEach(System.out::println);
    }

    public long getNumberOfStudentsWithHighTestScore() {
        return students.stream().filter(s -> s.getTestScores()*100 >= 85).count();
    }

    public Map<String, Double> getBestStudents() {
        return students.stream().filter(s -> s.getTestScores()*100 >= 85).collect(Collectors.toMap(Student::getName, Student::getTestScores));
    }

    public Map<String, Pair<Double, Double>> getStudentData() {
        return students.stream().filter(Objects::nonNull).filter(s -> s.getAttendenceRecords()*100 > 90 && s.getTestScores()*100 > 90).collect(Collectors.toMap(Student::getName, s -> new Pair<>(s.getTestScores(), s.getAttendenceRecords())));
    }

    public Map<String, Pair<Double, Double>> getStudentDataOptimized() {
        return students.parallelStream().filter(s -> s != null && s.getAttendenceRecords() != 0.0 && s.getTestScores() != 0.0).filter(s -> s.getAttendenceRecords()*100 > 90 && s.getTestScores()*100 > 90).collect(Collectors.toMap(Student::getName, s -> new Pair<>(s.getTestScores(), s.getAttendenceRecords())));
    }
}
