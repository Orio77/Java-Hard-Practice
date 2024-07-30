package generics.exercise2_parameterizedTypes.scenario3;

public class SocialDataProcessor<T extends SocialData<?>> implements DataProcessor<T> {

    @Override
    public void process(T data) {
        System.out.println("Processed data of value: " + data.getData());
    }


}
