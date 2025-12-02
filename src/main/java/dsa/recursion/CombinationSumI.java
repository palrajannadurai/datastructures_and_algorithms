package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            // we should not use i + 1, because we can't reuse the same elements
            backtrack(nums, result, current, i, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, result, new ArrayList<>(), 0, target);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
