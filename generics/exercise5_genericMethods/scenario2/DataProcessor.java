package generics.exercise5_genericMethods.scenario2;

import java.util.stream.Stream;

public class DataProcessor<T> {
    
    public Stream<T> processData(DataSource<T> data) {
        return Stream.of(data.retrieveData());
    }
}
