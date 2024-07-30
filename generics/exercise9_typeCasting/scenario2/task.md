# Exercise Documentation

## Classes to Create

1. `GameAction`
2. `PlayerAction`
3. `ObjectInteraction`
4. `GameEvent<T extends GameAction>`

## Class Methods to Implement

### `GameAction`

This class represents a generic game action. It should contain necessary information about an action such as action type and timestamp.

### `PlayerAction` and `ObjectInteraction`

These classes extend the `GameAction` class. They represent specific types of game actions and should contain additional information specific to their type.

### `GameEvent<T extends GameAction>`

This class is responsible for handling game events. It should contain the following methods:

- `processEvent(T gameEvent)`: This method should process game events of any type that extends `GameAction`.
    
- `isEventValid(T gameEvent)`: This method should check if the provided game event is valid.
    
- `handleEvent(T gameEvent)`: This method should process a game event and handle any type-related errors.
    

## General Overview

The `GameEvent` class is the main class in this exercise. It uses Java Generics with bounded type parameters to ensure compatibility with specific game action types and type safety. The `GameAction` class is the base class for different game actions. The `PlayerAction` and `ObjectInteraction` classes represent different types of game actions.

The `GameEvent` class has methods to process, validate, and handle game events. It uses the generic type `T` in method parameters, allowing for flexibility in handling game events of different types.

## Example Workflow

1. Create a `PlayerAction` or `ObjectInteraction` object with necessary information.
2. Create a `GameEvent` object.
3. Call the `processEvent` method of the `GameEvent` object with the `PlayerAction` or `ObjectInteraction` object as a parameter.
4. The `GameEvent` processes the game event.
5. Call the `isEventValid` method of the `GameEvent` object with the `PlayerAction` or `ObjectInteraction` object as a parameter.
6. The `isEventValid` method checks if the provided game event is valid.
7. Call the `handleEvent` method of the `GameEvent` object with the `PlayerAction` or `ObjectInteraction` object as a parameter.
8. The `handleEvent` method processes the game event and handles any type-related errors.