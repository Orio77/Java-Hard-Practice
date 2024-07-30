package dataStructures.exercise4_sorting.scenario2;

import java.util.ArrayList;

public class Session {
    private int sessionID;
    private TimeOfTheDay timeOfTheDay;
    private ArrayList<Participant> participants;

    public Session(int sessionID, TimeOfTheDay timeOfTheDay) {
        this.sessionID = sessionID;
        this.timeOfTheDay = timeOfTheDay;
        participants = new ArrayList<>();
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public TimeOfTheDay getTimeOfTheDay() {
        return timeOfTheDay;
    }

    public void setTimeOfTheDay(TimeOfTheDay timeOfTheDay) {
        this.timeOfTheDay = timeOfTheDay;
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void addParticipants(ArrayList<Participant> participants) {
        this.participants.addAll(participants);
    }

    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }
}
