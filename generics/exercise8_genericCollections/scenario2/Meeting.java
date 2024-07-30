package generics.exercise8_genericCollections.scenario2;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting extends Appointment {

    public Meeting(LocalDateTime startTime, LocalDateTime endTime, List<Integer> participants) {
        super(startTime, endTime, participants);
    }
    
}
