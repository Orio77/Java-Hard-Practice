package streamAPI.exercise10_streamAPIwithDataStructures.scenario2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OnlineNewspaper {
    

    public Map<String, List<Article>> tagArticles(List<Article> articles, List<String> tags) {

        return tags.stream().collect(Collectors.toMap(Function.identity(), tag -> articles.stream().filter(article -> {
            if (article.getTags().contains(tag)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList())
        ));
    }

    // AI hint on how to filter (I made a method for each articles own distinct tag count)
    public Article topTaggedArticle(List<Article> articles, List<String> tags) {
        return articles.stream().collect(Collectors.toMap(Function.identity(), (Article article) -> article.getTags().stream().filter(tag -> article.getTags().contains(tag)).distinct().count())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public Map<String, Long> countTagOccurrences(List<Article> articles, List<String> tags) {

        return tags.stream().collect(Collectors.toMap(Function.identity(), tag -> articles.stream().filter(article -> article.getTags().contains(tag)).count()));
    }

    public Map<String, List<Article>> groupArticlesByTag(List<Article> articles, List<String> tags) {

        return tags.stream().collect(Collectors.toMap(Function.identity(), tag -> articles.stream().filter(article2 -> article2.getTags().contains(tag)).toList()));
    }

    public String findMostCommonTag(List<Article> articles) {

        return articles.stream().flatMap(article -> article.getTags().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public String findLeastCommonTag(List<Article> articles) {

        return articles.stream().flatMap(article -> article.getTags().stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public Map<String, List<Article>> tagArticlesSafe(List<Article> articles, List<String> tags) {

        if (articles == null || tags == null) {
            throw new IllegalArgumentException("Articles and Tags cannot be null");
        }

        return tags.stream().collect(Collectors.toMap(Function.identity(), tag -> articles.stream().filter(article -> {
            if (article.getTags().contains(tag)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList())
        )).entrySet().stream().sorted(Comparator.comparing((Map.Entry<String, List<Article>> es) -> es.getValue().size()).thenComparing(Comparator.comparing(Map.Entry::getKey))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Article topTaggedArticleSafe(List<Article> articles, List<String> tags) {
        return articles.stream().collect(Collectors.toMap(Function.identity(), (Article article) -> article.getTags().stream().filter(tag -> tags.contains(tag)).count())).entrySet().stream().sorted(Map.Entry.<Article, Long> comparingByValue().reversed()).map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public Long tagCount(List<Article> articles, String tag) {
        return articles.stream().filter(article -> article.getTags().contains(tag)).count();
    }
}
