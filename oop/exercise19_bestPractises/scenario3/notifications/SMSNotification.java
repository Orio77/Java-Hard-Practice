package oop.exercise19_bestPractises.scenario3.notifications;

import oop.exercise19_bestPractises.scenario3.Patient;

public class SMSNotification extends Notification{
    

    @Override
    public void send(Patient patient) {
        System.out.println("Sending an email to " + patient.getName());
    }


}
