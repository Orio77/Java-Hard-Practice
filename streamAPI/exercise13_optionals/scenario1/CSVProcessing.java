package streamAPI.exercise13_optionals.scenario1;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVProcessing {
    private List<CSVObject> objects;
    private List<CSVObject2> objects2;

    public long getNumberOfResponses() {

        return objects.stream().filter(o -> Optional.ofNullable(o.getRegion()).map(region -> region.matches("North America")).orElse(false)).count();
    }

    public Map<String, Integer> groupGenderResponseRate() {
        
        return objects.stream().collect(Collectors.groupingBy(CSVObject::getGender, Collectors.summingInt(CSVObject::getResponse)));
    }

    public Map<Integer, Integer> groupAgeResponseRate() {
        
        return objects.stream().collect(Collectors.groupingBy(CSVObject::getAge, Collectors.summingInt(CSVObject::getResponse)));
    }

    // AI Helped
    public Map<String, Double> getPositiveResponseRate() {
        Map<String, Long> totalResponses = objects.stream().collect(Collectors.groupingBy(CSVObject::getRegion, Collectors.counting()));

        Map<String, Integer> positiveResponses = objects.stream().collect(Collectors.groupingBy(CSVObject::getRegion, Collectors.summingInt(o -> o.getResponse() > 5 ? 1 : 0)));

        return totalResponses.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> positiveResponses.get(e.getKey()) / (double) e.getValue()));
    }

    public List<Campaign> getCampaigns() {

        Map<Integer, CSVObject2> map = objects2.stream().collect(Collectors.toMap(CSVObject2::getCamaignId, Function.identity()));

        return objects.stream().filter(obj -> map.containsKey(obj.getCamaignId())).map(obj -> {
            CSVObject2 obj2 = map.get(obj.getCamaignId());
            return new Campaign(obj.getCamaignId(), obj.getRegion(), obj.getAge(), obj.getGender(), obj.getResponse(), obj2.getStartDate(), obj2.getEndDate(), obj2.getTargetAge(), obj2.getTargetGender());
        }).collect(Collectors.toList());
    }

    public Map<Integer, List<Campaign>> groupByCampaignID() {
        List<Campaign> campaigns = getCampaigns();

        return campaigns.stream().collect(Collectors.groupingBy(Campaign::getCamaignId));
    }

    public Map<String, List<Campaign>> groupByCampaignTargetGender() {
        List<Campaign> campaigns = getCampaigns();

        return campaigns.stream().collect(Collectors.groupingBy(Campaign::getTargetGender));
    }

    public Map<Integer, List<Campaign>> groupByCampaignTargetAge() {
        List<Campaign> campaigns = getCampaigns();

        return campaigns.stream().collect(Collectors.groupingBy(Campaign::getTargetAge));
    }

    public double getAverageResponse(Map<Object, List<Campaign>> campaigns) {
        return campaigns.values().stream().flatMap(List::stream).mapToInt(o -> o.getResponse()).average().orElse(0.0);
    }

    public double getTotalResponses(Map<Object, List<Campaign>> campaigns) {
        return campaigns.values().stream().flatMap(List::stream).mapToInt(o -> o.getResponse()).count();
    }

    public double getTotalPositiveResponses(Map<Object, List<Campaign>> campaigns) {
        return campaigns.values().stream().flatMap(List::stream).filter(o -> o.getResponse() > 5).count();
    }

    public double getPositiveResponseRate(Map<Object, List<Campaign>> campaigns) {
        return getTotalPositiveResponses(campaigns) / getTotalResponses(campaigns);
    }
}
