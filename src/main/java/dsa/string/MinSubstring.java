package dsa.string;

import java.util.HashSet;
import java.util.Set;

public class MinSubstring {

    private boolean hasAllCharacters(String s, int start, int end, int[] tFreq) {
        int[] sFreq = new int[128];
        for (int i = start; i <= end; i++) {
            sFreq[s.charAt(i)]++;
        }
        for (int i = 0; i < sFreq.length; i++) {
            if (tFreq[i] > sFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public int minWindowBF(String s, String t) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        final int n = s.length();
        Set<Character> uniqueCharacters = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueCharacters.add(s.charAt(i));
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Character> curr = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (j - i + 1 < uniqueCharacters.size()) {
                    continue;
                }
                for (int k = i; k <= j; k++) {
                    curr.add(s.charAt(k));
                    if (uniqueCharacters.size() == curr.size()) {
                        min = Math.min(min, j - i + 1);
                        System.out.println(s.substring(i, j + 1) + " " + (j - i +1));
                    }
                }
            }
        }
        return min;
    }


    public String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int left = 0;
        int formed = 0;
        int required = t.length();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int[] windowFreq = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(left);
            if (tFreq[c] > 0 && windowFreq[c] < tFreq[c]) {
                formed++;
            }
            windowFreq[c]++;
            if (formed == required) {
                System.out.println(s.substring(left, right));
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "AAAAABBBCD";
        System.out.println(new MinSubstring().minWindowBF(s, "ABC"));
    }
}
