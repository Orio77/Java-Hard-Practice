package generics.exercise8_genericCollections.scenario2;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MeetingsDemo {
    public static void main(String[] args) {
        AppointmentManager<Appointment> manager = new AppointmentManager<>();
        Appointment appointment1 = new Appointment(LocalDateTime.of(2024, 02, 03, 13, 0, 0), LocalDateTime.of(2024, 02, 03, 15, 0, 0), new ArrayList<>());

        manager.addAppointment(appointment1);
        System.out.println(manager.getAppointmentsSortedByEndTime());

    }
}
