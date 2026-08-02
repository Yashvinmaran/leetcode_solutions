class Solution {

    private static int calculate(int[] piles, int l, int r, int[][] dp){
        if(dp[l][r] != -1)return dp[l][r];
        if(l == r)return piles[l];

        int left = piles[l] - calculate(piles, l+1, r, dp);
        int right = piles[r] - calculate(piles, l, r - 1, dp);

        dp[l][r] = Math.max(left, right);

        return dp[l][r];
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int[] d : dp){
            Arrays.fill(d,-1);
        }

        return calculate(piles, 0, n - 1, dp) >= 0;
    }
}
