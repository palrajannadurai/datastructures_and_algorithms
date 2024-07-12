package com.dsa.string;

public class ATOI {

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (!Character.isWhitespace(s.charAt(i))) {
                break;
            }
            i++;
        }
        if (i == n) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i++) - '0');
            if (result >= Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) result * sign;
    }

    public static void main(String[] args) {
//        String s = "-91283472332";
        String s = " ";
        System.out.println(myAtoi(s));
    }
}
