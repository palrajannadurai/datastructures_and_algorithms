package com.dsa.string;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        Arrays.sort(strs);
        String firstWord = strs[0], lastWord = strs[strs.length - 1];

        int index = 0;
        while (index < firstWord.length()) {
            if (firstWord.charAt(index) != lastWord.charAt(index)) {
                break;
            }
            index++;
        }
        return index == 0 ? "" : firstWord.substring(0, index);
    }

    public static void main(String[] args) {
        String[] words = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(words));
    }
}
