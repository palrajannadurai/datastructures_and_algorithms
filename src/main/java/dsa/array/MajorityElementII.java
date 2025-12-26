package dsa.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int threshold = nums.length / 3;
        List<Integer> majorityElement = new ArrayList<>();

        for (Map.Entry<Integer, Integer> obj: freqMap.entrySet()) {
            if (obj.getValue() > threshold) {
                majorityElement.add(obj.getKey());
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }
}
