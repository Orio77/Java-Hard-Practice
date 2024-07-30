package streamAPI.exercise1_basics.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamsUtil
 */
public class StreamsUtil {

    public static List<String> filterStrings(List<String> strings, char startChar) {
        return strings.stream().filter(str -> str.startsWith(Character.toString(startChar))).collect(Collectors.toList());
    } 

    public static List<String> toUpperCaseList(List<String> strings) {
        return strings.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
    }
    
    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, (a, b) -> a + b);
    }

    public static void sortPersonsByAge(List<Person> persons) {
        persons.sort(Comparator.comparing(p -> p.getAge()));
    }

    public static Optional<String> findFirstLongString(List<String> strings) {
        return strings.stream().filter(s -> s.length() > 3).findFirst();
    }

    public static void printStrings(List<String> strings) {
        strings.stream().forEach(System.out::println);
    }

    public static Map<Object, List<String>> groupByFirstChar(List<String> strings) {
        return strings.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

    public static List<Integer> mergeAndSortLists(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream()).sorted().toList();
    }
}