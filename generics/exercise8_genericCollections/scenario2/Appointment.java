package generics.exercise8_genericCollections.scenario2;

import java.time.LocalDateTime;
import java.util.List;

public class Appointment {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Integer> participants;

    public Appointment(LocalDateTime startTime, LocalDateTime endTime, List<Integer> participants) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.participants = participants;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public List<Integer> getParticipants() {
        return participants;
    }
}
