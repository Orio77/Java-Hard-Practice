package generics.exercise8_genericCollections.scenario2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AppointmentManager<T extends Appointment> {
    private Queue<T> appointments;

    public AppointmentManager() {
        appointments = new PriorityQueue<>(Comparator.comparing(ap -> ap.getStartTime()));
    }
    
    public boolean addAppointment(T appointment) {
        if (appointment == null) {
            return false;
        }
        return appointments.add(appointment);
    }

    public List<T> getAppointmentsSortedByEndTime() {
        List<T> revSorted = new ArrayList<>(appointments);

        revSorted.sort(Comparator.comparing(ap -> ap.getEndTime()));

        return revSorted;
    }

    public List<T> queryAppointments(LocalDateTime start, LocalDateTime end) {
        List<T> desiredAppointments = new ArrayList<>();

        for (T appointment : appointments) {
            if (appointment.getStartTime().isAfter(start) && appointment.getEndTime().isBefore(end)) {
                desiredAppointments.add(appointment);
            }
        }

        return desiredAppointments;
    }
}
