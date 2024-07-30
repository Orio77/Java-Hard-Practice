package generics.exercise2_parameterizedTypes.scenario3;

public class SocialData<T> {
    private T data;

    public SocialData(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
