package oop.exercise19_bestPractises.scenario3;

import java.util.ArrayList;
import java.util.List;

public class HealthcareAdministrator implements PatientManagement, DoctorManagement{
    private List<Doctor> docs;
    private List<Patient> patients;

    public HealthcareAdministrator() {
        docs = new ArrayList<>();
        patients = new ArrayList<>();
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        return docs.add(doctor);
    }

    @Override
    public boolean removeDoctor(Doctor doctor) {
        return docs.remove(doctor);
    }

    @Override
    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    @Override
    public boolean removePatient(Patient patient) {
        return patients.remove(patient);
    }
    
}
