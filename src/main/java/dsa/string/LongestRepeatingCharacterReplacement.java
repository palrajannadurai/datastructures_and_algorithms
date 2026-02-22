package dsa.string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        final int n = s.length();
        int maxLen = 0;
        for (int start = 0; start < n; start++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            if (n - start <= maxLen) {
                break;
            }
            for (int end = start; end < n; end++) {
                freq[s.charAt(end) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(end) - 'A']);
                int windowSize = end - start + 1;
                if (windowSize - maxFreq <= k) {
                    maxLen = Math.max(maxLen, windowSize);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }

}
