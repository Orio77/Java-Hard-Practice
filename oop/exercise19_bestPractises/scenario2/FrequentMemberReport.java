package oop.exercise19_bestPractises.scenario2;

public class FrequentMemberReport extends Report {

    @Override
    public void generateReport(Member member) {
        System.out.println(member.getName() + " is a frequent member");
    }
}
