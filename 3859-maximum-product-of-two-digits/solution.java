class Solution {
    public int maxProduct(int n) {
        
        char[] nums = Integer.toString(n).toCharArray();
        int len = nums.length;
        Arrays.sort(nums);
        
        return ((nums[len-1] - '0') * (nums[len-2] - '0'));
    }
}
