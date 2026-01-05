package dsa.dp;

public class ClimbingStairs {
    public static int climbStairsDP(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(4));
    }
}
