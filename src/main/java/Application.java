import sun.applet.AppletListener;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Application {
    private static void lengthOfLastWord(String s) {
        Map<Character, Integer> numbers = new LinkedHashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            Character cc = s.charAt(i);
            if (numbers.containsKey(cc)) {
                numbers.put(cc, numbers.get(cc) + 1);
            } else {
                numbers.put(cc, 1);
            }
        }
        System.out.println(numbers);
    }

    public static int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = -1;
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            if (kv.getValue() == 1) {
                res = kv.getKey();
                break;
            }
        }
        return res;
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1],  b[1]));
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int[] pair: pairs) {
            int left = pair[0];
            int right = pair[1];
            if (left > lastEnd) {
                count++;
                lastEnd = right;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new Application().findLongestChain(pairs));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        Integer max = nums.stream().max(Integer::compareTo).orElse(null);
        System.out.println(max);
    }

}
