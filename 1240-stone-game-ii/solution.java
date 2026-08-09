class Solution {
    
    private static int solve(int[] piles, int person, int idx, int m, int[][][] dp) {
        if (idx >= piles.length) return 0;

        if (dp[person][idx][m] != -1) return dp[person][idx][m];

        int ans;
        int currentTake = 0;

        if (person == 1) {
            ans = 0;
            for (int x = 1; x <= 2 * m && idx + x <= piles.length; x++) {
                currentTake += piles[idx + x - 1];
                int nextStones = solve(piles, 0, idx + x, Math.max(m, x), dp);
                ans = Math.max(ans, currentTake + nextStones);
            }
        } else {
            ans = Integer.MAX_VALUE;
            for (int x = 1; x <= 2 * m && idx + x <= piles.length; x++) {
                int nextStones = solve(piles, 1, idx + x, Math.max(m, x), dp);
                ans = Math.min(ans, nextStones);
            }
        }

        return dp[person][idx][m] = ans;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n + 1][n + 1];
        
        for (int[][] ddp : dp) {
            for (int[] d : ddp) {
                Arrays.fill(d, -1);
            }
        }
        return solve(piles, 1, 0, 1, dp);
    }
}
