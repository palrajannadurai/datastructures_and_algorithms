package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOrange {

    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = prepareInitialState(grid, queue);

        if (freshCount == 0) {
            return 0;
        }
        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] direction: DIRECTIONS) {
                    assert curr != null;
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == FRESH) {
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        grid[newRow][newCol] = ROTTEN;
                    }
                }
            }
            minutes++;
        }
        return freshCount > 0 ? -1 : minutes;
    }

    private int prepareInitialState(int[][] grid, Queue<int[]> q) {
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == FRESH) {
                    freshCount++;
                }
            }
        }
        return freshCount;
    }


    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new RottenOrange().orangesRotting(grid));
    }
}
