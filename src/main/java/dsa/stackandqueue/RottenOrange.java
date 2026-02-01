package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOrange {

    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = initializeQueue(grid, queue);

        if (freshCount == 0) return 0;

        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (isFresh(grid, newRow, rows, newCol, cols)) {
                        grid[newRow][newCol] = ROTTEN;
                        freshCount--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }

    private static int initializeQueue(int[][] grid, Queue<int[]> queue) {
        int freshCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == ROTTEN) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == FRESH) {
                    freshCount++;
                }
            }
        }
        return freshCount;
    }

    private static boolean isFresh(int[][] grid, int nr, int rows, int nc, int cols) {
        return nr >= 0 &&
                nr < rows &&
                nc >= 0 &&
                nc < cols &&
                grid[nr][nc] == FRESH;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new RottenOrange().orangesRotting(grid));
    }
}
