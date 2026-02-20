class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)  parent[i] = i;

        int maxLen = 0;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
               if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j; 
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int curr = lastIndex;
        while (parent[curr] != curr) {
            result.add(nums[curr]);
            curr = parent[curr];
        }
        result.add(nums[curr]); 
        return result;
    }
}

