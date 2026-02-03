package dsa.string;

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

    public static void main(String[] args) {
        String str = "llve";
        System.out.println(new FirstUniqueCharacter().firstUniqChar(str));
    }
}
