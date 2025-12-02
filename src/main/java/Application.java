import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer i : numbers) {
            System.out.println(i + 1);
        }
//        ReverseLinkedList.reverseList();
    }

}
