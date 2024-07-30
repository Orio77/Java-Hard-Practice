package streamAPI.exercise20_usefulPrograms.scenario2;

public class Programmer {
    private String name;
    private int projectsCompleted;
    private String programmingLanguage;

    public String getName() {
        return name;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public int getProjectsCompleted() {
        return projectsCompleted;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
    public void setProjectsCompleted(int projectsCompleted) {
        this.projectsCompleted = projectsCompleted;
    }
}
