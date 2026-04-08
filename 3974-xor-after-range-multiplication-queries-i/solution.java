class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            change(nums, query);
        }

        int result = 0;
        for (int val : nums) {
            result ^= val;
        }
        return result;
    }

    private void change(int[] nums, int[] query) {
        int mod = 1_000_000_007;
        
        int start = query[0];
        int end = query[1];
        int step = query[2];
        int multiplier = query[3];

        if (step <= 0) return;

        int idx = start;
        while (idx <= end && idx < nums.length) {
            nums[idx] = (int) ((1L * nums[idx] * multiplier) % mod);
            idx += step;
        }
    }
}

