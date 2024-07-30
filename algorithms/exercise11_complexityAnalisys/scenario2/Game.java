package algorithms.exercise11_complexityAnalisys.scenario2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private static final int GRID_SIZE = 10;
    private static final char EMPTY = '.';
    private static final char PLAYER = 'P';
    private static final char ITEM = 'I';
    private static final char OBSTACLE = 'O';

    private char[][] grid;
    private int playerX, playerY;
    private HashMap<Integer, List<Integer>> validMoves;

    public Game() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        validMoves = new HashMap<>();
        ArrayList<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = EMPTY;
                emptyCells.add(new int[]{i, j});
            }
        }

        // Place the player
        playerX = GRID_SIZE / 2;
        playerY = GRID_SIZE / 2;
        grid[playerX][playerY] = PLAYER;
        emptyCells.removeIf(cell -> cell[0] == playerX && cell[1] == playerY);

        // Place items and obstacles
        for (int i = 0; i < GRID_SIZE; i++) {
            if (emptyCells.isEmpty())
                break;
            
            int randomIndex = ThreadLocalRandom.current().nextInt(emptyCells.size());
            int[] cell = emptyCells.remove(randomIndex);
            grid[cell[0]][cell[1]] = (i % 2 == 0) ? ITEM : OBSTACLE;
        }
        getValidMoves();
    }

    public void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;
        if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE) {
            if (grid[newX][newY] != OBSTACLE) {
                grid[playerX][playerY] = EMPTY;
                playerX = newX;
                playerY = newY;
                grid[playerX][playerY] = PLAYER;
            }
        }
    }

    public void movePlayerOptimized(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;
        
        if (isValidMove(dx, dy)) {
            grid[playerX][playerY] = EMPTY;
            playerX = newX;
            playerY = newY;
            grid[playerX][playerY] = PLAYER;
        }
    }

    private boolean isValidMove(int dx, int dy) {

        for (Integer integer : validMoves.get(dx)) {
            if (integer == dy) {
                validMoves.get(dx).remove(dy);
                return true;
            }
        }
        return false;
    }

    private HashMap<Integer, List<Integer>> getValidMoves() {
        LinkedList<Integer> js;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] != OBSTACLE) {
                    js = new LinkedList<>();
                    validMoves.put(i, js);
                    js.add(j);
                }
            }
        }
        return validMoves;
    }

    public void printGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printGrid();
        game.movePlayer(1, 0);
        game.printGrid();
    }
}
