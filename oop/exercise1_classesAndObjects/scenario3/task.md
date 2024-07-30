**Scenario 3: Crafting a Social Media Profile Manager**

**Enhanced Task 1**: Design a `UserProfile` class with fields like username, bio, and followers. The followers field should be a list of `UserProfile` objects. The class should have methods to get and set these fields. The `UserProfile` class should also have a method to display all the information about a user profile.

_Potential Input_:

UserProfile userProfile = new UserProfile("JohnDoe", "Software Developer", new ArrayList<>());

userProfile.setUsername("JaneDoe");

userProfile.getUsername();

userProfile.displayProfile();

_Desired Output_:

"JaneDoe"

"Username: JaneDoe, Bio: Software Developer, Followers: 0"

_Coach Suggestions_: Start by defining the `UserProfile` class with a constructor to initialize the fields. Then, implement the getter and setter methods. Finally, create a method to display the user profile information.

**Enhanced Task 2**: Develop methods for following and unfollowing other users. This should be done through methods in the `UserProfile` class that add a `UserProfile` object to the followers list or remove it.

_Potential Input_:

UserProfile user1 = new UserProfile("User1", "Bio1", new ArrayList<>());

UserProfile user2 = new UserProfile("User2", "Bio2", new ArrayList<>());

user1.follow(user2);

user1.unfollow(user2);

_Desired Output_:

"User1 is now following User2."

"User1 has unfollowed User2."

_Coach Suggestions_: Implement the `follow` and `unfollow` methods in the `UserProfile` class. These methods should add or remove a `UserProfile` object from the followers list. Remember to handle the case where a user tries to follow or unfollow a user they are not following or are already following, respectively.

**Enhanced Task 3**: Ensure that profiles can be searched and displayed efficiently. This can be done through a `ProfileManager` class that contains a list of `UserProfile` objects. The `ProfileManager` class should have a method to search for a `UserProfile` by username and display the profile information.

_Potential Input_:

ProfileManager profileManager = new ProfileManager(new ArrayList<>(Arrays.asList(user1, user2)));

profileManager.searchProfile("User1");

_Desired Output_:

"Username: User1, Bio: Bio1, Followers: 0"

_Coach Suggestions_: Create a `ProfileManager` class with a list of `UserProfile` objects. Then, implement a method to search for a `UserProfile` by username. This method should iterate over the list of `UserProfile` objects and return the one with the matching username. Make sure to handle the case where a `UserProfile` with the given username does not exist.
