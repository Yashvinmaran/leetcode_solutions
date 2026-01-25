class Solution {

    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = Math.min(m - 1, n - 1);

        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }

        return (int) res;
    }
}




// class Solution {
//      public static long factorial(int n) {
//         if (n < 0) return -1;

//         long result = 1;
//         for (int i = 2; i <= n; i++) {
//             result *= i;
//         }
//         return result;
//     }
//     public int uniquePaths(int m, int n) {
//         long res = (factorial((m-1) + (n-1))) / (factorial(m-1)*factorial(n-1));

    //     int totalSteps = m + n - 2;
    //     int downSteps = (m - 1) > totalSteps/2 ? totalSteps - (m - 1) : (m - 1);
       
    //    for (int i = 0; i < downSteps; i++){
    //     res = res * (totalSteps - i);
    //     res = res/ (i + 1);
    //    }

//        return (int)res;
//     }
// }



// class Solution {
//     private int paths(int m, int n, int[][] dp){
//         if (m == 1 && n == 1)return 1;
//         if(m == 0 || n == 0)return 0;
//         if(dp[m][n] != -1)return dp[m][n];
//         int rightWays = paths(m - 1, n, dp);
//         int downWays = paths(m, n - 1, dp);
//         return dp[m][n] = rightWays + downWays;
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i<=m; i++){
//             for (int j = 0; j<=n; j++){
//                 dp[i][j] = -1;
//             }
//         }
//         return paths(m,n, dp);
//     }
// }
