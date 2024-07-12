import java.util.*;

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
        System.out.println("Welcome");
    }

}
