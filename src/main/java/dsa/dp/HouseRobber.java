package dsa.dp;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        final int n = nums.length;
        int twoHouseBack = nums[0];
        int oneHouseBack = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int current = Math.max(oneHouseBack, nums[i] + twoHouseBack);
            twoHouseBack = oneHouseBack;
            oneHouseBack = current;
        }
        return Math.max(oneHouseBack, twoHouseBack);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new HouseRobber().rob(nums));
    }
}
