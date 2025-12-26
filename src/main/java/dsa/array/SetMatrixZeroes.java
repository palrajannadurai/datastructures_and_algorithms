package dsa.array;

import java.util.Arrays;

public class SetMatrixZeroes {
    // Method to set zeroes in the matrix based on the positions of zeros
//    public static void setZeroes(int[][] matrix) {
//        // Check if the matrix is empty or has no rows/columns
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return; // If so, return without modifying the matrix
//        }
//
//        int rowLength = matrix.length;
//        int columnLength = matrix[0].length;
//
//        // Arrays to track which rows and columns contain zeros
//        int[] row = new int[rowLength];
//        int[] column = new int[columnLength];
//
//        // Loop through the matrix to identify zeros and mark their rows and columns
//        for (int i = 0; i < rowLength; i++) {
//            for (int j = 0; j < columnLength; j++) {
//                if (matrix[i][j] == 0) {
//                    row[i] = 1; // Mark the row
//                    column[j] = 1; // Mark the column
//                }
//            }
//        }
//
//        // Loop through the matrix again to set zeros in rows and columns based on the tracking arrays
//        for (int i = 0; i < rowLength; i++) {
//            for (int j = 0; j < columnLength; j++) {
//                if (row[i] == 1 || column[j] == 1) {
//                    matrix[i][j] = 0; // Set the element to zero if its row or column contains a zero
//                }
//            }
//        }
//    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean hasFirstRowContainsZero = false;
        boolean hasFirstColumnContainsZero = false;

        // 1. check first row has zero
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                hasFirstRowContainsZero = true;
                break;
            }
        }

        // 2. check first column has zero
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                hasFirstColumnContainsZero = true;
                break;
            }
        }

        // 3. Use first row and column as a marker
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

        if (hasFirstRowContainsZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (hasFirstColumnContainsZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println("hasFirstRowContainsZero : " + hasFirstRowContainsZero);
        System.out.println("hasFirstColumnContainsZero : " + hasFirstColumnContainsZero);
    }

    public static void main(String[] args) {
//        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

