**Refined Scenario 2: Enhancing Social Media Friend Search Experience with Efficient Search Algorithms**
	**Refined Sprint Tasks:**

  1. **Task Refinement:** Implement Binary Search to efficiently locate friends in a sorted list.
    - **Actionable Instructions:**
        - Code the Binary Search algorithm to search through the sorted list of friends.
        - Test the algorithm with various search queries to ensure it works correctly.
  2. **Task Refinement:** Develop a feature that uses Linear Search to explore profiles of people with similar interests.
    - **Actionable Instructions:**
        - Implement the Linear Search algorithm to search through an unsorted list of profiles with similar interests.
        - Design the feature in a way that is easy for users to understand and use.
  3. **Task Refinement:** Utilize Breadth-First Search (BFS) to suggest potential connections based on mutual friends.
    - **Actionable Instructions:**
        - Implement the BFS algorithm to traverse the social graph and find potential connections.
        - Test the algorithm with various start points to ensure it suggests relevant connections.




**class User**
String name
ArrayList<String> interests;
ArrayList<User> friends
int id

+ (User) findFriend(String name);
"Binary search on a sorted list"
+ (ArrayList<User>) getSimilarPeople();
"linearly search each interest of friends and check if it matches with any of users interests"

**class Network**
ArrayList<User> userBase;

+ (ArrayList<User>) getFriendRecommendations(User user);
"BFS with a queue (no recursion)"
