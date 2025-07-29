class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] last = new int[32];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> j) & 1) == 1) {
                    last[j] = i;
                }
            }

            int maxIdx = i;
            for (int j = 0; j < 32; j++) {
                maxIdx = Math.max(maxIdx, last[j]);
            }

            res[i] = maxIdx - i + 1;
        }

        return res;
    }
}

