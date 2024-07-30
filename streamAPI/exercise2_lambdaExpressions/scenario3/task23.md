Background: A financial analytics firm requires a system for real-time analysis of stock market data. The task involves using Java Stream API to stream, process, and aggregate large volumes of financial transactions to generate timely insights.

Task 1

Problem: You are given a list of `Transaction` objects. Each `Transaction` has a `ticker` (String), `volume` (int), and `price` (double). Implement the following methods using Java Stream API and lambda expressions:

1. `findTopTransactionsByVolume(List<Transaction> transactions, int n)`: This method should return a list of `n` transactions with the highest volume. The list should be sorted in descending order of volume. If two transactions have the same volume, sort them by ticker in alphabetical order.
    
2. `calculateAveragePricePerTicker(List<Transaction> transactions)`: This method should return a map where the key is the ticker and the value is the average price of all transactions with that ticker.
    

Example:

Input:

List<Transaction> transactions = Arrays.asList(

    new Transaction("AAPL", 100, 150.0),

    new Transaction("AAPL", 200, 140.0),

    new Transaction("GOOG", 50, 1200.0),

    new Transaction("GOOG", 150, 1100.0),

    new Transaction("MSFT", 300, 200.0)

);

Output for `findTopTransactionsByVolume(transactions, 2)`:

[

    new Transaction("MSFT", 300, 200.0),

    new Transaction("AAPL", 200, 140.0)

]

Output for `calculateAveragePricePerTicker(transactions)`:

{

    "AAPL": 145.0,

    "GOOG": 1150.0,

    "MSFT": 200.0

}

Note: For the purpose of this problem, you can assume that all tickers and volumes are unique. Also, the volume is always a positive integer and the price is always a positive double.

Task 2

Topic: Stream Collectors

Problem: You are given a list of `Transaction` objects. Each `Transaction` has a `ticker` (String), `volume` (int), `price` (double), and `date` (LocalDate). Implement the following methods using Java Stream API and lambda expressions:

1. `groupTransactionsByDate(List<Transaction> transactions)`: This method should return a map where the key is the date and the value is a list of transactions that occurred on that date. The transactions in the list should be sorted by volume in descending order.
    
2. `calculateTotalVolumePerTicker(List<Transaction> transactions)`: This method should return a map where the key is the ticker and the value is the total volume of all transactions with that ticker.
    

Example:

Input:

List<Transaction> transactions = Arrays.asList(

    new Transaction("AAPL", 100, 150.0, LocalDate.of(2022, 1, 1)),

    new Transaction("AAPL", 200, 140.0, LocalDate.of(2022, 1, 2)),

    new Transaction("GOOG", 50, 1200.0, LocalDate.of(2022, 1, 1)),

    new Transaction("GOOG", 150, 1100.0, LocalDate.of(2022, 1, 2)),

    new Transaction("MSFT", 300, 200.0, LocalDate.of(2022, 1, 1))

);

Output for `groupTransactionsByDate(transactions)`:

{

    LocalDate.of(2022, 1, 1): [

        new Transaction("MSFT", 300, 200.0, LocalDate.of(2022, 1, 1)),

        new Transaction("AAPL", 100, 150.0, LocalDate.of(2022, 1, 1)),

        new Transaction("GOOG", 50, 1200.0, LocalDate.of(2022, 1, 1))

    ],

    LocalDate.of(2022, 1, 2): [

        new Transaction("AAPL", 200, 140.0, LocalDate.of(2022, 1, 2)),

        new Transaction("GOOG", 150, 1100.0, LocalDate.of(2022, 1, 2))

    ]

}

Output for `calculateTotalVolumePerTicker(transactions)`:

{

    "AAPL": 300,

    "GOOG": 200,

    "MSFT": 300

}

Task 3

Topic: Parallel Stream

Problem: You are given a list of `Transaction` objects. Each `Transaction` has a `ticker` (String), `volume` (int), `price` (double), and `date` (LocalDate). Implement the following methods using Java Stream API and lambda expressions:

1. `findMostActiveDay(List<Transaction> transactions)`: This method should return the date with the highest total volume of transactions. If there are multiple dates with the same highest total volume, return the earliest date.
    
2. `calculatePriceChangePerTicker(List<Transaction> transactions)`: This method should return a map where the key is the ticker and the value is the difference between the highest and lowest transaction price for that ticker.
    

Note: For these methods, you should use parallel streams to improve performance when dealing with large volumes of data.

Task 4

Topic: Stream Performance

Problem: You are given a list of `Transaction` objects. Each `Transaction` has a `ticker` (String), `volume` (int), `price` (double), and `date` (LocalDate). Implement the following methods using Java Stream API and lambda expressions:

1. `findTransactionWithHighestPrice(List<Transaction> transactions)`: This method should return the transaction with the highest price. If there are multiple transactions with the same highest price, return the one with the highest volume.
    
2. `findTransactionWithLowestPrice(List<Transaction> transactions)`: This method should return the transaction with the lowest price. If there are multiple transactions with the same lowest price, return the one with the lowest volume.
    
3. `calculateTotalVolumePerDay(List<Transaction> transactions)`: This method should return a map where the key is the date and the value is the total volume of transactions for that date.
    

Note: For these methods, you should consider the performance implications of your stream operations and choose the most efficient operations for each task.