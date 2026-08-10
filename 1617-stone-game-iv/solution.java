class Solution {
    
    private static boolean solve(Boolean[] dp, int current){
        if(current == 0)return false;

        if(dp[current] != null)return dp[current];

        for (int i = 1; i * i <= current; i++){
            int stone = i*i;
            if(!solve(dp, current - stone)) return dp[current] = true;
        }

        return dp[current] = false;
    }

    public boolean winnerSquareGame(int n) {
        
        Boolean[] dp = new Boolean[n + 1];

        return solve(dp, n);
    }
}
