package dsa.array;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSumBF(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] != target) {
                            continue;
                        }
                        List<Integer> current = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        // sorting makes logically same qudrables looks exactly same in the memory
                        Collections.sort(current);
                        //  iterate the entire array same value present in the same index
                        if (!result.contains(current)) {
                            result.add(current);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        // Sort the array to:
        // 1) Use two-pointer technique
        // 2) Easily skip duplicates
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // Pointer i → first element of quadruplet
        for (int i = 0; i < n; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pointer j → second element of quadruplet
            for (int j = i + 1; j < n; j++) {

                // Skip duplicate values for j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Pointer start → third element (moves forward)
                int start = j + 1;

                // Pointer end → fourth element (moves backward)
                int end = n - 1;

                // Two-pointer search between start and end
                while (start < end) {

                    // Calculate sum of current quadruplet
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];

                    if (sum == target) {

                        // Valid quadruplet found
                        result.add(Arrays.asList(
                                nums[i],     // fixed by i
                                nums[j],     // fixed by j
                                nums[start], // current start pointer
                                nums[end]    // current end pointer
                        ));

                        // Move both pointers to find next possible pair
                        start++;
                        end--;

                        // Skip duplicate values for start pointer
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }

                        // Skip duplicate values for end pointer
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }

                    } else if (sum < target) {
                        // Sum too small → move start forward to increase sum
                        start++;
                    } else {
                        // Sum too large → move end backward to decrease sum
                        end--;
                    }
                }
            }
        }
        // Return all unique quadruplets
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
