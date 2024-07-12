package com.dsa.array;

import java.util.Arrays;

public class SetMatrixZeroes {
    // Method to set zeroes in the matrix based on the positions of zeros
    public static void setZeroes(int[][] matrix) {
        // Check if the matrix is empty or has no rows/columns
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; // If so, return without modifying the matrix
        }

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        // Arrays to track which rows and columns contain zeros
        int[] row = new int[rowLength];
        int[] column = new int[columnLength];

        // Loop through the matrix to identify zeros and mark their rows and columns
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1; // Mark the row
                    column[j] = 1; // Mark the column
                }
            }
        }

        // Loop through the matrix again to set zeros in rows and columns based on the tracking arrays
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0; // Set the element to zero if its row or column contains a zero
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

