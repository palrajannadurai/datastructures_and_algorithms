package com.dsa.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // this wont support if the string contains unicode
    public static boolean isAnagramWithOutUnicode(String s, String t) {
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

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            freq.put(sc, freq.getOrDefault(sc, 0) + 1);
            freq.put(tc, freq.getOrDefault(tc, 0) - 1);
        }
        for (int value: freq.values()) {
            if(value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "cat";
        String b = "rct";
        System.out.println(isAnagram(a, b));
    }
}
