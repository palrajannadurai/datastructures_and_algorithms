package dsa.array;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean hasFirstColumnsContainsZero = false;
        boolean hasFirstRowContainsZero = false;

        for (int row : matrix[0]) {
            if (row == 0) {
                hasFirstRowContainsZero = true;
                break;
            }
        }

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                hasFirstColumnsContainsZero = true;
                break;
            }
        }
//        m = 3 - 1= 2
//        n = 4 - 1 = 3
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (hasFirstColumnsContainsZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (hasFirstRowContainsZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 2, 8},
                {3, 4, 5, 2},
                {1, 3, 1, 0}
        };
/*        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };*/
        for (int[] nums: matrix) {
            System.out.println(Arrays.toString(nums));
        }
        System.out.println("*********************");
        setZeroes(matrix);
        for (int[] nums: matrix) {
            System.out.println(Arrays.toString(nums));
        }

//        Integer.valueOf()
    }
}

