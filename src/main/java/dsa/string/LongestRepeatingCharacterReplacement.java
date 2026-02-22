package dsa.string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacementBF(String s, int k) {
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

    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }

}
