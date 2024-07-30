package streamAPI.exercise4_collectors.scenario3;

import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private String speciality;
    private List<Patient> patients;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Patient> getPatients() {
        return patients;
    }
    public String getSpeciality() {
        return speciality;
    }
}
