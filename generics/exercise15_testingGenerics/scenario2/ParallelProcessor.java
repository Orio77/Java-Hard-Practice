package generics.exercise15.scenario2;

import java.util.List;

public class ParallelProcessor<T extends Data<?>> implements Processor<T>{
    
    @Override
    public void process(List<T> dataList) {

        dataList.parallelStream().forEach(data -> {
            System.out.println("Data of value: " + data.getValue() + ", processed");
        });
    }


}
