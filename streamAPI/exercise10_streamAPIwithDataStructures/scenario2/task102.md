## Task 1

You are given a list of articles. Each article is represented as a `String`. Your task is to implement two methods:

1. `tagArticles(List<String> articles, List<String> tags)`: This method should return a `Map<String, List<String>>` where the key is a tag and the value is a list of articles that contain the tag. The articles should be sorted in descending order based on the number of occurrences of the tag. If two articles have the same number of occurrences, sort them alphabetically.
    
2. `topTaggedArticle(List<String> articles, List<String> tags)`: This method should return the article that has the most number of unique tags. If there are multiple articles with the same number of unique tags, return the one that appears first in the list.
    

Example:

Input: articles = ["Java Stream API", "Java Optional", "Java Stream Collectors", "Java Lambda Expressions"] tags = ["Java", "Stream", "Optional", "Lambda"]

Output: tagArticles: {"Java": ["Java Stream API", "Java Optional", "Java Stream Collectors", "Java Lambda Expressions"], "Stream": ["Java Stream API", "Java Stream Collectors"], "Optional": ["Java Optional"], "Lambda": ["Java Lambda Expressions"]} topTaggedArticle: "Java Stream API"

## Task 2

Drawn Topic: Stream Collectors

You are given a list of articles. Each article is represented as a `String`. Your task is to implement two methods:

1. `countTagOccurrences(List<String> articles, List<String> tags)`: This method should return a `Map<String, Long>` where the key is a tag and the value is the count of articles that contain the tag.
    
2. `groupArticlesByTag(List<String> articles, List<String> tags)`: This method should return a `Map<String, List<String>>` where the key is a tag and the value is a list of articles that contain the tag. The articles should be sorted alphabetically.
    

Example:

Input: articles = ["Java Stream API", "Java Optional", "Java Stream Collectors", "Java Lambda Expressions"] tags = ["Java", "Stream", "Optional", "Lambda"]

Output: countTagOccurrences: {"Java": 4, "Stream": 2, "Optional": 1, "Lambda": 1} groupArticlesByTag: {"Java": ["Java Lambda Expressions", "Java Optional", "Java Stream API", "Java Stream Collectors"], "Stream": ["Java Stream API", "Java Stream Collectors"], "Optional": ["Java Optional"], "Lambda": ["Java Lambda Expressions"]}

## Task 3

Drawn Topic: Stream Performance

You are given a list of articles. Each article is represented as a `String`. Your task is to implement two methods:

1. `findMostCommonTag(List<String> articles, List<String> tags)`: This method should return the tag that appears in the most number of articles. If there are multiple tags with the same count, return the one that appears first in the tags list.
    
2. `findLeastCommonTag(List<String> articles, List<String> tags)`: This method should return the tag that appears in the least number of articles. If there are multiple tags with the same count, return the one that appears first in the tags list.
    

Example:

Input: articles = ["Java Stream API", "Java Optional", "Java Stream Collectors", "Java Lambda Expressions"] tags = ["Java", "Stream", "Optional", "Lambda"]

Output: findMostCommonTag: "Java" findLeastCommonTag: "Optional"

## Task 4

Drawn Topic: Error Handling Strategies

You are given a list of articles. Each article is represented as a `String`. Your task is to implement three methods:

1. `tagArticles(List<String> articles, List<String> tags)`: This method should return a `Map<String, List<String>>` where the key is a tag and the value is a list of articles that contain the tag. The articles should be sorted in descending order based on the number of occurrences of the tag. If two articles have the same number of occurrences, sort them alphabetically. If an article or a tag is null, it should be ignored.
    
2. `topTaggedArticle(List<String> articles, List<String> tags)`: This method should return the article that has the most number of unique tags. If there are multiple articles with the same number of unique tags, return the one that appears first in the list. If an article or a tag is null, it should be ignored.
    
3. `tagCount(List<String> articles, String tag)`: This method should return the count of articles that contain the given tag. If the tag is null or empty, it should return 0.
    

Example:

Input: articles = ["Java Stream API", "Java Optional", "Java Stream Collectors", "Java Lambda Expressions", null] tags = ["Java", "Stream", "Optional", "Lambda", null]

Output: tagArticles: {"Java": ["Java Stream API", "Java Optional", "Java Stream Collectors", "Java Lambda Expressions"], "Stream": ["Java Stream API", "Java Stream Collectors"], "Optional": ["Java Optional"], "Lambda": ["Java Lambda Expressions"]} topTaggedArticle: "Java Stream API" tagCount: 2