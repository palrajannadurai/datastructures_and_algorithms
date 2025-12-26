package dsa.array;

public class UniquePaths {

    static long nCr(int n, int r) {
        r = Math.min(r, n-r);
        long result = 1;
        for (int i = 1; i <= r ; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int requiredDownMoves = m - 1;
        int requiredRightMoves = n - 1;
        int totalMoves = requiredDownMoves + requiredRightMoves;
        return Math.toIntExact(nCr(totalMoves, requiredDownMoves));
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 7));
    }
}
