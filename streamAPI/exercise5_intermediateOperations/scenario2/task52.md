Task 1

You are given a list of `Article` objects. Each `Article` has a `source`, `title`, `content`, and `category`. Implement the following methods:

1. `filterAndSortArticles(List<Article> articles, String source, String category)`: This method should filter the articles by the given source and category, then sort them by title in ascending order. Finally, it should return a list of titles.
    
2. `classifyArticles(List<Article> articles, String keyword)`: This method should filter the articles that contain the given keyword in their content. Then, it should group them by category and return a map where the key is the category and the value is a list of titles from that category, sorted in ascending order.
    

Example:

Input:

List<Article> articles = Arrays.asList(

    new Article("Source1", "Title1", "Content with keyword", "Category1"),

    new Article("Source1", "Title2", "Content without keyword", "Category2"),

    new Article("Source2", "Title3", "Content with keyword", "Category1"),

    new Article("Source2", "Title4", "Content without keyword", "Category2")

);

filterAndSortArticles(articles, "Source1", "Category1");

classifyArticles(articles, "keyword");

Output:

filterAndSortArticles: ["Title1"]

classifyArticles: {"Category1": ["Title1", "Title3"]}

Task 2 (Topic: Stream Collectors)

1. `countArticlesBySource(List<Article> articles)`: This method should return a map where the key is the source and the value is the count of articles from that source.
    
2. `averageArticleLengthByCategory(List<Article> articles)`: This method should return a map where the key is the category and the value is the average length of the content of articles in that category.
    

Example:

Input:

List<Article> articles = Arrays.asList(

    new Article("Source1", "Title1", "Content1", "Category1"),

    new Article("Source1", "Title2", "Content2", "Category2"),

    new Article("Source2", "Title3", "Content3", "Category1"),

    new Article("Source2", "Title4", "Content4", "Category2")

);

countArticlesBySource(articles);

averageArticleLengthByCategory(articles);

Output:

countArticlesBySource: {"Source1": 2, "Source2": 2}

averageArticleLengthByCategory: {"Category1": 8.0, "Category2": 8.0}

Task 3 (Topic: Parallel Stream)

1. `findMostCommonWords(List<Article> articles, int n)`: This method should return a list of the n most common words in the content of all articles. The list should be sorted in descending order of frequency. If two words have the same frequency, sort them in alphabetical order. Use parallel streams for this task.
    
2. `findUniqueSources(List<Article> articles)`: This method should return a list of unique sources. The list should be sorted in ascending order. Use parallel streams for this task.
    

Example:

Input:

List<Article> articles = Arrays.asList(

    new Article("Source1", "Title1", "Content with keyword", "Category1"),

    new Article("Source1", "Title2", "Content without keyword", "Category2"),

    new Article("Source2", "Title3", "Content with keyword", "Category1"),

    new Article("Source2", "Title4", "Content without keyword", "Category2")

);

findMostCommonWords(articles, 2);

findUniqueSources(articles);

Output:

findMostCommonWords: ["Content", "keyword"]

findUniqueSources: ["Source1", "Source2"]

Task 4 (Topic: Stream Performance)

1. `findLongestArticle(List<Article> articles)`: This method should return the title of the article with the longest content. If there are multiple articles with the same longest content, return the one with the earliest title in alphabetical order.
    
2. `findShortestArticle(List<Article> articles)`: This method should return the title of the article with the shortest content. If there are multiple articles with the same shortest content, return the one with the earliest title in alphabetical order.
    
3. `findAverageArticleLength(List<Article> articles)`: This method should return the average length of the content of all articles.
    

Example:

Input:

List<Article> articles = Arrays.asList(

    new Article("Source1", "Title1", "Content1", "Category1"),

    new Article("Source1", "Title2", "Content2", "Category2"),

    new Article("Source2", "Title3", "Content3", "Category1"),

    new Article("Source2", "Title4", "Content4", "Category2")

);

findLongestArticle(articles);

findShortestArticle(articles);

findAverageArticleLength(articles);

Output:

findLongestArticle: "Title4"

findShortestArticle: "Title1"

findAverageArticleLength: 8.0