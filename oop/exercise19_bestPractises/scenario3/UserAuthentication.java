package oop.exercise19_bestPractises.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserAuthentication {
    private List<Patient> registeredPatients;
    private List<Patient> loggedInPatients;

    public UserAuthentication() {
        registeredPatients = new ArrayList<>();
        loggedInPatients = new ArrayList<>();
    }

    public boolean login(Patient patient, String login) {
        if (patient.getPatientID() == Integer.parseInt(login)) {
            loggedInPatients.add(patient);
            return true;
        }
        return false;
    }

    public boolean logout(Patient patient) {
        for (Patient loggedInPatient : loggedInPatients) {
            if (loggedInPatient == patient) {
                loggedInPatients.remove(loggedInPatient);
                return true;
            }
        }
        return false;
    }

    public boolean verifyCredentials(String name) {
        for (Patient patient : loggedInPatients) {
            if (patient.getName().matches(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Patient> getLoggedInPatients() {
        return Collections.unmodifiableList(loggedInPatients);
    }
    public List<Patient> getRegisteredPatients() {
        return Collections.unmodifiableList(registeredPatients);
    }
}
