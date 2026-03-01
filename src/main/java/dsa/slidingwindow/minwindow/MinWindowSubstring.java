package dsa.slidingwindow.minwindow;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        for (char c: t.toCharArray()) {
            tFreq[c]++;
        }
        int formed = 0, required = t.length();
        int minLen = Integer.MAX_VALUE, start = 0, left = 0;
        int[] sFreq = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (tFreq[curr] > 0 && sFreq[curr] < tFreq[curr]) {
                formed++;
            }
            sFreq[curr]++;
            while (formed == required) {
                int windowLength = right - left + 1;
                if (windowLength < minLen) {
                    minLen = windowLength;
                    start = left;
                }
                char leftChar = s.charAt(left);
                sFreq[leftChar]--;
                if (tFreq[leftChar] > 0 && sFreq[leftChar] < tFreq[leftChar]) {
                    formed--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinWindowSubstring().minWindow(s, t));
    }
}
