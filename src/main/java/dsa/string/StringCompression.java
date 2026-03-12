package dsa.string;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(new StringCompression().compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        final int n = chars.length;
        while (read < n) {
            char current = chars[read];
            int count = 0;
            while (read < n && current == chars[read]) {
                count++;
                read++;
            }
            chars[write++] = current;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}
