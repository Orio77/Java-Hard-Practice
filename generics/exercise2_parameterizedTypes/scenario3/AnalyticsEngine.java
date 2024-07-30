package generics.exercise2_parameterizedTypes.scenario3;

public class AnalyticsEngine<T extends SocialData<T>> {
    private DataProcessor<T> processor;

    public AnalyticsEngine(DataProcessor<T> dataProcessor) {
        this.processor = dataProcessor;
    }

    public void processData(T data) {
        processor.process(data);
    }

    public void analyze(T data) {
        System.out.println("Performing analysis of data with value: " + data.getData());
    }
}
