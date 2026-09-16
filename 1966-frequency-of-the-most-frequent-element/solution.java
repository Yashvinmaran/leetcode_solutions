class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long currSum = 0;
        int left = 0;
        int maximumFrequency = 0;

        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            
            long target = nums[right];
            long size = (right - left + 1);

            while ((size * target) > (k + currSum)) {
                currSum -= nums[left];
                left++;
                size = (right - left + 1);
            }

            maximumFrequency = Math.max(maximumFrequency, (int)(right - left + 1));
        }

        return maximumFrequency;
    }
}

