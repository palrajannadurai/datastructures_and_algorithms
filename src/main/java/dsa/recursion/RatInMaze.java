package dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class RatInMaze {

    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static final char[] DIRS = {'D', 'R', 'U', 'L'};
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return res;
        }
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        dfs(maze, 0, 0, n, new StringBuilder(), visited);
        Collections.sort(res);
        return res;
    }

    private void dfs(int[][] maze, int row, int col, int n, StringBuilder path, boolean[][] visited) {
        if (row == n - 1 && col == n - 1) {
            res.add(path.toString());
            return;
        }
        visited[row][col] = true;
        for (int i = 0; i < DX.length; i++) {
            int newRow = row + DX[i];
            int newCol = col + DY[i];
            if (isValid(newRow, newCol, n, visited, maze)) {
                path.append(DIRS[i]);
                dfs(maze, newRow, newCol, n, path, visited);
                path.deleteCharAt(path.length() - 1);
            }
        }
        visited[row][col] = false;
    }

    private boolean isValid(int row, int col, int n, boolean[][] visited, int[][] maze) {
        return row >= 0 && row < n && col >= 0 && col < n && !visited[row][col] && maze[row][col] == 1;
    }


    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(new RatInMaze().ratInMaze(maze));
    }
}
