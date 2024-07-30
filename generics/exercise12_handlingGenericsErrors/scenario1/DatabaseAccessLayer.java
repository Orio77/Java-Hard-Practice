package generics.exercise12_handlingGenericsErrors.scenario1;

public class DatabaseAccessLayer<T> {

    public DatabaseResult<T> handleGenericError(Exception e, Class<T> clazz) {
        return new DatabaseResult<T>(null, "Failed to get result", false);
    }

    public String logError(Exception e, Class<T> clazz) {
        return "Message: \n" + e.getMessage() + "\n" + clazz.getClass();
    }

    public DatabaseResult<T> simulateQueryExecution(Query<T> query) {
        if (query.hashCode() % 2 == 0) {
            return new DatabaseResult<T>(null, "", true);
        }
        else 
            return new DatabaseResult<T>(null, "Failed", false);
    }

    public DatabaseResult<T> queryDatabase(Query<T> query) {
        DatabaseResult<T> result = simulateQueryExecution(query);

        if (result.isSuccess())
            return result;
        else {
            Exception e = new Exception("Exception");
            handleGenericError(e, query.getType());
            logError(e, query.getType());
            result.setErrorMessage(e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }
}