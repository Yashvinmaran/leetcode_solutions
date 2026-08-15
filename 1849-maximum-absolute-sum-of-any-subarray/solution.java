class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int min_sum = Integer.MAX_VALUE;

        int left = 0;

        int n = nums.length;

        int curr = 0;
        for (int right = 0; right < n; right++){
            curr += nums[right];
             if(curr < 0){
                while(left <= right){
                    curr -= nums[left++];
                }
            }
            max_sum = Math.max(curr, max_sum);
        }

        left = 0;
        curr = 0;
        for (int right = 0; right < n; right++){
            curr += nums[right];
             if(curr > 0){
                while(left <= right){
                    curr -= nums[left++];
                }
            }
            min_sum = Math.min(curr, min_sum);
        }

        min_sum = min_sum < 0 ? -min_sum : min_sum;

        return Math.max(min_sum, max_sum);
    }
}
