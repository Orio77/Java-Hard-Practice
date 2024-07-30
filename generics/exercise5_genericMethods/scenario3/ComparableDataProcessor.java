package generics.exercise5_genericMethods.scenario3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparableDataProcessor<T extends Comparable<T>> extends DataProcessor{
    
    public List<T> sortData(List<T> data) {

        return data.stream().sorted().collect(Collectors.toList());
    }

    public <R> List<R> processAndSOrtData(List<T> data, Function<T, R> function, Comparator<R> comparator) {
        List<R> processedData = processData(data, function);
        processedData.sort(comparator);
        return processedData; 
    }
}
