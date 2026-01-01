package dsa.array;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[i + 1]) {
                nums[counter++] = nums[i+1];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
//        Output: 2, nums = [1,2,_]

    }
}
