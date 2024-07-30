package algorithms.exercise7_RecursionAndBacktracking.scenario3;

public class NQueens {
    // AI Helped with base case and recursive method call in correct place
    private static boolean placeQueens(boolean[][] board, int row) {

        if (row == board.length)
            return true;
        
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = true;
                if (placeQueens(board, row + 1))
                    return true;
            }
            board[row][i] = false;
        }
        return false;
    }

    // Ai copied - my implementation was wrong
    private static boolean isSafe(boolean[][] board, int row, int col) {

        // Check row on the left side
        for (int j = 0; j < col; j++) {
            if (board[row][j])
                return false;
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j])
                return false;
        }

        return false;
    }

    public static void solveNQueens(int N) {
        boolean[][] board = new boolean[N][N];

        if (placeQueens(board, 0))
            printBoard(board);
        else
            System.out.println("No solution");
    }

    private static void printBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j])
                    System.out.println("Q ");
                else 
                    System.out.println(". ");
            }
            System.out.println();
        }
    }
}
