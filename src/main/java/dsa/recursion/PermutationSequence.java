package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        StringBuilder sb =  new StringBuilder();
        for (int i = n; i > 0; i--) {
            int idx = k / factorial[i-1];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k = k % factorial[i-1];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(
                getPermutation(n, k)
        );
    }
}
