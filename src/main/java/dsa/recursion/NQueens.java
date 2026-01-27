package dsa.recursion;

import java.util.*;

public class NQueens {
    private final List<List<String>> result = new ArrayList<>();
    private final Set<Integer> columns = new HashSet<>();
    private final Set<Integer> mainDiagonal = new HashSet<>();
    private final Set<Integer> antiDiagonal = new HashSet<>();

    private char[][] createBoard(int n) {
        char[][] board = new char[n][n];
        for (char[] item: board) {
            Arrays.fill(item, '.');
        }
        return board;
    }

    private boolean isSafe(int row, int col) {
        return !columns.contains(col)
                && !mainDiagonal.contains(row - col)
                && !antiDiagonal.contains(row + col);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = createBoard(n);
        backtrack(0, n, board);
        return result;
    }

    private void construct(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (char[] r: board) {
            temp.add(new String(r));
        }
        result.add(temp);
    }

    private void backtrack(int row, int n, char[][] board) {
        if (row == n) {
            construct(board);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isSafe(row, col)) {
                continue;
            }
            // move forward
            board[row][col] = 'Q';
            columns.add(col);
            mainDiagonal.add(row - col);
            antiDiagonal.add(row + col);
            backtrack(row + 1, n, board);

            // backtrack
            board[row][col] = '.';
            columns.remove(col);
            mainDiagonal.remove(row - col);
            antiDiagonal.remove(row + col);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }

}
