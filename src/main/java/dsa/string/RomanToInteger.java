package com.dsa.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInteger {
    private static Map<Character, Integer> romans = new LinkedHashMap<>();
    static {
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romans.get(s.charAt(i)) < romans.get(s.charAt(i + 1))) {
                result -= romans.get(s.charAt(i));
            } else {
                result += romans.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }
}
