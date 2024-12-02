class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] twoSum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                // if (i != j) {
                    int add = nums[i] + nums[j];
                    if (add == target) {
                        twoSum[0] = i;
                        twoSum[1] = j;
                        return twoSum;
                    }
            }
        }
        return new int[0];
    }
}

