package streamAPI.exercise13_optionals.scenario1;

import java.time.LocalDateTime;

public class CSVObject2 {
    private int camaignId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int targetAge;
    private String targetGender;

    public CSVObject2(int camaignId, LocalDateTime startDate, LocalDateTime endDate, int targetAge,
            String targetGender) {
        this.camaignId = camaignId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.targetAge = targetAge;
        this.targetGender = targetGender;
    }
    
    public int getCamaignId() {
        return camaignId;
    }
    public void setCamaignId(int camaignId) {
        this.camaignId = camaignId;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public int getTargetAge() {
        return targetAge;
    }
    public void setTargetAge(int targetAge) {
        this.targetAge = targetAge;
    }
    public String getTargetGender() {
        return targetGender;
    }
    public void setTargetGender(String targetGender) {
        this.targetGender = targetGender;
    }

    
}
