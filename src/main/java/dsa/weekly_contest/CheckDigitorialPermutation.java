package dsa.weekly_contest;

// https://leetcode.com/problems/check-digitorial-permutation/description/

public class CheckDigitorialPermutation {

    private static final int[] fact = new int[10];

    static {
        fact[0] = 1;
        for (int i = 1; i < 10; i++) {
            fact[i] = i * fact[i - 1];
        }
    }

    public boolean isDigitorialPermutation(int n) {
        int sum = 0;
        int original = n;
        while (n > 0) {
            int digit = n % 10;
            sum += fact[digit];
            n /= 10;
        }
        return isPermutation(sum, original);
    }

    private boolean isPermutation(int a, int b) {
        int[] count = new int[10];
        while (a > 0) {
            count[a % 10]++;
            a /= 10;
        }
        while (b > 0) {
            count[b % 10]--;
            b /= 10;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
