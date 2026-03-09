class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);
        int ans = Math.max((nums[n-2] * nums[n - 1] * nums[n]), (nums[0] * nums[1] * nums[n]));
        return ans;
    }
}
