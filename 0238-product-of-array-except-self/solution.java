class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
     int []ans = new int[n];

     for (int i = 0, prefix = 1; i < n; i++){
        ans[i] = prefix;
        prefix *= nums[i];
     }

     for (int i = n - 1, suffix = 1; i>=0; i--){
        ans[i] *= suffix;
        suffix *= nums[i];
     }
     return ans;
    }
}
