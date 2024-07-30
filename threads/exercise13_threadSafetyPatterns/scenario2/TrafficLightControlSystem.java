package threads.exercise13_threadSafetyPatterns.scenario2;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class TrafficLight {
    private String id;
    private String color;
    private AtomicInteger trafficCount;
    private String pattern;
    

    public String getColor() {
        return color;
    }
    public String getId() {
        return id;
    }
    public String getPattern() {
        return pattern;
    }
    public AtomicInteger getTrafficCount() {
        return trafficCount;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    public void setTrafficCount(AtomicInteger trafficCount) {
        this.trafficCount = trafficCount;
    }
}

class TrafficLightControlSystem {
    private List<TrafficLight> trafficLights;
    private ExecutorService executorService;
    

    public synchronized void synchronizeTrafficLights() {
        AtomicBoolean greenFound = new AtomicBoolean(false);
        executorService.submit(() -> {
            for (TrafficLight trafficLight : trafficLights) {
                if (trafficLight.getColor().matches("green")) {
                    greenFound.set(true);
                    continue;
                }
                if (greenFound.get() && trafficLight.getColor().matches("green")) {
                    trafficLight.setColor("red");
                }
            }
            if (!greenFound.get()) {
                trafficLights.iterator().next().setColor("green");
            }
        });
    }

    public synchronized void adjustTrafficLightPattern(TrafficLight trafficLight, String pattern) {
        trafficLight.setPattern(pattern);
    }

    public synchronized void sendSignal(TrafficLight sender, TrafficLight receiver, String signal) {
        // I assume signal means orange light

        switch (signal) {
            case "wasGreen":
                sender.setColor("red");
                receiver.setColor("green");
                break;
            case "wasRed":
                sender.setColor("green");
                receiver.setColor("red");
                break;
            default:
                break;
        }
    }

    public synchronized String receiveSignal(TrafficLight receiver) {
        switch (receiver.getColor()) {
            case "green":
                return "wasGreen";
            case "red":
                return "wasRed";
            default:
                return new String();
        }
    }

    public void incrementTrafficCount(TrafficLight trafficLight) {
        trafficLight.getTrafficCount().incrementAndGet();
    }

    public int getTrafficCount(TrafficLight trafficLight) {
        return trafficLight.getTrafficCount().get();
    }

    public void startTrafficLightSystem() {
        for (TrafficLight trafficLight : trafficLights) {
            executorService.submit(() -> {
                trafficLight.setColor("red");
            });
        }
        executorService.shutdown();
        synchronizeTrafficLights();
    }

    public void stopTrafficLightSystem() {
        for (TrafficLight trafficLight : trafficLights) {
            executorService.submit(() -> {
                trafficLight.setColor("orangeOff");
            });
        }
        executorService.shutdown();
    }

    public void restartTrafficLightSystem() {
        stopTrafficLightSystem();
        startTrafficLightSystem();
    }
}
