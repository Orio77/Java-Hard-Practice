package dataStructures.exercise9_optimization.scenario1;

import java.util.*;

public class Optimization_1 {
    private Map<Integer, String> dataMap;
    private List<String> dataList;

    public Optimization_1() {
        dataMap = new HashMap<>();
        dataList = new ArrayList<>();
    }

    public void addData(int key, String value) {
        dataMap.put(key, value);
        dataList.add(value);
    }

    public void addAllData(Map<Integer, String> data) {
        dataMap.putAll(data);
    }

    public String getData(int key) {
        return dataMap.get(key);
    }

    public List<String> getAllData() {
        return new ArrayList<>(dataList);
    }

    public List<String> getAllDataOptimized() {
        return Collections.unmodifiableList(dataList);
    }

    public static void main(String[] args) {
        Optimization_1 example = new Optimization_1();
        for (int i = 0; i < 1000000; i++) {
            example.addData(i, "Data " + i);
        }

        long startTime = System.currentTimeMillis();
        // for (int i = 0; i < 1000000; i++) {
        //     example.getData(i);
        // }
        example.getAllDataOptimized();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for retrieval: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        example.getAllDataOptimized();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for getting all data: " + (endTime - startTime) + "ms");
    }
}
