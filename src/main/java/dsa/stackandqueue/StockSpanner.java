package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class StockSpanner {

    private Deque<int[]> deque;

    public StockSpanner() {
        deque = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!deque.isEmpty() && deque.peek()[0] <= price) {
            span = deque.pop()[1] + 1;
        }
        deque.push(new int[]{price, span});
        return span;
    }

    public int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = -1;
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
            if(kv.getValue() == 1) {
                res = kv.getValue();
            }
        }
        return res;
    }
}