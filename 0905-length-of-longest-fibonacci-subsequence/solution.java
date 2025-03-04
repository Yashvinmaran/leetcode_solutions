class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, maxLen = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int sum = arr[i] + arr[j];
                if (indexMap.containsKey(sum)) {
                    int k = indexMap.get(sum);
                    dp[j][k] = Math.max(2, dp[i][j]) + 1;
                    maxLen = Math.max(maxLen, dp[j][k]);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
