package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    private void backtrack(int[] candidates, int start, int target, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSumI().combinationSum(candidates, target));
    }
}
