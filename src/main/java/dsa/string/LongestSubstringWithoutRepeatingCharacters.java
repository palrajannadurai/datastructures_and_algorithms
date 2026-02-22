package dsa.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            if (seen.containsKey(curr)) {
                left = Math.max(left, seen.get(curr) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            seen.put(curr, right);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
