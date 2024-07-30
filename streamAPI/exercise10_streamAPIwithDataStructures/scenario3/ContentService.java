package streamAPI.exercise10_streamAPIwithDataStructures.scenario3;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContentService {
    public List<String> findTopViewedContent(List<User> users, int topN) {
        return users.stream().flatMap(user -> user.getViewedContent().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.<ViewedContent, Long>comparingByValue().thenComparing((Map.Entry<ViewedContent, Long> es) -> es.getKey().getTimestamp())).limit(topN).map(es -> es.getKey().getContentId()).toList();
    }

    public List<String> findRecentViewedContent(List<User> users, int days) {
        return users.stream().flatMap(user -> user.getViewedContent().stream()).filter(content -> LocalDateTime.now().getDayOfYear() - days < content.getTimestamp().getDayOfYear()).map(ViewedContent::getContentId).toList();
    }

    public Map<String, List<String>> groupByGenre(List<User> users) {
        return users.stream().flatMap(user -> user.getViewedContent().stream()).collect(Collectors.groupingBy(ViewedContent::getGenre, Collectors.mapping(ViewedContent::getContentId, Collectors.toList())));
    }

    public Map<String, Long> countByGenre(List<User> users) {
        return users.stream().flatMap(user -> user.getViewedContent().stream()).collect(Collectors.groupingBy(ViewedContent::getGenre, Collectors.counting()));
    }

    public List<String> findTopViewedContentParallel(List<User> users, int topN) {
        return users.parallelStream().flatMap(user -> user.getViewedContent().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.<ViewedContent, Long>comparingByValue().thenComparing((Map.Entry<ViewedContent, Long> es) -> es.getKey().getTimestamp())).limit(topN).map(es -> es.getKey().getContentId()).toList();
    }

    public List<String> findRecentViewedContentParallel(List<User> users, int days) {
        return users.parallelStream().flatMap(user -> user.getViewedContent().stream()).filter(content -> LocalDateTime.now().getDayOfYear() - days < content.getTimestamp().getDayOfYear()).map(ViewedContent::getContentId).toList();
    }

    public List<String> findTopRatedContent(List<User> users, int topN) {
        return users.stream().flatMap(user -> user.getViewedContent().stream()).sorted(Comparator.comparing(ViewedContent::getRating).thenComparing(ViewedContent::getTimestamp)).limit(topN).map(ViewedContent::getContentId).toList();
    }

    public List<String> findTopRatedContentByGenre(List<User> users, String genre, int topN) {
        return users.stream().flatMap(user -> user.getViewedContent().stream()).filter(content -> content.getGenre().matches(genre)).sorted(Comparator.comparing(ViewedContent::getRating).thenComparing(ViewedContent::getTimestamp)).limit(topN).map(ViewedContent::getContentId).toList();
    }

    public List<String> findUserTopRatedContent(List<User> users, String userId, int topN) {
        
        Optional<User> user = users.stream().filter(u -> u.getUserId().matches(userId)).findFirst();
        User validUser = null;

        if (user.isEmpty()) {
            return null;
        }
        else {
            validUser = user.get();
        }

        return validUser.getViewedContent().stream().sorted(Comparator.comparing(ViewedContent::getRating).thenComparing(ViewedContent::getTimestamp)).limit(topN).map(ViewedContent::getContentId).toList();
    }
}
