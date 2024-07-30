package streamAPI.exercise5_intermediateOperations.scenario2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArticleService {
    
    public List<String> filterAndSortArticles(List<Article> articles, String source, String category) {
        return articles.stream().filter(article -> article.getCategory().matches(category) && article.getSource().matches(source)).map(Article::getTitle).sorted(Comparator.naturalOrder()).toList();
    }

    public Map<String, List<String>> classifyArticles(List<Article> articles, String keyword) {
        Map<String, List<String>> map = articles.stream().filter(article -> article.getContent().contains(keyword)).collect(Collectors.groupingBy(Article::getCategory, Collectors.mapping(Article::getTitle, Collectors.toList())));

        map.entrySet().forEach(es -> es.getValue().sort(Comparator.naturalOrder()));
        return map;
    }

    public Map<String, Long> countArticlesBySource(List<Article> articles) {
        return articles.stream().collect(Collectors.groupingBy(Article::getSource, Collectors.counting()));
    }

    public Map<String, Double> averageArticleLengthByCategory(List<Article> articles) {
        return articles.stream().collect(Collectors.groupingBy(Article::getCategory, Collectors.averagingDouble(article -> article.getContent().length())));
    }

    public List<String> findMostCommonWords(List<Article> articles, int n) {
        return articles.stream().flatMap(article -> Arrays.stream(article.getContent().split(","))).collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(n).map(Map.Entry::getKey).toList();
        
    }

    public List<String> findUniqueSources(List<Article> articles) {
        return articles.stream().map(Article::getSource).distinct().toList();
    }

    public String findLongestArticle(List<Article> articles) {
        return articles.stream().max(Comparator.comparing((Article article) -> article.getContent().length())).map(Article::getTitle).orElse(null);
    }

    public String findShortestArticle(List<Article> articles) {
        return articles.stream().min(Comparator.comparing((Article article) -> article.getContent().length())).map(Article::getTitle).orElse(null);
    }

    public double findAverageArticleLength(List<Article> articles) {
        return articles.stream().mapToInt(article -> article.getContent().length()).average().orElse(0);
    }
}
