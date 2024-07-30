package oop.exercise19_bestPractises.scenario3;

import java.util.List;

public class TelemedicineSession {
    private List<Appointment> sessions;
    
    public void scheduleSession(Patient patient, Doctor doctor, int date) {
        sessions.add(new Appointment(doctor, patient, date));
    }

    public void conductSession(Appointment appointment) {
        System.out.println("Conducting a session between doctor " + appointment.getDoctor().getName() + " and patient" + appointment.getPatient().getName());
    }
}
