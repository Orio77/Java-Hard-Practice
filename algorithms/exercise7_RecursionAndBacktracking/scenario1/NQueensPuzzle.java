package algorithms.exercise7_RecursionAndBacktracking.scenario1;
// AI Copied
public class NQueensPuzzle {
    private int n;

    public NQueensPuzzle(int queens) {
        n = queens;
    }

    public void solve() {
        boolean[][] board = new boolean[n][n];
        placeQueens(board, 0);
    }

    private boolean placeQueens(boolean[][] board, int row) {

        if (row == board.length) {
            printBoard(board);
            System.out.println();
            return true;
        }

        boolean result = false;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                result = placeQueens(board, row + 1) || result;
                board[row][col] = false;
            }
        }

        return result;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false; // Queen in the same collumn
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false; // Queen in left diagonal
        }

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j])
                return false; // Queen in right diagonal
        }

        return true;
    }

    private void printBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.println(board[i][j] ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[]args) {
        NQueensPuzzle queen = new NQueensPuzzle(4);
        queen.solve();
    } 
}
