Task 1

Problem: Given a list of User objects, each User has a list of ViewedContent objects. Each ViewedContent has a contentId and a timestamp. Implement two methods:

1. `findTopViewedContent(List<User> users, int topN)`: This method should return a list of topN contentIds that have been viewed the most by all users. In case of a tie, return the contentId that was viewed most recently.
    
2. `findRecentViewedContent(List<User> users, int days)`: This method should return a list of contentIds that have been viewed by any user in the past 'days' days.
    

Example:

Input:

List<User> users = Arrays.asList(

    new User(Arrays.asList(new ViewedContent("content1", LocalDateTime.now().minusDays(1)), new ViewedContent("content2", LocalDateTime.now().minusDays(2)))),

    new User(Arrays.asList(new ViewedContent("content2", LocalDateTime.now().minusDays(1)), new ViewedContent("content3", LocalDateTime.now().minusDays(2))))

);

int topN = 2;

int days = 1;

Output:

findTopViewedContent(users, topN) => ["content2", "content1"]

findRecentViewedContent(users, days) => ["content1", "content2"]

Task 2 (Topic: Stream Collectors)

Problem: Given a list of User objects, each User has a list of ViewedContent objects. Each ViewedContent has a contentId and a genre. Implement two methods:

1. `groupByGenre(List<User> users)`: This method should return a Map where the key is the genre and the value is a list of contentIds of that genre.
    
2. `countByGenre(List<User> users)`: This method should return a Map where the key is the genre and the value is the count of contentIds of that genre.
    

Example:

Input:

List<User> users = Arrays.asList(

    new User(Arrays.asList(new ViewedContent("content1", "action"), new ViewedContent("content2", "comedy"))),

    new User(Arrays.asList(new ViewedContent("content3", "action"), new ViewedContent("content4", "drama")))

);

Output:

groupByGenre(users) => {"action" : ["content1", "content3"], "comedy" : ["content2"], "drama" : ["content4"]}

countByGenre(users) => {"action" : 2, "comedy" : 1, "drama" : 1}

Task 3 (Topic: Stream Performance)

Problem: Given a list of User objects, each User has a list of ViewedContent objects. Each ViewedContent has a contentId and a timestamp. Implement two methods:

1. `findTopViewedContentParallel(List<User> users, int topN)`: This method should return a list of topN contentIds that have been viewed the most by all users. In case of a tie, return the contentId that was viewed most recently. This method should use parallel streams.
    
2. `findRecentViewedContentParallel(List<User> users, int days)`: This method should return a list of contentIds that have been viewed by any user in the past 'days' days. This method should use parallel streams.
    

Example:

Input:

List<User> users = Arrays.asList(

    new User(Arrays.asList(new ViewedContent("content1", LocalDateTime.now().minusDays(1)), new ViewedContent("content2", LocalDateTime.now().minusDays(2)))),

    new User(Arrays.asList(new ViewedContent("content2", LocalDateTime.now().minusDays(1)), new ViewedContent("content3", LocalDateTime.now().minusDays(2))))

);

int topN = 2;

int days = 1;

Output:

findTopViewedContentParallel(users, topN) => ["content2", "content1"]

findRecentViewedContentParallel(users, days) => ["content1", "content2"]

Task 4 (Topic: Optional)

Problem: Given a list of User objects, each User has a list of ViewedContent objects. Each ViewedContent has a contentId, a genre, and a rating. Implement three methods:

1. `findTopRatedContent(List<User> users, int topN)`: This method should return a list of topN contentIds that have the highest average rating by all users. In case of a tie, return the contentId that was rated most recently.
    
2. `findTopRatedContentByGenre(List<User> users, String genre, int topN)`: This method should return a list of topN contentIds of a specific genre that have the highest average rating by all users. In case of a tie, return the contentId that was rated most recently.
    
3. `findUserTopRatedContent(List<User> users, String userId, int topN)`: This method should return a list of topN contentIds that have the highest rating by a specific user. In case of a tie, return the contentId that was rated most recently.
    

Example:

Input:

List<User> users = Arrays.asList(

    new User("user1", Arrays.asList(new ViewedContent("content1", "action", 5), new ViewedContent("content2", "comedy", 4))),

    new User("user2", Arrays.asList(new ViewedContent("content3", "action", 4), new ViewedContent("content4", "drama", 5)))

);

int topN = 2;

String genre = "action";

String userId = "user1";

Output:

findTopRatedContent(users, topN) => ["content1", "content4"]

findTopRatedContentByGenre(users, genre, topN) => ["content1", "content3"]

findUserTopRatedContent(users, userId, topN) => ["content1", "content2"]