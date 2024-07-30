package oop.exercise19_bestPractises.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicalRecord {
    private List<String> record;

    public MedicalRecord() {
        record = new ArrayList<>();
    }
    public List<String> getRecord() {
        return Collections.unmodifiableList(record);
    }
}
