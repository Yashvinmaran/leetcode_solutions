class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++){
            currSum += nums[right];
            
            while(currSum >= target){
                currSum -= nums[left];
                minLen = Math.min(minLen, (right - left + 1));
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
