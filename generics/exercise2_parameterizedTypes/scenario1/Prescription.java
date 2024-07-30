package generics.exercise2_parameterizedTypes.scenario1;

public class Prescription<T> {
    private T medication;
    private double dosage;
    private String patientInformation;

    public Prescription(T medication) {
        this.medication = medication;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }
    public double getDosage() {
        return dosage;
    }

    public void setMedicationDetails(T medication) {
        this.medication = medication;
    }

    public void setPatientInformaton(String patientInformation) {
        this.patientInformation = patientInformation;
    }

    // AI helped, I used 'instanceof', silly me
    public boolean checkMedicationType(Object medication) {
        return medication.getClass().equals(this.medication.getClass());
    }

    public String getPatientInformation() {
        return patientInformation;
    }
    public T getMedication() {
        return medication;
    }
}
