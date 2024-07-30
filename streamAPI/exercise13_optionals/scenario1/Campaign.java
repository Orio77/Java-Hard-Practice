package streamAPI.exercise13_optionals.scenario1;

import java.time.LocalDateTime;

public class Campaign {
    private int camaignId;
    private String region;
    private int age;
    private String gender;
    private int response;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int targetAge;
    private String targetGender;

    public Campaign(int camaignId, String region, int age, String gender, int response, LocalDateTime startDate,
            LocalDateTime endDate, int targetAge, String targetGender) {
        this.camaignId = camaignId;
        this.region = region;
        this.age = age;
        this.gender = gender;
        this.response = response;
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
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getResponse() {
        return response;
    }
    public void setResponse(int response) {
        this.response = response;
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
