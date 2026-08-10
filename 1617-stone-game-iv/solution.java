class Solution { 

    private static boolean solve(int n, Boolean[][] dp, int person, int currentN) { 
        if (currentN == 0) {
            return false; 
        }

        if (dp[person][currentN] != null) {
            return dp[person][currentN];
        }
        for (int i = 1; i * i <= currentN; i++) {
            int stonesToRemove = i * i;
            int nextPerson = (person == 0) ? 1 : 0;

            if (!solve(n, dp, nextPerson, currentN - stonesToRemove)) {
                return dp[person][currentN] = true;
            }
        }
        return dp[person][currentN] = false;
    } 

    public boolean winnerSquareGame(int n) { 
        Boolean[][] dp = new Boolean[2][n + 1]; 
        
        return solve(n, dp, 0, n); 
    } 
}

