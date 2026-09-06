class Solution {
    public int missingNumber(int[] nums) {

       int max = nums.length;
       int totalSum = 0;

       for (int i = 0; i < nums.length; i++){
        // if(nums[i] > max)max = nums[i];
        totalSum += nums[i];
       }

       return (max * (max + 1)/2) - totalSum;
    }
}
