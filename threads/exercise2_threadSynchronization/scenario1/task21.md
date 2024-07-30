**Task 1: Thread Synchronization and Message Delivery**

In a real-time messaging application, implement two methods, `sendMessage` and `receiveMessage`.

`sendMessage` should take a message and a chat room as parameters. It should send the message to the specified chat room. Ensure that if multiple threads are sending messages to the same chat room, the messages are sent in the order they were called.

`receiveMessage` should take a chat room as a parameter. It should receive the next message from the specified chat room. If multiple threads are receiving messages from the same chat room, ensure that each message is received by exactly one thread.

Example: If Thread1 calls `sendMessage("Hello", "ChatRoom1")` and then Thread2 calls `sendMessage("World", "ChatRoom1")`, the messages should be received in the order "Hello", "World".

**Task 2: Thread Synchronization and Deadlock Avoidance**

Using the concept of Deadlock Avoidance, implement two methods, `enterChatRoom` and `leaveChatRoom`.

`enterChatRoom` should take a user and a chat room as parameters. It should allow the user to enter the chat room. If the user is already in another chat room, they should leave that chat room before entering the new one.

`leaveChatRoom` should take a user as a parameter. It should allow the user to leave their current chat room.

Ensure that if multiple threads are trying to enter or leave chat rooms, no deadlocks occur.

Example: If Thread1 calls `enterChatRoom("User1", "ChatRoom1")` and then Thread2 calls `enterChatRoom("User1", "ChatRoom2")`, User1 should first leave ChatRoom1 before entering ChatRoom2.

**Task 3: Thread Synchronization and ThreadLocal Usage**

With the concept of ThreadLocal Usage, implement two methods, `setUserContext` and `getUserContext`.

`setUserContext` should take a user as a parameter. It should set the user context for the current thread.

`getUserContext` should take no parameters. It should return the user context for the current thread.

Ensure that each thread has its own user context.

Example: If Thread1 calls `setUserContext("User1")` and then Thread2 calls `setUserContext("User2")`, `getUserContext` should return "User1" for Thread1 and "User2" for Thread2.

**Task 4: Thread Synchronization and Executors Framework**

Using the Executors Framework, implement three methods, `createChatRoom`, `deleteChatRoom`, and `listChatRooms`.

`createChatRoom` should take a chat room as a parameter. It should create a new chat room.

`deleteChatRoom` should take a chat room as a parameter. It should delete the specified chat room.

`listChatRooms` should take no parameters. It should return a list of all chat rooms.

Ensure that if multiple threads are creating, deleting, or listing chat rooms, the operations are performed in a thread-safe manner.

Example: If Thread1 calls `createChatRoom("ChatRoom1")`, `listChatRooms` should include "ChatRoom1". If Thread2 then calls `deleteChatRoom("ChatRoom1")`, `listChatRooms` should no longer include "ChatRoom1".