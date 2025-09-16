class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        for (int i = 0; i<n-1; i++){
            for (int j = 0; j<n-i-1; j++){
                int c = nums[j] + nums[j+1];
                nums[j] = c%10;
            }
        }
        return nums[0];
    }
}
