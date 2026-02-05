package dsa.array;

public class WordSearch {

    private static final int ASCII_SIZE = 128;
    private static final int XOR_MASK = 256;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        final int row = board.length;
        final int col = board[0].length;

        if (row * col < word.length()) return false;

        int[] freq = new int[ASCII_SIZE];
        for (char[] r : board) {
            for (char c : r) {
                freq[c]++;
            }
        }
        for (char c : word.toCharArray()) {
            if (--freq[c] < 0) {
                return false;
            }
        }

        if (freq[word.charAt(0)] > freq[word.charAt(word.length() - 1)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (word.charAt(index) != board[row][col]) {
            return false;
        }
        board[row][col] ^= XOR_MASK;

        for(int[] direction: DIRECTIONS) {
            if (dfs(board, word, row + direction[0], col + direction[1], index + 1)) {
                board[row][col] ^= XOR_MASK;
                return true;
            }
        }
        board[row][col] ^= XOR_MASK;
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println( new WordSearch().exist(board, word));
    }
}
