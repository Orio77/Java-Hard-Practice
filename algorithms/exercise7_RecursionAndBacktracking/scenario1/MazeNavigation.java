package algorithms.exercise7_RecursionAndBacktracking.scenario1;
// AI Copied
public class MazeNavigation {
    int[][] maze;
    int[][] solution;

    public MazeNavigation(int[][] maze) {
        this.maze = maze;
        this.solution = new int[maze.length][maze[0].length];
    }

    public boolean navigateMaze(int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(x, y)) {
            solution[x][y] = 1;

            if (navigateMaze(x + 1, y))
                return true;

            if (navigateMaze(x, y + 1))
                return true;

            solution[x][y] = 0;
                return false;
        }
        return false;
    }

    private boolean isSafe(int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
    }
}
