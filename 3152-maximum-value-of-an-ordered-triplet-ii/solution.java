class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int []prefix = new int[n];
        int []suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for (int i = 1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], nums[i]);
        }

        for (int j = n-2; j>=0; j--){
            suffix[j] = Math.max(suffix[j+1], nums[j]);
        }
        long maxValue = 0; 
        for (int i = 1; i<n-1; i++){
            maxValue = Math.max(maxValue, (long)(prefix[i-1] - nums[i]) * suffix[i+1]);
        }
        return maxValue;
    }
}
