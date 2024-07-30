package oop.exercise13_garbageCollection.scenario1;

import java.util.stream.Stream;

public class DataProcessor {
    
    // Garbage collection efficient
    public Stream<ProcessedData> process(Stream<Data> dataStream) {
        Stream<ProcessedData> processed = dataStream.map(data -> new ProcessedData(data)).filter(pd -> pd.getNewValue() % 2 == 1);
        return processed;
    }
}