import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int n = basket1.length;

        for (int i = 0; i < n; i++) {
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
        }

        List<Integer> swapList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                swapList.add(entry.getKey());
            }
        }

        Collections.sort(swapList);
        int minVal = Math.min(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt());
        long cost = 0;
        for (int i = 0; i < swapList.size() / 2; i++) {
            cost += Math.min(swapList.get(i), 2 * minVal);
        }

        return cost;
    }
}

