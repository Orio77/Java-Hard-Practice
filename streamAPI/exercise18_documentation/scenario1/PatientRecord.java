package streamAPI.exercise18_documentation.scenario1;

public class PatientRecord {
    private String name;
    private int age;
    private int id;
    private String condition;

    public PatientRecord(String name, int age, int id, String condition) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.condition = condition;
    }

    public int getAge() {
        return age;
    }
    public String getCondition() {
        return condition;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
