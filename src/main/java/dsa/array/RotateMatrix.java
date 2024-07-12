package com.dsa.array;

public class RotateMatrix {

    private static void transpose(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            /*
            * We iterate over the upper triangle of the matrix (excluding the diagonal),
            *       which means we only consider elements where the row index is less than the column index.
            * In this example, we iterate over the elements (0, 1), (0, 2), and (1, 2).
            * we can reduce the number of swaps
            * */
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverse(int[] nums) {
        int right = 0;
        int left = nums.length - 1;
        while (right < left) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right++;
            left--;
        }
    }

    static void rotate(int[][] matrix) {
        transpose(matrix, matrix.length, matrix[0].length);
        for (int[] i : matrix) {
            reverse(i);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }

}
