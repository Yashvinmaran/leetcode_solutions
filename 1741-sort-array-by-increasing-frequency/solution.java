import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int a : nums) {
            freqMap.put(a, freqMap.getOrDefault(a, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((e1, e2) -> {
            int cmp = Integer.compare(e1.getValue(), e2.getValue());
            if (cmp == 0)
                return Integer.compare(e2.getKey(), e1.getKey());
            return cmp;
        });

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                nums[idx++] = entry.getKey();
            }
        }

        return nums;
    }
}

