package oop.exercise19_bestPractises.scenario3;

public class Patient {
    private String name;
    private int patientID;
    private MedicalRecord medicalHistory;
    private HealthcareService healthcareService;
    private PatientCare patientCareService;

    public Patient(String name) {
        this.name = name;
        patientID = name.hashCode();
        medicalHistory = new MedicalRecord();
    }

    public MedicalRecord getMedicalHistory() {
        return medicalHistory;
    }
    public String getName() {
        return name;
    }
    public int getPatientID() {
        return patientID;
    }
    public HealthcareService getHealthcareService() {
        return healthcareService;
    }
    public PatientCare getPatientCareService() {
        return patientCareService;
    }

    public boolean scheduleAppointment(Doctor doctor, int date) {
        for (Appointment appointment : doctor.getAppointments()) {
            if (appointment.getDate() == date) {
                System.out.println("Doctor is unavailable at that time");
                return false;
            }
        }
        return doctor.scheduleAppointment(new Appointment(doctor, this, date));
    }

    public boolean cancelAppointment(Doctor doctor, int date) {
        for (Appointment appointment : doctor.getAppointments()) {
            if (appointment.getDate() == date) {
                doctor.cancelAppointment(appointment);
                return true;
            }
        }
        return false;
     }
}
