package com.dsa.string;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int index = 0;
        for (char c : t.toCharArray()) {
            if (t.charAt(index) == c) {
                index++;
                if (index == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
