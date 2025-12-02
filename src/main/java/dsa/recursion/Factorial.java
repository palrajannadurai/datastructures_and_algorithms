package dsa.recursion;

public class Factorial {
    public static int factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // recurrence relation
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
