Task 1

Problem: Given a list of User objects, each User has a list of Post objects, and each Post has a list of Comment objects. Some of these objects may be null. Your task is to implement two methods:

1. `filterNonNullUsers(List<User> users)`: This method should return a list of Users, where each User, their Posts, and the Comments on those Posts are all non-null. The list should be sorted in descending order by the total number of comments on a User's Posts.
    
2. `sortPostsByComments(List<User> users)`: This method should return a list of all non-null Posts from all non-null Users, sorted in descending order by the number of non-null Comments.
    

Example:

Input:

User1: Post1 (Comment1, Comment2), Post2 (null)

User2: null

User3: Post3 (Comment3), Post4 (null, Comment4)

Output for `filterNonNullUsers`:

User1: Post1 (Comment1, Comment2)

User3: Post3 (Comment3)

Output for `sortPostsByComments`:

Post1 (Comment1, Comment2), Post3 (Comment3)

Task 2

Topic: Stream Performance

Problem: Given the same list of User objects as in Task 1, implement two methods:

1. `filterAndSortParallel(List<User> users)`: This method should do the same as `filterNonNullUsers` from Task 1, but it should use parallel streams to improve performance.
    
2. `comparePerformance(List<User> users)`: This method should return the difference in execution time between `filterNonNullUsers` and `filterAndSortParallel`.
    

Task 3

Topic: Stream API with Data Structures

Problem: Given the same list of User objects as in Task 1, implement two methods:

1. `mapUsersToPostCount(List<User> users)`: This method should return a Map where the keys are User objects and the values are the number of non-null Posts that User has. The Map should be sorted in descending order by the values.
    
2. `mapPostsToCommentCount(List<User> users)`: This method should return a Map where the keys are Post objects and the values are the number of non-null Comments that Post has. The Map should be sorted in descending order by the values.
    

Task 4

Topic: Optional

Problem: Given the same list of User objects as in Task 1, implement three methods:

1. `findFirstUserWithPost(List<User> users)`: This method should return an Optional of the first User in the list who has at least one non-null Post.
    
2. `findFirstPostWithComment(List<User> users)`: This method should return an Optional of the first Post in the list of all Posts from all Users that has at least one non-null Comment.
    
3. `findFirstComment(List<User> users)`: This method should return an Optional of the first Comment in the list of all Comments from all Posts from all Users.