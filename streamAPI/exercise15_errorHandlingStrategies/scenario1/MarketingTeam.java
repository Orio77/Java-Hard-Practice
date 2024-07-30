package streamAPI.exercise15_errorHandlingStrategies.scenario1;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class MarketingTeam {
    private List<CampaignResponse> campaigns;
    private Stack<Error> errorLog;

    public Map<String, Long> processCampaignData() {
        return campaigns.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(CampaignResponse::getRegion, Collectors.counting()));
    }

    public Map<String, Long> processCampaignDataOptimized() {
        return campaigns.parallelStream().filter(Objects::nonNull).collect(Collectors.groupingBy(CampaignResponse::getRegion, Collectors.counting()));
    }

    // AI Helped - I tried to use Method class of java.lang.reflect
    public long measureTime(Runnable method) {
        long start = System.nanoTime();
        method.run();
        long end = System.nanoTime();
        return end - start;
    }
    
    public Map<String, List<CampaignResponse>> processCampaignDataAdvanced() {
        Map<String, List<CampaignResponse>> groupedCampaigns = campaigns.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(c -> {
            try {
                return c.getRegion();
            } catch (Error e) {
                errorLog.push(e);
                return "Null";
            }
        }));

        groupedCampaigns.entrySet().stream().map(e -> (long) e.getValue().size()).forEach(System.out::println);

        return groupedCampaigns;
    }
}
