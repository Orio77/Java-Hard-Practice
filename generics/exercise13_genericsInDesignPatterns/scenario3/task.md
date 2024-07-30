Topic: Generics in Design Patterns

**Problem: Generic Message Factory**

You are working on a messaging application that needs to support various message types, such as text messages, images, and voice messages. Your task is to apply generics within the Factory design pattern to create message objects dynamically.

To accomplish this, you need to implement the following classes and interfaces:

1. `Message`: This is an interface that represents a generic message. It should have two methods:
    
    - `getContent()`: This method should return the content of the message.
    - `getType()`: This method should return the type of the message (e.g., "text", "image", "voice").
2. `TextMessage`, `ImageMessage`, `VoiceMessage`: These are classes that implement the `Message` interface. Each class should have a constructor that accepts the content of the message.
    
3. `MessageFactory`: This is a class that uses generics and the Factory design pattern to create message objects dynamically. It should have one method:
    
    - `createMessage(Class<T> type, String content)`: This method should accept a class type and a string content, and return an instance of the specified class type with the provided content.

**Constraints:**

- The `content` for `TextMessage` is a string of text.
- The `content` for `ImageMessage` is a string representing the URL of the image.
- The `content` for `VoiceMessage` is a string representing the URL of the voice message.
- All strings are non-null and have a length of 1 to 1000.

**Example:**
MessageFactory factory = new MessageFactory();

Message textMessage = factory.createMessage(TextMessage.class, "Hello, World!");
System.out.println(textMessage.getType()); // prints "text"
System.out.println(textMessage.getContent()); // prints "Hello, World!"

Message imageMessage = factory.createMessage(ImageMessage.class, "http://example.com/image.jpg");
System.out.println(imageMessage.getType()); // prints "image"
System.out.println(imageMessage.getContent()); // prints "http://example.com/image.jpg"

Message voiceMessage = factory.createMessage(VoiceMessage.class, "http://example.com/voice.mp3");
System.out.println(voiceMessage.getType()); // prints "voice"
System.out.println(voiceMessage.getContent()); // prints "http://example.com/voice.mp3"


**New Task: Generic Message Collection**

Building upon the previous task, you are now required to manage collections of different types of messages. To do this, you will need to use generics in collections.

Your task is to create a `MessageCollection` class that can store and manage different types of messages. This class should use generics to ensure type safety and flexibility.

To accomplish this, you need to implement the following:

1. `MessageCollection<T extends Message>`: This is a class that represents a collection of messages of a specific type. It should have the following methods:
    
    - `addMessage(T message)`: This method should add a message to the collection.
    - `getMessage(int index)`: This method should return the message at the specified index in the collection.
    - `getAllMessages()`: This method should return all messages in the collection as a List.
    - `removeMessage(int index)`: This method should remove the message at the specified index from the collection.

**Constraints:**

- The `MessageCollection` class should ensure type safety, i.e., it should only allow adding messages of a specific type to the collection.
- The `index` for `getMessage` and `removeMessage` methods is a zero-based index and it's always valid.

**Example:**
MessageFactory factory = new MessageFactory();
MessageCollection<TextMessage> textMessages = new MessageCollection<>();

TextMessage textMessage1 = factory.createMessage(TextMessage.class, "Hello, World!");
textMessages.addMessage(textMessage1);

TextMessage textMessage2 = factory.createMessage(TextMessage.class, "Hello, again!");
textMessages.addMessage(textMessage2);

System.out.println(textMessages.getMessage(0).getContent()); // prints "Hello, World!"
System.out.println(textMessages.getAllMessages().size()); // prints "2"

textMessages.removeMessage(0);
System.out.println(textMessages.getAllMessages().size()); // prints "1"

**New Task: Generics in Streams**

Building upon the previous tasks, you are now required to perform operations on the collections of different types of messages using Java Streams. This task will allow you to apply the concept of Generics in Streams.

Your task is to add the following methods to the `MessageCollection` class:

1. `filterMessages(Predicate<T> predicate)`: This method should accept a Predicate and return a new `MessageCollection` that contains only the messages that satisfy the predicate.
    
2. `transformMessages(Function<T, T> function)`: This method should accept a Function and return a new `MessageCollection` that contains the messages after applying the function to each of them.
    

**Constraints:**

- The `Predicate<T>` is a functional interface that represents a boolean-valued function of one argument. It is used as a lambda expression or method reference.
- The `Function<T, T>` is a functional interface that represents a function that accepts one argument and produces a result. It is used as a lambda expression or method reference.

**Example:**
MessageFactory factory = new MessageFactory();
MessageCollection<TextMessage> textMessages = new MessageCollection<>();

TextMessage textMessage1 = factory.createMessage(TextMessage.class, "Hello, World!");
textMessages.addMessage(textMessage1);

TextMessage textMessage2 = factory.createMessage(TextMessage.class, "Hello, again!");
textMessages.addMessage(textMessage2);

// Filter messages that contain the word "World"
MessageCollection<TextMessage> filteredMessages = textMessages.filterMessages(message -> message.getContent().contains("World"));
System.out.println(filteredMessages.getAllMessages().size()); // prints "1"

// Transform messages by appending "!!!" to the content
MessageCollection<TextMessage> transformedMessages = textMessages.transformMessages(message -> {
    String newContent = message.getContent() + "!!!";
    return factory.createMessage(TextMessage.class, newContent);
});
System.out.println(transformedMessages.getMessage(0).getContent()); // prints "Hello, World!!!!"




### List of concepts:
[Understanding Generics, Parameterized Types, Wildcard Types, Type Erasure, Generic Methods, Bounded Type Parameters, Generics Best Practises, Generics in Collections, Type Casting and Type Checking, Generic Interfaces and Classes, Generics in Streams, Handling Generics Errors, Generics in Design Patterns, Performance Considerations, Testing Generics, Documentation]