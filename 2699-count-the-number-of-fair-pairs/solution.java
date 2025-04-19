class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long countUpper = countPairs(nums, upper);
        long countLower = countPairs(nums, lower - 1);
        return countUpper - countLower;
    }

    private long countPairs(int[] nums, int bound) {
        long count = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] <= bound) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}

