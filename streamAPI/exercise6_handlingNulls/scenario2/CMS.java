package streamAPI.exercise6_handlingNulls.scenario2;

import java.util.ArrayList;
import java.util.List;

public class CMS {
    private List<Article> processedArticles;

    public List<Article> processArticles(List<Article> articles) {
        if (articles == null) {
            return new ArrayList<>();
        }

        return articles.parallelStream().filter(article -> article != null && article.getTitle() != null && article.getContent() != null).peek(article -> {
            if (article.getTags() == null) {
                article.setTags(new ArrayList<>());
            }
        }).toList();
    }

    public List<Article> getArticles() {
        return processedArticles;
    }
}
