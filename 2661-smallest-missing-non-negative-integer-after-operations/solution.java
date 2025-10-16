class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Step 1: Count frequencies of normalized remainders
        for (int num : nums) {
            int mod = ((num % value) + value) % value; // normalize negatives
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
        }

        // Step 2: Find smallest missing integer
        int i = 0;
        while (true) {
            int mod = i % value;
            int count = freq.getOrDefault(mod, 0);
            if (count == 0) return i;
            freq.put(mod, count - 1);
            i++;
        }
    }
}

