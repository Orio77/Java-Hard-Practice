package generics.exercise5_genericMethods.scenario2;

public class DataSourceHandler<T> {
    private DataProcessor<T> processor;

    public DataSourceHandler() {
        processor = new DataProcessor<>();
    }

    public void handleDataSourceDetails(DataSource<T> data) {
        System.out.println("Data details: " + processor.processData(data));
    }

    public DataProcessor<T> getProcessor() {
        return processor;
    }
}
