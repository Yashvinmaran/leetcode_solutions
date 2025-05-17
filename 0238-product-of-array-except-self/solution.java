class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []ans = new int[n];

        for (int i = 0, prefix = 1; i<n; i++){
            ans[i] = prefix;
            prefix *= nums[i];
        }

        for (int j = n-1, suffix = 1; j >= 0; j--){
            ans[j] *= suffix;
            suffix *= nums[j];
        }

        return ans;
    }
}
