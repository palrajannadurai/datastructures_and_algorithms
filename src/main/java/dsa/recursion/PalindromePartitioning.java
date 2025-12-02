package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    static void backtrack(String s, List<List<String>> result, List<String> current, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    current.add(s.substring(start, i + 1));
                    backtrack(s, result, current, i + 1);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
