class Solution { 
    public long maxAlternatingSum(int[] nums) { 
        int n = nums.length;
        long[] squaredNums = new long[n];
        
        for (int i = 0; i < n; i++) {
            squaredNums[i] = (long) nums[i] * nums[i];
        }
        
        Arrays.sort(squaredNums);
        
        long ans = 0;
        int m = n / 2; 
        
        for (int i = 0; i < n; i++) {
            if (i < m) {
                ans -= squaredNums[i];
            } else {
                ans += squaredNums[i];
            }
        }
        
        return ans;
    } 
}

