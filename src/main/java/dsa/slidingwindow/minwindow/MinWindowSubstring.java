package dsa.slidingwindow.minwindow;


public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        // creates tFreq array
        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }
        int formed = 0, required = t.length();
        int left = 0, start = 0, minLen = Integer.MAX_VALUE;
        int[] sFreq = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (tFreq[current] > 0 && sFreq[current] < tFreq[current]) {
                formed++;
            }
            sFreq[current]++;
            while (formed == required) {
                int window = right - left + 1;
                if (window < minLen) {
                    start = left;
                    minLen = window;
                }
                char leftChar = s.charAt(left);
                sFreq[leftChar]--;
                if (tFreq[leftChar] > 0 && tFreq[leftChar] > sFreq[leftChar]) {
                    formed--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
