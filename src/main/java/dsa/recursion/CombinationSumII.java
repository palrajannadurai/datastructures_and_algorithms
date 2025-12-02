package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if ( i > start && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, result, current, i + 1, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, result, new ArrayList<>(), 0, target);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
