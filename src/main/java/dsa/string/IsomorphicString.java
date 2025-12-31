package dsa.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char tc = t.charAt(i);
            char sc = s.charAt(i);
            if (map.containsKey(sc)) {
                if (map.get(sc) != tc) {
                    return false;
                }
            } else {
                if (used.contains(tc)) {
                    return false;
                }
                map.put(sc, tc);
                used.add(tc);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s, t));
    }
}
