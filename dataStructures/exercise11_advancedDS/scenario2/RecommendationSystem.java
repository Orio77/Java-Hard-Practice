package dataStructures.exercise11_advancedDS.scenario2;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels; 

public class RecommendationSystem {
    private ArrayList<User> userBase;
    private ArrayList<Content> contentBase;
    private final int VIDEOSTORECOMMEND = 10;

    public RecommendationSystem() {
        userBase = new ArrayList<>();
        contentBase = new ArrayList<>();
    }

    public ArrayList<Content> getContentBase() {
        return contentBase;
    }

    public ArrayList<User> getUserBase() {
        return userBase;
    }

    public void simulateContentBase(int numberOfVideos) {
        for (int i = 0; i < numberOfVideos; i++) {
            int j = i + 1;
            contentBase.add(new Content("Video" + j));
        }
    }

    private ArrayList<Content> getNewContent(User user) {
        ArrayList<Content> unseenContent = new ArrayList<>();
        unseenContent.addAll(contentBase);
        BloomFilter<String> viewedContent = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 10000);

        for (Content content : user.getViewedContent()) {
            viewedContent.put(content.getName());
        }

        Iterator<Content> iterator = unseenContent.iterator();
        while (iterator.hasNext()) {
            Content nextVideo = iterator.next();
            if (viewedContent.mightContain(nextVideo.getName())) {
                iterator.remove();
            }
        }
        return unseenContent;
    }

    public List<Content> getRecommendations(User user) {
    
        HashSet<HashSet<Content>> candidates = getRecommendationCandidates(30, VIDEOSTORECOMMEND, user);
        HashSet<Content> recentlyWatched = getRecentlyWatched(user);
        HashSet<Content> bestRecommendations = candidates.iterator().next();
        int userHash = simulateHashing(recentlyWatched);
        int bestRecommendationsHash = bestRecommendations.hashCode();
        int minHash = Math.abs(userHash - bestRecommendationsHash);

        for (HashSet<Content> candidate : candidates) {
            if (Math.abs(userHash - simulateHashing(candidate)) < minHash) {
                bestRecommendations = candidate;
            }
        }

        List<Content> recommendationList = new ArrayList<>();

        Iterator<Content> iterator = bestRecommendations.iterator();
        for (int i = 0; i < VIDEOSTORECOMMEND && iterator.hasNext(); i++) {
            recommendationList.add(iterator.next());
        }

        return recommendationList;
    }

    public void showRecommendations(User user) {
        System.out.println("Your recommendations: ");
        System.out.println(getRecommendations(user));
    }

    private HashSet<HashSet<Content>> getRecommendationCandidates(int numberOfCandidates, int numberOfVideos, User user) {
        ArrayList<Content> unseenVideos = getNewContent(user);
        HashSet<HashSet<Content>> candidates = new HashSet<>();
        HashSet<Content> contentSet;
        Random random = new Random();

        for (int i = 0; i < numberOfCandidates; i++) {
            contentSet = new HashSet<>();
            for (int j = 0; j < numberOfVideos; j++) {
                contentSet.add(unseenVideos.get(random.nextInt(unseenVideos.size())));
            }
            candidates.add(contentSet);
        }
        return candidates;
    }

    private HashSet<Content> getRecentlyWatched(User user) {
        HashSet<Content> recentlyWatched = new HashSet<>();

        for (int i = 1; i <= VIDEOSTORECOMMEND; i++) {
            recentlyWatched.add(user.getViewedContent().get(user.getViewedContent().size() - i));
        }

        return recentlyWatched;
    }

    private int simulateHashing(HashSet<Content> set) {
        Iterator<Content> iterator = set.iterator();
        int minHash = 2147483647;
        while (iterator.hasNext()) {
            Content currentVideo = iterator.next();
            if (currentVideo.hashCode() < minHash)
                minHash = currentVideo.hashCode();
        }
        return minHash;
    }
}
