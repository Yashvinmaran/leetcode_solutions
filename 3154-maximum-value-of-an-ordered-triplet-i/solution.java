class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0;
        int maxLeft = nums[0];

        for (int j = 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                long value = (long) (maxLeft - nums[j]) * nums[k];
                maxVal = Math.max(maxVal, value);
            }
            maxLeft = Math.max(maxLeft, nums[j]);
        }
        return maxVal;
    }
}

