package oop.exercise19_bestPractises.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctor implements Medication, Physiotherapy, Surgery, HealthPlan{
    private String name;
    private int doctorID;
    private List<Appointment> appointments;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        doctorID = name.hashCode();
        appointments = new ArrayList<>();
        this.specialization = specialization;
    }

    public boolean scheduleAppointment(Appointment appointment) {
        return appointments.add(appointment);
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    @Override
    public void performProcedure() {
        Medication.super.performProcedure();
    }

    @Override
    public void createHealthPlan(Patient patient) {
        System.out.println("Creating a health plan for " + patient.getName());
    }

    public List<Appointment> getAppointments() {
        return Collections.unmodifiableList(appointments);
    }
    public int getDoctorID() {
        return doctorID;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }
}
