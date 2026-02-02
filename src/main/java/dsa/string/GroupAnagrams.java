package dsa.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            String key = getCountKey(str);
            res.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(res.values());
    }

    private String getCountKey(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for (int i : count) {
            key.append('#').append(i);
        }
        return key.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}
