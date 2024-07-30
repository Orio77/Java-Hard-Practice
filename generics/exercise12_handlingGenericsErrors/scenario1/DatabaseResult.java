package generics.exercise12.scenario1;

public class DatabaseResult<T> {
    private T data;
    private String errorMessage;
    private boolean success;


    public DatabaseResult(T data, String errorMessage, boolean success) {
        this.data = data;
        this.errorMessage = errorMessage;
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public T getData() {
        return data;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
