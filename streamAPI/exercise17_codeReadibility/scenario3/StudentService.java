package streamAPI.exercise17_codeReadibility.scenario3;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentService {
    
    public List<Student> findTopPerformers(List<Student> students, int n) {
        return students.stream().sorted((s1, s2) -> {
            Double avg1 = s1.getCourseGrades().values().stream().mapToInt(num -> num).average().getAsDouble();
            Double avg2 = s2.getCourseGrades().values().stream().mapToInt(num -> num).average().getAsDouble();
            return avg1.compareTo(avg2);
        }).limit(n).toList();
    }

    public List<String> recommendCourse(List<Student> students, String studentId) {
        return students.stream().filter(student -> student.getId().matches(studentId)).flatMap(student -> student.getCoursesTaken().stream()).filter(course -> {
            Set<String> allCourses = students.get(0).getCourseGrades().keySet(); // Assuming all courses are included here
            if (allCourses.contains(course)) {
                return false;
            }
            else {
                return true;
            }
        }).toList();
    }

    public String findMostPopularCourse(List<Student> students) {
        return students.stream().flatMap(student -> student.getCoursesTaken().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public String findLeastScoringCourse(List<Student> students) {
        return students.stream().flatMap(student -> student.getCourseGrades().entrySet().stream()).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue))).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public List<Student> findFailedStudents(List<Student> students) {
        return students.stream().filter(student -> {
            Optional<Integer> st = student.getCourseGrades().values().stream().filter(grade -> grade >= 50).findAny();

            if (st.isPresent()) {
                return true;
            }
            else {
                return false;
            }
        }).toList();
    }

    public List<String> findTopCourse(List<Student> students) {
        Double maxAvg = students.stream().flatMap(student -> student.getCourseGrades().entrySet().stream()).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue))).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        return students.stream().flatMap(student -> student.getCourseGrades().entrySet().stream()).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue))).entrySet().stream().filter(es -> es.getValue() == maxAvg).map(Map.Entry::getKey).toList();
    }

    public Student findStudentById(List<Student> students, String id) throws StudentNotFoundException {
        List<Student> stdnt = students.stream().filter(student -> student.getId().matches(id)).toList();

        if (stdnt.isEmpty()) {
            throw new StudentNotFoundException();
        }
        else {
            return stdnt.get(0);
        }
    }

    public double calculateAverageGrade(List<Student> students, String id) throws StudentNotFoundException, NoCoursesTakenException {
        if (!students.stream().anyMatch(student -> student.getId().matches(id))) {
            throw new StudentNotFoundException();
        }
        Optional<Double> avg = students.stream().filter(student -> student.getId().matches(id)).flatMap(student -> student.getCourseGrades().entrySet().stream()).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue))).entrySet().stream().map(Map.Entry::getValue).findFirst();

        if (avg.isPresent()) {
            return avg.get();
        }
        else {
            throw new NoCoursesTakenException();
        }

    }

    public String recommendNextCourse(List<Student> students, String id) throws StudentNotFoundException, NoCoursesLeftException {
        List<String> allCourses = students.stream().flatMap(student -> student.getCourseGrades().entrySet().stream()).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue))).entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toList();

        Optional<Student> optionalTarget = students.stream().filter(student -> student.getId().matches(id)).findFirst();
        Student target = null;

        if (!optionalTarget.isPresent()) {
            throw new StudentNotFoundException();
        }
        else {
            target = optionalTarget.get();
        }

        target.getCoursesTaken().stream().map(course -> {
            if (allCourses.contains(course)) {
                allCourses.remove(course);
            }
            return course;
        }).close();

        if (allCourses.isEmpty()) {
            throw new NoCoursesLeftException();
        }

        return allCourses.get(0);
    }
}
