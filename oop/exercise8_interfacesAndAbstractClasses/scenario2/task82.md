**Enhanced Scenario 2: Building a Multiplayer Online Game with Advanced Use of Interfaces and Abstract Classes**

- Enhanced Task 1 part:
    
    1. Define an abstract `GameCharacter` class with essential game logic. This class should include abstract methods that must be implemented by any class that extends it. These methods could include `move()`, `attack()`, `defend()`, etc.
    2. Define an interface `ICharacterBehaviour` that includes methods for special abilities that only some characters might have, such as `castSpell()`, `stealth()`, `heal()`, etc.
    3. Make the `GameCharacter` class implement the `ICharacterBehaviour` interface, but provide default implementations that indicate the character does not have these special abilities.
- Enhanced Task 2 part:
    
    1. Create specific character classes that extend the abstract `GameCharacter` class. These classes should override the abstract methods defined in `GameCharacter` to provide character-specific behaviour.
    2. Some of these character classes should also override the methods from the `ICharacterBehaviour` interface to provide special abilities. For example, a `Wizard` class might override `castSpell()`, while a `Rogue` class might override `stealth()`.
    3. Create a `CharacterFactory` class that uses a Factory Method pattern to create instances of these character classes based on input parameters. This class should have a method `createCharacter(String characterType)` that returns an instance of the appropriate class.
- Enhanced Task 3 part:
    
    1. Ensure that each character type behaves differently in the game. This should be demonstrated by calling the methods on instances of the character classes and observing different behaviour.
    2. Implement a `GameSimulation` class that creates a variety of characters using the `CharacterFactory`, puts them into a game scenario, and simulates their interactions.
    3. The `GameSimulation` class should demonstrate polymorphism by interacting with all characters through references of type `GameCharacter`, even though the actual instances belong to the specific character classes.