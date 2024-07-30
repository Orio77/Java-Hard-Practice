package streamAPI.exercise2_lambdaExpressions.scenario1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambdas {
    Addition addition = (a, b, adder) -> adder.apply(a, b);
    Sort sort = (strs) -> strs.sort(Comparator.comparing(s -> s.length()));
    Sort print = (strs) -> strs.stream().forEach(System.out::println);
    StringOperation operation = (str, op) -> str.toUpperCase();
    Thread thread = new Thread(() -> {
        System.out.println("Hello from a new Thread");
    });
    IntList op = (intList) -> intList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    IntList sqr = (intList) -> intList.stream().map(n -> n*n).collect(Collectors.toList());
    OptionalIntList findMax = (intList) -> intList.stream().max((a, b) -> Integer.compare(a, b));

    public int present1(int a, int b) {
        return addition.add(a, b, Integer::sum);
    }

    public void present2(List<String> strs) {
        sort.sort(strs);
    }

    public void present3(List<String> strs) {
        print.sort(strs);
    }

    public String present4(String str, StringOperation op) {
        return operation.applyStringOperation(str, operation);
    }

    public void present5() {
        thread.run();
    }

    public List<Integer> present6(List<Integer> list) {
        return op.filterEvenNumbers(list);
    }

    public List<Integer> present7(List<Integer> list) {
        return sqr.filterEvenNumbers(list);
    }

    public Optional<Integer> present8(List<Integer> list) {
        return findMax.perform(list);
    }



}
