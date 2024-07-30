package oop.exercise19_bestPractises.scenario3;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private int date;

    public Appointment(Doctor doctor, Patient patient, int date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public int getDate() {
        return date;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }
}
