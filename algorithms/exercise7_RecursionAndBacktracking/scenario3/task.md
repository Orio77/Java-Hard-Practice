**Scenario:** "The Royal Chessboard"

**Task 1:** Implement a function `place_queens(board, row)` that uses recursion and backtracking to place queens on an N x N chessboard such that no two queens threaten each other. The `board` parameter is a 2D list representing the chessboard, and `row` is the current row where a queen is being placed.

**Potential Input:** A 4x4 empty chessboard (represented as a 2D list filled with 0s), and row = 0.

**Desired Output:** A 4x4 chessboard with queens placed such that no two queens threaten each other.

**Coach Suggestions:** Start by placing a queen in the first row. Then recursively call `place_queens` for the next row. If no safe spot is found in a row, backtrack by returning false. If a safe spot is found for all queens, return true.

---

**Task 2:** Implement a function `is_safe(board, row, col)` that checks if a queen can be placed at board[row][col] without threatening any other queen.

**Potential Input:** A chessboard with a queen placed at (0, 0), and row = 1, col = 0.

**Desired Output:** False (since placing a queen at (1, 0) would threaten the queen at (0, 0)).

**Coach Suggestions:** Check the current column, the diagonals, and the row to the left. If any of these have a queen, return false. Otherwise, return true.

---

**Task 3:** Implement a function `solve_N_queens(N)` that uses `place_queens` and `is_safe` to solve the N-Queens problem. It should print all solutions.

**Potential Input:** N = 4

**Desired Output:** All solutions to the 4-Queens problem.

**Coach Suggestions:** Initialize an N x N chessboard. Call `place_queens` for the first row. If `place_queens` returns true, print the board. If it returns false, there is no solution.