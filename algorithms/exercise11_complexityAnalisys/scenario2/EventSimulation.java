package algorithms.exercise11_complexityAnalisys.scenario2;

import java.util.*;

public class EventSimulation {
    private PriorityQueue<Event> eventQueue;
    private HashMap<Event, String> events;

    public EventSimulation() {
        eventQueue = new PriorityQueue<>(Comparator.comparing(Event::getTimestamp));
        events = new HashMap<>();
    }

    public void addEvent(Event event) {
        eventQueue.add(event);
    }

    public void runSimulation() {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            processEvent(event);
        }
    }

    private void processEvent(Event event) {
        // Process the event based on its type
        switch (event.getType()) {
            case "A":
                // Process type A event
                System.out.println("Processing type A event at " + event.getTimestamp());
                break;
            case "B":
                // Process type B event
                System.out.println("Processing type B event at " + event.getTimestamp());
                break;
            // Other event types...
        }
    }

    @SuppressWarnings("unused")
    private void processEventOptimized(Event event) {

        String type = events.get(event);

        System.out.println("Processing type " + type +  " event at " + event.getTimestamp());
    }
}

class Event {
    private String type;
    private long timestamp;

    public Event(String type, long timestamp) {
        this.timestamp = timestamp;
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public String getType() {
        return type;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public void setType(String type) {
        this.type = type;
    }
}
