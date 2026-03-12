package dsa.array;

import java.util.ArrayList;
import java.util.List;

public class MergeAdjacentEqualElements {
    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 2};
        System.out.println(new MergeAdjacentEqualElements().mergeAdjacent(nums));
    }

    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> integers = new ArrayList<>();
        for (int n : nums) integers.add((long) n);

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < integers.size() - 1; i++) {
                if (integers.get(i).equals(integers.get(i + 1))) {
                    long merged = integers.get(i) + integers.get(i + 1);
                    integers.set(i, merged);
                    integers.remove(i + 1);
                    changed = true;
                    break;
                }
            }
        }
        return integers;
    }
}
