package streamAPI.exercise6_handlingNulls.scenario1;

public class Employee {
    private String name;
    private int hoursWorked;
    private int projectsCompleted;
    private double peerReviewScore;

    public Employee(String name, int hoursWorked, int projectsCompleted, double peerReviewScore) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.projectsCompleted = projectsCompleted;
        this.peerReviewScore = peerReviewScore;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
    public String getName() {
        return name;
    }
    public double getPeerReviewScore() {
        return peerReviewScore;
    }
    public int getProjectsCompleted() {
        return projectsCompleted;
    }
}
