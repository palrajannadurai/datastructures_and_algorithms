package dsa.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequenceV1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n] + 1;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(0, 0, text1, text2);
    }

    private int dfs(int i, int j, String text1, String text2) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + dfs(i + 1, j + 1, text1, text2);
        }
        return Math.max(dfs(i + 1, j, text1, text2), dfs(i, j + 1, text1, text2));
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
    }
}
