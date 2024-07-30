Task 1

Background: You are given a list of Player objects. Each Player has a name, a list of Game objects, and each Game has a list of Performance objects. Each Performance object has a timestamp and a score.

Your task is to implement two methods:

1. `findTopPerformers(List<Player> players, int n)`: This method should return a list of the top 'n' players who have the highest average score across all their games. The average score of a player is calculated by averaging the scores of all performances in all games of the player.
    
2. `findMostConsistentPlayers(List<Player> players, int n)`: This method should return a list of 'n' players who have the least standard deviation in their scores across all their games. The standard deviation gives a measure of how much the scores vary from the average score.
    

Example:

Input:

players = [

  Player("Player1", [Game([Performance("2022-01-01", 10), Performance("2022-01-02", 20)]), Game([Performance("2022-01-03", 30)])]),

  Player("Player2", [Game([Performance("2022-01-01", 40), Performance("2022-01-02", 50)]), Game([Performance("2022-01-03", 60)])])

]

n = 1

Output:

findTopPerformers(players, n) => ["Player2"]

findMostConsistentPlayers(players, n) => ["Player1"]

Note: For the purpose of this task, you can assume that no two players will have the same average score or standard deviation. You can also assume that 'n' will be less than or equal to the number of players.

Task 2

Topic: Stream Collectors

Background: You are given a list of Team objects. Each Team has a name and a list of Player objects. Each Player has a name and a list of Game objects, and each Game has a list of Performance objects. Each Performance object has a timestamp and a score.

Your task is to implement two methods:

1. `findTopTeams(List<Team> teams, int n)`: This method should return a list of the top 'n' teams who have the highest average score across all their games. The average score of a team is calculated by averaging the scores of all performances in all games of all players in the team.
    
2. `findMostImprovedTeams(List<Team> teams, int n)`: This method should return a list of 'n' teams who have shown the most improvement in their scores over time. The improvement of a team is calculated by finding the difference between the average score of the first half of performances and the second half of performances for all players in the team.
    

Example:

Input:

teams = [

  Team("Team1", [Player("Player1", [Game([Performance("2022-01-01", 10), Performance("2022-01-02", 20)]), Game([Performance("2022-01-03", 30)])])]),

  Team("Team2", [Player("Player2", [Game([Performance("2022-01-01", 40), Performance("2022-01-02", 50)]), Game([Performance("2022-01-03", 60)])])])

]

n = 1

Output:

findTopTeams(teams, n) => ["Team2"]

findMostImprovedTeams(teams, n) => ["Team1"]

Task 3

Topic: Parallel Stream

Background: You are given a list of Match objects. Each Match has a timestamp, a list of Team objects, and each Team has a list of Player objects. Each Player has a name and a list of Performance objects. Each Performance object has a timestamp and a score.

Your task is to implement two methods:

1. `findTopMatches(List<Match> matches, int n)`: This method should return a list of the top 'n' matches which have the highest average score across all teams and players. The average score of a match is calculated by averaging the scores of all performances in all teams in the match.
    
2. `findMostExcitingMatches(List<Match> matches, int n)`: This method should return a list of 'n' matches which have the highest standard deviation in their scores across all teams and players. The standard deviation gives a measure of how much the scores vary from the average score.
    

Example:

Input:

matches = [

  Match("2022-01-01", [Team("Team1", [Player("Player1", [Game([Performance("2022-01-01", 10), Performance("2022-01-02", 20)]), Game([Performance("2022-01-03", 30)])])])]),

  Match("2022-01-02", [Team("Team2", [Player("Player2", [Game([Performance("2022-01-01", 40), Performance("2022-01-02", 50)]), Game([Performance("2022-01-03", 60)])])])])

]

n = 1

Output:

findTopMatches(matches, n) => ["2022-01-02"]

findMostExcitingMatches(matches, n) => ["2022-01-01"]

Task 4

Topic: Error Handling Strategies

Background: You are given a list of Season objects. Each Season has a year, a list of Match objects, and each Match has a timestamp, a list of Team objects, and each Team has a list of Player objects. Each Player has a name and a list of Performance objects. Each Performance object has a timestamp and a score.

Your task is to implement three methods:

1. `findTopSeasons(List<Season> seasons, int n)`: This method should return a list of the top 'n' seasons which have the highest average score across all matches, teams, and players. The average score of a season is calculated by averaging the scores of all performances in all matches in the season.
    
2. `findMostExcitingSeasons(List<Season> seasons, int n)`: This method should return a list of 'n' seasons which have the highest standard deviation in their scores across all matches, teams, and players. The standard deviation gives a measure of how much the scores vary from the average score.
    
3. `findMostImprovedSeasons(List<Season> seasons, int n)`: This method should return a list of 'n' seasons which have shown the most improvement in their scores over time. The improvement of a season is calculated by finding the difference between the average score of the first half of matches and the second half of matches for all teams and players in the season.
    

Example:

Input:

seasons = [

  Season("2022", [Match("2022-01-01", [Team("Team1", [Player("Player1", [Game([Performance("2022-01-01", 10), Performance("2022-01-02", 20)]), Game([Performance("2022-01-03", 30)])])])]),

  Season("2023", [Match("2023-01-01", [Team("Team2", [Player("Player2", [Game([Performance("2023-01-01", 40), Performance("2023-01-02", 50)]), Game([Performance("2023-01-03", 60)])])])])

]

n = 1

Output:

findTopSeasons(seasons, n) => ["2023"]

findMostExcitingSeasons(seasons, n) => ["2022"]

findMostImprovedSeasons(seasons, n) => ["2023"]