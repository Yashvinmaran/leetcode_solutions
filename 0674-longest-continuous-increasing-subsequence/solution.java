class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int cnt = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i - 1] < nums[i])cnt++;
            else cnt = 1;
            max = Math.max(cnt, max);
        }
        return max;
    }
}
