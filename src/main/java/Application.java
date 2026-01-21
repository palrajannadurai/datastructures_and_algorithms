import java.util.*;
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


    public static void main(String[] args) {
        int n = 15;
        System.out.println((n & 1) == 1 ? "ODD" : "EVEN");
    }

}
