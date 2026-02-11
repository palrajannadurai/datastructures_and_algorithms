package dsa.array;

public class Triangles {

    static int findNumberOfTriangles(int[] nums) {
        final int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] > nums[k]
                    && nums[j] + nums[k] > nums[i]
                    && nums[k] + nums[i] > nums[j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 9, 7, 8};
        System.out.println(findNumberOfTriangles(nums));
    }
}
