package dsa.string;

public class LongestAlmostPalindromicSubstring {

    Boolean[][] memo;

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(new LongestAlmostPalindromicSubstring().almostPalindromic(s));
    }

    public int almostPalindromic(String s) {
        int maxLen = 0;
        final int n = s.length();
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (end - start + 1 > 2 && isAlmostPalindrome(s, start, end)) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

    private boolean isAlmostPalindrome(String s, int start, int end) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                memo[start][end] = isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
                return memo[start][end];
            }
        }
        memo[start][end] = true;
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
