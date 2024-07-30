package generics.exercise5_genericMethods.scenario3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataProcessor {
    
    public <T, R> List<R> processData(List<T> data, Function<T, R> function) {

        List<R> processedData = new ArrayList<>();
        for (T dataPiece : data) {
            R result = function.apply(dataPiece);
            processedData.add(result);
        }
        return processedData;
    }

    public <T> List<T> filterData(List<T> data, Predicate<T> predicate) {

        return data.stream().filter(predicate).collect(Collectors.toList());
    }


}
