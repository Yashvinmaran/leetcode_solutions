class Solution {
     
     private static int score(int[] nums, int l, int r, int[][] dp){

        if(l == r)return nums[l];

        if(dp[l][r] != -1)return dp[l][r];

        int left = nums[l] - score(nums, l + 1, r, dp);
        int right = nums[r] - score(nums, l, r - 1, dp);

        dp[l][r] = Math.max(left,right);

        return dp[l][r];
     }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int[] d : dp){
            Arrays.fill(d,-1);
        }
        return score(nums, 0, n - 1, dp) >= 0;
    }
}
