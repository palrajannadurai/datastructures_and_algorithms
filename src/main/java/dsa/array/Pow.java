package dsa.array;

public class Pow {
    public double myPow(double x, int n) {
        long exp = n;
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        double result = 1.0;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= x;
            }
            x *= x;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2, 10));
    }
}
