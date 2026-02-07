package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RatInMaze {

    static class Direction {
        private final int row;
        private final int col;
        private final char direction;

        public Direction(int row, int col, char direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public char getDirection() {
            return direction;
        }
    }

    private static final List<Direction> DIRECTION_LIST = Arrays.asList(
            new Direction(1, 0, 'D'),
            new Direction(-1, 0, 'U'),
            new Direction(0, -1, 'L'),
            new Direction(0, 1, 'R')
    );

    public List<String> ratInMaze(int[][] maze) {
        final int n = maze.length;
        List<String> res = new ArrayList<>();
        // check start and end cell is blocked or not?
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return res;
        }
        // we can't revisit the same path so track the visited path
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        dfs(maze, 0, 0, n, new StringBuilder(), visited, res);
        // we need lexicographical order
        Collections.sort(res);
        return res;
    }

    private void dfs(int[][] maze, int row, int col, int n, StringBuilder path, boolean[][] visited, List<String> res) {
        if (row == n - 1 && col == n - 1) {
            res.add(path.toString());
            return;
        }
        visited[row][col] = true;
        for (Direction direction : DIRECTION_LIST) {
            if (isValid(maze, row + direction.getRow(), col + direction.getCol(), n, visited)) {
                dfs(maze,
                        row + direction.getRow(),
                        col + direction.getCol(),
                        n,
                        path.append(direction.getDirection()),
                        visited,
                        res);
                path.deleteCharAt(path.length() - 1);
            }
        }
        visited[row][col] = false;
    }

    private boolean isValid(int[][] maze, int row, int col, int n, boolean[][] visited) {
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
