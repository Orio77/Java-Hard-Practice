**Scenario: Secure User Authentication System**

**Enhanced Task 1**: Design a `User` class with private attributes for username and password. The class should have a constructor that takes a username and password and sets these attributes. The password should be hashed before it is stored.

_Potential Input_:

User user = new User("JohnDoe", "password123");

-
-
-

1 vulnerability

_Desired Output_:

// No output, but the password should be hashed in the user object.

_Coach Suggestions_: Start by defining the `User` class with private attributes for username and password. Then, implement a constructor that takes a username and password, hashes the password, and sets the attributes.

**Enhanced Task 2**: Implement getter methods for the username and password. The getter for the password should return the hashed password, not the plain text password. Also, implement a method to check if a given password matches the stored password.

_Potential Input_:

System.out.println(user.getUsername());

System.out.println(user.checkPassword("password123"));

_Desired Output_:

"JohnDoe"

"true"

_Coach Suggestions_: Implement the getter methods for the username and password. The getter for the password should return the hashed password. Also, implement a `checkPassword` method that hashes the given password and compares it to the stored hashed password.

**Enhanced Task 3**: Implement a setter method for the password. This method should take a plain text password, hash it, and store it. The method should also validate the password to ensure it meets certain criteria (e.g., minimum length, contains a number).

_Potential Input_:

user.setPassword("newPassword1");

System.out.println(user.checkPassword("newPassword1"));

_Desired Output_:

"true"

_Coach Suggestions_: Implement a setter method for the password. This method should validate the password, hash it, and store it. The validation could check for things like minimum length and whether the password contains a number.
