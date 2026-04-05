class Solution {
    private int maximum(int[][] coins, int m, int n, int i, int j, int k, int[][][] dp) {
        if (i > m || j > n) return Integer.MIN_VALUE;
        if (i == m && j == n) {
            if (coins[i][j] < 0 && k < 2) return 0;
            return coins[i][j];
        }

        if (dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];

        int val = coins[i][j];

        int right = maximum(coins, m, n, i, j + 1, k, dp);
        int down = maximum(coins, m, n, i + 1, j, k, dp);

        int take = val + Math.max(right, down);

        int skip = Integer.MIN_VALUE;

        if (val < 0 && k < 2) {
            int rightSkip = maximum(coins, m, n, i, j + 1, k + 1, dp);
            int downSkip = maximum(coins, m, n, i + 1, j, k + 1, dp);
            skip = Math.max(rightSkip, downSkip);
        }

        return dp[i][j][k] = Math.max(take, skip);
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        return maximum(coins, m - 1, n - 1, 0, 0, 0, dp);
    }
}
