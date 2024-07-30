package streamAPI.exercise4_collectors.scenario3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.AbstractMap;

import streamAPI.exercise4_collectors.scenario1.Pair;

public class MedicalManagementApp {
    
    public List<Patient> filterAndSortPatients(List<Patient> patients) {
        return patients.stream().filter(patient -> patient.getAge() < 18 && patient.getTreatmentCost() < 5000).sorted(Comparator.comparing(Patient::getTreatmentCost)).toList();
    }

    public Map<String, Double> groupPatientsByDiagnosis(List<Patient> patients) {
        return patients.stream().collect(Collectors.groupingBy(Patient::getDiagnosis, Collectors.averagingDouble(Patient::getTreatmentCost)));
    }

    public Optional<Patient> findMostExpensiveTreatment(List<Hospital> hospitals) {
        return hospitals.stream().flatMap(hospital -> hospital.getPatients().stream()).max(Comparator.comparing(Patient::getTreatmentCost));
    }

    // AI Copied - I did not know how to get city from hospital after flatMap() operation
    public Map<CityDiagnosisPair, Double> groupPatientsByCityAndDiagnosis(List<Hospital> hospitals) {
        return hospitals.stream().flatMap(hospital -> hospital.getPatients().stream().map(patient -> new AbstractMap.SimpleEntry<>(new CityDiagnosisPair(hospital.getCity(), patient.getDiagnosis()), patient.getTreatmentCost())))
        .collect(Collectors.groupingBy(AbstractMap.SimpleEntry<CityDiagnosisPair, Double>::getKey, Collectors.summingDouble(AbstractMap.SimpleEntry<CityDiagnosisPair, Double>::getValue)));
    }

    public Map<String, Double> calculateAverageTreatmentCostPerSpecialty(List<Doctor> doctors) {
        return doctors.stream().collect(Collectors.groupingBy(Doctor::getSpeciality, Collectors.averagingDouble(doctor -> doctor.getPatients().stream().mapToDouble(Patient::getTreatmentCost).sum())));
    }

    public List<Doctor> findDoctorsWithPatientOverAge(List<Doctor> doctors, int age) {
        return doctors.stream().filter(doctor -> doctor.getPatients().stream().anyMatch(patient -> patient.getAge() > age)).toList();
    }

    public Optional<String> findDoctorWithMostExpensivePatient(Map<String, List<Patient>> doctors) {
        return doctors.entrySet().stream().max(Comparator.comparing((Map.Entry<String, List<Patient>> es) -> es.getValue().stream().mapToDouble(Patient::getTreatmentCost).max().orElse(0.0))).map(Map.Entry::getKey);
    }

    public Map<Pair<String, String>, Double> groupPatientsByDiagnosisAndDoctor(Map<String, List<Patient>> doctors) {
        
        Map<Pair<String, String>, Double> result = new HashMap<>();

        for (Map.Entry<String, List<Patient>> entry : doctors.entrySet()) {
            for (Patient patient : entry.getValue()) {
                Pair<String, String> key = new Pair<String,String>(patient.getDiagnosis(), entry.getKey());
                result.put(key, result.getOrDefault(key, 0.0) + patient.getTreatmentCost());
            }
        }
        return result;
    }

    public List<String> findDoctorsWithPatientsOverAge(Map<String, List<Patient>> doctors, int age) {
        return doctors.entrySet().stream().sorted(Comparator.comparing((Map.Entry<String, List<Patient>> es ) -> es.getValue().stream().filter(patient -> patient.getAge() > age).count())).filter(es -> {
            return es.getValue().stream().anyMatch(patient -> patient.getAge() > age);
        }).map(Map.Entry::getKey).toList();
    }
}
