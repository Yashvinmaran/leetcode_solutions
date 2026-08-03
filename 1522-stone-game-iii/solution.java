class Solution {
    private static int[] dp; 
    private static int solve(int[] stone, int idx, int n){ 
        if(idx >= n) return 0; 
        if(dp[idx] != -1)return dp[idx];
        int store = Integer.MIN_VALUE; 
        int sum = 0; 
        for (int i = 1; i <= 3 && idx + i <= n; i++){ 
            sum += stone[idx + i - 1]; 
            store = Math.max(store, sum - solve(stone, idx + i, n)); 
        } 
        return dp[idx] = store; 
    } 
    public String stoneGameIII(int[] stoneValue) { 

        int n = stoneValue.length;
        dp = new int[n + 1];

        Arrays.fill(dp, -1);
        int ans = solve(stoneValue, 0, n); 
        if(ans > 0) return "Alice"; 
        else if(ans == 0) return "Tie"; 
        return "Bob"; 
    } 
}

