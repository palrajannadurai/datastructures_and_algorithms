package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

    static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int start) {
        result.add(new ArrayList<>(current)); // Every state of my current list — empty or partial — is a valid subset
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i -1]) { // we will make sure the first occurrence is always used
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, result, current, i + 1);
            current.remove(current.size() - 1);  // Remove from the current list
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;

    }

    // if we want to remove duplicates subset

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
