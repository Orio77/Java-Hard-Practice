package generics.exercise12.scenario1;

import java.util.List;

public class Query<T> {
    private String sql;
    private List<Object> parameters;
    private Class<T> type;

    public Query(String sql, List<Object> parameters) {
        this.sql = sql;
        this.parameters = parameters;
    }

    

    public String getSql() {
        return sql;
    }
    public List<Object> getParameters() {
        return parameters;
    }

    public Class<T> getType() {
        return type;
    }
    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }
    public void setType(Class<T> type) {
        this.type = type;
    }
}
