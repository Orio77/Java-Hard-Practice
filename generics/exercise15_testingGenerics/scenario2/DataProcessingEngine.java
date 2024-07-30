package generics.exercise15.scenario2;

import java.util.List;

public class DataProcessingEngine<T extends Data<?>> {
    private Processor<T> processor;

    public void setProcessor(Processor<T> processor) {
        this.processor = processor;
    }

    public void execute(List<T> data) {
        processor.process(data);
    }
}
