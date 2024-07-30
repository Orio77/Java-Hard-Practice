Scenario 2: Crafting a Network Chat Application
Enhanced Sprint Tasks:


Task 1: Create a network communication module with error handling.
Enhanced Task 1 part: Implement a custom exception class NetworkException that inherits from the base Exception class. This class should be used to handle all network-related exceptions.
Enhanced Task 1 part: Implement a method connect in the network communication module that attempts to establish a network connection. This method should throw a NetworkException if the connection fails.
Enhanced Task 1 part: Implement a method disconnect in the network communication module that attempts to close a network connection. This method should throw a NetworkException if the disconnection fails.
~~

Task 2: Handle exceptions for network connection failures and data transmission issues.
Enhanced Task 2 part: Implement a method sendData in the network communication module that attempts to send data over the network. This method should throw a NetworkException if the data transmission fails.
Enhanced Task 2 part: Implement a method receiveData in the network communication module that attempts to receive data over the network. This method should throw a NetworkException if the data reception fails.
Enhanced Task 2 part: Implement a try-catch block in the main chat application to handle NetworkExceptions thrown by the network communication module.
~~
Task 3: Ensure the chat application gracefully recovers from unexpected errors.
Enhanced Task 3 part: Implement a finally block in the main chat application that ensures the network connection is closed, even if an exception is thrown.
Enhanced Task 3 part: Implement a method recover in the main chat application that attempts to recover from a NetworkException by re-establishing the network connection.
Enhanced Task 3 part: Implement a try-catch block in the recover method to handle any NetworkExceptions thrown during the recovery process.