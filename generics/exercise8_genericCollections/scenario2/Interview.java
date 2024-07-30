package generics.exercise8_genericCollections.scenario2;

import java.time.LocalDateTime;
import java.util.List;

public class Interview extends Appointment {

    public Interview(LocalDateTime startTime, LocalDateTime endTime, List<Integer> participants) {
        super(startTime, endTime, participants);
    }
    
}
