class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long total = 0;
        long sum = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++){
            sum += nums[right];

            int size = (right - left + 1);
            while((sum * size) >= k && left <= right){
                sum -= nums[left];
                left++;
                size = (right - left + 1);
            }

            total += (right - left + 1);
        }

        return total;
    }
}
