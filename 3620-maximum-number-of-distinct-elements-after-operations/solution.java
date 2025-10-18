class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            int possible = Math.max(prev + 1, num - k);
            if (possible <= num + k) {
                count++;
                prev = possible;
            }
        }
        return count;
    }
}

