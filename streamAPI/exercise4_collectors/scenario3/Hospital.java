package streamAPI.exercise4_collectors.scenario3;

import java.util.List;

public class Hospital {
    private int id;
    private String name;
    private String city;
    private List<Patient> patients;

    public String getCity() {
        return city;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Patient> getPatients() {
        return patients;
    }
}
