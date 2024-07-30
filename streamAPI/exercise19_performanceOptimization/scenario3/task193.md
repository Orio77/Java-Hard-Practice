Task 1

Background: You are given a list of Player objects. Each Player object has fields for name (String), score (int), and match outcomes (List of MatchOutcome objects). Each MatchOutcome object has fields for opponent (Player object), result (String: "win", "loss", "draw"), and score (int).

Functionality 1: Implement a method `topScoringPlayers(List<Player> players, int n)` that returns a list of the top n players with the highest scores. The method should use the Stream API to sort the players by score in descending order and limit the stream to the top n players.

Functionality 2: Implement a method `playerWinPercentage(List<Player> players, String playerName)` that calculates and returns the win percentage (as a double) of a specified player. The method should use the Stream API to filter the matches of the specified player, count the number of wins, and calculate the win percentage.

Example Input:

List<Player> players = Arrays.asList(

    new Player("Alice", 100, Arrays.asList(new MatchOutcome("Bob", "win", 50), new MatchOutcome("Charlie", "loss", 30))),

    new Player("Bob", 80, Arrays.asList(new MatchOutcome("Alice", "loss", 50), new MatchOutcome("Charlie", "win", 30))),

    new Player("Charlie", 90, Arrays.asList(new MatchOutcome("Alice", "win", 50), new MatchOutcome("Bob", "loss", 30)))

);

Example Output:

topScoringPlayers(players, 2); // Returns: ["Alice", "Charlie"]

playerWinPercentage(players, "Alice"); // Returns: 50.0

Note: The tasks above require a deep understanding of the Stream API and involve the creation of a complex pipeline. They are intermediate to senior level tasks.

Task 2

Topic: Stream Collectors

Background: The gaming company wants to provide players with a detailed breakdown of their performance. They want to use the Stream API to group match outcomes by result (win, loss, draw) and calculate the average score for each group.

Functionality 1: Implement a method `groupMatchOutcomesByResult(List<Player> players, String playerName)` that returns a Map where the keys are match results ("win", "loss", "draw") and the values are Lists of MatchOutcome objects. The method should use the Stream API to filter the matches of the specified player and group them by result.

Functionality 2: Implement a method `averageScoreByResult(List<Player> players, String playerName)` that returns a Map where the keys are match results ("win", "loss", "draw") and the values are the average scores for each group. The method should use the Stream API to filter the matches of the specified player, group them by result, and calculate the average score for each group.

Example Input:

List<Player> players = Arrays.asList(

    new Player("Alice", 100, Arrays.asList(new MatchOutcome("Bob", "win", 50), new MatchOutcome("Charlie", "loss", 30))),

    new Player("Bob", 80, Arrays.asList(new MatchOutcome("Alice", "loss", 50), new MatchOutcome("Charlie", "win", 30))),

    new Player("Charlie", 90, Arrays.asList(new MatchOutcome("Alice", "win", 50), new MatchOutcome("Bob", "loss", 30)))

);

Example Output:

groupMatchOutcomesByResult(players, "Alice"); // Returns: {"win": [MatchOutcome("Bob", "win", 50)], "loss": [MatchOutcome("Charlie", "loss", 30)]}

averageScoreByResult(players, "Alice"); // Returns: {"win": 50.0, "loss": 30.0}

1 vulnerability

Task 3

Topic: Stream Performance

Background: The gaming company wants to optimize the performance of their live game statistics feature. They want to use the Stream API to process large amounts of in-game data efficiently.

Functionality 1: Implement a method `topScoringPlayersParallel(List<Player> players, int n)` that returns a list of the top n players with the highest scores. The method should use the parallel Stream API to sort the players by score in descending order and limit the stream to the top n players.

Functionality 2: Implement a method `playerWinPercentageParallel(List<Player> players, String playerName)` that calculates and returns the win percentage (as a double) of a specified player. The method should use the parallel Stream API to filter the matches of the specified player, count the number of wins, and calculate the win percentage.

Example Input:

List<Player> players = new ArrayList<>();

for (int i = 0; i < 1000000; i++) {

    players.add(new Player("Player" + i, i, Arrays.asList(new MatchOutcome("Opponent" + i, "win", i))));

}

Example Output:

topScoringPlayersParallel(players, 5); // Returns: ["Player999999", "Player999998", "Player999997", "Player999996", "Player999995"]

playerWinPercentageParallel(players, "Player500000"); // Returns: 100.0

Task 4

Topic: Error Handling Strategies

Background: The gaming company wants to ensure that their live game statistics feature is robust and can handle unexpected situations gracefully. They want to use the Stream API to process in-game data and handle potential errors.

Functionality 1: Implement a method `safeTopScoringPlayers(List<Player> players, int n)` that returns a list of the top n players with the highest scores. The method should use the Stream API to sort the players by score in descending order and limit the stream to the top n players. If an error occurs during processing, the method should return an empty list.

Functionality 2: Implement a method `safePlayerWinPercentage(List<Player> players, String playerName)` that calculates and returns the win percentage (as a double) of a specified player. The method should use the Stream API to filter the matches of the specified player, count the number of wins, and calculate the win percentage. If an error occurs during processing, the method should return 0.0.

Functionality 3: Implement a method `safeAverageScoreByResult(List<Player> players, String playerName)` that returns a Map where the keys are match results ("win", "loss", "draw") and the values are the average scores for each group. The method should use the Stream API to filter the matches of the specified player, group them by result, and calculate the average score for each group. If an error occurs during processing, the method should return an empty map.

Example Input:

List<Player> players = Arrays.asList(

    new Player("Alice", 100, Arrays.asList(new MatchOutcome("Bob", "win", 50), new MatchOutcome("Charlie", "loss", 30))),

    new Player("Bob", 80, Arrays.asList(new MatchOutcome("Alice", "loss", 50), new MatchOutcome("Charlie", "win", 30))),

    new Player("Charlie", 90, Arrays.asList(new MatchOutcome("Alice", "win", 50), new MatchOutcome("Bob", "loss", 30)))

);

Example Output:

safeTopScoringPlayers(players, 2); // Returns: ["Alice", "Charlie"]

safePlayerWinPercentage(players, "Alice"); // Returns: 50.0

safeAverageScoreByResult(players, "Alice"); // Returns: {"win": 50.0, "loss": 30.0}