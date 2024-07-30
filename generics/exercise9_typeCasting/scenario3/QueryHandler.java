package generics.exercise9_typeCasting.scenario3;

import java.util.List;

public class QueryHandler<T extends Query> {
    private SupportAgent<T> agent;
    
    public void handleQuery(T query, String message) {
        query.respond(message);
    }

    public void handleQueries(List<T> queries, String message) {
        for (T query : queries) {
           handleQuery(query, message); 
        }
    }

    public void handleQueryWithAgent(T query) {
        agent.handleQuery(query);
    }

    public void setAgent(SupportAgent<T> agent) {
        this.agent = agent;
    }
    public SupportAgent<T> getAgent() {
        return agent;
    }

    public void handleQueriesWithAgent(List<T> queries) {
        for (T query : queries) {
            agent.handleQuery(query);
        }
    }
}
