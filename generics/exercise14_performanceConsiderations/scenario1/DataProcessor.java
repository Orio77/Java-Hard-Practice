package generics.exercise14.scenario1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataProcessor<T> {
    private List<T> data;

    public DataProcessor(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    public Integer count(T element) {
        Integer count = 0;
        for (T item : data) {
            if (item.equals(element)) {
                count = Integer.valueOf(count.intValue() + 1);
            }
        }
        return count;
    }

    public List<T> filter(T element) {
        List<T> result = new ArrayList<>();
        for (T item : data) {
            if (!item.equals(element)) {
                result.add(item);
            }
        }
        return new ArrayList<>(result);
    }
}

class Main {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(i);
        }

        DataProcessor<Integer> processor = new DataProcessor<>(data);

        while (true) {
            Integer count = processor.count(500000);
            List<Integer> filteredData = processor.filter(500000);

            System.out.println("Count: " + count);
            System.out.println("Filtered data size: " + filteredData.size());

            try {
                // Sleep for 5 seconds
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}