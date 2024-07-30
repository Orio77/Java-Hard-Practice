package oop.exercise19_bestPractises.scenario3.notifications;

import oop.exercise19_bestPractises.scenario3.Patient;

public class NotificationService {
    
    public void sendNotification(Notification notification, Patient patient) {
        notification.send(patient);
    }
}
