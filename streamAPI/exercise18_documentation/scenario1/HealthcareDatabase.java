package streamAPI.exercise18_documentation.scenario1;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HealthcareDatabase {
    private List<PatientRecord> records;

    public List<PatientRecord> standardizeRecords(List<String> data) {
        return data.stream().map(str -> {
            PatientRecord record = new PatientRecord(null, 0, 0, null);
            String[] parts = str.split(",");
            for (String part : parts) {
                if (Character.isDigit(part.charAt(0))) {
                    if (part.length() <= 2 && part.length() > 0) {
                        record.setAge(Integer.parseInt(part));
                    }
                    else if (part.length() == 6) {
                        record.setId(Integer.parseInt(part));
                    }
                }
                else if (Character.isLetter(part.charAt(0))) {
                    if (part.contains(" ")) {
                        record.setCondition(part);
                    }
                    else
                        record.setName(part);
                }
            }
            return record;
        }).toList();
    }

    public Map<String, List<PatientRecord>> groupRecordsByCondition() {
        return records.stream().collect(Collectors.groupingBy(PatientRecord::getCondition));
    }

    // AI Helped
    public List<PatientRecord> getAdultPatients() {
        return records.stream().filter(record -> {
            String ageStr = Optional.ofNullable(Integer.toString(record.getAge())).orElse("0");

            try {
                int age = Integer.parseInt(ageStr);
                return age >= 18;
            } catch (NumberFormatException e) {
                return false;
            }
        }).toList();
    }

    public List<PatientRecord> optimizeProcessing() {
        return records.parallelStream().filter(p -> p.getAge() > 18 && p.getCondition().matches("Diabetes")).toList();
    }

    public long measureTime(Runnable method) {
        
        long start = System.nanoTime();
        method.run();
        long end = System.nanoTime();

        return end - start;
    }
}
