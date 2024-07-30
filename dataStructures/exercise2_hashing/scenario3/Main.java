package dataStructures.exercise2_hashing.scenario3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        TestDataGenerator generator = new TestDataGenerator();

        ArrayList<Data> dataSet1 = generator.generateData("1");
        ArrayList<Data> dataSet2 = generator.generateData("2");
        ArrayList<Data> dataSet3 = generator.generateData("3");

        database.addAllData(dataSet1);
        database.addAllData(dataSet2);
        database.addAllData(dataSet3);

        
    }
}
