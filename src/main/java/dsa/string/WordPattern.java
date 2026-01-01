package dsa.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    public boolean wordPatternBF(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                   return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        final int patternLength = pattern.length();
        if (words.length != patternLength) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < patternLength; i++) {
          char c = pattern.charAt(i);
          String word = words[i];
          if (!Objects.equals(map.put(word, i), map.put(c, i))) {
              return false;
          }
        }
        return true;
    }

    public static void main(String[] args) {
        /*Example 1:
            Input: pattern = "abba", s = "dog cat cat dog"
            Output: true
         */
//        String pattern = "abba";
//        String s =
    }
}
