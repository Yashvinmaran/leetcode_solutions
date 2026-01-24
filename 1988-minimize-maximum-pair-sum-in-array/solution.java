class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while(i < j){
            int sum = (nums[i++] + nums[j--]);
            if(ans < sum)ans = sum;
        }
        return ans;
    }
}
