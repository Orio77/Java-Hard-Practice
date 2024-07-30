package dataStructures.exercise9_optimization.scenario3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Content {
    String id;
    String title;
    String body;

    Content(String id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    String getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getBody() {
        return body;
    }
}

class ContentManagementSystem {
    List<Content> contents;

    ContentManagementSystem() {
        contents = new ArrayList<>();
    }

    void addContent(Content content) {
        contents.add(content);
    }

    Content searchById(String id) {
        long startTime = System.nanoTime();
        for (Content content : contents) {
            if (content.getId().equals(id)) {
                long endTime = System.nanoTime();
                printExecutionTime(startTime, endTime, "searchById");
                return content;
            }
        }
        long endTime = System.nanoTime();
        printExecutionTime(startTime, endTime, "searchById");
        return null;
    }

    List<Content> searchByTitle(String title) {
        long startTime = System.nanoTime();
        List<Content> result = new ArrayList<>();
        for (Content content : contents) {
            if (content.getTitle().contains(title)) {
                result.add(content);
            }
        }
        long endTime = System.nanoTime();
        printExecutionTime(startTime, endTime, "searchByTitle");
        return result;
    }

    void printExecutionTime(long startTime, long endTime, String methodName) {
        long durationInNanoseconds = (endTime - startTime);
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;
        System.out.println("Execution time for " + methodName + " is " + durationInMilliseconds + " milliseconds");
    }

    void sortByTitle(List<Content> contents) {
        contents.sort(Comparator.comparing(Content::getTitle));
    }

    void sortByID(List<Content> contents) {
        contents.sort(Comparator.comparing(Content::getId));
    }

    Content searchByIDOptimized(String targetId) {
        long startTime = System.nanoTime();
        sortByID(contents);
        int left = 0;
        int right = contents.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midId = contents.get(mid).getId();

            // Check if targetId is present at the mid
            if (midId.equals(targetId)) {
                long endTime = System.nanoTime();
                printExecutionTime(startTime, endTime, "searchIDOptimized");
                return contents.get(mid);
            }

            // If targetId is greater, ignore left half
            if (midId.compareTo(targetId) < 0) {
                left = mid + 1;
            }

            // If targetId is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
        long endTime = System.nanoTime();
        printExecutionTime(startTime, endTime, "searchIDOptimized");

        // TargetId is not present
        return null;
    }

    Content searchByTitleOptimized(String title) {
        long startTime = System.nanoTime();
        sortByTitle(contents);
        int left = 0;
        int right = contents.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midTitle = contents.get(mid).getTitle();

            // Check if title is present at the mid
            if (midTitle.equals(title)) {
                long endTime = System.nanoTime();
                printExecutionTime(startTime, endTime, "searchIDOptimized");
                return contents.get(mid);
            }

            // If title is greater, ignore left half
            if (midTitle.compareTo(title) < 0) {
                left = mid + 1;
            }

            // If title is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
        long endTime = System.nanoTime();
        printExecutionTime(startTime, endTime, "searchTitleOptimized");

        // Title is not present
        return null;
    }

    void generateContents(int numContents) {
        Random rand = new Random();
        for (int i = 0; i < numContents; i++) {
            String id = String.valueOf(i);
            String title = "Title" + rand.nextInt(1000);
            String body = "Body" + rand.nextInt(1000);
            Content content = new Content(id, title, body);
            addContent(content);
        }
    }

    public List<Content> getContents() {
        return contents;
    }
    
    public static void main(String[] args) {
        ContentManagementSystem cms = new ContentManagementSystem();
        System.out.println("Unoptimized:");
        cms.generateContents(100000);
        cms.searchById("50000");
        cms.searchById("10134");
        cms.searchById("42435");
        cms.searchByTitle("Title500");
        cms.searchByTitle("Title123");
        cms.searchByTitle("Title434");
        System.out.println();
        System.out.println("Optimized:");
        cms.searchByTitleOptimized("Title500");
        cms.searchByTitleOptimized("Title123");
        cms.searchByTitleOptimized("Title434");
        cms.searchByIDOptimized("50000");
        cms.searchByIDOptimized("10134");
        cms.searchByIDOptimized("42435");
    }
}