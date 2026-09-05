class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int currSum1 = 0;
        int currSum2 = 0;
        int total_sum = 0;
        int minSum = Integer.MAX_VALUE;
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            total_sum += nums[i];
            currSum1 += nums[i];
            currSum2 += nums[i];
            minSum = Math.min(currSum1, minSum);
            max_sum = Math.max(max_sum, currSum2);
            if (currSum1 > 0)currSum1 = 0;
            if(currSum2 < 0)currSum2 = 0;
        }

        if(total_sum == minSum)return max_sum;
        return Math.max(max_sum, (total_sum - minSum));
    }
}
