package dataStructures.exercise2_hashing.scenario3;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private HashMap<Integer, String> database;

    public Database() {
        database = new HashMap<>();
    }

    public void addData(Data data) {
        database.put(data.getDataID(), data.getContents());
    }

    public void removeData(Data data) {
        database.remove(data.getDataID());
    }

    public void addAllData(ArrayList<Data> dataList) {
        for (Data data : dataList) {
            database.put(data.getDataID(), data.getContents());
        }
    }

    public void operationOnData(ArrayList<Data> dataSet) {
        for (Data data : dataSet) {
            data.setRecentlyUsed(true);
        }
    }

    public HashMap<Integer, String> getDatabase() {
        return database;
    }

    public void setDatabase(HashMap<Integer, String> database) {
        this.database = database;
    }
}
