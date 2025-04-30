public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;
        
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        long ans = 0;
        int count = 0;
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxVal) {
                count++;
            }
            while (count >= k) {
                ans += (n - i);
                
                if (nums[j] == maxVal) {
                    count--;
                }
                j++;
            }
        }
        
        return ans;
    }
}

