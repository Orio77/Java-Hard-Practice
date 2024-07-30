package generics.exercise11_genericsInStreams.scenario1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessor<T> {
    
    public List<T> processData(Stream<T> dataStream, Predicate<T> predicate) {
        return dataStream.collect(Collectors.toList());
    }

    public Stream<UserInteraction> filterByTime(Stream<UserInteraction> interactionStream, int time) {
        return interactionStream.filter(it -> it.getTime() == time);
    }

    public Stream<UserInteraction> filterByLocation(Stream<UserInteraction> interactionStream, Location location) {
        return interactionStream.filter(it -> it.getLocation().equals(location));
    }

    public Stream<Device> filterByLocation(Stream<UserInteraction> interactionStream) {
        return interactionStream.map(it -> it.getDevice());
    }

    public Insights extractInsights(List<UserInteraction> interactions) {
        Insights insights = new Insights(0, null, null);

        Map<Device, Integer> deviceCount = new HashMap<>();
        Map<Location, Integer> locationCount = new HashMap<>();
        Map<Integer, Integer> timeCount = new HashMap<>();

        int currentTime = 0;
        Device currentDevice = null;
        Location currentLocation = null;


        for (UserInteraction interaction : interactions) {

            currentTime = interaction.getTime();
            currentDevice = interaction.getDevice();
            currentLocation = interaction.getLocation();


            if (deviceCount.containsKey(currentDevice)) {
                deviceCount.put(currentDevice, deviceCount.get(currentDevice) + 1);
            }
            else {
                deviceCount.put(currentDevice, 1);
            }

            if (locationCount.containsKey(currentLocation)) {
                locationCount.put(currentLocation, locationCount.get(currentLocation) + 1);
            }
            else {
                locationCount.put(currentLocation, 1);
            }

            if (timeCount.containsKey(currentTime)) {
                timeCount.put(currentTime, timeCount.get(currentTime) + 1);
            }
            else {
                timeCount.put(currentTime, 1);
            }

        }
        
        Device mostDevice = deviceCount.keySet().iterator().next();
        Location mostLocation = locationCount.keySet().iterator().next();
        int mostTime = timeCount.keySet().iterator().next();

        for (int i = 0; i < deviceCount.size(); i++) {
            Iterator<Device> iterator = deviceCount.keySet().iterator();

            Device nextDevice = iterator.next();

            if (deviceCount.get(nextDevice) > deviceCount.get(mostDevice)) {
                mostDevice = nextDevice;
            }
        }

        for (int i = 0; i < locationCount.size(); i++) {
            Iterator<Location> iterator = locationCount.keySet().iterator();

            Location nextLocation = iterator.next();

            if (locationCount.get(nextLocation) > locationCount.get(mostLocation)) {
                mostLocation = nextLocation;
            }
        }

        for (int i = 0; i < timeCount.size(); i++) {
            Iterator<Integer> iterator = timeCount.keySet().iterator();

            Integer nextTime = iterator.next();

            if (timeCount.get(nextTime) > timeCount.get(mostTime)) {
                mostTime = nextTime;
            }
        }

        insights.setMostActiveTime(mostTime);
        insights.setMostFrequentLocation(mostLocation);
        insights.setMostUsedDevice(mostDevice);

        return insights;
    }
}
