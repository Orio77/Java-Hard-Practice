## Exercise Documentation

### List of Classes to Create

1. `GameState`
2. `Strategy<T>`
3. `EnemyAI<T extends GameState>`
4. `GameAI<T extends GameState>`

### List of Classes and Their Methods

#### `GameState`

- `getEnemies()`: This method should return a list of enemies currently in the game.
- `getPlayerState()`: This method should return the current state of the player in the game.

#### `Strategy<T>`

- `execute(T state)`: This method should perform an action based on the provided game state.

#### `EnemyAI<T extends GameState>`

- `execute(T state)`: This method should print different messages based on the state of the game.

#### `GameAI<T extends GameState>`

- `setStrategy(Strategy<T> strategy)`: This method should allow the strategy to be changed at runtime.
- `executeStrategy()`: This method should execute the current strategy and handle possible errors, printing a message if the strategy cannot be executed.

### General Overview

The exercise is designed to practice using Java Generics in different scenarios, particularly in the context of the Strategy design pattern. The `GameState` class encapsulates the state of the game, including the enemies and the player's state. The `Strategy` interface defines a method for executing a strategy based on the game state.

The `EnemyAI` class implements the `Strategy` interface and uses the game state to determine which messages to print. The `GameAI` class uses the Strategy pattern to allow the strategy to be changed at runtime and to execute the current strategy.

### Example Workflow

1. A `GameState` object is created, representing the current state of the game.
2. An `EnemyAI` object is created, which implements the `Strategy` interface.
3. A `GameAI` object is created, which uses the Strategy pattern.
4. The `setStrategy` method of the `GameAI` object is called, passing in the `EnemyAI` object.
5. The `executeStrategy` method of the `GameAI` object is called.
6. If the game state allows for the strategy to be executed, the `execute` method of the `EnemyAI` object is called, printing a message based on the game state.
7. If the game state does not allow for the strategy to be executed, a message is printed indicating that the strategy cannot be executed.