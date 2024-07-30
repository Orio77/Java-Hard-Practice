package generics.exercise5_genericMethods.scenario2;

public class Test<T> {
    
    public Object testRetrieveData(DataSource<T> source) {
        return source.retrieveData().getClass();
    }

    public Object testProcessData(DataProcessor<T> processor, DataSource<T> source) {
        return processor.processData(source).getClass();
    }
}
