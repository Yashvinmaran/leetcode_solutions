class Solution {

    private int findJump(int[] arr, int i, int d, int[] dp) {
        if (dp[i] != -1) return dp[i];

        int maxJumps = 0;

        for (int j = 1; j <= d && i + j < arr.length; j++) {
            if (arr[i + j] >= arr[i]) {
                break; 
            }
            maxJumps = Math.max(maxJumps, findJump(arr, i + j, d, dp));
        }

        for (int j = 1; j <= d && i - j >= 0; j++) {
            if (arr[i - j] >= arr[i]) {
                break;
            }
            maxJumps = Math.max(maxJumps, findJump(arr, i - j, d, dp));
        }

        dp[i] = 1 + maxJumps;
        return dp[i];
    }

    public int maxJumps(int[] arr, int d) {
        int max_jump = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        for (int i = 0; i < arr.length; i++) {
            max_jump = Math.max(max_jump, findJump(arr, i, d, dp));
        }

        return max_jump;  
    }
}

