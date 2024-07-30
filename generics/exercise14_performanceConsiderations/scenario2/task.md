## Exercise Documentation

### List of Classes to Create

1. `Trade<T>`
2. `TradeProcessor<T extends Trade<?>>`
3. `RealTimeTradeProcessor<T extends Trade<?>>`
4. `TradeEngine`

### List of Classes and Their Methods

#### `Trade<T>`

- `getPrice()`: This method should return the price of the trade.
- `getQuantity()`: This method should return the quantity of the trade.
- `getSymbol()`: This method should return the symbol of the trade.

#### `TradeProcessor<T extends Trade<?>>`

- `process(T trade)`: This method should simulate processing a trade and print a message.

#### `RealTimeTradeProcessor<T extends Trade<?>>`

- `process(T trade)`: This method should simulate processing a trade in real-time and print a message.

#### `TradeEngine`

- `setTradeProcessor(TradeProcessor<?> tradeProcessor)`: This method should allow the trade processor to be changed at runtime.
- `executeTrade(Trade<?> trade)`: This method should execute the trade using the current trade processor and handle possible errors, printing a message if the trade cannot be processed.

### General Overview

The exercise is designed to practice using Java Generics in different scenarios, particularly in the context of a real-time financial trading platform. The `Trade` class encapsulates a trade, including its price, quantity, and symbol. The `TradeProcessor` interface defines a method for processing a trade.

The `RealTimeTradeProcessor` class implements the `TradeProcessor` interface and uses the trade to determine which messages to print. The `TradeEngine` class uses the Strategy pattern to allow the trade processor to be changed at runtime and to execute the trade using the current trade processor.

### Example Workflow

1. A `Trade` object is created, representing a trade in the financial market.
2. A `RealTimeTradeProcessor` object is created, which implements the `TradeProcessor` interface.
3. A `TradeEngine` object is created, which uses the Strategy pattern.
4. The `setTradeProcessor` method of the `TradeEngine` object is called, passing in the `RealTimeTradeProcessor` object.
5. The `executeTrade` method of the `TradeEngine` object is called, passing in the `Trade` object.
6. If the trade can be processed, the `process` method of the `RealTimeTradeProcessor` object is called, printing a message.
7. If the trade cannot be processed, a message is printed indicating that the trade cannot be processed.