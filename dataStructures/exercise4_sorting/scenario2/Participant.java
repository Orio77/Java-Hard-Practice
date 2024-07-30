package dataStructures.exercise4_sorting.scenario2;

public class Participant {
    private int participantID;
    private TimeOfTheDay preference;

    public Participant(int participantID, TimeOfTheDay preference) {
        this.participantID = participantID;
        this.preference = preference;
    }

    public int getParticipantID() {
        return participantID;
    }
    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }
    public TimeOfTheDay getPreference() {
        return preference;
    }
    public void setPreference(TimeOfTheDay preference) {
        this.preference = preference;
    }
}
