package oop.exercise19_bestPractises.scenario2;

public class EmailNotification implements NotificationService{
    
    @Override
    public void sendNotification() {
        System.out.println("You got an email");
    }
}
