package generics.exercise3_wildcards.scenario1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SensorData<T> {
    private List<T> dataList;

    public SensorData() {
        dataList = new ArrayList<>();
    }
    
    public boolean addData(T data) {
        return dataList.add(data);
    }

    

    public T getData(int index) {
        return dataList.get(index);
    }

    public List<T> getDataList() {
        return Collections.unmodifiableList(dataList);
    }
}
