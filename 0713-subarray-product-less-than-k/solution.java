class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k <= 0)return 0;

        int left = 0;
        int totalCnt = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++){
            product *= nums[right];
            
            while(product >= k && left <= right){
                product /= nums[left];
                left++;
            }

            totalCnt += (right - left + 1);
        }

        return totalCnt;
    }
}
