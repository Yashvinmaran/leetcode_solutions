import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); 
        long count = 0;
        long result = 0;
        
        for (int num : nums) {
            if (num % modulo == k) count++;
            long target = (count - k + modulo) % modulo;
            result += map.getOrDefault(target, 0L);
            map.put(count % modulo, map.getOrDefault(count % modulo, 0L) + 1); 
        }
        
        return result;
    }
}

