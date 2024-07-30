package streamAPI.exercise13_optionals.scenario1;

public class CSVObject {
    private int camaignId;
    private String region;
    private int age;
    private String gender;
    private int response;

    public CSVObject(int camaignId, String region, int age, String gender, int response) {
        this.camaignId = camaignId;
        this.region = region;
        this.age = age;
        this.gender = gender;
        this.response = response;
    }

    public int getAge() {
        return age;
    }
    public int getCamaignId() {
        return camaignId;
    }
    public String getGender() {
        return gender;
    }
    public String getRegion() {
        return region;
    }
    public int getResponse() {
        return response;
    }
}
