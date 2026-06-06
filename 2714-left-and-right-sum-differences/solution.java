class Solution {
    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int right = 0;
        int[] ans = new int[n];
        ans[0] = 0;

        for (int i = 1; i < n; i++){
            right += nums[n-i];
            ans[i] = nums[i] + ans[i-1];
        }

        for (int i = 0; i < n; i++){
            ans[i] = Math.abs(ans[i] - right);
            right -= nums[i];
        }

        return ans;
    }
}
