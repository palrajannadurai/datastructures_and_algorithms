package dsa.string;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharacter {
    private static final int NO_OF_CHARACTERS = 26;
    public int firstUniqChar(String s) {
        int[] freq = new int[NO_OF_CHARACTERS];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    private int firstUniqueChar(String s) {
        Optional<Character> firstUniqueChar =
                    s.chars().mapToObj(c -> (char) c)
                            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                            .entrySet()
                            .stream()
                            .filter( entry -> entry.getValue() == 1)
                            .map(Map.Entry::getKey).findFirst();
        return firstUniqueChar.isPresent() ? firstUniqueChar.get() : -1;
    }

    public static void main(String[] args) {
        String str = "llve";
        System.out.println(new FirstUniqueCharacter().firstUniqueChar(str));
    }
}
