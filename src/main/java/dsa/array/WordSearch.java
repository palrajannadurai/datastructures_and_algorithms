package dsa.array;

public class WordSearch {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;

        if (m * n < word.length()) return false;

        int[] freq = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                freq[c]++;
            }
        }
        for (char c : word.toCharArray()) {
            if (--freq[c] < 0) {
                return false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        board[i][j] ^= 256;
        boolean found = false;
        for(int[] direction: DIRECTIONS) {
            found = dfs(board, word, i + direction[0], j + direction[1], index + 1);
            if (found) break;
        }
        board[i][j] ^= 256;
        return found;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println();
    }
}
