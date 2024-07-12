package com.dsa.string;

public class ReverseString {

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                result.append(words[i]).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String s = "example good a";
        System.out.println(reverseWords(s));
    }

}
