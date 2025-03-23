class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1, missing = -1;

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) {
                duplicate = val;
            } else {
                nums[val - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            } else {
                nums[i] = Math.abs(nums[i]);
            }
        }
        return new int[] { duplicate, missing };
    }
}

