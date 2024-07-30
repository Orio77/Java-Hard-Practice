package oop.exercise9_enums.scenario2;

import java.util.Random;

public class TrafficLightController {
    private TrafficLight light;
    
    public void start() {
        Random random = new Random();

        while (true) {
            if (light.getSensorTriggered())
                light.setCurrent("green");
            if (random.nextInt(10) % 2 == 0)
                light.triggerSensor();
            
            System.out.println("Current Light: " + light.getCurrent());
            System.out.println("Seconds left: " + light.getDuration());
            try {
                Thread.sleep(light.getDuration() * 10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
}
