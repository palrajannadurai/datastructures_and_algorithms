package com.dsa.string;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] frequency = new char[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            frequency[t.charAt(i) - 'a']--;
        }
        for (char c : frequency) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "cat";
        String b = "act";
        System.out.println(isAnagram(a, b));
    }
}
