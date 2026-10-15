class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                i++;
                continue;
            }

            int start = i;
            while (i + 1 < n && nums[i + 1] <= threshold && (nums[i] % 2 != nums[i + 1] % 2)) {
                i++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
            i++;
        }

        return maxLength;
    }
}

