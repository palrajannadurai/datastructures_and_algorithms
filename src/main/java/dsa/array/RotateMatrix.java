package dsa.array;

public class RotateMatrix {

    private static void reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void rotate(int[][] matrix) {
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //        rotate(arr);
        for (int[] ints : arr) {
            //            for (int j = 0; j < arr.length; j++) {
            //                System.out.print(ints[j] + " ");
            //            }
            reverse(ints);
            System.out.println(ints);
        }
    }
}
