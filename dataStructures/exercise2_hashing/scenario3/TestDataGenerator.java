package dataStructures.exercise2_hashing.scenario3;

import java.util.ArrayList;

public class TestDataGenerator {
    
    public ArrayList<Data> generateData(String testCase) {
        ArrayList<Data> dataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            dataList.add(new Data("data" + i + "_" + testCase));
        }

        return dataList;
    }
}
