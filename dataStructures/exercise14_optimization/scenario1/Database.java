package dataStructures.exercise14_optimization.scenario1;

import java.util.*;

public class Database {
    private Map<Integer, String> data;
    private ArrayList<String> cache;

    public Database() {
        this.data = new HashMap<>();
        this.cache = null;
    }

    // Simulates an SQL INSERT operation
    public void insert(int id, String value) {
        data.put(id, value);
        cache = null;
    }

    // Simulates an SQL SELECT operation
    public String select(int id) {
        return data.get(id);
    }

    // Simulates an SQL DELETE operation
    public void delete(int id) {
        data.remove(id);
        cache = null;
    }

    // Simulates an SQL UPDATE operation
    public void update(int id, String newValue) {
        data.put(id, newValue);
        cache = null;
    }

    // Simulates an SQL SELECT ALL operation
    public List<String> selectAll() {
        // Potential optimization: This operation can be optimized by caching the result and invalidating the cache on data modification.
        if (this.cache == null)
            cache = new ArrayList<>(data.values());

        return cache;
    }

    public long measureSelectAllTime() {
        long startTime = System.currentTimeMillis();
        selectAll();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}

class WebApplication {
    private Database database;

    public WebApplication(Database database) {
        this.database = database;
    }

    public void handleRequest(int id, String operation, String value) {
        switch (operation) {
            case "INSERT":
                database.insert(id, value);
                break;
            case "SELECT":
                System.out.println(database.select(id));
                break;
            case "DELETE":
                database.delete(id);
                break;
            case "UPDATE":
                database.update(id, value);
                break;
            case "SELECT_ALL":
                System.out.println(database.selectAll());
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Database database = new Database();
        WebApplication webApp = new WebApplication(database);

        // Simulate a series of requests
        webApp.handleRequest(1, "INSERT", "Data1");
        webApp.handleRequest(2, "INSERT", "Data2");
        webApp.handleRequest(1, "SELECT", null);
        webApp.handleRequest(2, "UPDATE", "UpdatedData2");
        webApp.handleRequest(2, "SELECT", null);
        webApp.handleRequest(1, "DELETE", null);

        for (int i = 0; i < 1000000; i++) {
            webApp.handleRequest(i, "INSERT", "Data" + i);
        }
 
        long timeTaken = database.measureSelectAllTime();
        System.out.println("Time taken by selectAll in milliseconds: " + timeTaken);
        timeTaken = database.measureSelectAllTime();
        System.out.println("Second Time taken by selectAll in milliseconds: " + timeTaken);
    }
}





/*selectAll method in Database class: This method creates a new list of all values in the database every time it is called. This can be optimized by caching the result and invalidating the cache whenever the data is modified (i.e., on insert, delete, or update operations). This would reduce the time complexity of the selectAll operation from O(n) to O(1) in cases where the data has not been modified since the last call. */









