class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result = Integer.MAX_VALUE;
        for (int k = l; k <= r; k++) {
            int currSum = 0;
            for (int i = 0; i < k; i++) {
                currSum += nums.get(i);
            }
            if (currSum > 0) 
                result = Math.min(currSum, result);
            for (int i = 1; i + k - 1 < nums.size(); i++) {
                currSum = currSum - nums.get(i - 1) + nums.get(i + k - 1);
                if (currSum > 0)
                    result = Math.min(currSum, result);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
