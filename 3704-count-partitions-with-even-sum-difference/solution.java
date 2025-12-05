class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int prefix_sum = 0;
        int suffix_sum = 0;
        int cnt = 0;

        for (int i = 0; i<n; i++){
            prefix_sum += nums[i];
        }

        for (int i = 0; i<n-1; i++){
            suffix_sum += nums[i];
            prefix_sum -= nums[i];
            if((prefix_sum - suffix_sum)%2 == 0)cnt++;
        }
        return cnt;
    }
}
