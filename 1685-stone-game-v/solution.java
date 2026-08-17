class Solution {
    private int[][] memo;
    private int[] pref;

    private int helper(int[] arr, int low, int high) {
        if (low >= high) return 0;
        
        if (memo[low][high] != -1) {
            return memo[low][high];
        }

        int maxScore = 0;

        for (int i = low; i < high; i++) {
            
            int part1 = pref[i + 1] - pref[low];
            int part2 = pref[high + 1] - pref[i + 1];
            
            int currentSplitScore = 0;
            
            if (part1 > part2) {
                currentSplitScore = part2 + helper(arr, i + 1, high);
            } else if (part2 > part1) {
                currentSplitScore = part1 + helper(arr, low, i);
            } else {
                int chooseLeft = part1 + helper(arr, low, i);
                int chooseRight = part2 + helper(arr, i + 1, high);
                currentSplitScore = Math.max(chooseLeft, chooseRight);
            }
            
            maxScore = Math.max(maxScore, currentSplitScore);
        }
        
        return memo[low][high] = maxScore;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stoneValue[i];
        }

        return helper(stoneValue, 0, n - 1);
    }
}

