class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int l = query[0], r = query[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int[] count = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            count[i] = curr;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > count[i]) {
                return false;
            }
        }

        return true;
    }
}

