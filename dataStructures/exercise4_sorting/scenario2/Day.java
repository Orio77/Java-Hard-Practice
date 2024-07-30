package dataStructures.exercise4_sorting.scenario2;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Day {
    private HashMap<Integer, Session> allSessions;
    private PriorityQueue<Session> morningSessions;
    private PriorityQueue<Session> noonSessions;
    private PriorityQueue<Session> afterNoonSessions;
    private PriorityQueue<Session> eveningSessions;

    public Day() {
        allSessions = new HashMap<>();
        morningSessions = new PriorityQueue<>(1);
        noonSessions = new PriorityQueue<>(1);
        afterNoonSessions = new PriorityQueue<>(1);
        eveningSessions = new PriorityQueue<>(1);
    }

    public void addSession(Session session, TimeOfTheDay timeOfTheDay) {

        allSessions.put(session.getSessionID(), session);

        switch(timeOfTheDay) {
            case MORNING:
                morningSessions.add(session);
                break;
            case NOON:
                noonSessions.add(session);
                break;
            case AFTERNOON:
                afterNoonSessions.add(session);
                break;
            case EVENING:
                eveningSessions.add(session);
                break;
            default:
                allSessions.remove(session.getSessionID());
                return;
        }
    }

    public int getPriority(Session session, TimeOfTheDay timeOfTheDay) {

        Session conflictedSession = getConflictSession(timeOfTheDay); // Already planned session
        int priorityCount1 = 0;
        int priorityCount2 = 0;

        for (Participant participant : session.getParticipants()) {
            if (participant.getPreference().equals(timeOfTheDay)) {
                priorityCount1++;
            }
        }

        for (Participant participant : conflictedSession.getParticipants()) {
            if (participant.getPreference().equals(timeOfTheDay)) {
                priorityCount2++;
            }
        }

        if (priorityCount1 > priorityCount2)
            return 1; // New session is of more priority
        else
            return 2; // Already planned session is of more priority
    }

    public void resolveConflict(Session session, TimeOfTheDay timeOfTheDay) {
        int priority = getPriority(session, timeOfTheDay);

        if (priority == 2) {
            addSession(session, TimeOfTheDay.returnRandom());
        }
        if (priority == 1) {
            getConflictSession(timeOfTheDay);
        }
    }

    public Session getConflictSession(TimeOfTheDay timeOfTheDay) {
        switch(timeOfTheDay) {
            case MORNING:
                return morningSessions.peek();
            case NOON:
                return noonSessions.peek();
            case AFTERNOON:
                return afterNoonSessions.peek();
            case EVENING:
                return eveningSessions.peek();
            default:
                return null;
        }
    }
}
