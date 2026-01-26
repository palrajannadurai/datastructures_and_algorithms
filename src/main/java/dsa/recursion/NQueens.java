package dsa.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class NQueens {
    private final List<List<String>> result = new ArrayList<>();
    private final Set<Integer> columns = new HashSet<>();
    private final Set<Integer> mainDiagonal = new HashSet<>();
    private final Set<Integer> antiDiagonal = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(x -> Arrays.fill(x, '.'));
        backtrack(0, n, board);
        return result;
    }

    private void backtrack(int row, int n, char[][] board) {
        if (row == n) {
            result.add(Arrays.stream(board)
                    .map(String::new)
                    .collect(Collectors.toList()));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (columns.contains(col) || mainDiagonal.contains(row - col) || antiDiagonal.contains(row + col)) {
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
