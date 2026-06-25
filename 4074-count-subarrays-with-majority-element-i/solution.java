class Solution {

    public int countMajoritySubarrays(int[] nums, int target) {
        int totalCount = 0;
        int n = nums.length;

        for (int start = 0; start < n; start++) {
            int targetCount = 0;
            int subarrayLength = 0;

            for (int end = start; end < n; end++) {
                subarrayLength++; 

                if (nums[end] == target) {
                    targetCount++;
                }

                if (targetCount * 2 > subarrayLength) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
}

