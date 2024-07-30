package streamAPI.exercise20_usefulPrograms.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgrammerManagement {
    

    public List<Programmer> findTopProgrammers(List<Programmer> programmers) {
        return programmers.stream().sorted(Comparator.comparing(Programmer::getProjectsCompleted)).limit(3).toList();
    }

    public int findMostCommonProjectCount(List<Programmer> programmers) {
        return programmers.stream().collect(Collectors.groupingBy(Programmer::getProjectsCompleted, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0);
    }

    public Map<String, List<Programmer>> groupByLanguage(List<Programmer> programmers) {
        return programmers.stream().collect(Collectors.groupingBy(Programmer::getProgrammingLanguage));
    }

    public String findMostPopularLanguage(List<Programmer> programmers) {
        return programmers.stream().collect(Collectors.groupingBy(Programmer::getProgrammingLanguage, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("null");
    }

    public List<Programmer> filterNullLanguages(List<Programmer> programmers) {
        return programmers.stream().filter(programmer -> programmer.getProgrammingLanguage() != null).toList();
    }

    public List<Programmer> defaultNullLanguages(List<Programmer> programmers, String defaultLanguage) {
        return programmers.stream().map(programmer -> {
            if (programmer.getProgrammingLanguage() == null) {
                programmer.setProgrammingLanguage(defaultLanguage);
            }
            return programmer;
        }).toList();
    }

    public String findFastestLanguage(List<Programmer> programmers) {
        return programmers.stream().sorted(Comparator.comparing(Programmer::getProjectsCompleted)).map(Programmer::getProgrammingLanguage).findFirst().orElse("null");
    }

    public String findSlowestLanguage(List<Programmer> programmers) {
        return programmers.stream().sorted(Comparator.comparing(Programmer::getProjectsCompleted).reversed()).map(Programmer::getProgrammingLanguage).findFirst().orElse("null");
    }

    public Map<String, Double> averageProjectsPerLanguage(List<Programmer> programmers) {
        return programmers.stream().collect(Collectors.groupingBy(Programmer::getProgrammingLanguage, Collectors.averagingDouble(Programmer::getProjectsCompleted)));
    }
}
