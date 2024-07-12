package com.dsa.string;

/*
* Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it.
* If it is impossible for b to be a substring of a after repeating it, return -1.
Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
Example 2:
Input: a = "a", b = "aa"
Output: 2
* */
public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.indexOf(b) != -1) {
            return count;
        }
        sb.append(a);
        count++;

        if (sb.indexOf(b) == -1) {
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }
}
