package dsa.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        Map<Character, Integer> idx = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (idx.containsKey(c)) {
                // To make sure the left idx always moves forward we need to take max always
                left = Math.max(left, idx.get(c) + 1);
            }
            idx.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
