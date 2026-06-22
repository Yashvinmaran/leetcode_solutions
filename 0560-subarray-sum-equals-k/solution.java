class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        int cnt = 0;
        
        // Map to store (prefix_sum -> frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once (for subarrays starting at index 0)
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            
            // If (prefix - k) exists in the map, it means we found valid subarrays
            if (map.containsKey(prefix - k)) {
                cnt += map.get(prefix - k);
            }
            
            // Record the current prefix sum into the map
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        
        return cnt;
    }
}

